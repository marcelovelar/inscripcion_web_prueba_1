package com.inscripcionweb.web.config;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//Filtro de seguridad que se encarga de que el jwt que llega sea válido o no.
@Component
public class JwtFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    @Autowired
    public JwtFilter(JwtUtil jwtUtil, UserDetailsService userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        // 1. Validar que sea un Header Authorization valido
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        System.out.println("1. Validar que sea un Header Authorization valido");
        if (authHeader == null || !authHeader.startsWith("Bearer")){
            filterChain.doFilter(request, response);
            return;
        }

        // 2. Validar que el JWT sea valido
        //String jwt = authHeader.split(" ")[1].trim();
        String jwt = authHeader.replace("Bearer ", "");
        System.out.println("2. Validar que el JWT sea valido");
        System.out.println(jwt);
        if (!this.jwtUtil.isValid(jwt)){
            System.out.println("JWT no válido");
            filterChain.doFilter(request, response);
            return;
        }




// 3. Cargar el usuario del UserDetailsService
        String username = this.jwtUtil.getUsername(jwt);
        User user = (User) this.userDetailsService.loadUserByUsername(username);
        System.out.println("3. Cargar el usuario del UserDetailsService");
        System.out.println("Usuario cargado: " + user.getUsername());

// 4. Cargar al usuario en el contexto de seguridad
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken (
                user.getUsername(), user.getPassword(), user.getAuthorities()
        );

        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        System.out.println("4. Usuario autenticado: " + SecurityContextHolder.getContext().getAuthentication());
        filterChain.doFilter(request, response);


    }
}

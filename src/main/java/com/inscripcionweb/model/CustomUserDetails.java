package com.inscripcionweb.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomUserDetails extends User {

    private final String description;

    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, boolean accountNonLocked, boolean accountNonDisabled, String description) {
        super(username, password, authorities);
        this.description = description;
        // Incluye otros campos según sea necesario
    }
}

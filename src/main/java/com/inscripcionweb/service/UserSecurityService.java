package com.inscripcionweb.service;

import com.inscripcionweb.persistance.entity.UserEntity;
import com.inscripcionweb.persistance.entity.UserRoleEntity;
import com.inscripcionweb.persistance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserSecurityService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserSecurityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = this.userRepository.findByIdPersona(username)
                .orElseThrow(() -> new UsernameNotFoundException("User "+ username + " not found"));


        if (userEntity.getLocked()) {
            String lockedDescription = userEntity.getDescripcion();
            throw new LockedException("User " + username + " is locked. Reason: " + lockedDescription);
        }

        System.out.println(userEntity);

        String [] roles = userEntity.getRoles().stream().map(UserRoleEntity::getRole).toArray(String[]::new);

        return User.builder()
                .username(userEntity.getIdPersona())
                .password(userEntity.getPassword())
                .roles(roles)
                .accountLocked(userEntity.getLocked())
                .disabled(userEntity.getDisabled())
                .build();
    }



}

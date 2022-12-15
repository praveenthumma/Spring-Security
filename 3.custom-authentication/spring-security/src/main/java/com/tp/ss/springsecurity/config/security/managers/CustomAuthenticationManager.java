package com.tp.ss.springsecurity.config.security.managers;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.tp.ss.springsecurity.config.security.providers.CustomAuthenticationProvider;

import lombok.AllArgsConstructor;


@Component
@AllArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {

    private final CustomAuthenticationProvider authenticationProvider;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        if (authenticationProvider.supports(authentication.getClass())) {
            return authenticationProvider.authenticate(authentication);
        } else {
            throw new ProviderNotFoundException("Authentication Provider Not Supported!");
        }       

    }
    
}

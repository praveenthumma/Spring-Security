package com.tp.ss.springsecurity.config.security.authentication;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CustomAuthentication implements Authentication {

    private boolean authentication;
    private final String key;
    
    @Override
    public boolean isAuthenticated() {
        
        return authentication;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
      //  this.authentication = isAuthenticated;
        
    }
    
    
    
    
    
    @Override
    public String getName() {
        
        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
        return null;
    }

    @Override
    public Object getCredentials() {
        
        return null;
    }

    @Override
    public Object getDetails() {
        
        return null;
    }

    @Override
    public Object getPrincipal() {
        
        return null;
    }


    
}

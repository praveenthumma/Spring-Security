package com.tp.ss.springsecurity.config.security.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.tp.ss.springsecurity.config.security.authentication.CustomAuthentication;
import com.tp.ss.springsecurity.config.security.managers.CustomAuthenticationManager;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationFilter extends OncePerRequestFilter {

    private final CustomAuthenticationManager customAuthenticationManager;
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {


    // 1. create an authentication object which is not yet authenticated
    // 2. delegate the authentication object to the manager
    // 3. get back the authentication from the manager
    // 4. if the object is authenticated then send request to the next filter in the chain

                String key = String.valueOf(request.getHeader("key"));       

                CustomAuthentication customAuthentication = new CustomAuthentication(false,key);

                try{


                var a = customAuthenticationManager.authenticate(customAuthentication);

                if (a.isAuthenticated()) {
                    SecurityContextHolder.getContext().setAuthentication(a);
                    filterChain.doFilter(request, response); // do this only when authentication works.
                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                response.sendError(403, ex.getMessage() + " Authentication Failed");
            }

        
    }


}

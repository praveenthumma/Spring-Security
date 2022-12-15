package com.tp.ss.multipleauthenticationproviders.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.filter.OncePerRequestFilter;

import com.tp.ss.multipleauthenticationproviders.authentication.ApiKeyAuthentication;
import com.tp.ss.multipleauthenticationproviders.managers.CustomAuthenticationManager;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ApiKeyFilter extends OncePerRequestFilter{

	private String key;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		CustomAuthenticationManager manager = new CustomAuthenticationManager();
		
		var auth = new ApiKeyAuthentication(key);
		
		//request.getAttribute("key").equals(key)
		filterChain.doFilter(request, response);
		
	}
	
	
}

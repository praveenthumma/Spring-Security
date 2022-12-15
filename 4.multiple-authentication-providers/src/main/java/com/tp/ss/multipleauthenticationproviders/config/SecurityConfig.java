package com.tp.ss.multipleauthenticationproviders.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.tp.ss.multipleauthenticationproviders.filters.ApiKeyFilter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.NoArgsConstructor;

@Configuration

public class SecurityConfig {
	
	@Value("${the.secret}")
	private String key;

	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		return http
				.httpBasic()
				.and()
				.addFilterBefore(new ApiKeyFilter(key),BasicAuthenticationFilter.class)
				.build();

	}

}

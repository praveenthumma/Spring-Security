package com.tp.epauth.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.httpBasic()
				.and()
				.authorizeRequests()
			//	.anyRequest().permitAll()
//				.anyRequest().denyAll()
	//			.anyRequest().hasAuthority("read")
	//			.anyRequest().hasRole("Admin")
	//			.anyRequest().hasAnyRole("ADMIN","MANAGERS")
	//			.anyRequest().hasAnyAuthority("read","write")
				.mvcMatchers("/hello").hasAuthority("read")
				.anyRequest().authenticated()				
				.and()
				.build();
	}
	
	
	@Bean
	public UserDetailsService userDetailsService () {
		var uds = new InMemoryUserDetailsManager();
		var u1  = User.withUsername("praveen")
				.password(passwordEncoder().encode("12345"))
				.authorities("read")
				.roles("Admin")
				.build();
		
		uds.createUser(u1);
		return uds;
	}
	
	@Bean
	public  PasswordEncoder passwordEncoder() {
		// TODO Auto-generated method stub
		return new BCryptPasswordEncoder();
	}

}

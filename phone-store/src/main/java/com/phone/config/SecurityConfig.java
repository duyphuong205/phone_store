package com.phone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import com.phone.custom.UserDetailsServiceCustom;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceCustom();
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(getPasswordEncoder());
		provider.setUserDetailsService(userDetailsService());
		return provider;
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.cors().disable().csrf().disable();
		
		http.authorizeHttpRequests()
			.antMatchers("/checkout").authenticated()
			.antMatchers("/admin/index").hasAnyRole("ADMIN", "STAFF")
			.anyRequest().permitAll();
		
		http.authenticationProvider(daoAuthenticationProvider());
		
		http.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/login-page")
			.failureUrl("/login/error");
		
		http.formLogin()
			.successHandler((request, response, auth) -> {
				if (auth.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN") || r.getAuthority().equalsIgnoreCase("ROLE_STAFF"))) {
					response.sendRedirect("/admin/index");
				} else {
					response.sendRedirect("/index");
				}
			});
		
		http.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/index")
			.addLogoutHandler(new SecurityContextLogoutHandler());
		
		return http.build();
	}
}

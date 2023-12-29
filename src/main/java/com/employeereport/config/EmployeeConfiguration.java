package com.employeereport.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class EmployeeConfiguration {

	@Bean
	public UserDetailsService userDetailsService() {
		
//		UserDetails admin = User.withUsername("ajith")
//				.password(encoder.encode("12345"))
//				.roles("ADMIN")
//				.build();
//		UserDetails user = User.withUsername("Jenis")
//				.password(encoder.encode("123"))
//				.roles("USER")
//				.build();
		//return new InMemoryUserDetailsManager(admin, user);
		return new UserInfoUserDetailsService();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http.csrf().disable().authorizeHttpRequests()
				.requestMatchers("/emp/send")
				.permitAll().and().authorizeHttpRequests()
				.requestMatchers("/emp/getAll").authenticated()
				.and().formLogin().and().build();
	}
	@Bean
	public PasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}
	
}

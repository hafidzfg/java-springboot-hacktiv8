package com.demo.api.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@Order(value=99) // order didefinisikan untuk menghindari konflik dengan randomizer pada unit test
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private UserPrincipalDetailsService userPrincipalDetailsService;
	
	
	public SecurityConfig(UserPrincipalDetailsService userPrincipalDetailsService) {
	        this.userPrincipalDetailsService = userPrincipalDetailsService;
	    }

	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic()
			.and()
				.authorizeRequests()
				.antMatchers("/api/index").permitAll()
				.antMatchers("/api/profile/**").authenticated()
				.antMatchers("/api/products/**").hasRole("ADMIN")
				.antMatchers("/api/management/**").hasAnyRole("ADMIN", "MANAGER")
				.antMatchers("/api/user/test1").hasAuthority("ACCESS_TEST1")
				.antMatchers("/api/user/test2").hasAuthority("ACCESS_TEST2")
			.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/api/logout"))
		        .deleteCookies("JSESSIONID")
			    .invalidateHttpSession(true)
		    .and()
		    	.csrf().disable();
	}

	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(this.userPrincipalDetailsService);
		return daoAuthenticationProvider;
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

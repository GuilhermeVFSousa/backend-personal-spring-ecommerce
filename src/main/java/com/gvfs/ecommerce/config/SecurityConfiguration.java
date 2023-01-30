package com.gvfs.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;

import com.okta.spring.boot.oauth.Okta;

@Configuration
public class SecurityConfiguration {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		// protegendo o endpoint /api/orders
		http.authorizeRequests(configurer -> configurer
				.antMatchers("/api/orders/**")
				.authenticated())
		.oauth2ResourceServer()
		.jwt();
		
		// add CORS filter
		http.cors();
		
		// add content negotiation strategy
		http.setSharedObject(ContentNegotiationStrategy.class, new HeaderContentNegotiationStrategy());
		
		// mudando a response do body 401 vazio para uma response mais amigável
		Okta.configureResourceServer401ResponseBody(http);
		
		return http.build();
	}

}

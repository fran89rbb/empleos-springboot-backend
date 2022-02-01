package com.franrodriguez.springboot.rest.empleos.app.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/app/home").permitAll()
		.antMatchers(HttpMethod.GET, "/app/home/verDetalle/{id}").hasAnyRole("USER", "ADMIN")
		.antMatchers(HttpMethod.GET, "/app/vacantes/page/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.POST, "/app/vacantes").hasRole("ADMIN")
		.antMatchers(HttpMethod.PUT, "/app/vacantes/{id}").hasRole("ADMIN")
		.antMatchers("/app/vacantes/**").hasRole("ADMIN")
		.anyRequest().authenticated();
	}

}

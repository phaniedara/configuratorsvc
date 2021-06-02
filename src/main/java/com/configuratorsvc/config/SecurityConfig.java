package com.configuratorsvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/rest/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        .authorizeRequests().antMatchers("/ui**").authenticated()
        .and()
        .formLogin().loginPage("/ui/login").defaultSuccessUrl("/ui").failureUrl("/ui/login?error").permitAll()
        .and()
        .logout().logoutUrl("/ui").logoutSuccessUrl("/ui").invalidateHttpSession(true);

	}
}

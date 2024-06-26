package com.rental.rentalapplication.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	/*
	private UserDetailsService userDetailsService;

	public SecurityConfig(UserDetailsService userDetailsService) {
		super();
		this.userDetailsService = userDetailsService;
	}
	*/
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            
            .authorizeHttpRequests(authorize -> authorize
            	.requestMatchers("/homePage/show","/register/**").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
            		.loginPage("/login")
            		.loginProcessingUrl("/login")
            		.defaultSuccessUrl("/register/success")
            		.permitAll()
            		)
            .logout(
            		logout -> logout
            		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            		.permitAll()
            		);
            
        return http.build();
    }
	
	/*
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	*/
	@Bean
    public UserDetailsService userDetailsService(){

        UserDetails user = User.builder()
                .username("kowalski@user.pl")
                .password(passwordEncoder().encode("user"))
                .roles("USER")
                .build();

        

        return new InMemoryUserDetailsManager(user);
    }
	
}

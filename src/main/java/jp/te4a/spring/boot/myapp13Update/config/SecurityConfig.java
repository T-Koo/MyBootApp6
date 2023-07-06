package jp.te4a.spring.boot.myapp13Update.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.formLogin(login -> login
                .loginProcessingUrl("/login")
                .loginPage("/loginForm")
                .defaultSuccessUrl("/books", true)
                .failureUrl("/loginForm?error")
                .usernameParameter("username").passwordParameter("password")
        ).logout(logout -> logout
                .logoutSuccessUrl("/loginForm")
        ).authorizeHttpRequests(authz -> authz
        		.requestMatchers("/loginForm").permitAll()
        		.requestMatchers("/users").permitAll()
        		.requestMatchers("/users").permitAll()
        		.requestMatchers("/users/create").permitAll()
        		.requestMatchers("/webjars/**", "/css/**").permitAll()
                .anyRequest().authenticated()
        );
        return http.build();
    }
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}


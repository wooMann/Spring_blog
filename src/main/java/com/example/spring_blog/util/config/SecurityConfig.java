package com.example.spring_blog.util.config;


import com.example.spring_blog.exception.AuthFailureHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final AuthFailureHandler authFailureHandler;

    public SecurityConfig(AuthFailureHandler authFailureHandler) {
        this.authFailureHandler = authFailureHandler;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .mvcMatchers("/", "/post/**", "/join")
                .permitAll()
                .anyRequest().authenticated();
        http.formLogin()
                .loginPage("/")
                .defaultSuccessUrl("/main")
                .loginProcessingUrl("/login")
                        .failureHandler(authFailureHandler);
        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/logout")
                .invalidateHttpSession(true);

        return http.build();
    }
}

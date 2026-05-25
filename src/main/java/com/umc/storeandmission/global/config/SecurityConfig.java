package com.umc.storeandmission.global.config;

import com.umc.storeandmission.global.security.exception.CustomAccessDenied;
import com.umc.storeandmission.global.security.exception.CustomEntryPoint;
import com.umc.storeandmission.global.security.filter.JwtAuthFilter;
import com.umc.storeandmission.global.security.service.CustomUserDetailsService;
import com.umc.storeandmission.global.security.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtUtil jwtUtil;
    private final CustomUserDetailsService customUserDetailsService;

    private final String[] allowUrls = {
            "/swagger-ui/**",
            "/swagger-resources/**",
            "/swagger-ui.html",
            "/v3/api-docs/**",
            "/v3/api-docs",

            "/login",
            "/signup"
    };

    private final String[] publicAPI = {
            "/api/v1/auth/signup",
            "/api/v1/auth/login"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers(allowUrls).permitAll()
                        .requestMatchers(publicAPI).permitAll()
                        .anyRequest().authenticated()
                )
//                .formLogin(form -> form
//                        .loginPage("/login")
//                        .defaultSuccessUrl("/swagger-ui/index.html", true)
//                        .permitAll()
//                )
                .formLogin(AbstractHttpConfigurer::disable)
                .sessionManagement(AbstractHttpConfigurer::disable)
                .addFilterBefore(jwtAuthFilter(), UsernamePasswordAuthenticationFilter.class)
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                )
                .exceptionHandling(exception -> exception
                        .accessDeniedHandler(customAccessDenied())
                        .authenticationEntryPoint(customEntryPoint())
                )
        ;

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CustomAccessDenied customAccessDenied() {
        return new CustomAccessDenied();
    }

    @Bean
    public CustomEntryPoint customEntryPoint() {
        return new CustomEntryPoint();
    }

    @Bean
    public JwtAuthFilter jwtAuthFilter() { return new JwtAuthFilter(jwtUtil, customUserDetailsService); }
}

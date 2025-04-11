package com.example.Web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                        .requestMatchers("/profile/**").permitAll()
//                        .requestMatchers("/").hasAnyAuthority("USER", "CREATOR", "EDITOR", "ADMIN")
//                        .requestMatchers("/new").hasAnyAuthority("ADMIN", "CREATOR")
//                        .requestMatchers("/edit/**").hasAnyAuthority("ADMIN", "EDITOR")
//                        .requestMatchers("/delete/**").hasAuthority("ADMIN")
//                        .anyRequest().authenticated()
                )
                .formLogin(login -> login.permitAll())
                .logout(logout -> logout.permitAll())
                .exceptionHandling(eh -> eh.accessDeniedPage("/403"))
        ;

        return http.build();
    }
}

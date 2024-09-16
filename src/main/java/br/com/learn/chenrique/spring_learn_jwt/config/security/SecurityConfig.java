package br.com.learn.chenrique.spring_learn_jwt.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    UserDetailsService detailsService(PasswordEncoder encoder) {
        UserDetails admin = User.withUsername("admin").authorities("BASIC", "SPECIAL").password(encoder.encode("1"))
                .build();
        UserDetails user = User.withUsername("user").authorities("BASIC").password(encoder.encode("2")).build();
        return new InMemoryUserDetailsManager(admin);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/open").permitAll();
                    auth.requestMatchers("/closed").authenticated();
                    auth.requestMatchers(HttpMethod.POST, "/product").authenticated();

                    auth.requestMatchers(HttpMethod.GET, "/special").hasAuthority("SPECIAL");
                    auth.requestMatchers(HttpMethod.GET, "/basic").hasAnyAuthority("SPECIAL", "BASIC");
                }).httpBasic(Customizer.withDefaults()).csrf(t -> t.disable()).build();
    }
}

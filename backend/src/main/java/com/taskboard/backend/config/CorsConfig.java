package com.taskboard.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        
        // Origines autorisées (à adapter en prod)
        corsConfiguration.setAllowedOrigins(Arrays. asList(
            "http://localhost:5173",  // Vite dev server
            "http://localhost:3000"   // Alternative
        ));
        
        // Méthodes HTTP autorisées
        corsConfiguration.setAllowedMethods(Arrays.asList(
            "GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"
        ));
        
        // Headers autorisés
        corsConfiguration.setAllowedHeaders(List.of("*"));
        
        // Permettre les credentials (cookies, auth headers)
        corsConfiguration.setAllowCredentials(true);
        
        // Durée de cache du preflight
        corsConfiguration.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/api/**", corsConfiguration);

        return new CorsFilter(source);
    }
}
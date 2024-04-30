package io.github.euristenede.projetoathenas.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author Euristenede Santos
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Endpoint que deseja configurar o CORS
            .allowedOrigins("http://localhost:4200") // Origens permitidas
            .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos permitidos
            .allowedHeaders("*"); // Headers permitidos
    }
}

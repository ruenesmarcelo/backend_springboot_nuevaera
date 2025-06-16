import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // Le dice a Spring que esta clase es de configuración
public class WebConfig {

    @Bean // Expone el objeto WebMvcConfigurer como bean para Spring
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("api/") // Aplica a todos los endpoints del backend
                        .allowedOrigins("http://localhost:4200") // Permite el frontend Angular
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos HTTP aceptados
                        .allowedHeaders("*") // Permite cualquier encabezado
                        .allowCredentials(true); // Permite enviar cookies, tokens, etc.
            }
        };
    }
}

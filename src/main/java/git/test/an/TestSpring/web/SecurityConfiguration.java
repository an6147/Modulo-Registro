package git.test.an.TestSpring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    
    @Autowired
    
    private UserDetailsService userDetailsService;

    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
        build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authz) -> authz
                .requestMatchers("/editar/**", "/agregar/**", "/eliminar")
                    .hasRole("ADMIN")
                .requestMatchers("/")
                    .hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
            ).formLogin(form -> form
			.loginPage("/login")
			.permitAll()
            ).exceptionHandling((exceptionHandling) -> exceptionHandling
                        .accessDeniedPage("/errores/403")
                        );
        return http.build();
    }

}

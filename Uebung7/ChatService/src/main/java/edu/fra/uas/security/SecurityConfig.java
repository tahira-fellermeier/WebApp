package edu.fra.uas.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    // legt fest, welche Sicherheitsanforderungen für eingehende HTTP-Anfragen
    // gelten
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());
        // Deaktiviert den Cross Site Request Forgery (CSRF) -Schutz. Dies sollte mit
        // Vorsicht verwendet werden, da CSRF-Angriffe verhindert werden sollen.
        http.authorizeHttpRequests((authorize) -> authorize.anyRequest().fullyAuthenticated());
        // alle Anfragen sollen authentifiziert werden
        http.httpBasic(withDefaults());
        // HTTP Basic Authentifizierung, Benutzer schicken Benutzername und
        // Passwortdirekt in der Anfrage-Header (Authorization) mit

        // http.sessionManagement((sessionManagement) -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        // Sitzungsverwaltung deaktivieren

        // http.addFilterBefore(new AuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

}

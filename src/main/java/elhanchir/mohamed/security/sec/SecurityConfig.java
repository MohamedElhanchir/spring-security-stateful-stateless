package elhanchir.mohamed.security.sec;

import elhanchir.mohamed.security.sec.services.UserDetailServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    private UserDetailServiceImpl userDetailServiceImpl;

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http
                //    .csrf(AbstractHttpConfigurer::disable)
                    .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                    .formLogin(Customizer.withDefaults())
                    .authorizeHttpRequests(authorize -> authorize
                            .anyRequest().authenticated()
                    )
                    .userDetailsService(userDetailServiceImpl);
               /*     .authorizeHttpRequests(authorize -> authorize
                            .requestMatchers("/blog/**").permitAll()
                            .anyRequest().authenticated()
                    )
                    .formLogin(form -> form
                            .loginPage("/login")
                            .permitAll()
                    )
                    .rememberMe(remember -> remember);*/

            return http.build();
        }


}

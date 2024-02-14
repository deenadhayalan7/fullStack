package com.eweb.giftbackend.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.eweb.giftbackend.utils.MyConstant;

// import io.jsonwebtoken.lang.Arrays;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationConfig jwtAuthenticationConfig;
    @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

    httpSecurity.csrf(AbstractHttpConfigurer::disable)
    .cors(cors->cors.configurationSource(configurationSource()))
     .authorizeHttpRequests(authorize->authorize.requestMatchers(MyConstant.AUTH+"/**","/swagger-ui/**","/swagger-ui.html","/v3/api-docs/**")

     .permitAll()
     .anyRequest()
     .authenticated())
     .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
     .authenticationProvider(authenticationProvider)
     .addFilterBefore(jwtAuthenticationConfig, UsernamePasswordAuthenticationFilter.class);
    return httpSecurity.build();   
  }
  @Bean
  public CorsConfigurationSource configurationSource(){
          CorsConfiguration corsConfiguration=new CorsConfiguration();
          corsConfiguration.setAllowedOrigins(MyConstant.ORIGINS);
          corsConfiguration.setAllowedHeaders(MyConstant.HEADERS);
          corsConfiguration.setAllowedMethods(MyConstant.METHODS);
        //   corsConfiguration.setAllowedOrigins(Arrays.asList("http://127.0.0.1:4000/"));
        // corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        // corsConfiguration.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
          corsConfiguration.setAllowCredentials(true);
          UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
          source.registerCorsConfiguration("/**", corsConfiguration);
          return source;
 
        }        
}

package com.jfoltyn.forsetiserver.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import static com.jfoltyn.forsetiserver.controllers.ServiceDictionary.ACCOUNT_NUMBER;
import static com.jfoltyn.forsetiserver.controllers.ServiceDictionary.USER;
import static org.springframework.http.HttpMethod.PUT;

@EnableWebSecurity(debug = true)
public class WebSecurity extends WebSecurityConfigurerAdapter {
   private UserDetailsService userDetailsService;
   private BCryptPasswordEncoder bCryptPasswordEncoder;

   public WebSecurity(UserDetailsService userDetailsServiceImpl, BCryptPasswordEncoder bCryptPasswordEncoder) {
      this.userDetailsService = userDetailsServiceImpl;
      this.bCryptPasswordEncoder = bCryptPasswordEncoder;
   }

   @Override
   protected void configure(HttpSecurity http) throws Exception {
      http.cors().and().csrf().disable()
            .authorizeRequests()
            .regexMatchers("/" + USER + ".*").authenticated()
            .regexMatchers(PUT, "/" + ACCOUNT_NUMBER + ".*").authenticated()
            .anyRequest().permitAll()
            .and()
            .addFilter(new JWTAuthenticationFilter(authenticationManager()))
            .addFilter(new JWTAuthorizationFilter(authenticationManager()))
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
   }

   @Override
   public void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
   }

   @Bean
   CorsConfigurationSource corsConfigurationSource() {
      final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
      return source;
   }
}
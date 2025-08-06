package com.shopperx.shopperxapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.annotation.web.configurers.PasswordManagementConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(CsrfConfigurer::disable);
//        http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
//        http.formLogin(Customizer.withDefaults());
//        http.httpBasic(Customizer.withDefaults());
//        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        Customizer<CsrfConfigurer<HttpSecurity>> csrfconfig =  new Customizer<CsrfConfigurer<HttpSecurity>>() {
            @Override
            public void customize(CsrfConfigurer<HttpSecurity> customizer){
                customizer.disable();
            }
        };

        Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry> registry =
                new Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry> () {

                    @Override
                    public void customize (AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry customizer){
                        customizer.anyRequest().authenticated();
                    }
                };

        Customizer<HttpBasicConfigurer<HttpSecurity>> httpBasic = new Customizer<HttpBasicConfigurer<HttpSecurity>> () {

            @Override
            public void customize(HttpBasicConfigurer<HttpSecurity> httpBasic){
                httpBasic.realmName("");
            }
        };

        Customizer<PasswordManagementConfigurer<HttpSecurity>> passwordConfig = new Customizer<PasswordManagementConfigurer<HttpSecurity>> () {
            @Override
            public void customize(PasswordManagementConfigurer<HttpSecurity> customizer) {
                customizer.changePasswordPage("/change-password");
            }
        };

        return http
                   .authorizeHttpRequests(registry)
                   .csrf(csrfconfig)
                   .httpBasic(httpBasic)
                   .passwordManagement(passwordConfig)
                   .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                   .build();

    }


}

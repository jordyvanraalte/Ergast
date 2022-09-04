package nl.jordyvanraalte.ergast.configurations;

import nl.jordyvanraalte.ergast.filters.ApiKeyAuthenticationFilter;
import nl.jordyvanraalte.ergast.services.impl.ApiKeyAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;

import java.util.Collections;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ApiKeyAuthenticationService apiKeyAuthenticationService;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .addFilterBefore(
                        new ApiKeyAuthenticationFilter(authenticationManager()),
                        AnonymousAuthenticationFilter.class);
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(Collections.singletonList(apiKeyAuthenticationService));
    }
}
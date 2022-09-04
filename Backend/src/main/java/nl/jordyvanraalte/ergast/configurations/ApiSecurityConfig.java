package nl.jordyvanraalte.ergast.configurations;



import nl.jordyvanraalte.ergast.filters.AuthFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Order(1)
public class ApiSecurityConfig {


    @Value("${ergast.api.header}")
    private String principalRequestHeader;

    //WARNING - API key is in application.properties which has been added to this Git, don't use this in production
    @Value("${ergast.api.key}")
    private String principalRequestValue;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        AuthFilter filter = new AuthFilter(principalRequestHeader);
        filter.setAuthenticationManager(new AuthenticationManager() {

            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                String principal = (String) authentication.getPrincipal();
                if (!principalRequestValue.equals(principal)) {
                    throw new BadCredentialsException("The API key was not found or not the expected value.");
                }
                authentication.setAuthenticated(true);
                return authentication;
            }
        });
                http.addFilter(filter).authorizeRequests().anyRequest().authenticated();
        return http.build();
    }
}

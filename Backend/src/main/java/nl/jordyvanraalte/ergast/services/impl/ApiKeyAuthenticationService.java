package nl.jordyvanraalte.ergast.services.impl;

import nl.jordyvanraalte.ergast.entities.ApiKeyAuthenticationToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class ApiKeyAuthenticationService implements AuthenticationProvider {


    @Value( "${ergast.api.key}" )
    private String key;

    @Override
    public Authentication authenticate(Authentication authentication) {
        String apiKey = (String) authentication.getPrincipal();

        if (ObjectUtils.isEmpty(apiKey)) {
            throw new InsufficientAuthenticationException("No API key in request");
        } else {
            if (key.equals(apiKey)) {
                return new ApiKeyAuthenticationToken(apiKey, true);
            }
            throw new BadCredentialsException("API Key is invalid");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return ApiKeyAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
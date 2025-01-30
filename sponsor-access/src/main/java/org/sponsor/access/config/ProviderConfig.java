package org.sponsor.access.config;

import org.sponsor.access.provider.BasicAuthenticationProvider;
import org.sponsor.access.provider.SocialAuthenticationProvider;
import org.sponsor.access.provider.TokenAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;

@Configuration
public class ProviderConfig {

    @Autowired
    private BasicAuthenticationProvider basicAuthenticationProvider;
    
    @Autowired
    private  TokenAuthenticationProvider tokenAuthenticationProvider;
    
    @Autowired
    private  SocialAuthenticationProvider socialAuthenticationProvider;

    @Bean
    public AuthenticationManager authenticationManager() {
      return new ProviderManager(basicAuthenticationProvider, tokenAuthenticationProvider, socialAuthenticationProvider);
    }
}

package org.sponsor.account.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;

@Configuration
public class ProviderConfig {

    @Autowired
    private  TokenAuthenticationProvider tokenAuthenticationProvider;
    
    @Bean
    public AuthenticationManager authenticationManager() {
      return new ProviderManager(tokenAuthenticationProvider);
    }
}

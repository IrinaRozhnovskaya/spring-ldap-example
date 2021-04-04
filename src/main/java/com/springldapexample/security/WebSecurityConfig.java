package com.springldapexample.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.ldap.LdapProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@EnableConfigurationProperties(LdapProperties.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final LdapProperties ldapProperties;

    @Value("${ldap.userDnPattern}")
    private String userDnPattern;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/private").authenticated()
                .antMatchers(HttpMethod.GET, "/api/public").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        String url = String.format("%s/%s", ldapProperties.getUrls()[0], ldapProperties.getBase());

        auth.ldapAuthentication()
                .contextSource()
                .url(url)
                .managerDn(ldapProperties.getUsername())
                .managerPassword(ldapProperties.getPassword())
                .and()
                .userDnPatterns(userDnPattern);
    }
}

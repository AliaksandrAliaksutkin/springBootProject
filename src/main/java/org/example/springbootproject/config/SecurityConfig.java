package org.example.springbootproject.config;

import lombok.RequiredArgsConstructor;
import org.example.springbootproject.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserServiceImpl userServiceImpl;

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .csrf().disable()                       // порядок элементов antMatchers () имеет значение; сначала должны быть более конкретные правила, а за ними - более общие .
                .authorizeRequests()
                .antMatchers("/address*").hasRole("ADMIN")
                .antMatchers("/new*").hasRole("ADMIN")
                .antMatchers("/delete*").hasRole("ADMIN")
                .antMatchers("/update*").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/homepage", true);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(userServiceImpl);
        return authenticationProvider;
    }

}

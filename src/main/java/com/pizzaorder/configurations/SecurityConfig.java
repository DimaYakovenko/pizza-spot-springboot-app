package com.pizzaorder.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;
    /*
    In-Memory authentication type

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("foo")
                .password("{noop}   bar")
                .authorities("ROLE_ADMIN")
                .and()
                .withUser("user")
                .password("{noop}user")
                .authorities("ROLE_USER");
    }*/

/*
  JDBC-based authentication
*/

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(
                        "select name, password, enabled from Users " +
                                "where name=?")
                .authoritiesByUsernameQuery(
                        "select name, authority from Authorities " +
                                "where name=?");
//                .passwordEncoder(new StandardPasswordEncoder("bcrypt"));
                /*.withDefaultSchema()
                .withUser(User.withUsername("foo")
                        .password(passwordEncoder().encode("bar"))
                        .authorities("USER"))
                .withUser("dima")
                .password(passwordEncoder().encode("1234"))
                .authorities("ADMIN", "USER");*/
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity)
            throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/h2-console/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();

        httpSecurity.csrf()
                .ignoringAntMatchers("/h2-console/**");
        httpSecurity.headers()
                .frameOptions()
                .sameOrigin()
                .and()
                .logout()
                .logoutSuccessUrl("/");
    }

}


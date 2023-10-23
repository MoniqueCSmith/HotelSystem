/*
package za.ac.cput.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("shanlynn")
                .password("{noop}54321")
                .roles("ADMIN", "USER")
                .and()
                .withUser("ashton")
                .password("{noop}12345")
                .roles("USER");
    }
*/

//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        http.httpBasic()
//                .and()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.POST,"/**/create").hasRole("ADMIN")
//                .antMatchers(HttpMethod.GET, "/**/read/**").hasRole("USER")
//                .and().csrf().disable()
//                .formLogin().disable();
//
//    }

/*}*/

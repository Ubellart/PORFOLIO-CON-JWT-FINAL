package Backend.Porfolio;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import Backend.Porfolio.Security.Jwt.JwtEntryPoint;
import Backend.Porfolio.Security.Jwt.JwtTokenFilter;
import Backend.Porfolio.Security.Service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 *
 * @author victo
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)


public class MainSecurity extends WebSecurityConfigurerAdapter {
    
@Autowired
UserDetailsImpl userDetailsServiceImpl;
@Autowired
JwtEntryPoint jwtEntryPoint;

@Bean
public  JwtTokenFilter jwtTokenFilter(){
    
    return new JwtTokenFilter();
}
@Bean  
public  PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
}


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable()
         .authorizeRequests()
                .antMatchers("/auth/**").permitAll()
                .antMatchers(HttpMethod.GET).permitAll()
                .anyRequest().hasRole("ADMIN")
//                .anyRequest().authenticated() ORIGINAL
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                
              http.addFilterBefore(jwtTokenFilter(),UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();

    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean(); 
    }
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
    }



}

//  @Autowired
//
//    UserDetailsImpl userDetailsServiceImpl;
//
//
//
//    @Autowired
//
//    JwtEntryPoint jwtEntryPoint;
//
//
//
//    @Bean
//
//    public JwtTokenFilter jwtTokenFilter() {
//
//        return new JwtTokenFilter();
//
//    }
//
//
//
//    @Bean
//
//    public PasswordEncoder passwordEncoder() {
//
//        return new BCryptPasswordEncoder();
//
//    }
//
//
//
//    @Bean
//
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
//
//            throws Exception {
//
//        return authenticationConfiguration.getAuthenticationManager();
//
//    }
//
//
//
//    @Bean
//
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//        http.cors().and().csrf().disable()
//
//                .exceptionHandling().authenticationEntryPoint(jwtEntryPoint).and()
//
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//
//                .authorizeRequests()
//
//                .antMatchers("/**").permitAll()
//
//                .anyRequest().authenticated();
//
//
//
//        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//
//
//
//        return http.build();
//
//    }
//}
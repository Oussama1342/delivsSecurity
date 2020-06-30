package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired	
	private  UserDetailsService userDetailsService ; 
	
    @Autowired
    private BCryptPasswordEncoder bcryptPasswordEncoder; 
    
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
		
		String passAdin = bcryptPasswordEncoder.encode("mjkl");
		//String passUser = bcryptPasswordEncoder.encode("klert");
		
		auth.inMemoryAuthentication().withUser("admin").password(passAdin).roles("ADMIN")
		.and() ;
		/*.withUser("oussama").password(passUser).roles("USER");
		 auth.jdbcAuthentication().usersByUsernameQuery("")
		 .authoritiesByUsernameQuery("")*/
		auth.userDetailsService(userDetailsService)
		 .passwordEncoder(bcryptPasswordEncoder);
		
	}
    
	
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
/* http.cors().and().csrf().disable()
	.headers()
	.frameOptions().disable()
	.cacheControl().disable()
	.and()
	.formLogin().disable();
	http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	http.authorizeRequests().antMatchers("/login/**","/addusers/**").permitAll();
	http.authorizeRequests().antMatchers("/getusers/**").hasAnyAuthority("CLIENT");

	//http.authorizeRequests().antMatchers("/	http://localhost:5007/allPro\n" + "/**").hasAnyAuthority("CLIENT");

	  //http.authorizeRequests().antMatchers("/hj/*!*").hasAnyAuthority("USER");
	

	http.authorizeRequests().anyRequest().authenticated(); 
	http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
	http.addFilterBefore(new JWTAuthorisationFilter(), UsernamePasswordAuthenticationFilter.class);
	*/
		http.csrf().disable();
		  http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		 // http.formLogin();
		  http.authorizeRequests().antMatchers("/login/**").permitAll();

		 http.authorizeRequests().antMatchers(HttpMethod.GET,"/getusers/**").hasAnyAuthority("CLIENT");
		  
		  http.authorizeRequests().anyRequest().authenticated(); 
		  http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
		  http.addFilterBefore(new JWTAuthorisationFilter(), UsernamePasswordAuthenticationFilter.class);
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
}

package com.example.demo.configuration;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.entity.Users;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		Users users =null;
		try {		users =new ObjectMapper().readValue(request.getInputStream(), Users.class);
        }
		catch(IOException e){
	       throw new RuntimeException(e);
        }
		System.out.println("*******************");
		System.out.println("Username:"+users.getUsername());
		System.out.println("Password:"+users.getPassword());


		return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(users.getUsername(), users.getPassword()));
	}
	
	protected void successfulAuthentication(HttpServletRequest request,HttpServletResponse response, FilterChain chain ,Authentication authResult) {
     User SpringUser = (User) authResult.getPrincipal();
		String Jwt = Jwts.builder()
				.setSubject(SpringUser.getUsername())
				.setExpiration(new Date(System.currentTimeMillis()+SecurityConstant.EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SecurityConstant.SECRET)
				.claim("roles", SpringUser.getAuthorities())
				.compact();
		response.addHeader(SecurityConstant.HEADER_STRING, SecurityConstant.TOKEN_PREFIX+Jwt);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}

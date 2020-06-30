package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.UsersRepository;
import com.example.demo.entity.Users;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	Accountservice accountService;
	
	@Autowired
	UsersRepository userrepository ;
	

	
	//l9dim

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users users = accountService.findByUsername(username);
		if(users== null) throw new  UsernameNotFoundException(username);
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		users.getRoles().forEach(r->{
			authorities.add(new SimpleGrantedAuthority(r.getRole()));
		});

		

		return new User(users.getUsername(),users.getPassword(),authorities);
	}
	
	

}

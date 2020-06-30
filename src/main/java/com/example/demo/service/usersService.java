package com.example.demo.service;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DAO.RoleRepository;
import com.example.demo.DAO.UsersRepository;
import com.example.demo.entity.Role;
import com.example.demo.entity.Users;

@RestController
public class usersService {
	
    @Autowired
	private UsersRepository usersRepo ; 
    @Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder; 
    @Autowired
    private RoleRepository roleRepo ;
    
    @PostMapping("/addusers")
    public Users addUsers(@RequestBody Users user) {
    	user.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
    	Role userRole = roleRepo.findByRole("CLIENT");
    	usersRepo.save(user);
    	return user;
    }

    @GetMapping("/getusers")
    public Iterable<Users> getallUsers(){
    	
    	return  usersRepo.findAll();  
    }
    
    @PostMapping("/addRole")
    public Role addRole(@RequestBody Role role) {
    	roleRepo.save(role);
    	return role ; 
    }
    
    @GetMapping("/allroles")
    public List<Role> getROles(){
    	return (List<Role>) roleRepo.findAll();
    }
    @GetMapping("/hj")
    public String test() {
    	return "Hellow Guys";
    }
    
    @GetMapping("/getr/{role}")
    public Role GETBY(@PathVariable String role) {
    	return roleRepo.findByRole(role);
    }
    
    @GetMapping("/hellowt")
    public String hellowtest() {
    	return "hellow JWT";
    }
}

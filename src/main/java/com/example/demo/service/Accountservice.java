package com.example.demo.service;


import com.example.demo.entity.Role;
import com.example.demo.entity.Users;

public interface Accountservice {
	public Users saveUser(Users U);
    public Role saveRole(Role role);	
	public Users findByUsername(String username);
	public void addRoleToUser(String username,String roleName);

}

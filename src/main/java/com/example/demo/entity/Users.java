package com.example.demo.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
//import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Document(indexName ="pfefront", type = "users")
public class Users  implements Serializable {

	@Id
	private String idUser ; 
	private String nameUser;
	private String username;
	private String password ;
	private String  email; 
 	private List<Role> roles ; 
	
   
	

	public Users(String idUser, String username, String password, List<Role> roles) {
		super();
		this.idUser = idUser;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Users(String idUser, String nameUser, String username, String password, String email,
			List<Role> roles) {
		super();
		this.idUser = idUser;
		this.nameUser = nameUser;
		this.username = username;
		this.password = password;
		this.email = email;
		this.roles = roles;
	}

	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public String getNameUser() {
		return nameUser;
	}
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
 
	
}

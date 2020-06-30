package com.example.demo.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
//import org.springframework.data.mongodb.core.mapping.DBRef;

@Document(indexName = "pfefront", type = "roleUsers")
public class Role implements Serializable {

	@Id
	private String id ; 
	private String role ;
	
	public Role() {
		// TODO Auto-generated constructor stub
	}
	
	public Role(String id, String role) {
		super();
		this.id = id;
		this.role = role;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	} 
	
	
	
}

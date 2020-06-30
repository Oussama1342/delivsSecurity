package com.example.demo.DAO;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Role;

@Repository
public interface RoleRepository extends ElasticsearchRepository<Role, String> {
	
	Role findByRole(String role);
	

}

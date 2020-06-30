package com.example.demo.DAO;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Users;

@Repository
public interface UsersRepository extends ElasticsearchRepository<Users, String> {

	Users findByUsername(String username);
    Users findByEmail(String email);
}

package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.DAO.RoleRepository;
import com.example.demo.DAO.UsersRepository;
import com.example.demo.entity.Role;
import com.example.demo.entity.Users;
import com.example.demo.service.Accountservice;

@SpringBootApplication
@CrossOrigin(origins = "*")
public class SecurityDelivsApplication implements CommandLineRunner {

	  @Autowired
	  private BCryptPasswordEncoder bcryptPasswordEncoder; 
	@Autowired
   UsersRepository usersRepository;
	public static void main(String[] args) {
		SpringApplication.run(SecurityDelivsApplication.class, args);
	
	
	}

	/*
	 * CommandLineRunner start(UsersRepository userRepo, RoleRepository roleRepo) {
	 * return args->{ userRepo.deleteAll();
	 * Stream.of("USER1","USER2").forEach(c->userRepo.save(new
	 * Users("g","g","j","h","u",new ArrayList<>()))); }; }
	 */

	@Bean
    public BCryptPasswordEncoder getBCPE() {
    	return new BCryptPasswordEncoder();
    }


	@Override
	public void run(String... args) throws Exception {
	String pass = bcryptPasswordEncoder.encode("amari");
	String pass1 = bcryptPasswordEncoder.encode("oussama");

  usersRepository.saveAll(Arrays.asList(new Users("oss4", "amari", pass, Arrays.asList(new Role("nb", "CLIENT")))));
  usersRepository.saveAll(Arrays.asList(new Users("oss40", "oussama", pass1 , Arrays.asList(new Role("mk", "RESTAURANT")))));

   // accountservice.saveUser(new Users("pko", "oussama", "ouss13", "amari13"));
   // accountservice.saveRole(new Role("r1", "CLIENT"));
	//accountservice.addRoleToUser("username", "CLIENT");
    
		/*
		 * usersRepository.saveAll( Arrays.asList( new Users("kk", "am", "ma",
		 * Arrays.asList(new Role("ruj", "CLIENT")
		 * 
		 * ))));
		 */
		
	}
}

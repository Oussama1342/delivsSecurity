
  package com.example.demo.service;
  
  import java.util.Arrays; import java.util.HashSet;
  
  import org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.stereotype.Service; import
  org.springframework.transaction.annotation.Transactional;
  
  import com.example.demo.DAO.RoleRepository; import
  com.example.demo.DAO.UsersRepository; import com.example.demo.entity.Role;
  import com.example.demo.entity.Users;
  
  @Service
  
  @Transactional public class AccountServiceImple implements Accountservice{
  
  @Autowired UsersRepository userRepository ;
  
  @Autowired RoleRepository roleRepository ;
  
  @Override public Users saveUser(Users U) { userRepository.save(U); return U;
  }
  
  @Override public Role saveRole(Role role) { roleRepository.save(role); return
  role; }
  
  @Override public Users findByUsername(String username) { return
  userRepository.findByUsername(username); }
  
  @Override public void addRoleToUser(String username, String roleName) { //
  
  }
  
  
  
  }
 
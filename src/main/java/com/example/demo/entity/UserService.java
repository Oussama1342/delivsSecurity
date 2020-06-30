/*
 * package com.example.demo.entity;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * import org.springframework.stereotype.Service;
 * 
 * import com.example.demo.DAO.UsersRepository;
 * 
 * @Service("userservice") public class UserService implements
 * UserDetailsService {
 * 
 * @Autowired private UsersRepository usersRepository ;
 * 
 * 
 * @Override public UserDetails loadUserByUsername(String username) throws
 * UsernameNotFoundException {
 * 
 * Users user = usersRepository.findByUserbane(username);
 * 
 * 
 * return null; }
 * 
 * }
 */

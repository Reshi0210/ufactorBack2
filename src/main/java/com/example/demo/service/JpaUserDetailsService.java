package com.example.demo.service;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.SecurityUser;
import com.example.demo.models.User;
import com.example.demo.models.Worker;
import com.example.demo.repository.JpaUserDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import utilities.AgeUtilities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;

@Service
@AllArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

    private JpaUserDetailsRepository jpaUserDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var user=jpaUserDetailsRepository.findByUsername(username);
        return user.map(SecurityUser::new).orElseThrow(()->new UsernameNotFoundException("User Not found: "+username));
    }

    public List<User> findAll(){
       return jpaUserDetailsRepository.findAll();
    }

     public User findById(Long id){
        return jpaUserDetailsRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Resource not found"));
    }

    public ResponseEntity<User> create(User u) {
        jpaUserDetailsRepository.save(u);
        return ResponseEntity.ok(u);

    }

    public User update(Long id){
        return jpaUserDetailsRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Resource not found"));
    }

      public ResponseEntity<User> update(long id, User u2 ) {

      User  u = jpaUserDetailsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Missmatch error"));
        u2.setId(u.getId());
        jpaUserDetailsRepository.save(u2);
        return ResponseEntity.ok(u2);

    }



    public ResponseEntity<Map<String, Boolean>> delete(long CI) {

       User u1 = jpaUserDetailsRepository.findById(CI).orElseThrow(() -> new ResourceNotFoundException("Missmatch error"));
        jpaUserDetailsRepository.delete(u1);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    public User getlogedUser(String userName){
        return jpaUserDetailsRepository.findByUsername(userName).orElseThrow(() -> new ResourceNotFoundException("Missmatch error"));
    }
}

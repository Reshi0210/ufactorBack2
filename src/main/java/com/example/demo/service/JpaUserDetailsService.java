package com.example.demo.service;

import com.example.demo.models.SecurityUser;
import com.example.demo.repository.JpaUserDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

    private JpaUserDetailsRepository jpaUserDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var user=jpaUserDetailsRepository.findByUsername(username);
        return user.map(SecurityUser::new).orElseThrow(()->new UsernameNotFoundException("User Not found: "+username));
    }
}

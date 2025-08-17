package com.shopperx.shopperxapi.services;

import com.shopperx.shopperxapi.entities.UserPrincipal;
import com.shopperx.shopperxapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.shopperx.shopperxapi.entities.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDetails register(){

        return null;
    }

    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
        User user = userRepository.findUsersByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException(String.format("User with username: %s not found", username) );
        }
        return new UserPrincipal(user);
    }
}

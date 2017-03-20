/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jasperprojects.starter.security;

/**
 *
 * @author Bert
 */

import com.jasperprojects.starter.domain.User;
import com.jasperprojects.starter.repository.UserRepository;
import com.jasperprojects.starter.security.UserNotActivatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Component("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {

    private UserRepository userRepo;

    @Autowired
    public UserDetailServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username)
                throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if(user!=null){
            if(!user.isEnabled())
                throw new UserNotActivatedException("User " + username + " was not activated");
            else return user;
        } else{
            throw new UsernameNotFoundException("Invalid username");
        }
    }
}

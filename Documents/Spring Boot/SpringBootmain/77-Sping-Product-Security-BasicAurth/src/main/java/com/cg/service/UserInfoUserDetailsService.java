package com.cg.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.cg.config.UserInfoUserDetails;
import com.cg.model.UserInfo;
import com.cg.repository.UserInfoRepository;

import java.util.Optional;
 
@Component
public class UserInfoUserDetailsService implements UserDetailsService {
 
    @Autowired
    private UserInfoRepository repository;
 
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = repository.findByName(username);
        return userInfo.map(UserInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));
 
    }
}
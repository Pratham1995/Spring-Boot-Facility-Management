package com.example.Service;

import com.example.Model.UserJPA;
import com.example.web.DTO.UserReistrationDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService  extends UserDetailsService {
    UserJPA save(UserReistrationDTO userReistrationDTO);
    UserJPA findByEmail(String email);
}

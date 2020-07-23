package com.example.Service;

import com.example.Model.RoleJPA;
import com.example.Model.UserJPA;
import com.example.Repository.UserRepository;
import com.example.web.DTO.UserReistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserJPA findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserJPA save(UserReistrationDTO userReistrationDTO) {
        UserJPA userJPA=new UserJPA(userReistrationDTO.getFirstname(),
                userReistrationDTO.getLastname(),
                userReistrationDTO.getEmail(),
                bCryptPasswordEncoder.encode(userReistrationDTO.getPassword()),
                Arrays.asList(new RoleJPA("Role_User")));

        return userRepository.save(userJPA);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserJPA userJPA= userRepository.findByEmail(username);
        if(userJPA==null){
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new org.springframework.security.core.userdetails.User(userJPA.getEmail(),userJPA.getPassword(),mapRolestoAuthorities(userJPA.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolestoAuthorities(Collection<RoleJPA> roles){
        return roles.stream().map(role->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}

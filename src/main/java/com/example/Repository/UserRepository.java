package com.example.Repository;

import com.example.Model.UserJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserJPA,Long> {

    UserJPA findByEmail(String email);

}

package com.edhealthbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edhealthbackend.Model.User;

public interface UserRepo extends JpaRepository<User,Long>{

    User findByEmail(String userEmail);

}

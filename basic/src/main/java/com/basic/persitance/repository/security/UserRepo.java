package com.basic.persitance.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;

import com.basic.persitance.model.security.User;

public interface UserRepo extends JpaRepository<User, Long> {

}

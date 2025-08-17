package com.shopperx.shopperxapi.repository;

import com.shopperx.shopperxapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    User findUsersByUsername(String username);
}

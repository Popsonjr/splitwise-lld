package com.example.lld_demo.repositories;

import com.example.lld_demo.domain.model.User;
import org.springframework.data

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existByEmailIgnoreCase(String email);
}

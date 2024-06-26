package com.example.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface UserRepository extends JpaRepository<User, Integer> {
    User getByPhone(String phone);
    Optional<User> findByPhone(String phone);
    User findByPhoneAndPassword(String phone, String password);
    List<User> findAllById(int id);

}

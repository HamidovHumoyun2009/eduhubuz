package com.example.auth;

import com.example.util.jwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String register(User user) {
        Optional<User> optionalUser = userRepository.findByPhone(user.getPhone());

        if (optionalUser.isPresent()){
            return "Bu user oldin ro'yxatdan o'tgan";
        }
        User savedUser = userRepository.save(user);
        return savedUser.toString();
    }

    public TokenResponse login(User user) {

        User u = userRepository
                .findByPhoneAndPassword(user.getPhone(), user.getPassword());

        String token = jwtUtil.encode(u.getId(), u.getRole());

        return new TokenResponse(u.getId(), u.getRole(), token);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }
}

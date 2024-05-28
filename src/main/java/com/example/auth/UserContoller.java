package com.example.auth;

import com.example.exp.UnAuthorizedException;
import com.example.util.jwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserContoller {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody User user){
        return userService.register(user);
    }
    @PostMapping("/login")
    public TokenResponse getAll(@RequestBody User user) {
        return userService.login(user);
    }

    @GetMapping("/get-all")
    public HttpEntity<List<User>>getAllUsers(HttpServletRequest request){
        if (jwtUtil.checkRole(request, UserRole.ADMIN)) {
            return ResponseEntity.ok(userService.getAll());
        }
        throw new UnAuthorizedException();
    }
}

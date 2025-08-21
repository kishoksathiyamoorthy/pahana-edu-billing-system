package com.pahanaedu.billingsystem.controller;

import com.pahanaedu.billingsystem.model.User;
import com.pahanaedu.billingsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // REGISTER
    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody User user) {
        Map<String, String> response = new HashMap<>();

        if (userRepository.existsByEmail(user.getEmail())) {
            response.put("error", "Email already in use");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(user.getRole() != null ? user.getRole() : "user");
        userRepository.save(user);

        response.put("message", "User registered successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // LOGIN
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> loginData) {
        Map<String, String> response = new HashMap<>();

        String email = loginData.get("email");
        String rawPassword = loginData.get("password");

        User user = userRepository.findByEmail(email);

        if (user == null) {
            response.put("error", "Invalid email");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
            response.put("error", "Invalid password");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        response.put("message", "Login successful");
        response.put("id", String.valueOf(user.getId()));
        response.put("role", user.getRole());
        response.put("username", user.getUsername());

        return ResponseEntity.ok(response);
    }

    // Update email
    @PutMapping("/users/{id}")
    public ResponseEntity<Map<String, String>> updateEmail(
            @PathVariable Long id, @RequestBody Map<String, String> updateData) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) return ResponseEntity.notFound().build();
        user.setEmail(updateData.get("email"));
        userRepository.save(user);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Email updated successfully");
        return ResponseEntity.ok(response);
    }

    // Reset password
    @PutMapping("/users/reset-password")
    public ResponseEntity<Map<String, String>> resetPassword(@RequestBody Map<String, String> data) {
        Long id = Long.parseLong(data.get("id"));
        String oldPassword = data.get("oldPassword");
        String newPassword = data.get("newPassword");

        User user = userRepository.findById(id).orElse(null);
        if (user == null) return ResponseEntity.notFound().build();

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (!encoder.matches(oldPassword, user.getPassword())) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Old password is incorrect");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
        }

        user.setPassword(encoder.encode(newPassword));
        userRepository.save(user);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Password reset successfully");
        return ResponseEntity.ok(response);
    }


    // LOGOUT
    @PostMapping("/logout")
    public ResponseEntity<Map<String, String>> logout() {
        // For stateless JWT, nothing to do on backend
        Map<String, String> response = new HashMap<>();
        response.put("message", "Logged out successfully");
        return ResponseEntity.ok(response);
    }

}

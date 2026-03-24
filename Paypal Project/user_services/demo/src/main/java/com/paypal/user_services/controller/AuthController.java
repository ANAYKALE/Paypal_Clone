package com.paypal.user_services.controller;

import com.paypal.user_services.Entity.User;
import com.paypal.user_services.dto.JwtResponse;
import com.paypal.user_services.dto.LoginRequest;
import com.paypal.user_services.dto.SignUpRequest;
import com.paypal.user_services.repository.UserRepository;
import com.paypal.user_services.utils.JWTUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

private final UserRepository userRepository;

private final PasswordEncoder passwordEncoder;

private final JWTUtil jwtUtil;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder, JWTUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

@PostMapping("/signup")
public ResponseEntity<?> signup(@RequestBody SignUpRequest request){
    Optional<User> existingUser=userRepository.findByEmail(request.getEmail());
    if(existingUser.isPresent()){
        return ResponseEntity.badRequest().body("User Already Exists");
    }

    User user=new User();
    user.setName(request.getName());
    user.setEmail(request.getEmail());
    user.setRole("ROLE_USER");
    user.setPassword(passwordEncoder.encode(request.getPassword()));
    userRepository.save(user);
    User saveUser=userRepository.save(user);

    return ResponseEntity.ok("User Registered successfully");

    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){
        Optional<User> userOpt=userRepository.findByEmail(request.getEmail());
        if(userOpt.isEmpty()){
            return ResponseEntity.status(401).body("User Not Found");
        }
        User user =userOpt.get();
        if(!passwordEncoder.matches(request.getPassword(),user.getPassword())){
            return ResponseEntity.status(401).body("Invalidate credential");
        }

        Map<String ,Object> claims =new HashMap<>();
        claims.put("role",user.getRole());

        String token=jwtUtil.generateToken(claims,user.getEmail());

        return ResponseEntity.ok(new JwtResponse(token));

    }




}

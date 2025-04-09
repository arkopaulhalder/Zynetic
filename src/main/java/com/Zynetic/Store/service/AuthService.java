package com.Zynetic.Store.service;

import com.Zynetic.Store.dto.JwtResponse;
import com.Zynetic.Store.dto.UserRequest;
import com.Zynetic.Store.model.User;
import com.Zynetic.Store.repository.UserRepository;
import com.Zynetic.Store.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.Zynetic.Store.repository.UserRepository;
import com.Zynetic.Store.security.JwtUtil;

@Service
public class AuthService {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthService(UserRepository userRepo,PasswordEncoder passwordEncoder,JwtUtil jwtUtil) {
        this.userRepo=userRepo;
        this.jwtUtil=jwtUtil;
        this.passwordEncoder=passwordEncoder;
    }

    public String register(UserRequest request){
        User user= new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepo.save(user);
        return "You have been logged IN";
    }

    public JwtResponse login(UserRequest request)throws Exception{
        User user = userRepo.findByEmail(request.getEmail()).orElse(null);

        if(user == null || !passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new Exception("Invalid credentials Try Again");
        }

        String token = jwtUtil.generateToken(user.getEmail());
        return new JwtResponse(token);
    }
}
package com.Zynetic.Store.controller;

import com.Zynetic.Store.dto.JwtResponse;
import com.Zynetic.Store.dto.UserRequest;
import com.Zynetic.Store.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    //user sign-up
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody UserRequest request){
        String message = authService.register(request);
        return ResponseEntity.ok(message);
    }

    //user sign-in
    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> login (@RequestBody UserRequest request) {
        try{
            JwtResponse token = authService.login(request);
            return ResponseEntity.ok(token);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
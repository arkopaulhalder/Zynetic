package com.Zynetic.Store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class JwtResponse {
    private String token;
    public JwtResponse() {
    }
    public JwtResponse(String token) {
        this.token = token;

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
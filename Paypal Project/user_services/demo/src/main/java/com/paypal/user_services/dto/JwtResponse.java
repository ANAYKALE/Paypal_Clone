package com.paypal.user_services.dto;

public class JwtResponse {

    private String Token;

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public JwtResponse(String token) {
        Token = token;
    }

    public JwtResponse() {
    }
}

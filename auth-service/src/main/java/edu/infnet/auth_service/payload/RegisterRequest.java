package edu.infnet.auth_service.payload;

public record RegisterRequest(String username, String password, String email) {
}

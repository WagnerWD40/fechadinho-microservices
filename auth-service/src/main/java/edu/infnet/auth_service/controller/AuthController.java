package edu.infnet.auth_service.controller;

import edu.infnet.auth_service.payload.LoginRequest;
import edu.infnet.auth_service.payload.RegisterRequest;
import edu.infnet.auth_service.payload.ResponsePayload;
import edu.infnet.auth_service.service.AuthService;
import edu.infnet.auth_service.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/auth")
    public ResponseEntity<ResponsePayload> auth(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(new ResponsePayload(authService.authenticate(loginRequest)));
    }

    @PostMapping("/register")
    public ResponseEntity<ResponsePayload> register(@RequestBody RegisterRequest registerRequest) {
        try {
            authService.register(registerRequest);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }

        LoginRequest login = new LoginRequest(registerRequest.username(), registerRequest.password());

        return ResponseEntity.ok(new ResponsePayload(authService.authenticate(login)));
    }
}

package edu.infnet.auth_service.service;

import edu.infnet.auth_service.model.Role;
import edu.infnet.auth_service.model.User;
import edu.infnet.auth_service.payload.LoginRequest;
import edu.infnet.auth_service.payload.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public User register(RegisterRequest registerRequest) {
        var user = User.builder()
            .username(registerRequest.username())
            .password(passwordEncoder.encode(registerRequest.password()))
            .email(registerRequest.email())
            .role(Role.USER)
            .build();

        return userService.create(user);
    }

    public String authenticate(LoginRequest loginRequest) {
        var userAuth = new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password());
        Authentication authentication = authenticationManager.authenticate(userAuth);

        User usuarioAutenticado = (User) authentication.getPrincipal();

        List<String> roles = authentication.getAuthorities()
                                            .stream()
                                            .map(GrantedAuthority::getAuthority)
                                            .toList();

        return jwtService.generateToken(usuarioAutenticado, roles);
    }


}

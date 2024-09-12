package usermanagement.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usermanagement.auth.AuthenticationRequest;
import usermanagement.auth.AuthenticationResponse;
import usermanagement.auth.RegisterRequest;
import usermanagement.config.JwtService;
import usermanagement.enums.Role;
import usermanagement.model.User;
import usermanagement.service.AuthenticationService;

import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {

    private final AuthenticationService authenticationService;

    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register
            (@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/register-admin")
    public ResponseEntity<AuthenticationResponse> registerAdmin
            (@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authenticationService.registerAdmin(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login
            (@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.login(request));
    }

    @GetMapping("/validate")
    public ResponseEntity<String> validateToken(@RequestParam String token) {
        try {
            String username = jwtService.extractUsername(token);

            if (jwtService.validateToken(token)) {
                return ResponseEntity.ok("Token is valid for user: " + username);
            } else {
                return ResponseEntity.badRequest().body("Invalid token");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid token: " + e.getMessage());
        }
    }

    @GetMapping("/userRole")
    public ResponseEntity<List<User>> getUsersByRole(@RequestParam Role role) {
        List<User> users = authenticationService.getUsersByRole(role);
        return ResponseEntity.ok(users);
    }
}

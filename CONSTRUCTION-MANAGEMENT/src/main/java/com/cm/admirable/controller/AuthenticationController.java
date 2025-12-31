package com.cm.admirable.controller;
/*
* AUTHENTICATION CONTROLLOR CLASS HELPS TO LOGIN AND REGISTER NEW USERS
* */
import com.cm.admirable.dto.LoginRequest;
import com.cm.admirable.dto.LoginResponse;
import com.cm.admirable.dto.RegisterResponse;
import com.cm.admirable.dto.UserDto;
import com.cm.admirable.exceptions.UserNotFoundException;
import com.cm.admirable.service.AuthenticationService;
import com.cm.admirable.service.RegistractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class AuthenticationController {

    private AuthenticationService authenticationService;
    private RegistractionService registractionService;

    @Autowired
//    private JwtUtil jwtUtil;

    public AuthenticationController(AuthenticationService authenticationService, RegistractionService registractionService) {
        this.authenticationService = authenticationService;
        this.registractionService = registractionService;

    }

    @PostMapping
    public ResponseEntity<LoginResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = null;
        try {
            loginResponse = authenticationService.authenticateUser(loginRequest);
            System.out.println("LOGIN REQUEST RECEIVED IN CONTROLLOR: " + loginRequest);
        } catch (UserNotFoundException e) {
            System.out.println("User Not found. " + e.getMessage());
            return ResponseEntity.status(404).body(new LoginResponse("FAILED", "User Not found."));
        }
        return loginResponse != null ?
                ResponseEntity.ok(loginResponse) :
                ResponseEntity.status(401).body(new LoginResponse("FAILED", "Authentication failed."));

    }

    //    http://localhost:7787/api/register
    @PostMapping("/register")
    public RegisterResponse authenticateResiger(@RequestBody UserDto userDto) {
        return registractionService.registerUser(userDto);
    }
//    http://localhost:7787/api/exists
    @PostMapping("/exists")
    public RegisterResponse existsById(Long id) {
        return registractionService.existsById(id);
    }
@PostMapping("/findallbyid")
    public RegisterResponse findAllById(Long id) {
        return registractionService.findAllById(id);
    }
}
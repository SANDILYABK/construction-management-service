package com.cm.admirable.service;


import com.cm.admirable.dao.UserDAO;
import com.cm.admirable.dto.LoginRequest;
import com.cm.admirable.dto.LoginResponse;
import com.cm.admirable.entity.User;
import com.cm.admirable.exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class AuthenticationService {

    private UserDAO userDAO;

    public AuthenticationService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public LoginResponse authenticateUser(final LoginRequest loginRequest) {
        AtomicReference<LoginResponse> loginResponse = new AtomicReference<>();
        User userFromDB = userDAO.findByEmail(loginRequest.email());
        if( Objects.isNull(userFromDB)) {
            loginResponse.set(new LoginResponse("FAILED", "User Not found."));
            throw new UserNotFoundException("User with this email id : ".concat(loginRequest.email().concat(
                    " does not exist in our records")));
        }
        else {
            if (loginRequest.email().equals(userFromDB.getEmail()) &&
                  loginRequest.password().equals(userFromDB.getPassword())) {
                loginResponse.set(new LoginResponse("SUCCESS", "Login is success"));
            } else {
                loginResponse.set(new LoginResponse("FAILED", "User id and password do not match"));
            }
        }
        return loginResponse.get();
    }
}

package com.cm.admirable.service;
/*
* This class used to 
* Validate Email exist or not 
* Check all paraments before insertion 
* Load data
* */
import com.cm.admirable.dao.UserDAO;
import com.cm.admirable.dto.RegisterResponse;
import com.cm.admirable.dto.UserDto;
import com.cm.admirable.entity.User;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.cm.admirable.security.*;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class RegistractionService {
    private UserDAO userDAO;
    private JwtUtil jwtUtil;
    //private final PasswordEncoder passwordEncoder;

    public RegistractionService(UserDAO userDAO) {
        this.userDAO=userDAO;
        //this.passwordEncoder = passwordEncoder;
        //this.jwtUtil=jwtUtil;
    }
    public RegisterResponse registerUser(UserDto userDto) {
        AtomicReference<RegisterResponse> registerRes = new AtomicReference<>();
        User user = new User();
        user.setFirstName(userDto.firstName());
        user.setLastName(userDto.lastName());
        user.setEmail(userDto.email());
        user.setPassword(userDto.password());
        user.setPhone(userDto.phone());
        user.setStatus(User.Status.ACTIVE);
        User savedUsers= userDAO.save(user);
        return new RegisterResponse("User Registed Successfully");
    }

    public RegisterResponse existsById(Long id) {
        AtomicReference<RegisterResponse> registerRes = new AtomicReference<>();
        if (userDAO.existsById(id)) {
            registerRes.set(new RegisterResponse("User Exists"));
            System.out.println("User Exists");
        } else {
            registerRes.set(new RegisterResponse("User Not Exists"));
        }
        return registerRes.get();
    }

    public RegisterResponse findAllById(Long id) {
        AtomicReference<RegisterResponse> registerRes = new AtomicReference<>();
        if (userDAO.findById(id).isPresent()) {
            registerRes.set(new RegisterResponse("User Found"));
            System.out.println("User Found");
        } else {
            registerRes.set(new RegisterResponse("User Not Found"));
        }
        return registerRes.get();
    }
}

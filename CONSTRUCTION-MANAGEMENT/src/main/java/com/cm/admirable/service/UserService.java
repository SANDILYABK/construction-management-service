package com.cm.admirable.service;

import com.cm.admirable.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public UserDto createUser(UserDto userDto) {
        return new UserDto();
    }
    public UserDto getUser(String id) {
        return new UserDto();
    }

}

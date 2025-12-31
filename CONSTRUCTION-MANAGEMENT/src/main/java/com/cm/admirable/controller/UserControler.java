package com.cm.admirable.controller;

import com.cm.admirable.dto.UserDto;
import com.cm.admirable.service.UserService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/cmusers")
public class UserControler {
    private final UserService service;

    public UserControler(UserService service) {
        this.service = service;
    }
    // http://localhost:7787/api/cmusers

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto){
        return service.createUser(userDto);
    }

    // http://localhost:7787/api/
    @GetMapping("/{id}")
    public UserDto getId(@PathVariable String id){
        return service.getUser(id);
    }
    @GetMapping("/phone/{phone}")
    public UserDto FindByPhone(@PathVariable String phone) {
        return service.getUser(phone);
    }
}

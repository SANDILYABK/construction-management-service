package com.cm.admirable.dto;

public record UserDto(String id, String firstName, String lastName, String email,String phone, String password) {
    public UserDto() {
        this("","","","","","");
    }

}

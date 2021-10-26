package com.mon.bbn.model;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {

    private final String username;
    private final String password;
    private final String fullname;
    private final String email;
    private final String phoneNumber;
    private final String country;
    private final String state;
    private final String city;

    public User toUser(PasswordEncoder passwordEncoder){
        return new User(username, passwordEncoder.encode(password), fullname, email, phoneNumber, country, state, city);
    }

}

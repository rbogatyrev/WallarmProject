package com.wallarm.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private String firstName;
    private String lastName;
    private String position;
    private String companyName;
    private String password;
    private String email;
    private String phone;

}

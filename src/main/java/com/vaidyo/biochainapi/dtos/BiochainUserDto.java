package com.vaidyo.biochainapi.dtos;

import lombok.Data;
@Data
public class BiochainUserDto {
    String username;
    String password;
    String firstName;
    String lastName;
    String dateOfBirth;
    String gender;
}

package com.vaidyo.biochainapi.controllers;

import com.vaidyo.biochainapi.entities.UserData;
import com.vaidyo.biochainapi.entities.UserList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.vaidyo.biochainapi.dtos.BiochainUserDto;
import java.util.HashMap;

@RestController()
public class SignupSignInController {

//    public static class UserList {
//        public static HashMap<String, UserData> users = new HashMap<>();
//    }
//

    @PostMapping("biochain/signup")
    public ResponseEntity<String> biochainSignup(@RequestBody BiochainUserDto biochainUser){

        if(UserList.users.get(biochainUser.getUsername()) != null){
            return ResponseEntity.badRequest().body("User already exists");
        }
        UserData userData = new UserData();
        int userId = UserList.users.size() + 1;
        userData.setUserId("BCU-" + userId );
        userData.setUsername(biochainUser.getUsername());
        userData.setPassword(biochainUser.getPassword());
        userData.setFirsName(biochainUser.getFirstName());
        userData.setLastName(biochainUser.getLastName());
        userData.setDateOfBirth(biochainUser.getDateOfBirth());
        userData.setGender(biochainUser.getGender());
        UserList.users.put(biochainUser.getUsername(),  userData);
        return ResponseEntity.ok("Signup Successful" + ", - User created with UserId: " + userData.getUserId());
    }

    @PostMapping("biochain/signin")
    public ResponseEntity<String> biochainSignIn(@RequestBody BiochainUserDto biochainUser){

        if(UserList.users.get(biochainUser.getUsername()) != null && UserList.users.get(biochainUser.getUsername()).getPassword().equals(biochainUser.getPassword())){
            return ResponseEntity.ok("Login successful");
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}


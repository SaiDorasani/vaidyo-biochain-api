package com.vaidyo.biochainapi.controllers;

import com.vaidyo.biochainapi.blockchain.Bioblock;
import com.vaidyo.biochainapi.blockchain.Biochain;
import com.vaidyo.biochainapi.dtos.BioblockDto;
import com.vaidyo.biochainapi.entities.UserData;
import com.vaidyo.biochainapi.entities.UserList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Collections;
import java.util.List;

@RestController
public class BiochainController {

    @RequestMapping("/")
    public String helloVaidyoBiochain(){
        return "Hello Vaidyo Biochain - A blockchain for healthcare";
    }

    @PostMapping("biochain/bioblocks/create")
    public ResponseEntity<String> biochainCreateBlock(@RequestBody BioblockDto bioblockDto){

        String bioblockData = bioblockDto.toString();
        String previousHash = "0";
        List<Bioblock> biochainList = Biochain.getInstance().getBlockchain();
        if(biochainList.size() > 0) {
            previousHash = biochainList.get(biochainList.size() - 1).getHash();
        }
        //Create blockchain block
        Bioblock bioblock = new Bioblock(bioblockData, previousHash, Instant.now().toEpochMilli());
        biochainList.add(bioblock);
        return ResponseEntity.ok("Bio Block added successfully");
    }

    @PostMapping("patients/biochain/bioblocks/create")
    public ResponseEntity<String> biochainPatientsCreateBlock(@RequestBody BioblockDto bioblockDto){

        String bioblockData = bioblockDto.toString();
        String previousHash = "0";
        List<Bioblock> biochainList = Biochain.getInstance().getBlockchain();
        if(biochainList.size() > 0) {
            previousHash = biochainList.get(biochainList.size() - 1).getHash();
        }
        //Create blockchain block
        Bioblock bioblock = new Bioblock(bioblockData, previousHash, Instant.now().toEpochMilli());
        biochainList.add(bioblock);
        return ResponseEntity.ok("Bio Block added successfully");
    }

    @PostMapping("patients/biochain/bioblocks/create/{username}")
    public ResponseEntity<String> biochainPatientsCreateBlockByUsername(@PathVariable String username, @RequestBody BioblockDto bioblockDto){


        UserData userData = UserList.users.get(username);
        if(bioblockDto.getKey().equals("weight")){
            userData.setWeight(bioblockDto.getValue());
        } else
        if(bioblockDto.getKey().equals("height")){
            userData.setHeight(bioblockDto.getValue());
        } else
        if(bioblockDto.getKey().equals("bp")){
            userData.setBp(bioblockDto.getValue());
        } else
        if(bioblockDto.getKey().equals("oxygen")){
            userData.setOxygen(bioblockDto.getValue());
        }

        UserList.users.put(username, userData);
        String bioblockData = bioblockDto.toString();
        String previousHash = "0";
        List<Bioblock> biochainList = Biochain.getInstance().getBlockchain();
        if(biochainList.size() > 0) {
            previousHash = biochainList.get(biochainList.size() - 1).getHash();
        }
        //Create blockchain block
        Bioblock bioblock = new Bioblock(bioblockData, previousHash, Instant.now().toEpochMilli());
        biochainList.add(bioblock);
        return ResponseEntity.ok("Bio Block added successfully");
    }


    @GetMapping("patients/biochain/bioblocks/fetchby/{username}")
    public List<Bioblock> biochainsCreatedBlockByUsername(@PathVariable String username) {
        List<Bioblock> biochainList = Biochain.getInstance().getBlockchain();
        Collections.reverse(biochainList);
        return biochainList;
    }
}

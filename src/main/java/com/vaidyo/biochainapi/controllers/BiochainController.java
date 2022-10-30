package com.vaidyo.biochainapi.controllers;

import com.vaidyo.biochainapi.blockchain.Bioblock;
import com.vaidyo.biochainapi.blockchain.Biochain;
import com.vaidyo.biochainapi.dtos.BioblockDto;
import com.vaidyo.biochainapi.dtos.BiochainUserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

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
}


package com.vaidyo.biochainapi.controllers;

import com.vaidyo.biochainapi.dtos.PatientDto;
import com.vaidyo.biochainapi.entities.UserData;
import com.vaidyo.biochainapi.entities.UserList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PatientController {
//
//    @GetMapping("biochain/provider/patients")
//    public List<PatientDto> biochainGetPatients(){
//        List<UserData> userDataList = new ArrayList<UserData>(UserList.users.values());
//        List<PatientDto> patientDtoList = PatientDto.toPatientDtoList(userDataList);
//        return patientDtoList;
//    }

//    public ResponseEntity<String> biochainCreateBlock(@RequestBody BioblockDto bioblockDto){
//
//        String bioblockData = bioblockDto.toString();
//        String previousHash = "0";
//        List<Bioblock> biochainList = Biochain.getInstance().getBlockchain();
//        if(biochainList.size() > 0) {
//            previousHash = biochainList.get(biochainList.size() - 1).getHash();
//        }
//        //Create blockchain block
//        Bioblock bioblock = new Bioblock(bioblockData, previousHash, Instant.now().toEpochMilli());
//        biochainList.add(bioblock);
//        return ResponseEntity.ok("Bio Block added successfully");
//    }
}


package com.vaidyo.biochainapi.dtos;

import com.vaidyo.biochainapi.entities.UserData;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PatientDto {
    String username;
    String firstName;
    String lastName;
    String dateOfBirth;
    String userId;
    String gender;
    String weight;
    String height;
    String bp;
    String oxygen;
    public static List<PatientDto> toPatientDtoList(List<UserData> userDataList) {
        List<PatientDto> patientDtoList = new ArrayList<>();
       userDataList.forEach(userData -> {
           PatientDto patientDto = new PatientDto();
           patientDto.firstName = userData.getFirsName();
           patientDto.lastName = userData.getLastName();
           patientDto.dateOfBirth = userData.getDateOfBirth();
           patientDto.userId = userData.getUserId();
           patientDto.username = userData.getUsername();
           patientDto.gender = userData.getGender();
           patientDto.weight = userData.getWeight();
           patientDto.height = userData.getHeight();
           patientDto.bp = userData.getBp();
           patientDto.oxygen = userData.getOxygen();
           patientDtoList.add(patientDto);
       });
        return patientDtoList;
    }
}

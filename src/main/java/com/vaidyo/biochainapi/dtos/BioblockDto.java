package com.vaidyo.biochainapi.dtos;

import lombok.Data;

@Data
public class BioblockDto {
    String userId;
    String data; //type:(any one of: healthIndex, vaccineInfo, labOrder, prescriptions
}

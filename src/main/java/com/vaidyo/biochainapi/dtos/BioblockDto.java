package com.vaidyo.biochainapi.dtos;

import lombok.Data;

@Data
public class BioblockDto {
    String userId;
    String key; //type:(any one of: healthIndex, vaccineInfo, labOrder, prescriptions
    String value;
}

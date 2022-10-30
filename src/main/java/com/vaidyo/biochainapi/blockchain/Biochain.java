package com.vaidyo.biochainapi.blockchain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

//Biochain singleton Instance
@Data
public class Biochain {
    private static Biochain biochainSingleton;
    List<Bioblock> blockchain = new ArrayList<>();
    int prefix = 4;
    String prefixString = new String(new char[prefix]).replace('\0', '0');

    public static Biochain getInstance() {
        if(biochainSingleton == null) {
            biochainSingleton = new Biochain();
        }

        return biochainSingleton;
    }
}

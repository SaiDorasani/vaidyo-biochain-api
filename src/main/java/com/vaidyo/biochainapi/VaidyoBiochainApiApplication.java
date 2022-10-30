package com.vaidyo.biochainapi;

import com.vaidyo.biochainapi.blockchain.Biochain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VaidyoBiochainApiApplication {
    public static Biochain vaidyoBiochain = new Biochain();

    public static void main(String[] args) {
        SpringApplication.run(VaidyoBiochainApiApplication.class, args);
    }

}

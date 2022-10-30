package com.vaidyo.biochainapi.blockchain;

import lombok.Data;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;

import static java.nio.charset.StandardCharsets.UTF_8;

@Data
public class Bioblock {
    private String previousHash;
    private String data;
    private String hash;
    private int nonce;
    private long timeStamp;

    public Bioblock(String data, String previousHash, long timeStamp) {
        this.previousHash = previousHash;
        this.data = data;
        this.timeStamp = timeStamp;
        this.hash = calculateBioBlockHash();
    }
    public String calculateBioBlockHash() {
        String dataToHash = previousHash
                + Long.toString(timeStamp)
                + Integer.toString(nonce)
                + data;
        MessageDigest digest = null;
        byte[] bytes = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            bytes = digest.digest(dataToHash.getBytes(UTF_8));
        }  catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        StringBuffer buffer = new StringBuffer();
        for (byte b : bytes) {
            buffer.append(String.format("%02x", b));
        }
        return buffer.toString();
    }
}

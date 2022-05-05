package com.example.aes256_ecb;

public class AES{
    protected String key;

    AES(String key) {
        this.key = key;
    }

    public String getAES_key() {
        return this.key;
    }


    public void setAES_key(String key) {
        this.key = key;
    }

}

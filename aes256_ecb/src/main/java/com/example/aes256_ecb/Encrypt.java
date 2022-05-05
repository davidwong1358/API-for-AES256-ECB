package com.example.aes256_ecb;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.*;

public class Encrypt extends AES {
    private String plain_text;
    
    Encrypt(String key, String text) {
        super(key);
        this.plain_text = text;    
    }

    public String getPlain_text() {
        return this.plain_text;
    }

    public void setPlain_text(String text){
        this.plain_text = text;
    }

    public String encrypt(){
        try{
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            final SecretKeySpec secretKey = new SecretKeySpec(this.key.getBytes(), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            final String encryptedString = Hex.encodeHexString(cipher.doFinal(this.plain_text.getBytes())).toUpperCase();
            return String.format("{\"cipher_text\":\"%s\"}",encryptedString);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

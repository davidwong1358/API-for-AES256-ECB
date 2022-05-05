package com.example.aes256_ecb;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.*;

public class Decrypt extends AES {
    private String cipher_text;

    Decrypt(String key, String text) {
        super(key);
        this.cipher_text = text;    
    }

    public String getCipher_text() {
        return this.cipher_text;
    }

    public void setCipher_text(String text){
        this.cipher_text = text;
    }

    public String decrypt(){
        try
        {
            String encrypted = Base64.encodeBase64String(Hex.decodeHex(this.cipher_text.toCharArray()));
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            final SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            final String decryptedString = new String(cipher.doFinal(Base64.decodeBase64(encrypted)));
            final String encodedString = new String(Base64.encodeBase64(decryptedString.getBytes()));
            return String.format("{\"plain_text\":\"%s\",\"base64\":\"%s\"}",
                                decryptedString, encodedString);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
package com.example.aes256_ecb;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @PostMapping("/aes/encrypt")
    String encryptMessage(@RequestBody Encrypt newInput){
        String encrypted = newInput.encrypt();
        return encrypted;
    }

    @PostMapping("/aes/decrypt")
    String decryptMessage(@RequestBody Decrypt newInput){
        String decrypted = newInput.decrypt();
        return decrypted;
    }
}
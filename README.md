# About AES256-ECB API
This is an API for encrypting and decrypting messages with using AES256 (ECB Mode).

The API is implemented by Springboot 2.6.7 with Java 8.

# Encryption 
Use this by **HTTP POST /aes/encrypt**

This API accepts **JSON** data which provided **Plain Text** & **AES Key** for encryption by **POST** Method.

Here is an example for proper JSON data to encrypt message:
```
{
  "plain_text": "Apple",
  "aes_key": "404D635166546A576E5A723475377721"
}
```
The expected result will be:
```
{
  "cipher_text": "C9E461E80EC3047944ACAE96A9896BC3"
}
```

# Decryption 
Use this by **HTTP POST /aes/decrypt**

This API accepts **JSON** data which provided **Cipher Text** & **AES Key** for decryption by **POST** Method.

Here is an example for proper JSON data to decrypt message:
```
{
  "cipher_text": "C9E461E80EC3047944ACAE96A9896BC3",
  "aes_key": "404D635166546A576E5A723475377721"
}
```
The expected result will be:
```
{
  "plain_text ": "Apple",
  "base64": "QXBwbGU="
}
```

# Credit
Credits to this for AES256 Encryption & Decryption:

https://stackoverflow.com/questions/66953606/java-aes-128-ecb-to-aes-256-ecb-conversion

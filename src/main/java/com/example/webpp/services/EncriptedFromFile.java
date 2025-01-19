package com.example.webpp.services;

import org.springframework.stereotype.Service;

import javax.crypto.*;
import javax.xml.xpath.XPath;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Service
public class EncriptedFromFile {
    public String encryped(String secretMessage) {
        KeyGenerator keyGenerator = null;
        String encodedMessage = null;
        try {
            keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128); // Указываем размер ключа
            SecretKey secretKey = keyGenerator.generateKey();

            // Создание экземпляра Cipher для алгоритма AES
            Cipher cipher = Cipher.getInstance("AES");

            // Инициализация Cipher в режиме шифрования с нашим ключом
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
//            String secretMessage = "Это секретное сообщение";
            byte[] encryptedMessage = cipher.doFinal(secretMessage.getBytes());

            // Преобразование зашифрованного сообщения в строку для отправки
            encodedMessage = Base64.getEncoder().encodeToString(encryptedMessage);
            System.out.println("Зашифрованное сообщение: " + encodedMessage);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return encodedMessage;
    }

    public String  decryted(String encodedMessage) {
        Cipher cipher = null;
        String decryptedMessage;

        try {
            cipher = Cipher.getInstance("AES");
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            SecretKey secretKey = keyGenerator.generateKey();

            // Инициализация Cipher в режиме дешифрования
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encodedMessage));
           decryptedMessage = new String(decryptedBytes);
            System.out.println("Расшифрованное сообщение: " + decryptedMessage);
        } catch (Exception e) {
            throw new RuntimeException(e);

        }

        return decryptedMessage;
    }

    public String readFile(String path) {
        String line = "";
        try (FileReader reader = new FileReader(path)) {
            // читаем посимвольно
            int c;
            while ((c = reader.read()) != -1) {
                line = line + (char) c;

            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
        return line;
    }
}

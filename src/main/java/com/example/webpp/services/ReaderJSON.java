package com.example.webpp.services;

import com.example.webpp.model.RootJSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class ReaderJSON {
    public String reader() {
        String path = "C:\\Users\\I\\IdeaProjects\\WebPP\\src\\main\\resources\\in.json";
//        StringBuilder resultStringBuilder = new StringBuilder();
//        try (InputStream inputStream = new FileInputStream(path);
//             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                resultStringBuilder.append(line).append("\n");
//            }
//
//        } catch (IOException e) {
//            System.out.println(e.getStackTrace());
//        }
//        System.out.println(resultStringBuilder);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
          RootJSON op =  objectMapper.readValue(new File(path), RootJSON.class);
            System.out.println(op);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "";
    }

}

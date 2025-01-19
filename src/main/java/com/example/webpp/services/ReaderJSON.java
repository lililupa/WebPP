package com.example.webpp.services;

import com.example.webpp.model.RootJSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class ReaderJSON {
    public String reader(String path) {
//        String path = "src/main/resources/in.json";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
          RootJSON op =  objectMapper.readValue(new File(path), RootJSON.class);
            System.out.println(op);
            FileWriter writer = new FileWriter("src/main/resources/fromJson.txt", false);

            for (String s : op.getOperation()) {
                    System.out.println(s);
                    writer.write(s+ "\n");
            }
            writer.flush();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "";
    }

}

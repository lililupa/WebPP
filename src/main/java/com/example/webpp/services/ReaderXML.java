package com.example.webpp.services;

import com.example.webpp.model.Root;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;

import java.io.*;

@Service

public class ReaderXML {
    String path = "src/main/resources/in.xml";

    public void parseXML(String xml) {
//    ObjectMapper objectMapper = new ObjectMapper();
//    try {
//        Root readValue = objectMapper.readValue(xml, Root.class);
//        System.out.println();
//    } catch (JsonProcessingException e) {
//        throw new RuntimeException(e);
//    }


        try {

            JAXBContext context = JAXBContext.newInstance(Root.class);
            Unmarshaller m = context.createUnmarshaller();
            Object reader = m.unmarshal(new StringReader(xml));
            StringWriter writer = new StringWriter();

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public String readFromInputStream() {

        StringBuilder resultStringBuilder = new StringBuilder();
        try (InputStream inputStream = new FileInputStream(path);
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }

        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
        System.out.println(resultStringBuilder);
        parseXML(resultStringBuilder.toString());
        return resultStringBuilder.toString();
    }

}
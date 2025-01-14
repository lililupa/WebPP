package com.example.webpp.controller;

import com.example.webpp.services.ReaderXML;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    private final  ReaderXML readerXML;

    public TestController(ReaderXML readerXML) {
        this.readerXML = readerXML;
    }
@GetMapping("/test")
    public String test(){
        readerXML.readFromInputStream();
return "";
    }
}

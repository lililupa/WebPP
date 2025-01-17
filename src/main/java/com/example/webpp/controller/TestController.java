package com.example.webpp.controller;

import com.example.webpp.services.ReaderJSON;
import com.example.webpp.services.ReaderXML;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    private final ReaderXML readerXML;
    private final ReaderJSON readerJSON;

    public TestController(ReaderXML readerXML, ReaderJSON readerJSON) {
        this.readerXML = readerXML;
        this.readerJSON = readerJSON;
    }

    @GetMapping("/test")
    public String test() {
        readerXML.parseXML();
        return "test";
    }
    @GetMapping("/json")
    public String json() {
        readerJSON.reader();
        return "test";
    }
}

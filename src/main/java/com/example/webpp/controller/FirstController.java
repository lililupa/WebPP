package com.example.webpp.controller;

import com.example.webpp.services.CalculateFromTextFile;
import com.example.webpp.services.EncriptedFromFile;
import com.example.webpp.services.ReaderJSON;
import com.example.webpp.services.ReaderXML;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FirstController {
    private final CalculateFromTextFile calculate;
    private final ReaderXML readXML;
    private final ReaderJSON readJSON;
    private final EncriptedFromFile encriptedFile;

    public FirstController(CalculateFromTextFile calculate, ReaderXML readXML, ReaderJSON readJSON, EncriptedFromFile encriptedFile) {
        this.calculate = calculate;
        this.readXML = readXML;
        this.readJSON = readJSON;
        this.encriptedFile = encriptedFile;
    }

    @GetMapping("/")
    public String first() {
        return "first";
    }

//    @PostMapping("/type")
//    public String type(String file, Model model) {
//        String pathIn = "src/main/resources/in.txt";
//        String toFile = calculate.transformInformationToFile(pathIn);
//        model.addAttribute("result", toFile);
//
//        return "first";
//    }
    @PostMapping("/action1")
    public String action1(Model model){
        String pathIn = "src/main/resources/in.txt";
        String toFile = calculate.transformInformationToFile(pathIn);
        model.addAttribute("result", toFile);

        return "first";
    }
    @PostMapping("/action2")
    public String action2(Model model){
        String path = "src/main/resources/in.xml";
     readXML.parseXML(path);

        String pathIn = "src/main/resources/fromxml.txt";
        String toFile = calculate.transformInformationToFile(pathIn);
        model.addAttribute("result", toFile);


        return "first";
    }
    @PostMapping("/action3")
    public String action3(Model model){
        String path = "src/main/resources/in.json";

        readJSON.reader(path);
        String pathIn = "src/main/resources/fromJson.txt";
        String toFile = calculate.transformInformationToFile(pathIn);
        model.addAttribute("result", toFile);
        return "first";
    }
    @PostMapping("/action4")
    public String action4(Model model){
        String path = "src/main/resources/in.txt";

        String readFile = encriptedFile.readFile(path);
        String encrypted = encriptedFile.encryped(readFile);
        String decrypted = encriptedFile.decryted(encrypted);
        model.addAttribute("result", "");
        System.out.println(readFile);
        System.out.println(encrypted);

        return "first";
    }
@PostMapping("/action5")
public String action5(Model model) {
    model.addAttribute("result", "");
    return "first";
}

}

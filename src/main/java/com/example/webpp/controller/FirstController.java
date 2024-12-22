package com.example.webpp.controller;

import com.example.webpp.services.CalculateFromTextFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FirstController {
    private final CalculateFromTextFile calculate;

    public FirstController(CalculateFromTextFile calculate) {
        this.calculate = calculate;
    }

    @GetMapping("/")
    public String first() {

        return "first";
    }

    @PostMapping("/type")
    public String type(String file, Model model) {
        String toFile = calculate.transformInformationToFile();
        model.addAttribute("result", toFile);

        return "first";
    }
}

package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class DataController {

    @GetMapping("/data")
    public Map<String, String> getData() {
        Map<String, String> response = new HashMap<>();
        response.put("mesaj", "Merhaba!");
        return response;
    }
}

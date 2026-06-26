package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*")
// Frontend'in backend'e erişebilmesi için kapıyı açıyoruz
@RestController
@RequestMapping("/api")
public class DataController {

    private final MesajRepository mesajRepository;

    public DataController(MesajRepository mesajRepository) {
        this.mesajRepository = mesajRepository;
    }

    @GetMapping("/data")
    public Map<String, String> getData() {
        Map<String, String> response = new HashMap<>();

        var latest = mesajRepository.findTopByOrderByCreatedAtDesc();
        String mesajText;

        if (latest.isPresent()) {
            mesajText = "mesaj var";
        } else {
            mesajText = "Veritabanından selamlar, henüz mesaj yok!";
            Mesaj m = new Mesaj(mesajText, LocalDateTime.now());
            mesajRepository.save(m);
        }

        response.put("mesaj", mesajText);
        return response;
    }
}

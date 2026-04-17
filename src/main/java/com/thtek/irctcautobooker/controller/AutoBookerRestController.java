package com.thtek.irctcautobooker.controller;


import com.thtek.irctcautobooker.respository.PackInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutoBookerRestController {

    @Autowired
    PackInfoRepository packInfoRepository;

    @GetMapping("/validate/{userId}")
    public String verifyUserValidity() {

        return "valid";
    }

    @PostMapping("/newPack")
    public String addNewPack() {

        return "successful";
    }

    @PutMapping("/updatePack/{userId}")
    public String updatePack() {
        return "successful";
    }

}

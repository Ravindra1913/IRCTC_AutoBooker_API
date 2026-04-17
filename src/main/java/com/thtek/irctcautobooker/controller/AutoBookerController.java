package com.thtek.irctcautobooker.controller;

import com.thtek.irctcautobooker.entity.PackDetails;
import com.thtek.irctcautobooker.respository.PackInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AutoBookerController {

    @Autowired
    PackInfoRepository packInfoRepository;

    @GetMapping("/")
    public String home() {
        return "Hello, Ravindra!";
    }
    //Todo
    // 1. Generate a unique key
    // 2. Get the user mobile number
    // 3. Send a msg to mobile number with the code
    // 4. Link mobile number and unique key
    // 5. Provision to get a msg of the unique key based on mobile number
    // 6. Keep tracking validity of the unique key
    // 7. Send a msg 12 hours before validitiy expires
    // 8. Provision to validate the mobile number and unique key and send successful/failure response
    // Table Schema details to be saved. unique id, phone number, timestamp of purchase, validity,
    // expiry timestamp, pack number, status, last validity verified timestamp

    @PostMapping("/savePack")
    public String savePackDetails(@RequestBody PackDetails packDetails) {

        packInfoRepository.save(packDetails);

        return "Details Saved";
    }

    @GetMapping("/{id}")
    public String getPackDetails(@PathVariable String id) {
        String result = packInfoRepository.getPackDetailsById(id);

        return result;
    }


}

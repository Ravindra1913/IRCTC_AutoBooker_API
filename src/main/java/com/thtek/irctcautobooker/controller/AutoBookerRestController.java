package com.thtek.irctcautobooker.controller;


import com.thtek.irctcautobooker.entity.NewPackRequest;
import com.thtek.irctcautobooker.model.PackDetails;
import com.thtek.irctcautobooker.respository.PackInfoRepository;
import com.thtek.irctcautobooker.respository.SubscriptionPlansInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@RestController
public class AutoBookerRestController {

    Logger logger = LoggerFactory.getLogger(AutoBookerRestController.class);

    @Autowired
    PackInfoRepository packInfoRepository;

    @Autowired
    SubscriptionPlansInfoRepository subscriptionPlansInfoRepository;

    @GetMapping("/")
    public String home() {
        return "Hello World!";
    }

    @GetMapping("/check-validity")
    public ResponseEntity<?> verifyUserValidity(@RequestParam String userId) {

        try{
            logger.info("User ID is : " + userId);
               Instant expiryDate = packInfoRepository.getPackDetailsByphNo(userId);
               logger.info("Expiry Date is " + expiryDate);


            return expiryDate!=null ? ResponseEntity.ok(Map.of(
                    "status", "success",
                    "message", expiryDate.toString()))
                    : ResponseEntity.ok(Map.of(
                            "status", "fail",
                            "message", "User ID not found"));


        }
        catch (Exception e){
            logger.error("Error during 'Check Validity'", e);
            return ResponseEntity.status(500).body(Map.of(
                    "status", "error",
                    "message", e.getMessage()
            ));

        }
    }

    @PostMapping("/newPack")
    public ResponseEntity<?> addNewPack(@RequestBody NewPackRequest newPackRequest) {

        try {
            logger.debug("Add New Pack Request");

            Instant buytimestamp = Instant.now();

            int validity = newPackRequest.getValidity();
            Integer subscriptionPlanId = subscriptionPlansInfoRepository.getSubscriptionPlanId(
                    newPackRequest.getSubscriptionPlan(),
                    validity);

            if(subscriptionPlanId == null) {
                return ResponseEntity.badRequest().body(Map.of(
                        "status", "error",
                        "message", "Invalid Subscription plan or validity")
                );
            }

            Instant expirytimestamp = buytimestamp.plus(Duration.ofDays(validity));

            logger.debug("Creating PackDetails Object");
            PackDetails newPackDetails = new PackDetails(
                    UUID.randomUUID().toString(),   // ✅ dynamic ID
                    newPackRequest.getUserId(),
                    buytimestamp,
                    validity,
                    expirytimestamp,
                    subscriptionPlanId,
                    true
            );

            logger.debug("PackDetails Object Created ");

            packInfoRepository.save(newPackDetails);

            logger.debug("PackDetails object Saved to DB");

            return ResponseEntity.ok(Map.of(
                    "status", "success",
                    "message", "Pack created successfully"
            ));

        } catch (Exception e) {
            logger.error("Error while adding a new Pack : ", e);
            return ResponseEntity.status(500).body(Map.of(
                    "status", "error",
                    "message", e.getMessage()
            ));
        }
    }

    @PutMapping("/updatePack/{userId}")
    public String updatePack() {
        return "successful";
    }

}

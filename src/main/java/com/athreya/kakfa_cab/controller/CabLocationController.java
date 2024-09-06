package com.athreya.kakfa_cab.controller;

import com.athreya.kakfa_cab.service.CabLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
public class CabLocationController {

    @Autowired
    private CabLocationService cabLocationService;

    @PutMapping
    public String getLocation() throws InterruptedException {
        for(int i=0;i<100;i++){
            cabLocationService.updateLocation(String.valueOf(i));
            Thread.sleep(1000);
            System.out.println("location : " + i+1);
        }
        return "Location updated";
    }
}

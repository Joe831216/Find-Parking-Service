package com.joe.findparking.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WebController {

    @RequestMapping(value = "/findNearbyParkingLots", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String findNearbyParkingLots() {
        String uri = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=&radius=3000&type=parking&key=";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        return result;
    }

}

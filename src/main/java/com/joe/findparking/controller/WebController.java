package com.joe.findparking.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WebController {
    private static final String GOOGLE_PLACE_API_KEY = "";

    private RestTemplate restTemplate;
    private String uri;
    private String result;

    // 尋找附近停車場(依重要性排序)
    @RequestMapping(value = "/findnearby/parkinglots/default", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String findNearbyParkingLotsDefault(@RequestParam("location") String location, @RequestParam("radius") int radius) {
        uri = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?language=zh-TW&type=parking&location=" + location + "&radius=" + radius + "&key=" + GOOGLE_PLACE_API_KEY;
        restTemplate = new RestTemplate();
        result = restTemplate.getForObject(uri, String.class);

        return result;
    }

    // 尋找附近停車場(依距離排序)
    @RequestMapping(value = "/findnearby/parkinglots/rankbydistance", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String findNearbyParkingLotsRankbyDistance(@RequestParam("location") String location) {
        uri = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?language=zh-TW&type=parking&rankby=distance&location=" + location + "&key=" + GOOGLE_PLACE_API_KEY;
        restTemplate = new RestTemplate();
        result = restTemplate.getForObject(uri, String.class);

        return result;
    }
}

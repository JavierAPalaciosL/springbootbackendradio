package com.api.radio.controllers;

import com.api.radio.dto.DTOPlaces;
import com.api.radio.dto.DTOSearch;
import com.api.radio.utils.Routes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/test")
public class APITest {

    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/places")
    public DTOPlaces getPlaces() {
        String url = Routes.PLACES;
        ResponseEntity<DTOPlaces> response = restTemplate.getForEntity(url, DTOPlaces.class);
        return response.getBody();
    }

    @GetMapping("/search")
    public DTOSearch getSearch(@RequestParam String query) {
        String url = Routes.SEARCH+query;
        ResponseEntity<DTOSearch> response = restTemplate.getForEntity(url, DTOSearch.class);
        return response.getBody();
    }

    @GetMapping("/{channelID}")
    public HashMap<String, String> build(@PathVariable String channelID) {
        String url =Routes.LISTENMP3+"/"+channelID+"/channel.mp3";

        HashMap<String, String> response = new HashMap<>();
        response.put("url", url);
        System.out.println(url);

        return response;
    }

}

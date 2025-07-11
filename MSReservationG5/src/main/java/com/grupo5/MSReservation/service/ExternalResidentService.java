package com.grupo5.MSReservation.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.grupo5.MSReservation.dto.ResidentDTO;

@Service
public class ExternalResidentService {
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${msresident.url:http://localhost:8081}")
    private String msResidentUrl;

    public ResidentDTO getResidentById(Long id) {
        String url = msResidentUrl + "/resident/" + id;
        ResponseEntity<ResidentDTO> response = restTemplate.getForEntity(url, ResidentDTO.class);
        return response.getBody();
    }
} 
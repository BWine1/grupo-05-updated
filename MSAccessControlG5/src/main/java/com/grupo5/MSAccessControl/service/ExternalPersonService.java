package com.grupo5.MSAccessControl.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.grupo5.MSAccessControl.dto.ExternalResidentDTO;
import com.grupo5.MSAccessControl.dto.ExternalVisitorDTO;

@Service
public class ExternalPersonService {
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${msvisitor.url:http://localhost:8082}")
    private String msVisitorUrl;
    @Value("${msresident.url:http://localhost:8081}")
    private String msResidentUrl;

    public ExternalVisitorDTO getVisitorById(Long id) {
        String url = msVisitorUrl + "/visitante/" + id;
        ResponseEntity<ExternalVisitorDTO> response = restTemplate.getForEntity(url, ExternalVisitorDTO.class);
        return response.getBody();
    }

    public ExternalResidentDTO getResidentById(Long id) {
        String url = msResidentUrl + "/resident/" + id;
        ResponseEntity<ExternalResidentDTO> response = restTemplate.getForEntity(url, ExternalResidentDTO.class);
        return response.getBody();
    }
} 
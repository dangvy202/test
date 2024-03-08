package com.test.fpt.controller;

import com.test.fpt.dto.CampaignResponse;
import com.test.fpt.service.CommercialsService;
import com.test.fpt.service.Impl.CommercialsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/commercial")
public class CommercialsController {

    private final CommercialsServiceImpl service;

    @GetMapping
    public ResponseEntity<CampaignResponse> getSumRevenue() {
        CampaignResponse response = service.sumRevenue();
        if(!StringUtils.hasLength(response.getError())) {
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampaignResponse> getSumImpressionByCampaignId(@PathVariable("id") int id) {
        CampaignResponse response = service.sumImpressionByCampaignId(id);
        if(response.getError() == null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

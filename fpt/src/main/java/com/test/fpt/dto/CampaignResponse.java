package com.test.fpt.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Getter
@Setter
public class CampaignResponse {
    private String error;
    private BigDecimal sum;
}

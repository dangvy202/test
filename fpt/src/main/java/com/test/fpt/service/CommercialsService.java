package com.test.fpt.service;

import com.test.fpt.dto.CampaignResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public interface CommercialsService {
    CampaignResponse sumImpressionByCampaignId(int campaignId);
    CampaignResponse sumRevenue();
}

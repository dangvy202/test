package com.test.fpt.service.Impl;

import com.test.fpt.dto.CampaignResponse;
import com.test.fpt.entity.Commercials;
import com.test.fpt.repository.CommercialsRepository;
import com.test.fpt.service.CommercialsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.Collections;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommercialsServiceImpl implements CommercialsService {

    private final CommercialsRepository repository;

    @Override
    public CampaignResponse sumImpressionByCampaignId(int campaignId) {
        CampaignResponse res = new CampaignResponse();
        try{
            var commercialsList =  repository.findCommercialsByCampaignId(campaignId);
            BigDecimal sum = BigDecimal.ZERO;
            if(!CollectionUtils.isEmpty(commercialsList)) {
                for (Commercials commercial : commercialsList) {
                    Long number = (long)commercial.getImpressions();
                    sum = sum.add(BigDecimal.valueOf(number));
                }
                res.setSum(sum);
                log.info("SUCCESS");
            } else {
                log.error("campaign Id not found");
                res.setError("campaign Id not found");
            }
        }catch (Exception ex) {
            log.error(ex.getMessage());
            res.setError(ex.getMessage());
        }
        return res;
    }

    @Override
    public CampaignResponse sumRevenue() {
        CampaignResponse response = new CampaignResponse();
        try{
            BigDecimal sumRevenue = repository.findsumRevenue();
            response.setSum(sumRevenue);
            log.info("SUCCESS");
        } catch (Exception ex) {
            log.error(ex.getMessage());
            response.setError(ex.getMessage());
        }
        return response;
    }
}

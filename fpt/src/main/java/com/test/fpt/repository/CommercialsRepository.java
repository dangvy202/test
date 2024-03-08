package com.test.fpt.repository;

import com.test.fpt.entity.Commercials;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CommercialsRepository extends JpaRepository<Commercials,Long> {


    List<Commercials> findCommercialsByCampaignId (int campaignId);

    @Query("SELECT SUM(c.revenue) FROM Commercials c")
    BigDecimal findsumRevenue();
}

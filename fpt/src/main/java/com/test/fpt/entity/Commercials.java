package com.test.fpt.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "campaign")
public class Commercials {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "campaign_id")
    private int campaignId;

    @Column(name = "impressions")
    private int impressions;

    @Column(name = "clicks")
    private int clicks;

    @Column(name = "conversions")
    private int conversions;

    @Column(name = "revenue")
    private Double revenue;


}

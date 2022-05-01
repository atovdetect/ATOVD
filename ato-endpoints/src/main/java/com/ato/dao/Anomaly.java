package com.ato.dao;

import lombok.*;

import javax.persistence.*;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "anomalies_detected")
public class Anomaly {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "anomaly_id")
    private Integer anomaliId;

    @Column(name = "date")
    String date;

    @Column(name = "description")
    String description;

    @Column(name = "ipaddress")
    String ipaddress;

    @Column(name = "detected_date")
    String datectedData;

    @Column(name = "app_id")
    String appId;

//    Map<String, String> requestHeaders;

}

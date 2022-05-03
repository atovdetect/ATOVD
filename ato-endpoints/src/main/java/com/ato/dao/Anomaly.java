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

    @Column(name = "description" , length = 4000)
    String description;

    @Column(name = "ipaddress")
    String ipaddress;

    @Column(name = "detected_data" , length = 4000)
    String datectedData;

    @Column(name = "app_id")
    String appId;

//    Map<String, String> requestHeaders;

}

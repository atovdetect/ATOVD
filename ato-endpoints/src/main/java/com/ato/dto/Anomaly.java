package com.ato.dto;

import lombok.Data;

import java.util.Map;

@Data
public class Anomaly {

    String id;

    String date;

    String description;

    String ipaddress;

    Map<String, String> requestHeaders;

}

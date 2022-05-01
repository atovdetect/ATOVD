package com.ato.dto;

import com.ato.dao.Anomaly;
import lombok.Data;

import java.util.List;

@Data
public class ReportDTO {

    String appId;

    int[]  numOfAnomalies;

    List<Anomaly> anomalies;


}

package com.ato.dto;

import com.ato.dao.Anomaly;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DashBoard {

    String noOfnewAlerts;

    String noOfAnomalies;

    String noOfCriticalAlerts;

    String date;

    User userInfo;

    List<Anomaly> anomalyList;

    String appId;

}

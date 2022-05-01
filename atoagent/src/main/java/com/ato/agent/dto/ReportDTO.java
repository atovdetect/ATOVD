package com.ato.agent.dto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

public class ReportDTO {


    String date;

    String description;

    String ipaddress;

    String datectedData;

    String appId;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public String getDatectedData() {
        return datectedData;
    }

    public void setDatectedData(String datectedData) {
        this.datectedData = datectedData;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    //    static final Gson gson = new GsonBuilder().create();
//
//    static OkHttpClient okhttp =
//            new OkHttpClient.Builder()
//                    .connectTimeout(3000, TimeUnit.MILLISECONDS)
//                    .readTimeout(3000, TimeUnit.MILLISECONDS)
//                    .writeTimeout(3000, TimeUnit.MILLISECONDS)
//                    .build();


}

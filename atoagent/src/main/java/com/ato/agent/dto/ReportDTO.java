package com.ato.agent.dto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

public class ReportDTO {

    String receivedHeaderSize;

    boolean isATODetected;

    static final Gson gson = new GsonBuilder().create();

    static OkHttpClient okhttp =
            new OkHttpClient.Builder()
                    .connectTimeout(3000, TimeUnit.MILLISECONDS)
                    .readTimeout(3000, TimeUnit.MILLISECONDS)
                    .writeTimeout(3000, TimeUnit.MILLISECONDS)
                    .build();


}

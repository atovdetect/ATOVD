package com.ato.agent;


import jakarta.servlet.http.HttpServletRequest;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 *
 */
public class HttpUtilsATO {


    static OkHttpClient okhttp =
            new OkHttpClient.Builder()
                    .connectTimeout(3000, TimeUnit.MILLISECONDS)
                    .readTimeout(3000, TimeUnit.MILLISECONDS)
                    .writeTimeout(3000, TimeUnit.MILLISECONDS)
                    .build();


    /**
     *
     * @param request
     */
    public void analyzeRequest(HttpServletRequest request){
        Map<String, String> result=getRequestHeadersInMap(request);
        if(result.size()>10){
            apiCall();
        }
    }


    /**
     *
     * @param request
     * @return
     */
     public Map<String, String> getRequestHeadersInMap(HttpServletRequest request) {

        Map<String, String> result = new HashMap<>();
        Enumeration headerNames = request.getHeaderNames();

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        Map<String, String> headers = Collections.list(httpRequest.getHeaderNames())
                .stream()
                .collect(Collectors.toMap(h -> h, httpRequest::getHeader));

        int headerSize=headers.size();

        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            result.put(key, value);
        }

        getIPAddress(request);
        apiCall();

        return result;
    }

    public String getIPAddress(HttpServletRequest request){
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }
        return ipAddress;
    }

    /**
     *
     */
    public void apiCall() {
        try {
            Request request = new Request.Builder()
                                            .url("http://3.8.16.176:8080/ato/reports")
                                            .header("User-Agent", "OkHttp Headers.java")
                                            .addHeader("Accept", "application/json; q=0.5")
                                            .addHeader("Accept", "application/vnd.github.v3+json")
                                            .build();

            Call call = okhttp.newCall(request);
            Response response = call.execute();
            System.out.println(response.body().string());

        } catch (Exception e) {

        }
    }

}

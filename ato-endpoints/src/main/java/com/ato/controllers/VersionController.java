package com.ato.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.ato.agent.HttpUtilsATO;

import java.util.Map;

@RestController
public class VersionController {

    @GetMapping("/version")
    public Map<String, String> getVersion(HttpServletRequest request){
        HttpUtilsATO atoutil= new HttpUtilsATO();
        return atoutil.getRequestHeadersInMap(request);
    }

    @GetMapping("/ipadress")
    public String getIpAddres(HttpServletRequest request){
        HttpUtilsATO atoutil= new HttpUtilsATO();
        return atoutil.getIPAddress(request);
    }

}

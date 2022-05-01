package com.customer.customerapi.controller;

//import com.ato.LoginDTO;
import com.ato.agent.dto.ClientConfiguration;
import com.customer.customerapi.LoginDTO;
//import jakarta.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ato.agent.HttpUtilsATO;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class CustomerController {

    @PostConstruct
    public void init(){
        ClientConfiguration client = new ClientConfiguration("92c3c8b6-2043-4fb6-b098-7fcfb2ffd5f7");
    }

    @GetMapping("/version")
    public Map<String, String> getVersion(HttpServletRequest request) throws Exception{
        HttpUtilsATO atoutil= new HttpUtilsATO();
        return atoutil.getRequestHeadersInMap(request);
    }

    @GetMapping("/ipadress")
    public String getIpAddres(HttpServletRequest request){
        HttpUtilsATO atoutil= new HttpUtilsATO();
        return atoutil.getIPAddress(request);
    }

    @PostMapping("/login")
    public String userLogin(HttpServletRequest request,@RequestBody LoginDTO loginDTO){
        HttpUtilsATO atoutil= new HttpUtilsATO();
        atoutil.analyzeRequest(request);
        return "LOGIN_SUCCESS";
    }
}

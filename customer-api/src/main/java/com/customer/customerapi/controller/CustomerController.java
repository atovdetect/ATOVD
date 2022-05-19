package com.customer.customerapi.controller;

//import com.ato.LoginDTO;

import com.ato.agent.dto.ClientConfiguration;
import com.customer.customerapi.CustomerService;
import com.customer.customerapi.LoginDTO;
//import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    CustomerService customerService;

    @PostConstruct
    public void init() {
        ClientConfiguration client = new ClientConfiguration("92c3c8b6-2043-4fb6-b098-7fcfb2ffd5f7");
    }

    @GetMapping("/version")
    public Map<String, String> getVersion(HttpServletRequest request) throws Exception {
        HttpUtilsATO atoutil = new HttpUtilsATO();
        return atoutil.getRequestHeadersInMap(request);
    }

    @PostMapping("/customerlogin")
    public String userLogin(HttpServletRequest request, @RequestBody LoginDTO loginDTO) {
        if (customerService.verifyLogin(loginDTO, request)) {
            return "LOGIN_SUCCESS";
        }
        return "INVALID_LOGIN";
    }
}

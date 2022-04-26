package com.customer.customerapi.controller;

//import com.ato.LoginDTO;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ato.agent.HttpUtilsATO;

import java.util.Map;

//import io.airbrake.javabrake.Notice;
//import io.airbrake.javabrake.Notifier;
//import io.airbrake.javabrake.Config;

//import javax.annotation.PostConstruct;
//import javax.servlet.http.HttpServletRequest;

@RestController
public class CustomerController {

    @PostConstruct
    public void init(){
//
//        Config config = new Config();
//
//        config.projectId = 413753;
//        config.projectKey = "51752e0d24b4d93a9b1185e3554ae296";
//        Notifier notifier = new Notifier(config);
//
//        notifier.addFilter(
//                (
//                        Notice notice) -> {
//                    notice.setContext("environment", "production");
//                    return notice;
//                });

//       ClientConfigurai
//        ClientConfiguration conf=new ClientConfiguration("");
//        conf.test();
    }

    @GetMapping("/version")
    public Map<String, String> getVersion(HttpServletRequest request) throws Exception{
        HttpUtilsATO atoutil= new HttpUtilsATO();

//        throw new Exception();
        return atoutil.getRequestHeadersInMap(request);
    }

    @GetMapping("/ipadress")
    public String getIpAddres(HttpServletRequest request){
        HttpUtilsATO atoutil= new HttpUtilsATO();
        return atoutil.getIPAddress(request);
    }

//    @PostMapping("/login")
//    public String userLogin(HttpServletRequest request, LoginDTO loginDTO){
//        HttpUtilsATO atoutil= new HttpUtilsATO();
//        return atoutil.getIPAddress(request);
//    }
}

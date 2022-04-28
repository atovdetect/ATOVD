package com.ato.controllers;

import com.ato.LoginDTO;
import com.ato.dto.Anomaly;
import com.ato.utils.EmailUtils;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ato.agent.HttpUtilsATO;
import com.ato.agent.dto.ClientConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.airbrake.javabrake.Notice;
import io.airbrake.javabrake.Notifier;
import io.airbrake.javabrake.Config;

@RestController
public class VersionController {

    @Autowired
    EmailUtils emailUtils;

    @PostConstruct
    public void init(){

        Config config = new Config();

        config.projectId = 413753;
        config.projectKey = "51752e0d24b4d93a9b1185e3554ae296";
        Notifier notifier = new Notifier(config);

        notifier.addFilter(
                (
                        Notice notice) -> {
                    notice.setContext("environment", "production");
                    return notice;
                });

//       ClientConfigurai
//        ClientConfiguration conf=new ClientConfiguration("");
//        conf.test();
    }

    @GetMapping("/reports")
    public String getVersion(HttpServletRequest request) throws Exception{
        HttpUtilsATO atoutil= new HttpUtilsATO();
        emailUtils.sendInDividualEmail("shyam.ramath@gmail.com", "Test mail", "ATO Anomaly Detected ");
        return "data stored";
    }

    @GetMapping("/fetchreport")
    public List<Anomaly> getIpAddres(HttpServletRequest request){

        List<Anomaly> anomalyList = new ArrayList<Anomaly>();
        anomalyList.add(new Anomaly());
        anomalyList.add(new Anomaly());
        anomalyList.add(new Anomaly());
        anomalyList.add(new Anomaly());

        return  anomalyList;
    }

    @PostMapping("/login")
    public String userLogin(HttpServletRequest request,@RequestBody LoginDTO loginDTO){
        HttpUtilsATO atoutil= new HttpUtilsATO();
        emailUtils.sendInDividualEmail("shyam.ramath@gmail.com", "Test mail", "ATO Anomanly detacted ");
        return atoutil.getIPAddress(request);
    }
}

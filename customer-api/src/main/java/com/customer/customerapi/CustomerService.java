package com.customer.customerapi;

import com.ato.agent.HttpUtilsATO;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class CustomerService {

    String userEmail="shyam.ramath@gmail.com";
    String passWord="topsecret";


    public boolean verifyLogin(LoginDTO login, HttpServletRequest request){

        if(login.getUserName().equals(userEmail) && login.getPassWord().equals(passWord)){
          return true;
        }

        HttpUtilsATO atoutil= new HttpUtilsATO();
        atoutil.analyzeRequest(request,login);

        return false;
    }

}

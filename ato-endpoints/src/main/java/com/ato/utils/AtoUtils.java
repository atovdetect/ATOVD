package com.ato.utils;

import com.ato.dao.User;
import com.ato.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AtoUtils {

    @Autowired
    UserRepository userRepository;

    public String getRegisteredEmail(String appID){
       Optional foundUser= userRepository.findUserByAppId(appID);

       if(foundUser.isPresent()){
           User user = (User)  foundUser.get();
           return user.getEmail();
       }
      return "";
    }

}

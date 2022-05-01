package com.ato.agent.dto;
//import io.airbrake.javabrake.Notice;
//import io.airbrake.javabrake.Notifier;
//import io.airbrake.javabrake.Config;
/**
 *
 */
public class ClientConfiguration {

    public static Config config;

    /**
     *
     * @param appId
     */
    public ClientConfiguration(String appId){
        this.config = new Config(appId);
    }

}

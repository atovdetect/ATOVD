package com.ato.agent.dto;
//import io.airbrake.javabrake.Notice;
//import io.airbrake.javabrake.Notifier;
//import io.airbrake.javabrake.Config;
/**
 *
 */
public class ClientConfiguration {

    String clientId;

    /**
     *
     * @param clientId
     */
    public ClientConfiguration(String clientId){
        this.clientId=clientId;
    }


//    public void test(){
//
//        Config config = new Config();
//        config.projectId = 12345;
//        config.projectKey = "FIXME";
//        Notifier notifier = new Notifier(config);
//
//        notifier.addFilter(
//                (
//                        Notice notice) -> {
//                    notice.setContext("environment", "production");
//                    return notice;
//                });
//    }







}

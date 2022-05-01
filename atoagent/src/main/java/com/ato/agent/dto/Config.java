package com.ato.agent.dto;

public class Config {

    public Config(String appId) {
        this.appId = appId;
    }

    String appId;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}

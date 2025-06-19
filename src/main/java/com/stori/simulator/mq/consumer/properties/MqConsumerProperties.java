package com.stori.simulator.mq.consumer.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "rocketmq.consumer")
public class MqConsumerProperties {

    private String namesrvAddr;

    private String group;
    private String group;
    private String id;
+ 
    public String getId() {
        return id;
    }
+ 
    public void setId(String id) {
        this.id = id;
    }
+ 
    public String getNamesrvAddr() {

    public String getNamesrvAddr() {
        return namesrvAddr;
    }

    public void setNamesrvAddr(String namesrvAddr) {
        this.namesrvAddr = namesrvAddr;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}

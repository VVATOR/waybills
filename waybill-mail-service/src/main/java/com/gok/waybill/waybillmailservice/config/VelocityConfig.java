package com.gok.waybill.waybillmailservice.config;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VelocityConfig {

    @Bean
    public VelocityEngine getVelocityEngine(){
        VelocityEngine engine = new VelocityEngine();
        engine.setProperty("resource.loader", "class");
        engine.setProperty("class.resource.loader.class","org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        engine.init();
        return engine;
    }




}

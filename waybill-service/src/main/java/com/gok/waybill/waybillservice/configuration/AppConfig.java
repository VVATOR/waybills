package com.gok.waybill.waybillservice.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig {

//    @Bean
//    public Crawler beanCrawler(){
//        return new Crawler();
//    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE");

                     /*   .allowedOrigins("http://localhost:8081")
                        .allowedOrigins("http://localhost:8080");*/
            }
        };
    }
}

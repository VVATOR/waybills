package com.gok.waybill.waybillservice.configuration;

import com.gok.waybill.waybillservice.data.repositories.WaybillRepository;
import com.gok.waybill.waybillservice.graphql.resolvers.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class GraphQlConfig {

    @Bean
    public Query query(WaybillRepository waybillRepository) {
        log.info("@Bean Query");
        return new Query(waybillRepository);
    }
}

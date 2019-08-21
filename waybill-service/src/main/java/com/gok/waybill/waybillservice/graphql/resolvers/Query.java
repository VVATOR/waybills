package com.gok.waybill.waybillservice.graphql.resolvers;


import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.gok.waybill.waybillservice.data.model.Waybill;
import com.gok.waybill.waybillservice.data.repositories.WaybillRepository;

import java.util.List;


public class Query implements GraphQLQueryResolver {

    private WaybillRepository waybillRepository;

    public Query(WaybillRepository waybillRepository) {
        this.waybillRepository = waybillRepository;
    }

    public List<Waybill> allWaybills() {
        return waybillRepository.findAll();
    }

    public long countWaybills() {
        return waybillRepository.count();
    }

}

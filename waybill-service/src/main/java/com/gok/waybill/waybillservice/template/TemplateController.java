package com.gok.waybill.waybillservice.template;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gok.waybill.waybillservice.data.model.Waybill;
import com.gok.waybill.waybillservice.data.repositories.WaybillRepository;
import com.gok.waybill.waybillservice.reports.DBFileStorageService;
import com.gok.waybill.waybillservice.reports.DatabaseFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@Slf4j
public class TemplateController {

    @Autowired
    private WaybillRepository waybillRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DBFileStorageService dbFileStorageService;

    @PostMapping("/template/xml/{fileId}")
    public ResponseEntity<Resource> templateFile(@PathVariable Integer fileId, @RequestBody  String body ) throws IOException {
        // Load file from database
        DatabaseFile dbFile = dbFileStorageService.getFile(fileId);
        if (body == null) {
          body = objectMapper.writeValueAsString("{    \"id\": \"1\",    \"status\": \"BROKEN\",    \"number\": \"74697\",    \"date\": \"1974-11-18\",    \"machine\": {        \"id\": \"6\",        \"name\": \"Lotlux\",        \"categoryMachine\": {            \"id\": \"9\",            \"name\": \"\\u041E\\u0410\\u041E \\u0418\\u0432\\u0430\\u043D\\u043E\\u0432\\u043E\\u0421\\u0431\\u044B\\u0442\\u0422\\u0440\\u0435\\u0439\\u0434\",            \"machines\": \"null\",            \"deleted\": \"false\"        },        \"registrationNumber\": \"8\",        \"garageNumber\": \"2\",        \"waybill\": \"null\",        \"deleted\": \"false\"    },    \"drivers\": [        {            \"id\": \"7\",            \"name\": \"\\u041B\\u0430\\u0432\\u0440\\u0435\\u043D\\u0442\\u0438\\u0439 \\u0421\\u043C\\u0438\\u0440\\u043D\\u043E\\u0432\",            \"personalNumber\": \"5632\",            \"waybills\": \"null\",            \"deleted\": \"false\"        }    ],    \"task\": {        \"id\": \"8\",        \"customer\": \"Pikachu\",        \"dateArriving\": \"2019-09-21\",        \"dateDeparture\": \"2019-06-23\",        \"departurePoint\": \"\\u041F\\u0435\\u0440\\u043C\\u044C\",        \"destinationPoint\": \"\\u041A\\u0440\\u0430\\u0441\\u043D\\u043E\\u0434\\u0430\\u0440\",        \"cargo\": \"Samuel Smith\\u2019s Imperial IPA\",        \"waybill\": \"null\",        \"deleted\": \"false\"    },    \"workDriverAndMachine\": {        \"id\": \"2\",        \"waybill\": \"null\",        \"deleted\": \"false\"    },    \"result\": {        \"id\": \"8\",        \"waybill\": \"null\",        \"deleted\": \"false\"    },    \"tsm\": {        \"id\": \"6\",        \"fuelingDate\": \"2019-11-19\",        \"fuelType\": \"Chocolate St\",        \"amountOfFuel\": \"90\",        \"startedAmountOfFuel\": \"74\",        \"finalAmountOfFuel\": \"6\",        \"waybill\": \"null\",        \"deleted\": \"false\"    },    \"deleted\": \"false\"}");
        }

        ExcelTemplateTransformer excelTemplateTransformer = new ExcelTemplateTransformer();
        return excelTemplateTransformer.templateResource(dbFile, body);
    }

}

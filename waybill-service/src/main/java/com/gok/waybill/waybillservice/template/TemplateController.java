package com.gok.waybill.waybillservice.template;

import com.gok.waybill.waybillservice.reports.DatabaseFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Slf4j
public class TemplateController {

    @Autowired
    private com.gok.waybill.waybillservice.reports.DBFileStorageService DBFileStorageService;

    @GetMapping("/template/xml/{fileId}")
    public ResponseEntity<Resource> templateFile(@PathVariable Integer fileId) throws IOException {
        // Load file from database
        DatabaseFile dbFile = DBFileStorageService.getFile(fileId);

        ExcelTemplateTransformer excelTemplateTransformer = new ExcelTemplateTransformer();
        return  excelTemplateTransformer.templateResource(dbFile);
    }

}

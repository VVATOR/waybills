package com.gok.waybill.waybillservice.jett.reports;

import com.gok.waybill.waybillservice.data.model.files.DatabaseFile;
import com.gok.waybill.waybillservice.reports.DBFileStorageService;
import com.gok.waybill.waybillservice.utils.fakedata.CommonFakeDatabase;
import lombok.extern.slf4j.Slf4j;
import net.sf.jett.transform.ExcelTransformer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class JettFileController {

    @Autowired
    private DBFileStorageService DBFileStorageService;

    @GetMapping("/template/xml/{fileId}")
    public ResponseEntity<Resource> templateFile(@PathVariable Integer fileId) throws IOException {
        // Load file from database
        DatabaseFile DbFile = DBFileStorageService.getFile(fileId);

        Map<String, Object> beans = new HashMap<>();
        beans.put("waybills", CommonFakeDatabase.waybills);
        byte[] data = DbFile.getData();

        File file = new File("grouping_output.xlsx");
        log.info("Running Grouping Demo");
        try {
            InputStream is = new ByteArrayInputStream(data);//JettFileController.class.getResourceAsStream("/grouping_template.xlsx");

            OutputStream os = new FileOutputStream(file);

            ExcelTransformer transformer = new ExcelTransformer();
            Workbook workbook = transformer.transform(is, beans);
            workbook.write(os);
            //os.write(data);
        } catch (IOException | InvalidFormatException e) {
            log.error("Exception creating template", e);
        }


        byte[] fileContent = Files.readAllBytes(file.toPath());
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(DbFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + DbFile.getFileName() + "\"")
                .body(new ByteArrayResource(fileContent));
    }

}
package com.gok.waybill.waybillservice.template;


import com.github.wnameless.json.flattener.JsonFlattener;
import com.gok.waybill.waybillservice.reports.DatabaseFile;
import jdk.nashorn.internal.parser.JSONParser;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

@Slf4j
public class ExcelTemplateTransformer {




    public ResponseEntity<Resource> templateResource(DatabaseFile dbfile, String jsonObject) throws IOException {
        /*final Map<String, Object> beans = new HashMap<>();
        beans.put("waybills", CommonFakeDatabase.waybills);*/


        Map<String, Object> beans = JsonFlattener.flattenAsMap(jsonObject);
        log.info("-----------------------------------------------");
        log.info("{}", beans);
        log.info("-----------------------------------------------");

        log.info("{}",Arrays.toString(beans.entrySet().toArray()));
        beans.forEach((k, v) -> log.info(k + " : " + v));
        log.info("-----------------------------------------------");

        byte[] data = dbfile.getData();

        File file = new File("grouping_output.xlsx");
        log.info("Running Grouping Demo");
        try (
                InputStream is = new ByteArrayInputStream(data);
                OutputStream os = new FileOutputStream(file);
        ) {
            Workbook workbook = this.transform(is, beans);
            workbook.write(os);
        } catch (IOException e) {
            log.error("Exception map beam to template", e);
        }


        byte[] fileContent = Files.readAllBytes(file.toPath());
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbfile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbfile.getFileName() + "\"")
                .body(new ByteArrayResource(fileContent));
    }

    public void transform(Workbook workbook, Map<String, Object> beans) {
        log.info("Transforming a Workbook.");
        for (int s = 0; s < workbook.getNumberOfSheets(); ++s) {
            final Sheet sheet = workbook.getSheetAt(s);
            log.info("sheet {}", sheet.getSheetName());

            // Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                log.info("row {}", row.getRowNum());
                // For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (cell.getCellType() == CellType.BLANK) {
                        continue;
                    }
                    //   log.info("cell {} - {}", cell.getCellType(), cell);
                    if (cell.getStringCellValue().contains("${")) { //TODO regexp
                        String trim = cell.getStringCellValue().trim();
                        String marker = trim.substring(2,trim.length()-1);
                        String newValue = (String) beans.get(marker);

                        log.info("map {} - {} - {}", cell.getCellType(), cell, newValue);

                        cell.setCellValue(newValue);
                    }
                }
            }
        }
        log.info("Done transforming a Workbook.");
    }

    private Workbook transform(InputStream is, Map<String, Object> beans) throws IOException {
        log.info("Creating a Workbook from an InputStream.");
        Workbook workbook = WorkbookFactory.create(is);
        this.transform(workbook, beans);
        return workbook;
    }

}

/*
package com.gok.waybill.waybillservice.jett.reports;

import com.gok.waybill.waybillservice.utils.fakedata.CommonFakeDatabase;
import lombok.extern.slf4j.Slf4j;
import net.sf.jett.transform.ExcelTransformer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Slf4j
public class JettTransformator {
    private void generateExcel() {
        Path outputDir = Paths.get("output");
        if(!Files.exists(outputDir)) {
            try {
                Files.createDirectory(outputDir);
            } catch(IOException e) {
                throw new RuntimeException(e);
            }
            log.info("Created directory " + outputDir.toAbsolutePath());
        }

        Map<String, Object> beans = new HashMap<>();
        beans.put("waybills", CommonFakeDatabase.waybills);


        log.info("Running Grouping Demo");
        try (
                InputStream is = JettTransformator.class.getResourceAsStream("/grouping_template.xlsx");
                OutputStream os = Files.newOutputStream(outputDir.resolve("grouping_output.xlsx"));
        ) {
            ExcelTransformer transformer = new ExcelTransformer();
            Workbook workbook = transformer.transform(is, beans);
            workbook.write(os);
        } catch(IOException | InvalidFormatException e) {
            log.error("Exception creating template", e);
        }
    }

}
*/

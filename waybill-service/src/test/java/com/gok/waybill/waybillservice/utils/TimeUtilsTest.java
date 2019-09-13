package com.gok.waybill.waybillservice.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Time Utils testing")
class TimeUtilsTest {

    @Test
    @DisplayName("Convert to local date via milisecond")
    void convertToLocalDateViaMilisecond() {
        final Date dateToConvert = new Date();
        final LocalDate expectedLocalDate = Instant.ofEpochMilli(dateToConvert.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        final LocalDate actual = TimeUtils.convertToLocalDateViaMilisecond(dateToConvert);
        System.out.println(dateToConvert);

        assertEquals(expectedLocalDate, actual);
    }

}
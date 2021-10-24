package com.fstg.taxesejour.infrastructure.utils;


import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class Utils {
    public static Date stringToDate(String date) {
        LocalDate localDate = LocalDate.parse(date);
        ZoneId defaultZoneId = ZoneId.systemDefault();
        //local date + atStartOfDay() + default time zone + toInstant() = Date
        return Date.from(Instant.parse(localDate.atStartOfDay(defaultZoneId).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
    }

    public static BigDecimal stringToBigDecimal(String input) {
        return new BigDecimal(input);
    }
}

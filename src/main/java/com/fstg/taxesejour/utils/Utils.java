package com.fstg.taxesejour.utils;


import com.fstg.taxesejour.infrastructure.entity.TauxRetardTaxeSejourTrim;

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

    public static int getNumberOfMonthRetard(Date datePresentation, Date expectedDatePresentation) {
        if (expectedDatePresentation != null) {
            if (datePresentation == null) datePresentation = new Date();
            long difference_In_Time = datePresentation.getTime() - expectedDatePresentation.getTime();
            return (int) ((difference_In_Time / (1000 * 60 * 60 * 24)) % 365) / 30;
        }
        return 0;
    }

    public static TauxRetardTaxeSejourTrim calculateMontant(int nombreMoisRetard, Double taux, Double taxuRetard, long nombreNuit) {
        BigDecimal premierMoisRetard = BigDecimal.ZERO;
        BigDecimal autreMoisRetard = BigDecimal.ZERO;
        for (int i = 1; i <= nombreMoisRetard; i++) {
            if (i == 1) {
                premierMoisRetard = BigDecimal.valueOf(nombreNuit * taux + nombreNuit * taxuRetard);
            } else {
                System.out.println("autreMoisRetard " + autreMoisRetard.toString());
                autreMoisRetard = autreMoisRetard.add(BigDecimal.valueOf(nombreNuit * taux));
            }
        }
        return TauxRetardTaxeSejourTrim.builder()
                .autreMoisRetard(autreMoisRetard)
                .premierMoisRetard(premierMoisRetard)
                .nombreMoisRetard(nombreMoisRetard)
                .dateApplication(new Date()).build();
    }
}

package com.fstg.taxesejour.utils;


import com.fstg.taxesejour.infrastructure.entity.TauxRetardTaxeSejourTrim;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Slf4j
public class Utils {
    public static Date stringToDate(String date) {
//        LocalDate localDate = LocalDate.parse(date);
//        ZoneId defaultZoneId = ZoneId.systemDefault();
//        //local date + atStartOfDay() + default time zone + toInstant() = Date
//        return Date.from(Instant.parse(localDate.atStartOfDay(defaultZoneId).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
        try {
            Date date1 = new SimpleDateFormat("yyyy-mm-dd").parse(date);
            return date1;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String dateToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
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
//        TODO Calculate expectedDatePresentation
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

    public static boolean isAfter(Date dateMin, Date dateMax) {
        return dateMax.getTime() > dateMin.getTime();
    }
}

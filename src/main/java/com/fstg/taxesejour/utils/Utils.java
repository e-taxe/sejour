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
    private Utils() {
    }

    public static Date stringToDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-mm-dd").parse(date);
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

    public static int getNumberOfMonthRetard(Date datePresentation, int numTrim, int annee) {
        StringBuilder stringBuilder = new StringBuilder();
        switch (numTrim) {
            case 1:
                stringBuilder.append(annee).append("-03").append("-31");
                break;
            case 2:
                stringBuilder.append(annee).append("-06").append("-30");
                break;
            case 3:
                stringBuilder.append(annee).append("-09").append("-30");
                break;
            case 4:
                stringBuilder.append(annee).append("-12").append("-31");
                break;
            default:
                return -1;
        }
        log.info("test " + stringBuilder.toString());
        Date expectedDatePresentation = null;
        try {
            expectedDatePresentation = new SimpleDateFormat("yyyy-MM-dd").parse(stringBuilder.toString());
            if (datePresentation == null) datePresentation = new Date();
            if (isAfter(datePresentation, expectedDatePresentation)) {
                return 0;
            }
            long difference = Math.abs(datePresentation.getTime() - expectedDatePresentation.getTime());
            return (int) ((difference / (1000 * 60 * 60 * 24)) % 365) / 30;
        } catch (ParseException e) {
            return -2;
        }

    }

    public static TauxRetardTaxeSejourTrim calculateMontant(int nombreMoisRetard, Double taux, Double taxuRetard, long nombreNuit) {
//        BigDecimal premierMoisRetard = BigDecimal.ZERO;
//        BigDecimal autreMoisRetard = BigDecimal.ZERO;
//        for (int i = 1; i <= nombreMoisRetard; i++) {
//            if (i == 1) {
//                premierMoisRetard = BigDecimal.valueOf(nombreNuit * taux + nombreNuit * taxuRetard);
//            } else {
//                System.out.println("autreMoisRetard " + autreMoisRetard.toString());
//                autreMoisRetard = autreMoisRetard.add(BigDecimal.valueOf(nombreNuit * taux));
//            }
//        }
        return null;
//        return TauxRetardTaxeSejourTrim.builder()
//                .autreMoisRetard(autreMoisRetard)
//                .premierMoisRetard(premierMoisRetard)
//
//                .nombreMoisRetard(nombreMoisRetard)
//                .dateApplicationMax(new Date()).build();
    }

    public static boolean isAfter(Date dateMin, Date dateMax) {
        return dateMax.getTime() > dateMin.getTime();
    }
}

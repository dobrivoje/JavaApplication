/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

import static ERS.TimeLine.SBCWorkerTimeLine.MAX_SYSTEM_TIME;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author dobri
 */
public class JavaApplicationRazno {

    private static Calendar c = Calendar.getInstance();

    private static Date toDate(String time) {
        try {
            return (new SimpleDateFormat("HH:mm:ss")).parse(time);
        } catch (ParseException | NullPointerException ex) {
            return new Date(toDate(MAX_SYSTEM_TIME).getTime());
        }
    }

    private static synchronized long timeDifferenceInMinutes(String startTime, String endTime) throws Exception {
        long L = TimeUnit.MILLISECONDS.toMinutes(toDate(endTime).getTime() - toDate(startTime).getTime());;
        if (L < 0) {
            throw new Exception("Time difference must not be negative !");
        } else {
            return L;
        }
    }

    public static void main(String[] args) {
        //<editor-fold defaultstate="collapsed" desc="testovi...">
        /*
         int IDStatus = 2;
         String color = ERS.queries.ERSQuery.getColorHex(IDStatus);
        
         System.out.println("Boja : " + color);
        
         System.out.println("Aktivna vremenska šema: ");
         System.out.println(ERS.queries.ERSQuery.getActiveTimeScheme().getSystemTimeMin()
         + " - "
         + ERS.queries.ERSQuery.getActiveTimeScheme().getSystemTimeMax());
         */
        //</editor-fold>

        long L = 0;

        try {
            L = timeDifferenceInMinutes("07:00:00", "08:13:39");
            System.out.println("Razlika u minutima : " + L);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}

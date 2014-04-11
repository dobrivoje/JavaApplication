/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

import ERS.queries.ERSQuery;
import ent.Raddan;
import ent.Radnik;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dobri
 */
public class JavaAppERSTest {

    private static final Object lock = new Object();
    private static final Calendar c = Calendar.getInstance();

    public static void main(String[] args) {

        //<editor-fold defaultstate="collapsed" desc="testovi">
        Radnik r = ERSQuery.radnikID(49);
        String pocetnoVreme, krajnjeVreme;
        Date T1 = null, T2 = null;

        for (Raddan rd : ERSQuery.evidencijeRadnikaZaDatum(r, "2013-4-8")) {
            try {
                pocetnoVreme = rd.getDatum() + " " + (rd.getPocStanja() != null ? rd.getPocStanja() : null);
                T1 = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(pocetnoVreme);
            } catch (ParseException ex) {
                T1 = new Date(Long.MAX_VALUE);
            }

            try {
                krajnjeVreme = rd.getDatum() + " " + (rd.getKrajStanja() != null ? rd.getKrajStanja() : null);
                T2 = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(krajnjeVreme);
            } catch (ParseException ex) {
                T2 = new Date(Long.MAX_VALUE);
            }

            System.out.println(rd.toString());
            // System.err.println(pocetnoVreme + " -> " + krajnjeVreme);

            c.setTime(T1);
            System.err.println(
                    c.get(Calendar.YEAR) + " "
                    + c.get(Calendar.MONTH) + " "
                    + c.get(Calendar.DAY_OF_MONTH) + " -> "
                    + c.get(Calendar.HOUR_OF_DAY) + " "
                    + c.get(Calendar.MINUTE) + " "
                    + c.get(Calendar.SECOND) + " "
            );
            c.setTime(T2);
            System.err.println(
                    c.get(Calendar.YEAR) + " "
                    + c.get(Calendar.MONTH) + " "
                    + c.get(Calendar.DAY_OF_MONTH) + " -> "
                    + c.get(Calendar.HOUR_OF_DAY) + " "
                    + c.get(Calendar.MINUTE) + " "
                    + c.get(Calendar.SECOND) + " "
            );
        }
    }
}

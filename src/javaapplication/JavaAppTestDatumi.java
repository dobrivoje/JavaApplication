 /* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author dobri
 */
public class JavaAppTestDatumi {

    private static final int Godina = 2014;
    private static final int Mesec = 2;

    private static final Calendar calendar = Calendar.getInstance();
    private static int god, mesec;
    private static int prethGod, prethMesec;
    private static boolean godIzmenjen, mesecIzmenjen;

    private static String kalendar;

    public static void main(String[] args) throws InterruptedException {

        /*
         kalendarDatum_bind=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
         System.out.println(kalendarDatum_bind);
         */
        kalendar = "2013-01-21";
        izracunaj(kalendar);
    }

    private static void izracunaj(String kalendar) {
        try {
            if (kalendar == null) {
                calendar.setTime(new Date());
            } else {
                calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(kalendar));
            }

            godIzmenjen = calendar.get(Calendar.YEAR) != god;
            mesecIzmenjen = calendar.get(Calendar.MONTH) != mesec;

            god = calendar.get(Calendar.YEAR);
            // PAZI NA MESEC POČINJE OD NULE !!!
            mesec = 1 + calendar.get(Calendar.MONTH);

            prethGod = (mesec == 1 ? god - 1 : god);
            prethMesec = (mesec == 1 ? 12 : mesec - 1);

            System.out.println("godIzmenjen: " + godIzmenjen);
            System.out.println("mesecIzmenjen: " + mesecIzmenjen);

        } catch (ParseException ex) {
        }
    }
}

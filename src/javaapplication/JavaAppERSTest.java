/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

import ERS.TimeLine.SBCWorkerTimeLine;
import ERS.queries.ERSQuery;
import static ERS.queries.ERSQuery.allWorkersTimeLine;
import ent.Firma;
import static ent.Raddan_.datum;
import ent.Radnik;
import java.text.ParseException;
import java.util.Map;

/**
 *
 * @author dobri
 */
public class JavaAppERSTest {

    public static void main(String[] args) throws ParseException {
        Radnik radnik = ERSQuery.radnikID(66);
        Firma aktivnaFirma = ERSQuery.FirmaID(2);

        String datum = "2014-4-9";
        try {
            //<editor-fold defaultstate="collapsed" desc="testovi">
            /*
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
             */
            /*
             SBData s = new SBData(r, "2014-4-11 10:00:00", "2014-4-11 10:10:00", 10f);
            
             System.out.println("Datum :" + s.getGodina() + " " + s.getMesec() + " " + s.getDan());
             System.out.println("Radnik :" + s.getRadnik().getImePrezime());
             System.out.println("Početak :" + s.getSatPocetak() + ":" + s.getMinutPocetak());
             System.out.println("Kraj :" + s.getSatKraj() + ":" + s.getMinutKraj());
             System.out.println("Trajanje: " + s.getTrajanje());
             */
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="test zaokruživanje.">
            /*
             String v = "13:15:11";
             Calendar c = Calendar.getInstance();
             c.setTime(new SimpleDateFormat("HH:mm:ss").parse(v));
             int sat = c.get(Calendar.HOUR_OF_DAY);
             float minut = c.get(Calendar.MINUTE);
             int sekund = c.get(Calendar.SECOND);
            
             // Zaokruživanje na 2 decomale !
             float n = 110.91738f;
             Number x = n;
             DecimalFormat df = new DecimalFormat("#.##");
             System.out.println("#1 : " + df.format(x.floatValue()));
            
             System.out.println("Ceo sat: " + v + ", sat: " + sat + ", minut: " + minut + ", sekund: " + sekund);
             System.out.println("----------------");
             System.out.println(df.format(sat + minut / 60));
             */
            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="Test ispisa radnika...">
            /*
             for (Map.Entry<Integer, SBCWorkerTimeLine> e : workerTimeLine(radnik, datum).entrySet()) {
             System.err.println(e.getKey() + ". " + e.getValue());
             }
             */
            //</editor-fold>
            for (Map<Integer, SBCWorkerTimeLine> e : allWorkersTimeLine(aktivnaFirma, datum)) {
                for (Map.Entry<Integer, SBCWorkerTimeLine> entry : e.entrySet()) {
                    Integer rbrAktivnosti = entry.getKey();
                    SBCWorkerTimeLine sbwt = entry.getValue();

                    System.out.println(rbrAktivnosti + sbwt.toString());
                }

                System.out.println("-------------------------");
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}

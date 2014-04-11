/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

import ERS.queries.ERSQuery;
import ent.Raddan;
import ent.Radnik;
import ent.Statusi;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author dobri
 */
public class JavaAppERSTest {

    private static final Object lock = new Object();
    private static final Calendar c = Calendar.getInstance();

    private static class SBData {

        private final Radnik radnik;
        private final Statusi status;
        private final String datum;
        private final String vremePocetka;
        private final String vremeKraja;
        private final Float trajanje;

        private final int godina;
        private final int mesec;
        private final int dan;

        private final int satPocetak;
        private final int satKraj;
        private final int minutPocetak;
        private final int minutKraj;

        // najlakše je kada je 6, pošto svaki zarez predstavlja 10 minuta
        private static int skaliranje = 6;

        private final Calendar c = Calendar.getInstance();

        //<editor-fold defaultstate="collapsed" desc="konstruktor">
        /**
         *
         * @param radnik
         * @param status
         * @param datum npr. "2014-04-21"
         * @param vremePocetka npr. "10:15:32"
         * @param vremeKraja npr. "10:22:01"
         * @param trajanje npr. 17f
         * @param skaliranje - broj zareza između dva susedna sata na
         * timeline-u. npr. ako je broj zareza 6, znači da svaki zarez
         * predstavlja 10 minuta između dva susedna sata
         */
        public SBData(Radnik radnik, Statusi status, String datum, String vremePocetka, String vremeKraja, Float trajanje, int skaliranje) {
            this.radnik = radnik;
            this.status = status;
            this.datum = datum;
            this.vremePocetka = vremePocetka;
            this.vremeKraja = vremeKraja;
            this.trajanje = trajanje;
            SBData.skaliranje = skaliranje;

            c.setTime(toDate(datum + " " + vremePocetka));

            godina = c.get(Calendar.YEAR);
            mesec = 1 + c.get(Calendar.MONTH);
            dan = c.get(Calendar.DAY_OF_MONTH);

            satPocetak = c.get(Calendar.HOUR_OF_DAY);
            minutPocetak = c.get(Calendar.MINUTE);

            c.setTime(toDate(datum + " " + vremeKraja));

            satKraj = c.get(Calendar.HOUR_OF_DAY);
            minutKraj = c.get(Calendar.MINUTE);
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="getters">
        public Radnik getRadnik() {
            return radnik;
        }

        public Statusi getStatus() {
            return status;
        }

        public Float getTrajanje() {
            return trajanje;
        }

        public int getGodina() {
            return godina;
        }

        public int getMesec() {
            return mesec;
        }

        public int getDan() {
            return dan;
        }

        public int getSatPocetak() {
            return satPocetak;
        }

        public int getSatKraj() {
            return satKraj;
        }

        public int getMinutPocetak() {
            return minutPocetak;
        }

        public int getMinutKraj() {
            return minutKraj;
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="setters">
        public static void setSkaliranje(int skaliranje) {
            SBData.skaliranje = skaliranje;
        }
        //</editor-fold>

        /**
         *
         * @param timeDate npr. "2014-04-02 10:15:32"
         * @return
         */
        private Date toDate(String timeDate) {
            try {
                return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(timeDate);
            } catch (ParseException ex) {
                return new Date(Long.MAX_VALUE);
            }
        }

        @Override
        public String toString() {
            return "[" + datum + "] "
                    + "[" + radnik.getImePrezime() + "] "
                    + "[" + status.getStatus() + "] "
                    + "[" + this.vremePocetka + "] "
                    + "[" + this.vremeKraja + "] "
                    + "[" + this.getTrajanje() + "] ";
        }
    }

    /**
     *
     * @param Radnik
     * @param Datum
     * @return Map<Integer, SBData>
     */
    private static Map<Integer, SBData> workerTimeLine(Radnik radnik, String datum) {
        Map<Integer, SBData> TL = new TreeMap<>();

        for (Raddan r1 : ERSQuery.evidencijeRadnikaZaDatum(radnik, datum)) {
            TL.put(r1.getRbrstanja(),
                    new SBData(r1.getFKIDRadnik(),
                            r1.getFKIDStatus(),
                            r1.getDatum(),
                            r1.getPocStanja(),
                            r1.getKrajStanja(),
                            r1.getTrajanje(), 6)
            );
        }

        return TL;
    }

    public static void main(String[] args) {
        Radnik radnik = ERSQuery.radnikID(66);

        //<editor-fold defaultstate="collapsed" desc="testovi">
        /*String pocetnoVreme, krajnjeVreme;
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
         }*/
        /*
         SBData s = new SBData(r, "2014-4-11 10:00:00", "2014-4-11 10:10:00", 10f);

         System.out.println("Datum :" + s.getGodina() + " " + s.getMesec() + " " + s.getDan());
         System.out.println("Radnik :" + s.getRadnik().getImePrezime());
         System.out.println("Početak :" + s.getSatPocetak() + ":" + s.getMinutPocetak());
         System.out.println("Kraj :" + s.getSatKraj() + ":" + s.getMinutKraj());
         System.out.println("Trajanje: " + s.getTrajanje());
         */
        //</editor-fold>
        for (Map.Entry<Integer, SBData> e : workerTimeLine(radnik, "2014-04-10").entrySet()) {
            System.err.println(e.getKey() + ". " + e.getValue());
        }
    }
}

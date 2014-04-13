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
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author dobri
 */
public class JavaAppERSTest {

    //<editor-fold defaultstate="collapsed" desc="Klasa StackedBarCategoryWorkerData">
    private static class StackedBarCategoryWorkerData {
        public static final String MIN_SYSTEM_TIME = "07:00:00";
        public static final String MAX_SYSTEM_TIME = "23:00:00";
        public static final Statusi STATUS_ODSUSTVO = ERSQuery.statusPoID(14);
        
        private final Radnik radnik;
        private final Statusi status;
        private String nalog;
        private final String datum;
        private final String vremePocetka;
        private final String vremeKraja;
        private final Float trajanje;

        private final int satPocetak;
        private final int satKraj;
        private final float minutPocetak;
        private final float minutKraj;

        private Number vremePocetakDecimal;
        private Number vremeKrajDecimal;

        private static final Calendar c = Calendar.getInstance();
        private static final DecimalFormat df1 = new DecimalFormat("#.##");

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
        public StackedBarCategoryWorkerData(Radnik radnik, Statusi status, String nalog, String datum, String vremePocetka, String vremeKraja, Float trajanje) {
            this.radnik = radnik;
            this.status = status;
            this.nalog = nalog;
            this.datum = datum;
            this.vremePocetka = vremePocetka;
            this.vremeKraja = vremeKraja;
            this.trajanje = trajanje;

            c.setTime(toDate(vremePocetka));
            satPocetak = c.get(Calendar.HOUR_OF_DAY);
            minutPocetak = c.get(Calendar.MINUTE);

            c.setTime(toDate(vremeKraja));
            satKraj = c.get(Calendar.HOUR_OF_DAY);
            minutKraj = c.get(Calendar.MINUTE);

            vremePocetakDecimal = satPocetak + minutPocetak / 60;
            vremeKrajDecimal = satKraj + minutKraj / 60;

            try {
                vremePocetakDecimal = df1.parse(df1.format(vremePocetakDecimal));
                vremeKrajDecimal = df1.parse(df1.format(vremeKrajDecimal));
            } catch (ParseException ex) {
            }
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

        public int getSatPocetak() {
            return satPocetak;
        }

        public int getSatKraj() {
            return satKraj;
        }

        public float getMinutPocetak() {
            return minutPocetak;
        }

        public float getMinutKraj() {
            return minutKraj;
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="setters">
        public void setNalog(String nalog) {
            this.nalog = nalog;
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="toDate">
        /**
         *
         * @param time npr. "2014-04-02 10:15:32"
         * @return
         */
        private Date toDate(String time) {
            try {
                return (new SimpleDateFormat("HH:mm:ss")).parse(time);
            } catch (ParseException | NullPointerException ex) {
                return new Date(toDate(MAX_SYSTEM_TIME).getTime());
            }
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="toString">
        @Override
        public String toString() {
            return "[" + datum + "] "
                    + "[" + radnik.getImePrezime() + "] "
                    + "[" + status.getStatus() + "] "
                    + (status.getUnosNaloga() ? "[" + this.nalog + "] " : "")
                    + "[" + this.vremePocetka + "] "
                    + "[" + this.vremeKraja + "] "
                    + "[" + this.getTrajanje() + "] "
                    + "  >>>> [" + this.vremePocetakDecimal + "] <-> [" + this.vremeKrajDecimal + "]";
        }
        //</editor-fold>
    }
    //</editor-fold>

    /**
     *
     * @param Radnik
     * @param Datum
     * @return Map<Integer, SBData>
     */
    private static Map<Integer, StackedBarCategoryWorkerData> workerTimeLine(Radnik radnik, String datum) {
        Map<Integer, StackedBarCategoryWorkerData> TL = new TreeMap<>();
        StackedBarCategoryWorkerData SB;
        List<Raddan> RD = ERSQuery.evidencijeRadnikaZaDatum(radnik, datum);

        if (!RD.isEmpty()) {
            for (Raddan r1 : RD) {
                SB = new StackedBarCategoryWorkerData(
                        radnik,
                        r1.getFKIDStatus(),
                        r1.getNalog(),
                        datum,
                        r1.getPocStanja(),
                        r1.getKrajStanja(),
                        r1.getTrajanje()
                );

                TL.put(r1.getRbrstanja(), SB);
            }

        } else {
            SB = new StackedBarCategoryWorkerData(
                    radnik,
                    StackedBarCategoryWorkerData.STATUS_ODSUSTVO,
                    null,
                    datum,
                    StackedBarCategoryWorkerData.MIN_SYSTEM_TIME,
                    StackedBarCategoryWorkerData.MAX_SYSTEM_TIME,
                    16f
            );

            TL.put(1, SB);
        }

        return TL;
    }

    public static void main(String[] args) throws ParseException {
        Radnik radnik = ERSQuery.radnikID(66);
        String datum = "2014-4-29";

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
        //<editor-fold defaultstate="collapsed" desc="test zaokruživanje.">
        /*String v = "13:15:11";
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
         System.out.println(df.format(sat + minut / 60));*/
        //</editor-fold>
        for (Map.Entry<Integer, StackedBarCategoryWorkerData> e : workerTimeLine(radnik, datum).entrySet()) {
            System.err.println(e.getKey() + ". " + e.getValue());
        }
    }
}

 /* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author dobri
 */
public class JavaAppTestQuery {

    private static final int Godina = 2014;
    private static final int Mesec = 2;

    public static void main(String[] args) throws InterruptedException {

        //<editor-fold defaultstate="collapsed" desc="uspešni testovi..">
        /*
         System.out.println("test radnik : " + Radnik.getRadnik("0217").toString());
         System.out.println("test int id : " + Radnik.getRadnik("0217").getIntID());
        
         for (Object[] r : INFSYS.queries.INFSistemQuery.test111("2014-2-7")) {
         System.out.println((Long) r[0] + "-" + (String) r[1]);
         }
         */
        /*for (MesecFA_UK r : INFSYS.queries.INFSistemQuery.MesecFA_UK(2014, 2)) {
         System.err.println(r.toString());
         }
         */
        /*
         for (DnevnoFA_UK r : INFSYS.queries.INFSistemQuery.DnevnoFA_UK(2014, 2)) {
         System.out.println(r.toString());
         }
         */
        /*
         for (Map.Entry<Integer, DnevnoFA_UK> e : INFSYS.queries.INFSistemQuery.DnevnoFA_UK(2014, 2).entrySet()) {
         System.err.println(e.getKey() + " - " + e.getValue());
         }
        
         System.err.println("posl dan " + Base4BusinessBeans.getLastDayOfMonth(Godina, Mesec));
        
         
        
         /*
         for (Map.Entry<Integer, DnevnoFA_UK> e : Mesec_DnevnoFA_UK(Godina, Mesec).entrySet()) {
         System.out.println(e.getKey() + " | " + e.getValue());
         }
         */
        /*int s = 1;
         for (Map<Integer, Integer> serija : Mesec_DnevnoFA_UK_Serije(Godina, Mesec)) {
         System.out.println("Serija-" + (s++));
        
         for (Map.Entry<Integer, Integer> e : serija.entrySet()) {
         System.out.println(e.getKey() + " | " + e.getValue());
         }
         }
        
         System.out.println();
         System.err.println("ukupno :" + (System.currentTimeMillis() - t1) + " ms.");
        
         
        
         int ss = 1;
         for (Map<Integer, Integer> serija : Mesec_DnevnoSATI_UK_Serije(Godina, Mesec)) {
         System.out.println("Serija-" + (ss++));
        
         for (Map.Entry<Integer, Integer> e : serija.entrySet()) {
         System.out.println(e.getKey() + " | " + e.getValue());
         }
         }
         
         /*
         for (Map.Entry<Integer, Integer> e : UKDnevnaFakturisanost(Godina, Mesec).entrySet()) {
        
         System.out.println(e.getKey() + " | " + e.getValue());
         }
         
        
         for (SSavetnikPerformanse s : SSavetnikPerformanse(Godina, Mesec)) {
         System.err.println(s.toString());
         }
        
         for (Map.Entry<Integer, Integer> m : Mesec_Svi_SSavetnici_Performanse_Ukupno(Godina, Mesec).entrySet()) {
         System.err.println(m.toString());
         }
         
        
         for (Map<Integer, Integer> s : Mesec_Svi_SSavetnici_Performanse_Serije(Godina, Mesec)) {
         System.err.println("Serija-" + (ss++));
         for (Map.Entry<Integer, Integer> m : s.entrySet()) {
         System.out.println(m.toString());
         }
         }

         for (Map.Entry<Integer, Integer> e : Mesec_Svi_SSavetnici_Performanse_Ukupno(Godina, Mesec).entrySet()) {
         System.out.println(e.getKey() + "-" + e.getValue());
         }
        
         for (Map<String, Integer> s : Mesec_DnevnoFA_UK_Serije(Godina, Mesec)) {
         System.err.println("Serija-" + (ss++));
         for (Map.Entry<String, Integer> m : s.entrySet()) {
         System.out.println(m.toString());
         }
         }
         */
        //</editor-fold>
        long t1 = System.currentTimeMillis();

        int ss = 1;

        //Set<Integer> s = new TreeSet<>();
        Set<String> sss = new HashSet<>();

        /*for (Map<Integer, Integer> s : finansijskiAspekt_GodisnjiPregled_RadMat(Godina)) {
         System.err.println("Serija-" + (ss++));
         for (Map.Entry<Integer, Integer> m : s.entrySet()) {
         System.out.println(m.getKey() + "->" + m.getValue());
         }
         }*/
        /*
         s.add(5);
         s.add(2);
         s.add(12);
         s.add(17);
         s.add(9);
        
         String y[]=new String[4];
        
         int i=0;
         for (Integer x : s) {
         y[i]=x.toString();
         System.err.println(y[i]);
         }
         */
        String s[] = new String[]{"01", "02", "03", "10", "11"};
        int i = 1;
        Map<String, Integer> mm = new HashMap<>();

        for (String s1 : s) {
            System.out.println(s1);
            mm.put("xx", i++);
        }

        for (int iii = 0; iii < 5; iii++) {
            mm.put("Y", iii++);
        }

        for (Map.Entry<String, Integer> m : mm.entrySet()) {
            System.out.println(m.getKey() + "->" + m.getValue());
        }

        System.out.println();
        System.err.println("ukupno :" + (System.currentTimeMillis() - t1) + " ms.");

        Map<Integer, Integer> M = new HashMap<>();

        for (int iii = 0; iii < 5; iii++) {
            M.put(iii, new Random().nextInt(100));
        }

        for (Map.Entry<Integer, Integer> e : M.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());

        }

    }
}

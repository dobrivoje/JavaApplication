/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.tests;

import java.text.ParseException;
import org.dobrivoje.calendarutilities.Kalendar;

/**
 *
 * @author dobri
 */
public class JavaAppTest_KalendarKlasa {

    public static void main(String[] args) throws ParseException {
        Kalendar k = Kalendar.getDefault();
        String Datum = "2014-1-19";

        k.setDatum(null);

        System.out.println(k.getGodina() + ", " + k.getMesec());
        System.out.println(k.getPrethGod() + ", " + k.getPrethMesec());
        System.out.println("God. izmenjena ? " + k.isGodinaIzmenjena() + ", mesec izmenjen ? " + k.isMesecIzmenjen());

        k.setDatum("2014-1-19");

        System.out.println(k.getGodina() + ", " + k.getMesec());
        System.out.println("God. izmenjena ? " + k.isGodinaIzmenjena() + ", mesec izmenjen ? " + k.isMesecIzmenjen());

        k.setDatum("2013-1-19");

        System.out.println(k.getGodina() + ", " + k.getMesec());
        System.out.println("God. izmenjena ? " + k.isGodinaIzmenjena() + ", mesec izmenjen ? " + k.isMesecIzmenjen());

    }
}

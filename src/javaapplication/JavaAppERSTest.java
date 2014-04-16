/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

import ERS.TimeLine.Functionalities.Adapters.FirmaAdapter;
import ERS.TimeLine.Functionalities.ITimeLineCategory;
import ERS.TimeLine.Functionalities.Adapters.RadnikAdapter;
import ERS.TimeLine.Functionalities.ITimeLineDuration;
import ERS.TimeLine.Functionalities.ITimeLineObservableUnit;
import ERS.queries.ERSQuery;
import ent.Firma;
import java.text.ParseException;
import java.util.Map;

/**
 *
 * @author dobri
 */
public class JavaAppERSTest {

    public static void main(String[] args) throws ParseException {
        String Datum = "2009-4-9";
        ITimeLineCategory r2 = new RadnikAdapter(66l);
        Firma Firma = ERSQuery.PODRAZUMEVANA_FIRMA;
        ITimeLineObservableUnit OU = new FirmaAdapter(Firma, Datum);

        System.out.println("ITimeLineCategory Radnik - " + r2.getCategory());
        System.out.println("Podrazumevana Firma : " + Firma.toString());

        /*
         ITimeLineObservableUnit OU = new FirmaAdapter(ERSQuery.PODRAZUMEVANA_FIRMA, Datum);
         for (ITimeLineCategory cat : OU.getCategories()) {
         System.out.println("Kategorija - " + cat.getCategory() + ", Radnik - " + ((RadnikAdapter)cat).getRadnik().getSifraINFSISTEM());
         }
         */
        //Test
        for (Map.Entry<String, Map<Integer, ITimeLineDuration>> entry : ERSQuery.AllCategoresEvents(OU, Datum).entrySet()) {
            String CAT = entry.getKey();
            Map<Integer, ITimeLineDuration> DOGADJAJI = entry.getValue();

            System.out.println(CAT);

            for (Map.Entry<Integer, ITimeLineDuration> entry1 : DOGADJAJI.entrySet()) {
                Integer I = entry1.getKey();
                ITimeLineDuration D = entry1.getValue();

                System.out.println(I + " -> " + D);
            }
        }
    }
}

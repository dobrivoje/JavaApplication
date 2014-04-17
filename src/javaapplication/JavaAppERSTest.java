/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

import ERS.TimeLine.Functionalities.Adapters.FirmaAdapter;
import ERS.TimeLine.Functionalities.ITimeLineCategory;
import ERS.TimeLine.Functionalities.ITimeLineDuration;
import ERS.TimeLine.Functionalities.ITimeLineObservableUnit;
import ERS.queries.ERSQuery;
import java.text.ParseException;
import java.util.Map;

/**
 *
 * @author dobri
 */
public class JavaAppERSTest {

    public static void main(String[] args) throws ParseException {
        String Datum = "2014-4-19";
        ITimeLineObservableUnit OU = new FirmaAdapter(ERSQuery.PODRAZUMEVANA_FIRMA, Datum);

        //Test
        for (Map.Entry<ITimeLineCategory, Map<Integer, ITimeLineDuration>> kat : ERSQuery.AllCategoresEvents(OU, Datum).entrySet()) {
            String CAT = kat.getKey().getCategory();
            Map<Integer, ITimeLineDuration> DOGADJAJI = kat.getValue();

            System.out.println(CAT);

            for (Map.Entry<Integer, ITimeLineDuration> e1 : DOGADJAJI.entrySet()) {
                Integer I = e1.getKey();
                ITimeLineDuration D = e1.getValue();

                System.out.println("    " + I + " -> " + D);
            }
        }
    }
}

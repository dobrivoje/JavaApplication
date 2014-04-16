/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

import ERS.TimeLine.Functionalities.Adapters.FirmaAdapter;
import ERS.TimeLine.Functionalities.ITimeLineCategory;
import ERS.TimeLine.Functionalities.Adapters.RadnikAdapter;
import ERS.TimeLine.Functionalities.Adapters.SBCWorkerAdapter;
import ERS.TimeLine.Functionalities.ITimeLineDuration;
import ERS.TimeLine.Functionalities.ITimeLineObservableUnit;
import ERS.TimeLine.SBCWorkerTimeLine;
import ERS.queries.ERSQuery;
import static ERS.queries.ERSQuery.radnikID;
import static ERS.queries.ERSQuery.statusPoID;
import static ERS.queries.ERSQuery.workerTimeLine;
import ent.Firma;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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
        Map<ITimeLineCategory, Map<Integer, ITimeLineDuration>> ACE = new TreeMap<>();

        Map<Integer, ITimeLineDuration> evidencije = new HashMap<>();
        SBCWorkerTimeLine dogadjaj = new SBCWorkerTimeLine(radnikID(66), statusPoID(1), Datum, "nalog x11", "11:00:00", "11:10:00", 10f);
        ITimeLineDuration itld = new SBCWorkerAdapter(dogadjaj);
        evidencije.put(0, itld);

        System.err.println("Test1 'evidencija.put' :");
        System.err.println(evidencije);

        System.err.println("Test2 'ACE' :");
        ITimeLineCategory CAT = new ITimeLineCategory() {

            @Override
            public String getCategory() {
                return "Cat Test";
            }
        };
        try {
            ACE.put(CAT, evidencije);
        } catch (Exception e) {
            System.err.println("greška !");
        }

        Map<Integer, ITimeLineDuration> evidentiraniStatusi;
        int ukPrisustvo = 0;

        for (ITimeLineCategory ITLC : OU.getCategories()) {
            RadnikAdapter RTL = (RadnikAdapter) ITLC;
            evidentiraniStatusi = new TreeMap<>();

            for (Map.Entry<Integer, SBCWorkerTimeLine> e : workerTimeLine(RTL.getRadnik(), Datum).entrySet()) {
                Integer RBr = e.getKey();
                SBCWorkerAdapter SBCWAdapter = new SBCWorkerAdapter(e.getValue());

                ukPrisustvo += (SBCWAdapter.getDuration() != -1 && SBCWAdapter.getStatusID() != 15
                        ? SBCWAdapter.getDuration() : 0);

                evidentiraniStatusi.put(RBr, SBCWAdapter);
            }

            System.out.println(ITLC.getCategory());
            System.out.println(evidentiraniStatusi.values());
            System.err.println("Uk. prisustvo: " + ukPrisustvo);

            ukPrisustvo = 0;

            // ACE.put(RTL, evidentiraniStatusi);
        }

        /*
         for (Map.Entry<ITimeLineCategory, Map<Integer, ITimeLineDuration>> entry : ACE.entrySet()) {
         ITimeLineCategory CAT = entry.getKey();
         Map<Integer, ITimeLineDuration> EvidDogadjaji = entry.getValue();
        
         System.err.println(CAT.getCategory());
         System.err.println(EvidDogadjaji.toString());
         }
         */
    }
}

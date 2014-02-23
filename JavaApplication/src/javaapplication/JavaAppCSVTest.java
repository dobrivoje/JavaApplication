/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

import Exceptions.ExcelSheetException;
import com.dobrivoje.CSV.CSVUtils;
import com.dobrivoje.CSV.FUCSVBean;
import ent.Radnik;
import java.io.File;

/**
 *
 * @author dobri
 */
public class JavaAppCSVTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            File f = new File("src/javaapplication/FU.csv");
            CSVUtils csv = CSVUtils.getDafault(f, ';', 1);
            System.out.println(csv.toString());

            FUCSVBean f1 = csv.getCSVBeanList().get(1);
            // System.err.println("f1: " + f1.getSati() + ", sati*2: " + 2 * f1.getSatiN());

            double suma = 0;

            for (FUCSVBean ff : csv.getCSVBeanList()) {
                Radnik r = ERS.queries.ERSQuery.radnikSifraINFSISTEM(ff.getRadnik());

                suma +=  ff.getSatiN();
                System.err.println((r != null ? "[" + r.getIme() + " " + r.getPrezime() + "] " : "[n/a] ") + ff.toString() + " [" + ff.getDatumRacunaN() + "]");
            }
            System.out.println("UKUPNO SATI : " + suma);

        } catch (ExcelSheetException ex) {
            System.err.println("ExcelSheetException: " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Exception: " + ex.getMessage() + ", " + ex.toString());
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

import Exceptions.ExcelSheetException;
import com.dobrivoje.CSV.CSVUtils2;
import com.dobrivoje.CSV.FakturisaneUslugeBean;
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
            File f = new File("src/javaapplication/FU20.csv");

            CSVUtils2 csv = CSVUtils2.getDafault(f);
            csv.setUpBean(new FakturisaneUslugeBean());
            System.out.println(csv.toString());

        } catch (ExcelSheetException ex) {
            System.err.println("ExcelSheetException: " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Exception: " + ex.getMessage() + ", " + ex.toString());
        }
    }
}

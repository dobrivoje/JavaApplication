/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

import ERS.Beans.FakturisaneUsluge.FUExcelBean;
import ERS.queries.ERSQuery;
import static ERS.queries.ERSQuery.tempFaktSati;
import Exceptions.ExcelSheetException;
import com.dobrivoje.EXCELL.ExcelUtils;
import ent.TempFaktSati;
import java.io.File;

/**
 *
 * @author dobri
 */
public class JavaAppTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ExcelUtils eu = null;

        try {
            File f = new File("src/javaapplication/FU1.xls");

            eu = ExcelUtils.getDafault(f);
            System.out.println(eu.toString());

        } catch (ExcelSheetException ex) {
            System.err.println("ExcelSheetException: " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Exception: " + ex.getMessage() + ", " + ex.toString());
        }
        
        FUExcelBean fueb;
        try {
            fueb=new FUExcelBean();
            fueb.setRadnik("0090");
            fueb.setDatumRacuna("21.01.2011");
            fueb.setRadniNalog("RN-test-333");
            fueb.setSati(1.23);
            
            ERSQuery.insertTempFU(fueb);
        } catch (Exception ex) {
            System.err.println("Problem u upisu tempFu.");
        }
        
        try {
            if (tempFaktSati().size() < 1) {
                System.err.println("Nema zapisa u tempFakt.");
            } else {
                for (TempFaktSati tf : tempFaktSati()) {
                    System.err.println(tf.toString());
                }
            }
        } catch (Exception e) {
        }
    }
}

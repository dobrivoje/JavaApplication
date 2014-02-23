/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

import Exceptions.ExcelSheetException;
import com.dobrivoje.EXCELL.ExcelUtils;
import ent.TempFaktSati;
import java.io.File;
import java.text.ParseException;

/**
 *
 * @author root
 */
public class JavaApplication5 {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        try {
            File f = new File("src/javaapplication/FU.String.xls");

            ExcelUtils eu = ExcelUtils.getDafault(f);
            System.out.println(eu.toString());

            // ERS.queries.ERSQuery.insertNoveFakturisaneUslugeExcel(eu.getExcelBeanList());
            TempFaktSati tf;

            /*
            for (FUExcelBean fu : eu.getExcelBeanList()) {
            String l = fu.getRadnik();
            double d = fu.getSati();
            String rn = fu.getRadniNalog();
            String dat = new SimpleDateFormat("yyyy-MM-dd").format(fu.getDatumRacuna());
            
            System.err.println(
            l + ", "
            + d + ", "
            + rn + ", "
            + dat
            );
            }
            */

        } catch (ExcelSheetException ex) {
            System.err.println("ExcelSheetException: " + ex.getMessage());
        } catch (ParseException ex) {
        } 
    }
}

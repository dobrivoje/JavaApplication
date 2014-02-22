/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

import Exceptions.ExcelSheetException;
import com.dobrivoje.EXCELL.ExcelUtils;
import java.io.File;

/**
 *
 * @author dobri
 */
public class JavaAppExcelTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            File f = new File("src/javaapplication/FU1.xls");

            ExcelUtils eu = ExcelUtils.getDafault(f);
            System.out.println(eu.toString());

        } catch (ExcelSheetException ex) {
            System.err.println("ExcelSheetException: " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Exception: " + ex.getMessage() + ", " + ex.toString());
        }
    }
}

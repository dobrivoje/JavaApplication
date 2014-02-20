/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dobrivoje.utilities.excel;

import Exceptions.ExcelSheetException;
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
        File f = null;

        try {
            f = new File("C:\\Documents and Settings\\dobri.AKK_DOMAIN\\desktop\\FU.xls");
        } catch (Exception ex) {
            System.err.println("Exception: " + ex.getMessage() + ", " + ex.toString());
        }

        try {
            ExcelUtils eu = ExcelUtils.getDafault(f);
            System.out.println(eu.toString());

        } catch (ExcelSheetException ex) {
            System.err.println("ExcelSheetException: " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Exception: " + ex.getMessage() + ", " + ex.toString());
        }
    }
}

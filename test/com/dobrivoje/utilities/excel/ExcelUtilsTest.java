/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dobrivoje.utilities.excel;

import Exceptions.ExcelSheetException;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dobri
 */
public class ExcelUtilsTest {

    public ExcelUtilsTest() {
    }

    @Test
    public void testGetBeanList() {
        System.out.println("getBeanList");
        ExcelUtils instance = null;

        try {
            instance = ExcelUtils.getDafault(new File("C:\\Documents and Settings\\dobri.AKK_DOMAIN\\desktop\\FU2.xls"));
        } catch (ExcelSheetException ex) {
        } catch (Exception ex) {
        }

        FakturisaneUslugeBean[] ocekivaniRezultat;
        Date d = null;
        
        try {
            d = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2008-1-3 00:00:00");
        } catch (ParseException ex) {
        }

            ocekivaniRezultat = new FakturisaneUslugeBean[]{
                new FakturisaneUslugeBean("0143", 0.5, "069845", d, null)
            };

        ArrayList<FakturisaneUslugeBean> expResult = new ArrayList<>(Arrays.asList(ocekivaniRezultat));
        List<IExcelable> result = instance.getBeanList();
        assertEquals(expResult, result);
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        ExcelUtils instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

}

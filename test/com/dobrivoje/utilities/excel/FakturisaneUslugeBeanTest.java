/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dobrivoje.utilities.excel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dobri
 */
public class FakturisaneUslugeBeanTest {

    public FakturisaneUslugeBeanTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testGetColumns() {
        System.out.println("getColumns");
        FakturisaneUslugeBean instance = new FakturisaneUslugeBean();

        String[] kolone = new String[]{"Radnik", "Sati", "RadniNalog", "DatumRacuna", "ProfitniCentar"};

        List<String> expResult = new ArrayList<>(Arrays.asList(kolone));
        List<String> result = instance.getColumns();
        assertEquals(expResult, result);
    }

}

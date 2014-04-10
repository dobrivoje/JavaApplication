/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dobrivoje.CSV;

import Exceptions.ExcelSheetException;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author root
 */
public class CSVUtils2 extends CSVSingletonUtils<FakturisaneUslugeBean> {

    private static CSVUtils2 instance;

    private CSVUtils2(File file, char Separator, int PreskociBrLinija) throws FileNotFoundException {
        super(file, Separator, PreskociBrLinija);
    }

    public static CSVUtils2 getDafault(File File, char Separator, int PreskociLinije) throws ExcelSheetException, Exception {
        return (instance == null ? instance = new CSVUtils2(File, Separator, PreskociLinije) : instance);
    }

    public static CSVUtils2 getDafault(File File) throws ExcelSheetException, Exception {
        return (instance == null ? instance = new CSVUtils2(File, ';', 1) : instance);
    }
}

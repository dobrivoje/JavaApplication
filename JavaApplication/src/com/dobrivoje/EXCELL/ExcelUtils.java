/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dobrivoje.EXCELL;

import Exceptions.ExcelSheetException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import jxl.DateCell;
import jxl.NumberCell;

/**
 *
 * @author root
 */
public class ExcelUtils extends ExcelSingletonUtils<FUExcelBean> {

    private static ExcelUtils instance;

    private ExcelUtils(File file, int PreskakanjeLinija, int RBr_Sheet_a) throws FileNotFoundException, IOException, Exception {
        super(file, PreskakanjeLinija, RBr_Sheet_a);
    }

    public static ExcelUtils getDafault(File File, int PreskociLinije, int Sheet_RBr) throws ExcelSheetException, Exception {
        if (Sheet_RBr < 1) {
            throw new ExcelSheetException("Sheet počinje od 1 pa na dalje.");
        } else {
            return (instance == null ? instance = new ExcelUtils(File, PreskociLinije, Sheet_RBr) : instance);
        }
    }

    public static ExcelUtils getDafault(File File) throws ExcelSheetException, Exception {
        return getDafault(File, 1, 1);
    }

    @Override
    public List<FUExcelBean> getExcelBeanList() {
        FUExcelBean fuTmp;

        for (int vrsta = PreskociBrLinija; vrsta < Sheet.getRows(); vrsta++) {
            fuTmp = new FUExcelBean();

            fuTmp.setRadnik(Sheet.getCell(0, vrsta).getContents());
            fuTmp.setSati(((NumberCell) Sheet.getCell(1, vrsta)).getValue());
            fuTmp.setRadniNalog(Sheet.getCell(2, vrsta).getContents());
            fuTmp.setDatumRacuna(((DateCell) Sheet.getCell(3, vrsta)).getDate());
            fuTmp.setProfitniCentar(Sheet.getCell(4, vrsta).getContents());

            ExcelBeanList.add(fuTmp);
        }

        return ExcelBeanList;
    }
}

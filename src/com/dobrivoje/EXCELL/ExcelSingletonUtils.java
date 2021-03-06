/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dobrivoje.EXCELL;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jxl.Sheet;
import jxl.Workbook;

/**
 *
 * @author root
 * @param <T>
 */
public abstract class ExcelSingletonUtils<T> {

    protected List<T> ExcelBeanList;
    //
    protected static int PreskociBrLinija = 1;
    protected static Workbook Workbook;
    protected static Sheet Sheet;

    protected ExcelSingletonUtils(File file, int PreskakanjeLinija, int RBr_Sheet_a) throws FileNotFoundException, IOException, Exception {
        this.ExcelBeanList = new ArrayList<>();
        ExcelSingletonUtils.Workbook = Workbook.getWorkbook(file);
        ExcelSingletonUtils.Sheet = Workbook.getSheet(RBr_Sheet_a - 1);
        ExcelSingletonUtils.PreskociBrLinija = PreskakanjeLinija;
    }

    public abstract List<T> getExcelBeanList();

    @Override
    public String toString() {
        int rb = 0;
        String tmp = "";

        for (T t : getExcelBeanList()) {
            tmp += (++rb) + ".  " + t.toString() + '\n';
        }

        return tmp;
    }
}

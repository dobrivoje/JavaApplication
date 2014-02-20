/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dobrivoje.EXCELL;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jxl.DateCell;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *
 * @author dobri
 */
public class App_JExcell {

    public static void main(String[] args) throws IOException, BiffException {
        Workbook workbook = Workbook.getWorkbook(new File("src/com/dobrivoje/EXCELL/FU1.xls"));
        Sheet sheet = workbook.getSheet(0);

        FakturisaneUslugeBean fu;
        List<FakturisaneUslugeBean> l1 = new ArrayList<>();

        for (int vrsta = 1; vrsta < sheet.getRows(); vrsta++) {
            fu = new FakturisaneUslugeBean();

            fu.setRadnik(sheet.getCell(0, vrsta).getContents());
            fu.setSati(((NumberCell) sheet.getCell(1, vrsta)).getValue());
            fu.setRadniNalog(sheet.getCell(2, vrsta).getContents());
            fu.setDatumRacuna(((DateCell) sheet.getCell(3, vrsta)).getDate());
            fu.setProfitniCentar(sheet.getCell(4, vrsta).getContents());

            l1.add(fu);
        }

        int rb = 0;
        for (FakturisaneUslugeBean fb : l1) {
            System.out.println((++rb) + ".  " + fb.toString());
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dobrivoje.EXCELL;

import java.io.File;
import java.io.IOException;
import jxl.Cell;
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
        Sheet sheet = workbook.getSheet("Radnici");
        Cell c;

        String cont[] = new String[sheet.getColumns()];

        for (int vrsta = 0; vrsta < sheet.getRows(); vrsta++) {
            for (int kolona = 0; kolona < sheet.getColumns(); kolona++) {
                c = sheet.getCell(kolona, vrsta);
                cont[kolona] = c.getContents().isEmpty() ? "n/a" : "[" + c.getContents() + "]";
            }

            for (String c1 : cont) {
                System.err.print(c1 + " ");
            }
        }
    }
}

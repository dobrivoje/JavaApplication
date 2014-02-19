/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dobrivoje.EXCELL;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author dobri
 */
public class App_AppachePOI {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        int sheetIndex = 0;
        Workbook workbook = new HSSFWorkbook(
                new FileInputStream("src/com/dobrivoje/EXCELL/FU1.xls"));
        Sheet sheet = workbook.getSheetAt(sheetIndex);

        for (int rowNo=0; rowNo<10; rowNo++) {
            Row row = sheet.getRow(rowNo);
            
            FakturisaneUslugeBean fu = new FakturisaneUslugeBean();

            try {
                fu.setRadnik(row.getCell(0).getStringCellValue());
                fu.setSati((float) row.getCell(1).getNumericCellValue());
                fu.setRadniNalog(row.getCell(2).getStringCellValue());
                fu.setDatumRacuna(row.getCell(3).getStringCellValue());
                fu.setDatumRacuna(row.getCell(4).getStringCellValue());

                System.err.println(fu.toString());
            } catch (IllegalStateException e) {
            }
        }
    }
}

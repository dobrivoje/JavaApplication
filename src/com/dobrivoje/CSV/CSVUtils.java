/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dobrivoje.CSV;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author root
 */
public class CSVUtils {

    private static CSVUtils instance;
    //
    private static char Separator = ';';
    private static final char CSV_Param = '\'';
    private static int PreskociBrLinija = 1;
    //
    private static CSVReader CVSReader;
    private static final CsvToBean CVSToBean = new CsvToBean();
    private static final ColumnPositionMappingStrategy cpms = new ColumnPositionMappingStrategy();
    //
    private static List<ICVSAble> CVSBeanList = new ArrayList<>();

    protected CSVUtils(File file, char Separator, int PreskociBrLinija) throws FileNotFoundException {
        init(file, Separator, PreskociBrLinija);
    }

    private static void init(File file, char Separator, int PreskociBrLinija) throws FileNotFoundException {
        CSVUtils.Separator = Separator;
        CSVUtils.PreskociBrLinija = PreskociBrLinija;

        CVSReader = new CSVReader(new FileReader(file), Separator, CSV_Param, PreskociBrLinija);
    }

    public static CSVUtils getDafault(File file) throws FileNotFoundException {
        return instance
                = (instance == null ? new CSVUtils(file, ';', 1) : instance);
    }

    public static CSVUtils getDafault(File file, char Separator, int PreskociBrLinija) throws FileNotFoundException {
        return instance
                = (instance == null ? new CSVUtils(file, Separator, PreskociBrLinija) : instance);
    }

    public void setUpBean(ICVSAble bean) {
        cpms.setType(bean.getClass());
        cpms.setColumnMapping(bean.getColumns().toArray(new String[bean.getColumns().size()]));

        CVSBeanList = CVSToBean.parse(cpms, CVSReader);
    }

    public List<ICVSAble> getList() {
        return CVSBeanList;
    }
}

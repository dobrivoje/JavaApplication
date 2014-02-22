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
 * @param <T>
 */
public abstract class CSVSingletonUtils<T> {

    protected List<T> CSVBeanList;
    //
    private static char Separator = ';';
    private static final char CSV_Param = '\'';
    private static int PreskociBrLinija = 1;
    //
    private static CSVReader CVSReader;
    private static final CsvToBean CVSToBean = new CsvToBean();
    private static final ColumnPositionMappingStrategy cpms = new ColumnPositionMappingStrategy();

    /**
     *
     * @param file
     * @param Separator
     * @param PreskociBrLinija
     * @throws FileNotFoundException
     */
    protected CSVSingletonUtils(File file, char Separator, int PreskociBrLinija) throws FileNotFoundException {
        this.CSVBeanList = new ArrayList<>();

        CSVSingletonUtils.Separator = Separator;
        CSVSingletonUtils.PreskociBrLinija = PreskociBrLinija;

        CVSReader = new CSVReader(new FileReader(file), Separator, CSV_Param, PreskociBrLinija);
    }

    public void setUpBean(ICVSAble bean) {
        cpms.setType(bean.getClass());
        cpms.setColumnMapping(bean.getColumns().toArray(new String[bean.getColumns().size()]));

        this.CSVBeanList = CVSToBean.parse(cpms, CVSReader);
    }

    public List<T> getCSVBeanList() {
        return CSVBeanList;
    }

    @Override
    public String toString() {
        int rb = 0;
        String tmp = "";

        for (T t : getCSVBeanList()) {
            tmp += (++rb) + ".  " + t.toString() + '\n';
        }

        return tmp;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dobrivoje.CSV;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author dobri
 */
public class FakturisaneUslugeBean implements ICVSAble {

    private String Radnik;
    private String Sati;
    private String RadniNalog;
    private String DatumRacuna;
    private String ProfitniCentar;

    private static final String[] kolone = new String[]{"Radnik", "Sati", "RadniNalog", "DatumRacuna", "ProfitniCentar"};

    @Override
    public List<String> getColumns() {
        return new ArrayList<>(Arrays.asList(kolone));
    }

    public FakturisaneUslugeBean() {
    }

    public FakturisaneUslugeBean(String Radnik, String Sati, String RadniNalog, String DatumRacuna, String ProfitniCentar) {
        this.Radnik = Radnik;
        this.Sati = Sati;
        this.RadniNalog = RadniNalog;
        this.DatumRacuna = DatumRacuna;
        this.ProfitniCentar = ProfitniCentar;
    }

    public String getRadnik() {
        return Radnik;
    }

    public void setRadnik(String Radnik) {
        this.Radnik = Radnik;
    }

    public String getSati() {
        return Sati;
    }

    public void setSati(String Sati) {
        this.Sati = Sati;
    }

    public String getRadniNalog() {
        return RadniNalog;
    }

    public void setRadniNalog(String RadniNalog) {
        this.RadniNalog = RadniNalog;
    }

    public String getDatumRacuna() {
        return DatumRacuna;
    }

    public void setDatumRacuna(String DatumRacuna) {
        this.DatumRacuna = DatumRacuna;
    }

    public String getProfitniCentar() {
        return ProfitniCentar;
    }

    public void setProfitniCentar(String ProfitniCentar) {
        this.ProfitniCentar = ProfitniCentar;
    }

    @Override
    public String toString() {
        return "[" + Radnik + "]"
                + "[" + Sati + "]"
                + "[" + RadniNalog + "]"
                + "[" + DatumRacuna + "]"
                + "[" + ProfitniCentar + "]";
    }

}

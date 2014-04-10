/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

/**
 *
 * @author dobri
 */
public class Kalendar {

    private int Godina;
    private int Mesec;

    public Kalendar(int Godina, int Mesec) {
        this.Godina = Godina;
        this.Mesec = Mesec;
    }

    public int getGodina() {
        return Godina;
    }

    public final void setGodina(int Godina) {
        this.Godina = Godina != this.Godina ? Godina : this.Godina;
    }

    public int getMesec() {
        return Mesec;
    }

    public final void setMesec(int mesec) {
        this.Mesec = mesec != this.Mesec ? mesec : this.Mesec;
    }
    public final void setGM(int godina, int mesec) {
        setGodina(godina);
        setMesec(mesec);
    }

    @Override
    public String toString() {
        return "Mesec-" + getMesec() + "  Godina-" + getGodina();
    }
}

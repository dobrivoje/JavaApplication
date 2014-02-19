/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

import com.dobrivoje.CSV.CSVUtils;
import com.dobrivoje.CSV.IColumnMapping;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;

/**
 *
 * @author dobri
 */
public class JavaApplication1 {

    static Date datum1 = null;
    static Date vreme1 = null;
    static String datum1Str = null;
    static String vreme1Str = null;

    private static int X = 0;
    private static final Test test = new Test();

    private static class Test {

        public void Izmeni(int i) {
            JavaApplication1.X = i;
        }
    }

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */

    /*
     private void generisiIzvestaj(long IDRadnik, String datumOD, String datumDO) {
     Map<String, Object> JasperParametri = new HashMap<>();

     ERSQuery.getEm().getTransaction().begin();
     Connection connection = ERSQuery.getEm().unwrap(java.sql.Connection.class);

     try {
     JasperParametri.put("IDRADNIK", IDRadnik);
     JasperParametri.put("DATUM_OD", datumOD);
     JasperParametri.put("DATUM_DO", datumDO);

     InputStream is = this.getClass()
     .getClassLoader()
     .getResourceAsStream(
     "izvestaji/jasperreports/radnik/za_period_detaljno/RadnikSatiZaPeriod.jasper");

     JasperPrint jasperPrint = JasperFillManager.fillReport(is, JasperParametri, connection);
     JasperViewer.setDefaultLookAndFeelDecorated(true);

     JasperViewer.viewReport(jasperPrint, false);
     ERSQuery.getEm().getTransaction().commit();
     } catch (NullPointerException e1) {
     System.out.println("Greška pri izboru datuma ili radnika.");

     ERSQuery.getEm().getTransaction().rollback();
     } catch (JRException ex) {
     System.out.println("Greška pri generisanju izveštaja !");

     ERSQuery.getEm().getTransaction().rollback();
     } catch (java.lang.IllegalStateException ise) {

     ERSQuery.getEm().getTransaction().rollback();
     } catch (Exception ee) {
     System.out.println("Greška u modulu izveštaja !");
     ERSQuery.getEm().getTransaction().rollback();
     } finally {
     try {
     connection.close();
     } catch (SQLException ex) {
     }
     }
     }
     */
    public static void main(String[] args) throws Exception {
        //<editor-fold defaultstate="collapsed" desc="razni testovi">
        // EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaApplicationPU");
        // EntityManager em = emf.createEntityManager();
        //<editor-fold defaultstate="collapsed" desc="razni testovi">
        //new javaapplication.JavaApplication().generisiIzvestaj(12, "2013-4-1", "2013-4-30");

        /*
         * System.out.println();
         * System.out.println();
         * System.out.println("Test: Aktivne firme - Lista");
         * System.out.println("________________________________________________________");
         *
         * String datum = "2013-4-24";
         * List<Firma> aktivneFirma = ERSQuery.AktivneFirme(true);
         * Firma f = aktivneFirma.iterator().next();
         *
         * for (Firma f2 : aktivneFirma) {
         * System.out.println("Firma:" + f2.toString());
         * }
         *
         * /*
         * System.out.println();
         * System.out.println();
         * System.out.println("Test: Org. jedinice, aktivne firme za datum :");
         * System.out.println("________________________________________________________");
         *
         * for (Orgjed o : ERSQuery.orgJedFirmeZaDatum(datum)) {
         * System.out.println("Orgjed :" + o.toString());
         * }
         */
        /*
         * System.out.println();
         * System.out.println();
         * System.out.println("Test: Radnici na dan.");
         * System.out.println("________________________________________________________");
         * System.out.println("Uk. broj radnika - " + ERSQuery.radniciZaDatum(datum).size());
         * System.out.println();
         *
         * for (Radnik r : ERSQuery.radniciZaDatum(datum)) {
         * System.out.println(r.toString());
         * }
         * System.out.println();
         * System.out.println();
         * System.out.println("Test: Radnici kompanije na dan.");
         * System.out.println("________________________________________________________");
         * System.out.println();
         *
         * Kompanija kk = new Kompanija(1);
         * for (Radnik rr1 : ERSQuery.radniciKompanijeZaDatum(kk, datum)) {
         * System.out.println(rr1.toString());
         * }
         * System.out.println();
         * System.out.println();
         * System.out.println("Test: Radnici firme na dan.");
         * System.out.println("________________________________________________________");
         * System.out.println();
         *
         * for (Radnik r : ERSQuery.radniciFirmeZaDatum(f, datum)) {
         * System.out.println(r.toString());
         * }
         * System.out.println();
         * System.out.println();
         * System.out.println("Test: Radnici orgjed na dan.");
         * System.out.println("________________________________________________________");
         * System.out.println();
         *
         * Orgjed o1 = new Orgjed();
         * o1.setIDOrgjed(36);
         * for (Radnik rr : ERSQuery.radniciOrgJedZaDatum(o1, datum)) {
         * System.out.println(rr.toString());
         * }
         *
         * System.out.println();
         *
         * System.out.println();
         * System.out.println();
         * System.out.println("Test: Veliki test Firma - Orgjed - Radnici na dan.");
         * System.out.println("________________________________________________________");
         * System.out.println();
         *
         * for (Firma firma : aktivneFirma) {
         * System.out.println(firma.toString());
         * System.out.println("________________________________________________________");
         * System.out.println();
         * for (Orgjed o : ERSQuery.orgJedFirmeZaDatum(firma, datum)) {
         * System.out.println("---->" + o.getNaziv());
         * for (Radnik r : ERSQuery.radniciOrgJedZaDatum(o, datum)) {
         * System.out.println("----+---->" + r.getIme() + " " + r.getPrezime());
         * }
         * }
         * }
         *
         *
         * /*
         * System.out.println();
         * System.out.println();
         * System.out.println("Test: Klasa DatumSelektor ");
         * System.out.println("________________________________________________________");
         * System.out.println();
         *
         * DatumSelektor ds = DatumSelektor.getDafault();
         *
         * ds.setDatumOD("2011-01-11");
         * ds.setDatumDO("2011-01-09");
         *
         * System.out.println(ds.getYMDDatumOD());
         * System.out.println(ds.getYMDDatumDO());
         */

        /*
         * TESTOVI PREKO WEB SERVISA :
         * Kompanija k = KompanijaWS.kompanijaPoID(1);
         * System.out.println(k.getNazivKompanije());
         * Firma firma = FirmaWS.firmaID(2);
         * List<Firma> firmeKomapanije = firmeKompanije(k);
         * System.out.println(firma.getNaziv());
         * System.out.println();
         * System.out.println();
         * System.out.println("Test: Aktivni radnici Orgjed");
         * System.out.println("________________________________________________________");
         * Kompanija k2 = KompanijaWS.kompanijaPoID(1);
         * for (Firma f2 : FirmaWS.firmeKompanije(k2)) {
         * System.out.println();
         * System.out.println("Firma:" + f2.getNaziv());
         * for (Orgjed o2 : OrgJedWS.orgJedFirme(f2)) {
         * System.out.println("|___Orgjed :" + o2.getNaziv() + ", ID=" + o2.getIDOrgjed());
         * System.out.println();
         * for (Radnik r2 : RadnikWS.aktivniRadniciOrgJedPoID(o2.getIDOrgjed(), true)) {
         * System.out.println("|______Radnik :" + r2.getIme() + ", " + r2.getPrezime());
         * }
         * }
         * }
         * System.out.println();
         * System.out.println();
         * System.out.println("Test: Svi Aktivni radnici");
         * System.out.println("________________________________________________________");
         * for (Radnik r1 : RadnikWS.aktivniRadniciOrgJedPoID(33, true)) {
         * System.out.println(r1.getIme() + " " + r1.getPrezime());
         * }
         *
         *
         */
        // testovi preko persistence library-ja :
        /*
         * Kompanija k = queries.ERSQuery.kompanijaPoID(1);
         * System.out.println(k.getNazivKompanije());
         * Firma firma = queries.ERSQuery.FirmaID(2);
         * List<Firma> firmeKomapanije = queries.ERSQuery.firmeKompanije(k);
         * System.out.println(firma.getNaziv());
         * System.out.println();
         * System.out.println();
         * System.out.println("Test: Aktivni radnici Orgjed");
         * System.out.println("________________________________________________________");
         * Kompanija k2 = queries.ERSQuery.kompanijaPoID(1);
         * for (Firma f2 : queries.ERSQuery.firmeKompanije(k2)) {
         * System.out.println();
         * System.out.println("Firma:" + f2.getNaziv());
         * for (Orgjed o2 : queries.ERSQuery.orgJedFirme(f2)) {
         * System.out.println("|___Orgjed :" + o2.getNaziv() + ", ID=" + o2.getIDOrgjed());
         * System.out.println();
         * for (Radnik r2 : queries.ERSQuery.aktivniRadniciOrgJedPoID(o2.getIDOrgjed(), true)) {
         * System.out.println("|______Radnik :" + r2.getIme() + ", " + r2.getPrezime());
         * }
         * }
         * }
         * System.out.println();
         * System.out.println();
         * System.out.println("Test: Svi Aktivni radnici");
         * System.out.println("________________________________________________________");
         * for (Radnik r1 : queries.ERSQuery.aktivniRadniciOrgJedPoID(33, true)) {
         * System.out.println(r1.getIme() + " " + r1.getPrezime());
         * }
         */
        /*
         * Orgjed o3 = queries.ERSQuery.ORGJED_ID(33);
         * Firma f3 = queries.ERSQuery.FirmaID(o3.getFKIDFirma().getIDFirma());
         * Kompanija k3 = queries.ERSQuery.kompanijaPoID(f3.getFkIdk().getIdk());
         * System.out.println(k3.getNazivKompanije());
         * System.out.println("|____" + f3.getNaziv());
         * System.out.println("|________" + o3.getNaziv());
         * for (Radnik r3 : queries.ERSQuery.aktivniRadniciOrgJed(o3, true)) {
         * System.out.println("            " + r3.getIme() + " " + r3.getPrezime());
         * }
         * /*
         * System.out.println("Sve evidencije radnika - ID-9");
         * System.out.println("Za opseg datuma od 1.1.2011 do 31.1.2011");
         * for (Raddan rd : queries.ERSQuery.evidencijeRadnikaZaOpsegDatuma(ERSQuery.radnikID(9), "2011-01-01", "2011-01-31")) {
         * System.out.println(rd.getDatum() + ", "
         * + rd.getFKIDRadnik().getIDRadnik() + ", "
         * + rd.getFKIDRadnik().getIme() + ", "
         * + rd.getFKIDRadnik().getPrezime() + ", "
         * + rd.getRbrstanja() + ", "
         * + rd.getNalog() + ", "
         * + rd.getPocStanja() + ", "
         * + rd.getKrajStanja() + ", "
         * + rd.getTrajanje());
         * }
         * System.out.println("Sve evidencije radnika - ID-9");
         * System.out.println("Za datum od 31.1.2011.");
         * for (Raddan rd : queries.ERSQuery.evidencijeRadnikaZaDatum(ERSQuery.radnikID(9), "2011-01-31")) {
         * System.out.println(rd.getDatum() + ", "
         * + rd.getFKIDRadnik().getIDRadnik() + ", "
         * + rd.getFKIDRadnik().getIme() + ", "
         * + rd.getFKIDRadnik().getPrezime() + ", "
         * + rd.getRbrstanja() + ", "
         * + rd.getNalog() + ", "
         * + rd.getPocStanja() + ", "
         * + rd.getKrajStanja() + ", "
         * + rd.getTrajanje());
         * }
         * System.out.println("Svi radnici");
         * System.out.println("Za datum od 31.1.2011.");
         * for (Radnik r1 : queries.ERSQuery.radniciZaDatum("2011-01-31")) {
         * System.out.println(
         * r1.getIme() + ", "
         * + r1.getPrezime() + ", "
         * + r1.getIDRadnik());
         * }
         */
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="učinci radnika">
        /*
         * Radnik radnik = ERSQuery.radnikID(9);
         * String datum1 = "2011-01-19 14:00:00";
         * //        String datum = new SimpleDateFormat("yyyy-MM-dd").format(new Date(datum1).toString());
         * System.out.println("datumi - ");
         * System.out.println("Za datum : " + new SimpleDateFormat("yyyy-MM-dd")
         * .format(new Date()));
         * System.out.println("Evidencija radnika 6 - " + radnik.toString());
         * System.out.println("Za datum : " + datum1);
         * for (Raddan rd : queries.ERSQuery.evidencijeRadnikaZaDatum6(radnik, datum1)) {
         * System.out.println(
         * rd.getDatum() + ", "
         * + rd.getRbrstanja() + ", "
         * + rd.getPocStanja() + ", "
         * + rd.getKrajStanja() + ", "
         * + rd.getStatus());
         * }
         * System.out.println("______________________________________________________");
         * System.out.println("______________________________________________________");
         * System.out.println("[SVI_RADNICI_SUMA_SATA_ZA_PERIOD]");
         * for (SVI_RADNICI_SUMA_SATA_ZA_PERIOD s : queries.ERSQuery.Izvestaj_SVI_RADNICI_SUMA_SATA_ZA_PERIOD("2011-01-01", "2011-01-31")) {
         * System.out.println(s);
         * }
         * System.out.println("______________________________________________________");
         * System.out.println("______________________________________________________");
         * System.out.println("[evidencijeRadnikaZaJedanDan]");
         * for (evidencijeRadnikaZaJedanDan er1 :
         * queries.ERSQuery.Izvestaj_evidencijeRadnikaZaJedanDan(9, "2011-01-19")) {
         * System.out.println(er1);
         * }
         * System.out.println("______________________________________________________");
         * System.out.println("______________________________________________________");
         * System.out.println("[SVI_RADNICI_UK_MESECNI_SATI_ZA_SVE_STATUSE]");
         * for (SVI_RADNICI_UK_MESECNI_SATI_ZA_SVE_STATUSE sr_uk : queries.ERSQuery.Izvestaj_SVI_RADNICI_UK_MESECNI_SATI_ZA_SVE_STATUSE("2011-01-01", "2011-01-31")) {
         * System.out.println(sr_uk);
         * }
         * System.out.println("______________________________________________________");
         * System.out.println("______________________________________________________");
         * System.out.println("[UCINAK_RADNIKA_ZA_PERIOD]");
         */
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="testovi 3">
        /*for (UCINAK_RADNIKA_ZA_PERIOD sr_uk : queries.ERSQuery.Izvestaj_UCINAK_RADNIKA_ZA_PERIOD(9, "2011-01-01", "2011-01-31")) {
         * System.out.println(sr_uk);
         * }
         * */
        /////////////////////
        /// izveštaji !!!! //
        /////////////////////
        /*
         * HashMap params = new HashMap();
         * params.put("IDRADNIK", 9);
         * params.put("DATUM_OD", "2011-01-01");
         * params.put("DATUM_DO", "2011-01-31");
         * Connection connection = null;
         * try {
         * connection = DriverManager
         * .getConnection("jdbc:jtds:sqlserver://sqlserver2.autokomerc.rs:1433/ERS", "sa", "sa55");
         * } catch (SQLException ex) {
         * }
         * /*
         * Connection connection = null;
         * connection = em.unwrap(java.sql.Connection.class);
         * JasperPrint jasperPrint = null;
         * try {
         * jasperPrint = JasperFillManager
         * .fillReport("src/izvestaji/radnik_sati_ukupno_za_period.jasper"
         * ,params
         * ,connection);
         * } catch (JRException ex) {
         * ex.printStackTrace();
         * }
         * JasperViewer.viewReport(jasperPrint);
         */
        /*System.out.println("______________________________________________________");
         * System.out.println("______________________________________________________");
         * System.out.println("[HashMap model !!!!]");
         *
         *
         * Map<Object, String> model = new HashMap<>();
         *
         * for (Statusi s : ERSQuery.listaStatusa()) {
         * model.put(s.getIDStatus(), s.getStatus());
         * }
         *
         * for (Object key : model.keySet()) {
         * System.out.println("key : " + (int) key + ", value = " + model.get(key));
         * }*/
        /*System.out.println("______________________________________________________");
         * System.out.println("______________________________________________________");
         * System.out.println("Upis podataka u bazu");
         *
         *
         * ERSQuery.evidentirajAktivnostRadnika(9,
         * new SimpleDateFormat("yyyy-MM-dd").format(new Date()),
         * 1,
         * "7000");*/
        /*
         * System.out.println("______________________________________________________");
         * System.out.println("______________________________________________________");
         * String tt1 = "2011-01-01 13:00:00";
         * String tt2 = "2011-01-01 13:10:00";
         * Date diff;
         * long ttt1 = 0, ttt2 = 0, difm = 0;
         * try {
         * ttt1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(tt1).getTime();
         * ttt2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(tt2).getTime();
         * diff = new Date(ttt2 - ttt1);
         * difm = diff.getTime() / (1000 * 60) % 60;
         * } catch (ParseException ex) {
         * }
         */
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="testovi 4">
        /*System.out.println("______________________________________________________");
         * System.out.println("SingleDatumSelektor test.");
         * System.out.println();
         *
         * SingleDatumSelektor sds = SingleDatumSelektor.getDafault();
         *
         * try {
         * sds.setDatum("2015-1-15");
         * System.out.println("sds.getYMDDatum() : " + sds.getYMDDatum());
         * System.out.println("sds.getDatum() : " + sds.getDatum());
         *
         * System.out.print("Dan, mesec, godina : ");
         * System.out.println(sds.getDan() + ", " + sds.getMesec() + ", " + sds.getGodina());
         *
         * } catch (NullPointerException | PomesaniDatumiException ex) {
         * System.err.println("greška !");
         * }
         *
         * System.out.println("______________________________________________________");
         * System.out.println("Običan test.");
         * System.out.println();
         *
         * String tt1 = "2011-01-01 13:00:00";
         * String tt2 = "2011-01-01 13:10:00";
         *
         * Date diff;
         * long ttt1 = 0, ttt2 = 0;
         * try {
         * ttt1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(tt1).getTime();
         * ttt2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(tt2).getTime();
         * diff = new Date(ttt2 - ttt1);
         *
         * System.out.println(diff);
         *
         * } catch (ParseException ex) {
         * }*/
        //</editor-fold>

        /*
         * System.out.println("______________________________________________________");
         * System.out.println("Izvestaj_evidencijeRadnikaZaJedanDan test");
         * System.out.println();
         *
         * List<evidencijeRadnikaZaJedanDan> er = ERSQuery.Izvestaj_evidencijeRadnikaZaJedanDan(9L, "2013-8-1");
         * for (evidencijeRadnikaZaJedanDan ee : er) {
         * System.out.println(ee.toString());
         * }
         *
         *
         * System.out.println("______________________________________________________");
         * System.out.println("Test1 - Aktivne firme, orgjed i radnici.");
         * System.out.println();
         *
         * for (Firma af : ERSQuery.AktivneFirme(true)) {
         * System.out.println(af.toString());
         *
         * for (Orgjed oj : ERSQuery.orgJedFirme(af)) {
         * System.out.println("    " + oj.toString());
         *
         * for (Radnik rr : ERSQuery.radniciOrgJedZaDatum(oj, "2011-7-11")) {
         * System.err.println("        " + rr.toString());
         * }
         * }
         * }
         *
         * System.out.println("______________________________________________________");
         * System.out.println("Test2 - Firm1, orgjed i radnik.");
         * System.out.println();
         *
         * Firma af1 = ERSQuery.AktivneFirme(true).iterator().next();
         * Orgjed oj = ERSQuery.ORGJED_ID(33);
         *
         * System.out.println(af1.toString());
         * System.out.println("  " + (new Orgjed(33).toString()));
         * for (Radnik r1 : ERSQuery.radniciOrgJedZaDatum(oj, "2011-7-11")) {
         * System.out.println(r1.toString());
         * }
         *
         * System.out.println("______________________________________________________");
         * System.out.println("Test3 - Test funkcije sa SQL Servera - f_RADNIK_UK_SATI_U_MESECU");
         * System.out.println();
         *
         * String datumOd = "2013-7-1";
         * String datumDo = "2013-7-31";
         *
         * for (Servis_Ukupan_Broj_Faktura_Za_Period iUkBrFakt : ERSQuery.Izvestaj_Servis_Ukupan_Broj_Faktura_Za_Period(datumOd, datumDo)) {
         * System.err.println(iUkBrFakt.toString());
         * }
         *
         * System.out.println("______________________________________________________");
         * System.out.println("Test4 - Test funkcije sa SQL Servera - [FULL_KD_Servis_Fakturisani_Nalozi_Po_PC]");
         * System.out.println();
         *
         * datumOd = "2013-7-1";
         * datumDo = "2013-7-31";
         *
         * for (Servis_Fakturisani_Nalozi_Po_PC fn
         * : ERSQuery.Izvestaj_Servis_Fakturisani_Nalozi_Po_PC(datumOd, datumDo)) {
         * System.err.println(datumOd + "-" + datumDo + ": " + fn.toString());
         * }
         *
         * /*
         * System.out.println("______________________________________________________");
         * System.out.println("Test5 - Test funkcije sa SQL Servera - [FULL_KD_Servis_Fakturisani_Nalozi_Po_PC_Detaljno]");
         * System.out.println();
         *
         * datumOd = "2013-7-1";
         * datumDo = "2013-7-31";
         *
         * for (Servis_Fakturisani_Nalozi_Po_PC_Detaljno fn
         * : ERSQuery.Izvestaj_Servis_Fakturisani_Nalozi_Po_PC_Detaljno(datumOd, datumDo)) {
         * System.err.println(fn.toString());
         * }
         */

        /*
         * System.out.println("______________________________________________________");
         * System.out.println("Test6 - poređenje poslovanja");
         * System.out.println();
         *
         * String datumOd1 = "2008-1-1";
         * String datumDo1 = "2008-12-31";
         * String datumOd2 = "2013-1-1";
         * String datumDo2 = "2013-7-31";
         *
         * for (Servis_Poslovanje_Mesecno spm
         * : ERSQuery.Izvestaj_Servis_Uporedjenje_Poslovanja(datumOd1, datumDo1)) {
         * System.err.println(spm.toString());
         * }
         * for (Servis_Poslovanje_Mesecno spm2
         * : ERSQuery.Izvestaj_Servis_Uporedjenje_Poslovanja(datumOd2, datumDo2)) {
         * System.err.println(spm2.toString());
         * }
         *
         * System.err.println((new SimpleDateFormat("yyyy-MM-dd")).format(new Date()));
       
         System.out.println("______________________________________________________");
         System.out.println("Test7 - radnal, sasija, šifra kupca");
         System.out.println();
       
         Nald001 nalog = INFSistemQuery.radniNalogDetalji("114587");
         System.out.println(nalog.toString());
       
         for (Nald001 n1 : INFSistemQuery.radniNaloziZaSasiju("WVGZZZ5NZBW518502 ")) {
         System.out.println(n1.toString());
         }
       
         for (Nald001 n1 : INFSistemQuery.radniNaloziZaRegistraciju("BG 963-229")) {
         System.out.println(n1.toString());
         }
         */
        //</editor-fold>
        /*
        
        

         System.out.println("______________________________________________________");
         System.out.println("Test10 - Datumi");
         System.out.println();

         DatumSelektor ds = DatumSelektor.getDafaultForMonthAndYear(2012, 2);

         try {
         System.out.println("od: " + ds.getDanOD() + ", do: " + ds.getDanDO()
         + ", mesec: " + ds.getMesecOD() + ", godina :" + ds.getGodinaOD());

         System.out.println(ds.getYMDDatumOD() + "  -  " + ds.getYMDDatumDO());

         } catch (NullPointerException | NoResultException e) {
         }
         System.out.println("______________________________________________________");
         System.out.println("Test11 - Datumi");
         System.out.println();

         SingleDatumSelektor sds = SingleDatumSelektor.getDafaultForMonthAndYear(1975, 9);

         try {
         System.out.println("od: " + sds.getDanOD() + ", do: " + sds.getDanDO()
         + ", mesec: " + sds.getMesecOD() + ", godina :" + sds.getGodinaOD());

         System.out.println(sds.getYMDDatumOD() + "  -  " + sds.getYMDDatumDO());

         } catch (NullPointerException | NoResultException e) {
         }
         */

        /*
         System.out.println("______________________________________________________");
         System.out.println("Test8 - delimične šasije");
         System.out.println();
         System.out.println("ukupno nađenih :"
         + INFSistemQuery.radniNaloziDelimicnaSasija("WFONXXGB%").size());


         for (Nald001 n1 : INFSistemQuery.radniNaloziDelimicnaRegistracija("WFONXXGBBNGG42026")) {
         System.out.println(n1.toString());
         }

         System.out.println("______________________________________________________");
         System.out.println("Test9 - PIB i Matični broj");
         System.out.println();
         System.out.println("ukupno nađenih :"
         + INFSistemQuery.KupciPoNazivu("prte").size());


         for (Sifarnik s1 : INFSistemQuery.KupciPoNazivu("prte")) {
         System.out.println(s1.toString());
         }


         System.out.println("______________________________________________________");
         System.out.println("Test10 - Kupci po MAT. Br.");
         System.out.println();

         try {
         System.out.println(INFSistemQuery.KupacPoMatBr("e4sdf3").toString());
         } catch (NullPointerException | NoResultException e) {
         }
        

         System.out.println("______________________________________________________");
         System.out.println("Test11 - Vozila Klijenta i servisi njihovih vozila");
         System.out.println();
         System.out.println(INFSistemQuery.VozilaKlijenta("014071").size());

         for (String sasija : INFSistemQuery.VozilaKlijenta("014071")) {
         System.out.println(sasija.toString());

         for (Nald001 n1 : INFSistemQuery.radniNaloziZaSasiju(sasija)) {
         System.err.println("     >" + n1.getBrFakt() + ", " + n1.getDatum());
         }
         }
        
         System.out.println("______________________________________________________");
         System.out.println("Test11 - Vozila Klijenta i servisi njihovih vozila");
         System.out.println();
         System.out.println(INFSistemQuery.VozilaKlijenta("014071").size());

         for (String sasija : INFSistemQuery.VozilaKlijenta("014071")) {
         System.out.println(sasija.toString());

         for (Nald001 n1 : INFSistemQuery.radniNaloziZaSasiju(sasija)) {
         System.err.println("     >" + n1.getBrFakt() + ", "
         + n1.getDatum() + ", "
         + n1.getMarka() + ", "
         + n1.getTip());
         }
         }

         int duzinaSifreINFSISTEM = 6;
         String novaSifra = "000000000000000000000000000000000";

         novaSifra += Integer.toString(18566);
         novaSifra = novaSifra.substring(novaSifra.length() - duzinaSifreINFSISTEM);
       
         System.err.println(novaSifra);
       
        

         System.out.println("____________________________________________________________");
         System.out.println("Test12 - Vozila Klijenta po datumu i servisi njihovih vozila");
         System.out.println();
         System.out.println(INFSistemQuery.VozilaKlijentaPoDatumu("014071", "2009-1-1", "2010-12-31").size());

         for (Nald001 n1 : INFSistemQuery.VozilaKlijentaPoDatumu("014071", "2009-1-1", "2010-12-31")) {
         System.out.println(n1.toString());
         }
       
        

         System.out.println("____________________________________________________________");
         System.out.println("Test13 - RN i FAKTURA");
         System.out.println();
         System.out.println(INFSistemQuery.pretraga_RN_Faktura("115610", true).size());

         for (Nald001 n1 : INFSistemQuery.pretraga_RN_Faktura("115610", true)) {
         System.out.println(n1.toString());
         }
       
         System.out.println("____________________________________________________________");
         System.out.println("Test14 - Storno Faktura");
         System.out.println();
         System.out.println(INFSistemQuery.pretraga_Storno_Faktura("114916").size());

         for (Nald001 n1 : INFSistemQuery.pretraga_Storno_Faktura("114916")) {
         System.out.println(n1.toString());
         }
       
        

         System.out.println("____________________________________________________________");
         System.out.println("Test15 - Storno Fakture");
         System.out.println();
         System.out.println(INFSistemQuery.storno_Fakture_ZaPeriod("2013-4-1", "2013-4-30").size());

         for (Nald001 n1 : INFSistemQuery.storno_Fakture_ZaPeriod("2013-4-1", "2013-4-30")) {
         System.out.println(n1.toString());
         }
        
        

         System.out.println("____________________________________________________________");
         System.out.println("Test15 - Fakture u periodu");
         System.out.println();
         System.out.println(INFSistemQuery.fakture_ZaPeriod("2013-9-1", "2013-9-3").size());

         for (Nald001 n1 : INFSistemQuery.fakture_ZaPeriod("2013-9-1", "2013-9-3")) {
         System.out.println("R/F-" + n1.getRadnal() + "/" + n1.getBrFakt()
         + ", Ukupno " + n1.getUkupno()
         + ", Datumi O/Z/F: " + n1.getDatum() + ", "
         + n1.getZatvoren() + ", "
         + n1.getFakturisan());
         }
       
         System.out.println("____________________________________________________________");
         System.out.println("Test16 - Storno fakture u periodu");
         System.out.println();
         System.out.println(INFSistemQuery.storno_Fakture_ZaPeriod("2013-9-1", "2013-9-30").size());

         for (Nald001 n1 : INFSistemQuery.storno_Fakture_ZaPeriod("2013-9-1", "2013-9-30")) {
         System.out.println("Storno - R/F-" + n1.getRadnal() + "/" + n1.getBrFakt()
         + ", Ukupno " + n1.getUkupno()
         + ", Datumi O/Z/F: " + n1.getDatum() + ", "
         + n1.getZatvoren() + ", "
         + n1.getFakturisan());
         }
       
       
       
         System.out.println("____________________________________________________________");
         System.out.println("Test17 - Fakture za datum ");
         System.out.println();
         System.out.println(INFSistemQuery.faktureZaDatum("2013-9-3").size());
       
         System.out.println("____________________________________________________________");
         System.out.println("Test17 - Radni nalozi za datum ");
         System.out.println();
         System.out.println(INFSistemQuery.radniNaloziZaDatum("2013-9-3").size());

        

         System.out.println("____________________________________________________________");
         System.out.println("Test18 - storno u periodu ");
         System.out.println();

         float ukupno = 0;

         for (Nald001 n1 : INFSistemQuery.storno_Fakture_ZaPeriod("2013-9-1", "2013-9-20")) {
         System.out.println("ST/FA-" + n1.getRadnal() + "/" + n1.getBrFakt()
         + ", Ukupno " + n1.getUkupno()
         + ", Datumi O/Z/F: " + n1.getDatum() + ", "
         + n1.getZatvoren() + ", "
         + n1.getFakturisan());
         ukupno += n1.getUkupno();
         }
         System.out.println("____________________________________________________________");
         System.out.println("Ukupno :"+(-1*ukupno));
       
         System.out.println("____________________________________________________________");
         System.out.println("Test19 - Stringovi");
         System.out.println();
       
         System.err.println("WAUZZZ44ZLN067843".substring(0, 3));
        
        

         System.out.println("____________________________________________________________");
         System.out.println("Test21 - storno");
         System.out.println();

         for (Nald001 n3 : INFSistemQuery.pretragaPoFakturi("115422")) {
         if (n3.getUkupno() < 0) {
         System.err.println(n3.getRadnal() + "/" + n3.getBrFakt());
         } else {
         System.out.println(n3.getRadnal() + "/" + n3.getBrFakt());
         }
         }
       
        

         System.out.println("____________________________________________________________");
         System.out.println("Test22 - generator ikonica za šasije");
         System.out.println();

         INodeIconRenderer inir = new INodeIconRenderer() {
         @Override
         public void node_setIconBaseWithExtension(String URL) {
         System.err.println(URL);
         }
         };

         ChasisIconRenderer cir = ChasisIconRenderer.getDefault();
         cir.generateIcons("VSS", inir);
        
         System.out.println("____________________________________________________________");
         System.out.println("Test23 - Radnik Servisa");
         System.out.println();
       
         System.out.println(INFSistemQuery.Radnik("0173"));
       
        

         System.out.println("____________________________________________________________");
         System.out.println("Test24 - Sve Šifre Kupaca");
         System.out.println();

         for (Sifarnik s : INFSistemQuery.SveSifre()) {
         System.out.println(s.toString());
         }
        
         */

        /*
         System.err.println();


         System.out.println("______________________________________________________");
         System.out.println("");
         System.out.println();


         // vreme i datum kao stringovi
         String tt1 = "2011-07-11 13:02:20";
         String tt2 = "2011-07-11 13:10:00";

         String danasnjiDatum = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
         String vreme = new SimpleDateFormat("hh:mm:ss").format(new Date());
         String datumVreme = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());

         Date diff;

         long ttt1 = 0, ttt2 = 0;
         try {
         // long sadasnjeVreme = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(new Date().getTime());

         ttt1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(tt1).getTime();
         ttt2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(tt2).getTime();
         Date tt1_datum = new SimpleDateFormat("yyyy-MM-dd").parse(tt1);
         // Date tt1_vreme = new SimpleDateFormat("hh:mm:ss").parse(tt1);

         diff = new Date(ttt2 - ttt1);

         System.out.println("Današnji Datum :" + danasnjiDatum);
         System.out.println("Današnje datum i vreme :" + datumVreme);
         System.out.println("Današnje Vreme :" + vreme);
         System.out.println("UKUPNA RAZLIKA U MINUTIMA :" + diff.getTime() / 1000 / 60);
         System.out.println("_____________________________");

         // vreme i datum kao Date !!!
         System.out.println("tt1 date :" + new SimpleDateFormat("dd.MM.yyyy").format(tt1_datum));
         //System.out.println("tt1 vreme :" + tt1_vreme);

         } catch (ParseException ex) {
         }

         System.err.println(queries.ERSQuery.poslednjaEvidencijaRadnikaZaDatum(r, "2013-10-12").getRbrstanja());
        
         // ERSQuery.evidencijeRadnikaZaDatum(r, "2013-10-9 22:32");
         // ERSQuery.evidentirajAktivnostRadnika(r, "2013-10-12 08:08", 1, "xxx-12-20000-568");
       
         System.err.println(r.getFKIDOrgjed().getFKIDFirma().toString());
         System.err.println(r.toString());

       
         for (Raddan r1 : queries.ERSQuery.evidencijaSvihRadnikaFirmeZaDatum(f, "2013-10-12")) {
         System.out.println(
         r1.getImeRadnika() + ", " + r1.getPCentar() + ", "
         + r1.getPocStanja() + ", " + r1.getKrajStanja() + ", t:" + r1.getTrajanje());
         }
        
         Vremena vremena = Vremena.getDafault();
         vremena.setVremeOD("10:00:00");
         vremena.setVremeDO("10:01:30");
         System.err.println("m: " + vremena.getTrajanjeMinuti() + ", s:" + vremena.getTrajanjeSekunde());
        
         DatumVremeSelektor dvs = DatumVremeSelektor.getDafault();

         dvs.setDatumOD("2010-9-7");
         dvs.setVremeOD("16:20:00");
         dvs.setDatumDO("2010-9-17");
         dvs.setVremeDO("16:25:00");

         System.out.println(dvs.getDanOD() + "..." + dvs.getMesecOD() + "..." + dvs.getGodinaOD());
         System.out.println(dvs.getDanDO() + "..." + dvs.getMesecDO() + "..." + dvs.getGodinaDO());
         System.out.println(dvs.getVremeODString() + "---" + dvs.getVremeDOString());
         System.out.println(dvs.getTrajanjeSekunde() + ", " + dvs.getTrajanjeMinuti() + ", " + dvs.getTrajanjeSati());
        
         */

        /*
         System.out.println("____________________________________________________________");
         System.out.println("Test25 - Upis raddan-a");
         System.out.println();

         Firma f = queries.ERSQuery.FirmaID(2);
         Radnik r = queries.ERSQuery.radnikID(9);
         Statusi s = queries.ERSQuery.statusPoID(1);

         try {
         ERSQuery.evidentirajAktivnostRadnika2(r, "2013-10-12 9:40:00", s, "xxx888");
         } catch (DatumException e) {
         System.err.println("problemi sa datumima !");
         }

         for (Raddan r1 : queries.ERSQuery.evidencijeRadnikaZaDatum(r, "2013-10-12")) {
         System.out.println(
         r1.getImeRadnika() + ", " + r1.getPCentar() + ", "
         + r1.getPocStanja() + ", " + r1.getKrajStanja() + ", t:" + r1.getTrajanje());
         }

         String sadasnjeDatumVreme = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
       
         Date sadasnjeDatumVreme_Date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2013-10-12 19:40:00");
         String sadasnjeVreme_Str = new SimpleDateFormat("hh:mm:ss").format(new Date(sadasnjeDatumVreme_Date.getTime()));
       
         long sadasnjeVreme = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(sadasnjeDatumVreme).getTime();
         String sadasnjiDatumString = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
         String sadasnjeVremeString = new SimpleDateFormat("hh:mm:ss").format(new Date(sadasnjeVreme));
       
         System.err.println("sadasnjeDatumVreme :" + sadasnjeDatumVreme);
         System.err.println("sadasnjeVreme: " + sadasnjeVremeString);
         System.err.println("sadasnjiDatumString: " + sadasnjiDatumString);
         System.err.println("sadasnjeVreme_Str: " + sadasnjeVreme_Str);
         
        

         DatumVremeSelektor dvs = DatumVremeSelektor.getDafault();

         dvs.setDatumVremeOD("2013-10-13 13:40:00");
         dvs.setDatumVremeDO("2013-10-13 19:45:00");

         System.out.println("getVremeODString : " + dvs.getVremeODString());
         System.out.println("getVremeDOString : " + dvs.getVremeDOString());
         System.out.println("getVremeOD : " + dvs.getVremeOD());
         System.out.println("getVremeDO : " + dvs.getVremeDO());
         System.out.println("getTrajanjeSati : " + dvs.getTrajanjeSati());
         System.out.println("getTrajanjeMinuti : " + dvs.getTrajanjeMinuti());
         System.out.println("getTrajanjeSekunde : " + dvs.getTrajanjeSekunde());
         System.out.println("getDatumODString : " + dvs.getDatumODString());
         System.out.println("getDatumDOString : " + dvs.getDatumDOString());
         System.out.println("getDatumOD : " + dvs.getDatumOD());
         System.out.println("getDatumDO : " + dvs.getDatumDO());
         System.out.println("getDatumVremeODString : " + dvs.getDatumVremeODString());
         System.out.println("getDatumVremeDOString : " + dvs.getDatumVremeDOString());

         Vremena v = Vremena.getDafault();
         v.setVremeOD("18:00:00");
         v.setVremeDO("18:11:00");
         System.out.println("getTrajanjeMinuti : " + v.getTrajanjeMinuti());
       
         // NE RADI !!!!
         // SingleDatumVremeSelektor sdvs = SingleDatumVremeSelektor.getDafault();
         // sdvs.setDatumVreme("2010-09-07 16:20:00");
         // System.out.println("SingleDatumVremeSelektor Datumi: " + sdvs.getDatumString());

        
        
        
         System.out.println("____________________________________________________________");
         System.out.println("Test25 - Upis raddan-a");
         System.out.println();

         Firma f = queries.ERSQuery.FirmaID(2);
         Radnik r = queries.ERSQuery.radnikID(9);
         Statusi s = queries.ERSQuery.statusPoID(1);

         Date d1 = new Date();
         Date d2 = new Date(d1.getTime() + 1000 * 60 * 7);
        
         java.sql.Date d3=new java.sql.Date(d2.getTime());

         System.err.println(d3);
        
         ERSQuery.evidentirajAktivnostRadnika3(r, d2, s, "TEST-3000-77-12");

         for (Raddan r1 : queries.ERSQuery.evidencijaSvihRadnikaFirmeZaDatum(f, "2013-10-15")) {
         System.out.println(
         r1.getImeRadnika() + ", " + r1.getPoslovnica() + ", "
         + r1.getPocStanja() + ", " + r1.getKrajStanja() + ", t:" + r1.getTrajanje());
         }
        
         
         /*
         Connection c;
         int timeout = 0;

         EntityManagerFactory emf;
         EntityManager em;

         try {

         emf = Persistence.createEntityManagerFactory("JavaLibraryEntitiesPU");
         em = emf.createEntityManager();

         c = em.unwrap(java.sql.Connection.class);
         timeout = c.getNetworkTimeout();

         } catch (Exception e) {
         System.err.println("ne postoji konekcija sa sql serverom: vreme: " + timeout);
         }
        
         
         System.out.println("____________________________________________________________");
         System.out.println("Test - Svi nalozi po šifri kupca - šasija se ne ponavlja");
         System.out.println();
         System.out.println("Ukupno: " + queries.infsistem.INFSistemQuery.VozilaKlijenta2("019084").size());

         for (Nald001 r1 : queries.infsistem.INFSistemQuery.VozilaKlijenta2("019084")) {
         System.out.println(r1.getSasija());
         }
        

         System.out.println("____________________________________________________________");
         System.out.println("Test - FaktSati iz ERS FaktSati tabele !!!");
         System.out.println();

         Radnik r = queries.ERSQuery.radnikID(17);
         System.err.println(r.toString());
        
         for (FaktSati f1 : queries.ERSQuery.evidencijeFaktSataRadnikaZaDatum(r, "2013-1-9")) {
         System.out.println(f1.toString());
         }


         System.out.println("____________________________________________________________");
         System.out.println("Test - Tipovi Radnika iz ERS");
         System.out.println();

         for (TipRadnika f1 : queries.ERSQuery.sviTipoviRadnika()) {
         System.out.println(f1.toString());
         }
        
         
         for (Sifarnik s1 : queries.infsistem.INFSistemQuery.KupciPoNazivu("ald")) {
         System.out.println(s1.toString());
         }

         System.out.println("____________________________________________________________");
         System.out.println("Test - 2222");
         System.out.println();

         System.err.println("X=" + X);
         test.Izmeni(2);
         System.err.println("X=" + X);
        
         
         System.out.println("____________________________________________________________");
         System.out.println("Test - Cenovnik RD");
         System.out.println();

         for (Cenovnik c1 : queries.CRDQuery.listaSvihCenovnika()) {
         System.out.println(c1.toString());
         }
        
         for (KatBroj c1 : queries.CRDQuery.ceneKatBrojeva("1k1819653b")) {
         System.out.println(c1.toString());
         }
        
         for (evidencijeRadnikaZaJedanDan c1 : queries.ERSQuery.Izvestaj_evidencijeRadnikaZaJedanDan(12, "2013-12-30")) {
         System.out.println(c1.toString());
         }
        
         
         EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JavaLibraryCENOVNIK_RD_PU");
         EntityManager entityManager = entityManagerFactory.createEntityManager();
         KatBroj kb;
         List<KatBroj> lista = new ArrayList<>();

         try {
         EntityTransaction entityTransaction = entityManager.getTransaction();
         entityTransaction.begin();

         Connection connection = entityManager.unwrap(java.sql.Connection.class);

         //primer sa stored procedurom sa sql servera, direktnim unosom parametra
         //pri čemu se vraća jedinstven rezultat
         CallableStatement callableStatement = null;
         ResultSet resultSet = null;

         callableStatement = connection.prepareCall("{call [dbo].[ceneKatBrojeva] (?1,?2)}");

         //primer sa stored procedurom sa sql servera, direktnim unosom parametra
         //pri čemu se vraća VIŠE OD JEDNOG REZULTATA !!!
         callableStatement.setString(1, "1K1819653");
         callableStatement.setString(2, null);
         resultSet = callableStatement.executeQuery();

         //stored procedura vraća tabelu sa 4 parametra !!!
         while (resultSet.next()) {
         kb = new KatBroj();

         kb.setKatBroj(resultSet.getString(1));
         kb.setNaziv(resultSet.getString(2));
         kb.setCena(resultSet.getFloat(3));
         kb.setDatum(resultSet.getString(4));

         lista.add(kb);

         kb = null;

         }

         entityTransaction.commit();
         } catch (SQLException e1) {
         System.out.println(e1.getMessage());
         } finally {
         entityManager.close();
         }
         */
        /*for (int i = 0; i < 10; i++) {
         for (KatBroj c1 : queries.CRDQuery.ceneKatBrojeva("1k1819653")) {
         System.err.println(c1.toString());
         }
         }*/
        /*System.out.println("____________________________________________________________");
         System.out.println("Test - Upis u ERS preko sp !");
         System.out.println();
        
         Radnik r = ERSQuery.radnikID(9);
         Statusi s = ERSQuery.statusPoID(3);
        
         datum1 = new Date();
         datum1Str = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        
         try {
         for (int i = 0; i < 1; i++) {
         ERSQuery.evidentirajAktivnostRadnika4(r, s, "test-1");
         for (Raddan rd1 : ERS.queries.ERSQuery.evidencijeRadnikaZaDatum(r, datum1Str)) {
         System.err.println(rd1.toString());
         }
         }
         } catch (Exception exception) {
         System.err.println(exception.getMessage());
         }
         */
        /*
         System.out.println("____________________________________________________________");
         System.out.println("Test - SP FullKD!");
         System.out.println();
        
         String delimicanOpis = "KVE003";
        
         try {
         // for (Nald001 n : INFSYS.queries.INFSistemQuery.RNPoDelimicnomOpisu(delimicanOpis)) {
         for (Nald001 n : INFSYS.queries.INFSistemQuery.RNPoDelimicnomOpisu2(delimicanOpis)) {
         System.err.println(n.toString());
         }
         } catch (Exception exception) {
         System.err.println(exception.getMessage());
         }
         */
        /*
         System.out.println("____________________________________________________________");
         System.out.println("Test - RD");
         System.out.println();
        
         String delimicanOpis = "1k1819653";
        
         System.out.println("Cene KatBroja.");
         /*try {
         for (Cene cena : ceneKatBroja(delimicanOpis)) {
         System.err.println(cena.toString());
         }
         } catch (Exception exception) {
         System.err.println("GREŠKA !!! " + exception.getMessage());
         }
        
         try {
         for (Cene c : CRDQuery.ceneKatBrojeva4(delimicanOpis)) {
         System.err.println(c.toString());
         }
         } catch (Exception exception) {
         System.err.println("GREŠKA !!! " + exception.getMessage());
         }
         */
        /*System.out.println("____________________________________________________________");
         System.out.println("Test - Upis u ERS preko sp !");
         System.out.println();
        
         Radnik r = ERSQuery.radnikID(9);
         Statusi s = ERSQuery.statusPoID(5);
        
         datum1 = new Date();
         datum1Str = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        
         try {
         for (int i = 0; i < 1; i++) {
         ERSQuery.evidentirajAktivnostRadnika4(r, s, "test-3");
         for (Raddan rd1 : ERS.queries.ERSQuery.evidencijeRadnikaZaDatum(r, datum1Str)) {
         System.err.println(rd1.toString());
         }
         }
         } catch (Exception exception) {
         System.err.println(exception.getMessage());
         }*/
        /*
         System.out.println("____________________________________________________________");
         System.out.println("Test !");
         System.out.println();

         for (Integer s1 : INFSYS.queries.INFSistemQuery.daniZa_brRN_U_Periodu("2014-1-1", "2014-1-31")) {
         System.err.println(s1.toString());
         }

         for (Long n1 : INFSYS.queries.INFSistemQuery.brRN_U_Periodu("2014-1-1", "2014-1-31")) {
         System.err.println(n1.toString());
         }

         System.out.println("____________________________________________________________");
        
         List<Integer> ll = INFSYS.queries.INFSistemQuery.daniZa_brRN_U_Periodu("2014-1-1", "2014-1-31");
         System.err.println("VELIČINA :"+ll.size());
        
         for (int i = 0; i < ll.size(); i++) {
         System.err.println(ll.get(i));
         }
        
         System.out.println("____________________________________________________________");
         List<Long> ll2 = INFSYS.queries.INFSistemQuery.brRN_U_Periodu("2014-1-1", "2014-1-31");
         System.err.println("VELIČINA :"+ll2.size());
        
         for (int i = 0; i < ll2.size(); i++) {
         System.err.println(ll2.get(i));
         }
         */
        NumberFormat nff = new DecimalFormat();
        String b1 = "10.2";
        String b2 = "15.3";

        Number bb1 = nff.parse(b1);
        Number bb2 = nff.parse(b2);

        System.err.println("Broj: " + (bb1.floatValue() + bb2.floatValue()));

        for (String polja : new FakturisaneUslugeBean().getColumnNames()) {
            System.out.println(polja);
        }

        System.out.println("____________________________________________________________");
        System.out.println("Test OpenCSV");
        System.out.println();

        /*
         CsvToBean csv = new CsvToBean();
         CSVReader reader = new CSVReader(new FileReader("src/javaapplication/FakturisaneUsluge2.csv"), ';', '\'', 1);

         ColumnPositionMappingStrategy strat = new ColumnPositionMappingStrategy();
         strat.setType(FakturisaneUslugeBean.class);

         // Nazivi kolona su iz definisanog bean-a !!! (a ne iz csv-a)
         strat.setColumnMapping(FakturisaneUslugeBean.getColumnNames());
         List<FakturisaneUslugeBean> list = csv.parse(strat, reader);
         */
        NumberFormat nf = new DecimalFormat("#,#");

        float s = 0;
        int nije = 0;

        CSVUtils csvu;
        FakturisaneUslugeBean fub;

        try {
            csvu = CSVUtils.getDafault("src/javaapplication/FakturisaneUsluge2.csv");
            csvu.setUpBean(new FakturisaneUslugeBean());

            for (IColumnMapping fUsluga : csvu.getList()) {
                FakturisaneUslugeBean fa = new FakturisaneUslugeBean();
                fa = (FakturisaneUslugeBean) fUsluga;

                try {
                    System.out.println(fa.toString() + ", " + (s += nf.parse(fa.getSati()).floatValue()));
                } catch (ClassCastException e1) {
                    nije++;
                } finally {
                    fa = null;
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("Ne postoji fajl !");
        }

        System.out.println("__________________________");
        System.out.println(s);
        System.out.println("Greške");

        /*
         System.out.println("__________________________");
         System.out.println(s);
         System.out.println("__________________________");
         System.out.println("Uvezao je : " + (list.size() - nije));
         System.err.println("__________________________");
         System.err.println("Nije uvezao: " + nije);
         System.out.println("__________________________");
         System.out.println("Ukupno :" + list.size());
         */
    }
}

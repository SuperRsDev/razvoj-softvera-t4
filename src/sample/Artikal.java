package sample;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Artikal {
    private String šifra; // Nije sigurno bolje koristiti char[]
    private String naziv;
    private double cijena;

    public void setŠifra(String šifra) {
        validirajSifru(šifra);
        this.šifra = šifra;
    }

    public void setNaziv(String naziv) {
        validirajNaziv(naziv);
        this.naziv = naziv;
    }

    public void setCijena(double cijena) {
        validirajCijenu(cijena);
        this.cijena = cijena;
    }

    public Artikal(String šifra, String naziv, double cijena) throws IllegalArgumentException {
        validirajElemente(šifra, naziv, cijena);
        this.šifra = šifra;
        this.naziv = naziv;
        this.cijena = cijena;
    }

    public Artikal(String sifraNazivCijena) throws IllegalArgumentException {
        String[] podjeljeniSifraNazivCijena = sifraNazivCijena.split(",");
        if(podjeljeniSifraNazivCijena.length > 2) {
            this.šifra = podjeljeniSifraNazivCijena[0];
            this.naziv = podjeljeniSifraNazivCijena[1];
            this.cijena = Double.parseDouble(podjeljeniSifraNazivCijena[2]);
        }   else {
            throw new IllegalArgumentException("Nedovoljan broj parametara");
        }
    }

    public String getŠifra() {
        return šifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public double getCijena() {
        return cijena;
    }

    private void validirajElemente(String šifra, String naziv, double cijena)
            throws IllegalArgumentException {
        validirajSifru(šifra);
        validirajNaziv(naziv);
        validirajCijenu(cijena);
    }

    private void validirajSifru(String šifra) {
        if("".equals(šifra)) {
            throw new IllegalArgumentException("Sifra ne moze biti prazna");
        }
    }

    private void validirajNaziv(String naziv) {
        if("".equals(naziv)) {
            throw new IllegalArgumentException("Naziv ne moze biti prazan");
        }
    }

    private void validirajCijenu(double cijena) {
        if(cijena <= 0) {
            throw new IllegalArgumentException("Cijena ne moze biti 0 ili negativna");
        }
    }

    public static ArrayList<Artikal> izbaciDuplikate(ArrayList<Artikal> artikli) {
        for(int i = 0;i < artikli.size();i++) {
            for(int j = i; j < artikli.size();j++) {
                Artikal trenutniArtikalZaPordjenje = artikli.get(i);
                Artikal sljedeciArtikalZaPoredjenje = artikli.get(j);
                if(trenutniArtikalZaPordjenje.equals(sljedeciArtikalZaPoredjenje)) {
                    artikli.remove(j);
                    j--;
                }
            }
        }
        return artikli;
    }

    private static ArrayList<Artikal> izbaciDuplikatePrekoHashSet(List<Artikal> artikli) {
        Set<Artikal> setArtikala = new HashSet<>(artikli);
        return new ArrayList<>(setArtikala);
    }

    public boolean equals(Object o) {
        var artikal = (Artikal)o;
        return this.cijena == artikal.cijena &&
                this.naziv.equals(artikal.naziv) &&
                this.šifra.equals(artikal.šifra);
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s", this.šifra, this.naziv, this.cijena);
    }
}

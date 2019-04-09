package sample.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Racun {
    private ArrayList<StavkaRacuna> artikli;

    public Racun() {
        artikli = new ArrayList<>();
    }

    public void dodajStavku(Artikal artikal, double kolicina) {
        artikli.add(new StavkaRacuna(artikal, kolicina));
    }

    public double ukupanIznos() {
        double[] kolicine = this.artikli.stream().mapToDouble(StavkaRacuna::getKolicina).toArray();
        return Arrays.stream(kolicine).sum();
    }

    public String getTekst() {
        ArrayList<String> artikliZaUpisUTekst = artikli.stream()
                .map(StavkaRacuna::toString)
                .collect(Collectors.toCollection(ArrayList::new));
        artikliZaUpisUTekst.add(String.format("UKUPNO %s", ukupanIznos()));
        return String.join(System.lineSeparator(), artikliZaUpisUTekst );
    }
}


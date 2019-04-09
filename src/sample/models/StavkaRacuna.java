package sample.models;

public class StavkaRacuna{
    private Artikal artikal;
    private double kolicina;

    public StavkaRacuna(Artikal artikal, double kolicina) {
        this.artikal = artikal;
        this.kolicina = kolicina;
    }

    public Artikal getArtikal() {
        return artikal;
    }

    public void setArtikal(Artikal artikal) {
        this.artikal = artikal;
    }

    public double getKolicina() {
        return kolicina;
    }

    public void setKolicina(double kolicina) {
        this.kolicina = kolicina;
    }

    public double getVrijednost() {
        return this.kolicina * this.artikal.getCijena();
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", this.artikal.getŠifra(), this.artikal.getCijena(), this.getVrijednost());
    }
}

package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Controller {
    public TextArea artikliZaUnos;
    public TextArea artikliBezDuplikata;

    public void dodajArtikale(ActionEvent actionEvent) {
        var uneseniTekst = this.artikliZaUnos.getText();
        var tekstRastavljenNaUnose = uneseniTekst.split(System.lineSeparator());
        ArrayList<Artikal> artikli = Arrays.stream(tekstRastavljenNaUnose)
                .map(Artikal::new)
                .collect(collectingAndThen(toList(), ArrayList::new));
        ArrayList<Artikal> jedinstveniArtikli = Artikal.izbaciDuplikate(artikli);
        ArrayList<String> artikliZaUpisUTekst = jedinstveniArtikli.stream()
                .map(Artikal::toString)
                .collect(Collectors.toCollection(ArrayList::new));
        var tekstArtikala = String.join(System.lineSeparator(), artikliZaUpisUTekst);
        artikliBezDuplikata.setText(tekstArtikala);
    }
}

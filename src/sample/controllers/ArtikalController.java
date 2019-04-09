package sample.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import sample.models.Artikal;
import sample.models.RacunModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class ArtikalController {
    public TextArea artikliZaUnos;
    public TextArea artikliBezDuplikata;
    public RacunModel racunModel;

    public ArtikalController() {
        racunModel = new RacunModel();
    }

    public void dodajArtikale(ActionEvent actionEvent) {
        String uneseniTekst = this.artikliZaUnos.getText();
        String newLineSeparator = "\n";
        String[] tekstRastavljenNaUnose = uneseniTekst.split(newLineSeparator);
        ArrayList<Artikal> artikli = Arrays.stream(tekstRastavljenNaUnose)
                .map(Artikal::new)
                .collect(collectingAndThen(toList(), ArrayList::new));

        RacunModel.setArtikliObservable(artikli);
        ArrayList<Artikal> jedinstveniArtikli = Artikal.izbaciDuplikate(artikli);
        ArrayList<String> artikliZaUpisUTekst = jedinstveniArtikli.stream()
                .map(Artikal::toString)
                .collect(Collectors.toCollection(ArrayList::new));
        String tekstArtikala = String.join(System.lineSeparator(), artikliZaUpisUTekst);
        artikliBezDuplikata.setText(tekstArtikala);
    }
}

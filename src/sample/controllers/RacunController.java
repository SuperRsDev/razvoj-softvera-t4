package sample.controllers;

import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.util.StringConverter;
import sample.models.Artikal;
import sample.models.Racun;
import sample.models.RacunModel;

public class RacunController {
    private RacunModel model;

    public ChoiceBox<Artikal> ponudjeniArtikli;
    public TextArea aktuelniRacunTextArea;
    public Spinner izabranaKolicina;

    private SimpleDoubleProperty kolicinaPropery;

    private Racun trenutniRacun;

    public RacunController() {
        this.model = new RacunModel();
        this.trenutniRacun = new Racun();
        kolicinaPropery = new SimpleDoubleProperty(0);
    }

    @FXML
    public void initialize() {
        ponudjeniArtikli.setConverter(getArtikliConverter());
        RacunModel.getArtikliObservable().addListener((ListChangeListener) (value) -> {
            ponudjeniArtikli.setItems(value.getList());
        });

        izabranaKolicina.getValueFactory().valueProperty().bindBidirectional(kolicinaPropery);
        kolicinaPropery.addListener((ChangeListener) (o, oldVal, newVal) -> izabranaKolicina.getValueFactory().setValue(newVal));
    }

    public void dodajStavku(ActionEvent actionEvent) {
        Artikal artikal = ponudjeniArtikli.getValue();
        double kolicina = (double)izabranaKolicina.getValue();
        trenutniRacun.dodajStavku(artikal, kolicina);
        aktuelniRacunTextArea.setText(trenutniRacun.getTekst());
    }

    public double ukupanIznos() {
        return trenutniRacun.ukupanIznos();
    }

    private StringConverter<Artikal> getArtikliConverter() {
        return new StringConverter<Artikal>() {
            @Override
            public String toString(Artikal artikal) {
                if (artikal == null) {
                    return "";
                } else {
                    return artikal.getŠifra();
                }
            }

            @Override
            public Artikal fromString(String s) {
                try {
                    return new Artikal(s);
                } catch (NumberFormatException e) {
                    return null;
                }
            }
        };
    }
}

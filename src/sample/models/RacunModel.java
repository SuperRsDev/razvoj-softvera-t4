package sample.models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class RacunModel {
        private static ObservableList<Artikal> artikliObservable = FXCollections.observableArrayList();
        private ObjectProperty<Artikal> trenutniArtikal = new SimpleObjectProperty<>();

        public ObjectProperty<Artikal> trenutniArtikalProperty() {
            return trenutniArtikal;
        }
        public Artikal getTrenutniArtikal() {
            return trenutniArtikal.get();
        }
        public void setTrenutniArtikal(Artikal k) {
            trenutniArtikal.set(k);
        }
        public static void setArtikliObservable(ArrayList<Artikal> artikli) {
            artikliObservable.addAll(artikli);
        }
        public static ObservableList<Artikal> getArtikliObservable() {
            return artikliObservable;
        }
}

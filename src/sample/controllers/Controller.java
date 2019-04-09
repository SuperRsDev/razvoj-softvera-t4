package sample.controllers;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import sample.models.RacunModel;

public class Controller {
    @FXML
    private TabPane tabPane;
    // Inject tab content.
    @FXML private Tab artikliTab;
    // Inject controller
    @FXML private ArtikalController artikliTabController;

    // Inject tab content.
    @FXML private Tab racunTab;
    // Inject controller
    @FXML private RacunController racunTabController;

    public Controller() {
        artikliTabController = new ArtikalController();
        racunTabController = new RacunController();
    }

    public void init() {
        tabPane.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Tab> observable,
                                                                        Tab oldValue, Tab newValue) -> {
            if (newValue == artikliTab) {
                System.out.println("Bar Tab page");
            } else if (newValue == racunTab) {
                System.out.println("Foo Tab page");
            }
        });
    }
}

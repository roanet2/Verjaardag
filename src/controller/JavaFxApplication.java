package controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import model.Kalender;
import model.Verjaardag;
import view.Scherm;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;


public class JavaFxApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private final Kalender kalender;
    private final Scherm scherm;

    public JavaFxApplication() {
        this.scherm = new Scherm(this);
        this.kalender = new Kalender("kalender.dat");
    }

    public void start(Stage primaryStage) {
        System.out.println("roan ettema is 108 50040221");
        scherm.setVerjaardagenListViewItems(kalender.sorteerEnGetVerjaardagen());
        scherm.getVoegToeButton().setOnAction.text;
        Scene scene = new Scene(scherm, 300, 350);
        primaryStage.setTitle("JavaFxApplication");
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(event -> {
            try {
                kalender.bewaar();
            } catch (Exception ex) {
                showErrorMessage(ex.getMessage());
            }
        });
        primaryStage.show();
    }

    public void voegVerjaardagToe() {
        String naam = scherm.getNaam;
        String dag = scherm.getDag;
        String maand = scherm.getMaand;
        String jaar = scherm.getJaar;

        try{
            LocalDate geboortedatum = ConvertStringsToCalendar(dag, maand, jaar);
            kalender.voegToe(naam, verjaardagen);
            List<Verjaardag> gesorteerdeverjaardagen = kalender.sorteerEnGetVerjaardagen;
            scherm.sorteerEnGetVerjaardagenListViewsItems(gesorteerdeverjaardagen);
        }catch(DateTimeParseException exception){
            showErrorMessage(exception.getMessage());
        }
    }

    private LocalDate convertStringsToCalender(String dag, String maand, String jaar) throws DateTimeParseException {
        return LocalDate.parse(jaar + "/" + maand + "/" + dag, DateTimeFormatter.ofPattern("y/M/d"));
    }

    private void showErrorMessage(String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("De volgende fout is opgetreden:");
        alert.setContentText(errorMessage);
        alert.show();
    }
}

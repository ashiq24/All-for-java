package sample;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

public class ListViewController {

    @FXML
    private ListView<String> listView = new ListView<>();

    final ObservableList<String> names = FXCollections.observableArrayList();

    private Button button;

    private ArrayList<String> persons = new ArrayList<>();
    private Main main;


    public void initialize(){
        for(int i=0;i<15;i++) {
            persons.add("Person " + i);
        }

      /*  names.addAll(
                "Adam", "Alex", "Alfred", "Albert",
                "Brenda", "Connie", "Derek", "Donny",
                "Lynne", "Myrtle", "Rose", "Rudolph",
                "Tony", "Trudy", "Williams", "Zach"
        ); */
        names.addAll(persons);

        System.out.println(names.size());
        listView.setItems(names);

      /*  listView.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue<? extends String> ov, String old_val,
                 String new_val) -> {
                    Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                    a.setContentText(new_val);
                    a.showAndWait();
                }
        ); */
    }

    public void setMain(Main main) { 
        this.main = main;
    }
}

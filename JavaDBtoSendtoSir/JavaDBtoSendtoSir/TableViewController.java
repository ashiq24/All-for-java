/**
 * Created by USER on 11/29/2015.
 */


import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.converter.NumberStringConverter;

import java.sql.ResultSet;

public class TableViewController {

    @FXML
    private TableView tableView;

    @FXML
    private Button button;

    private boolean init = true;

    private int keys[] = new int[500];
    private String names[] = new String[100];
    private String adresses[] = new String[500];
    private String foods[] = new String[500];
    private float ratings[] = new float[500];
    private Restuarant array[] = new Restuarant[500];
    private int numOfItem;
    void initializeColumns() {

        TableColumn<Restuarant, Number> keyCol = new TableColumn<>("keys");
        keyCol.setMinWidth(50);
        keyCol.setVisible(true);
        keyCol.setCellValueFactory(new PropertyValueFactory<>("keys"));
        keyCol.setCellFactory(TextFieldTableCell.<Restuarant,Number>forTableColumn(new NumberStringConverter()));

        keyCol.setOnEditCommit(
                (TableColumn.CellEditEvent<Restuarant, Number> t) -> {
                    ((Restuarant) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setNumber((Integer)t.getNewValue());
                }
        );
        TableColumn<Restuarant, String> NameCol = new TableColumn<>("Names");
        NameCol.setVisible(true);
        NameCol.setMinWidth(50);
        NameCol.setCellValueFactory(new PropertyValueFactory<>("Names"));
        NameCol.setCellFactory(TextFieldTableCell.<Restuarant>forTableColumn());

        NameCol.setOnEditCommit(
                (TableColumn.CellEditEvent<Restuarant, String> t) -> {
                    ((Restuarant) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setName(t.getNewValue());
                }
        );

        TableColumn<Restuarant, String> addressCol = new TableColumn<>("Address");
        addressCol.setMinWidth(300);
        addressCol.setCellValueFactory(new PropertyValueFactory<>("Address"));
        addressCol.setCellFactory(TextFieldTableCell.<Restuarant>forTableColumn());

        addressCol.setOnEditCommit(
            (TableColumn.CellEditEvent<Restuarant, String> t) -> {
                    ((Restuarant) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setAddress(t.getNewValue());
                }
        );

        TableColumn<Restuarant, String> foodCol = new TableColumn<>("FoodType");
        foodCol.setMinWidth(200);
        foodCol.setCellValueFactory(new PropertyValueFactory<>("FoodType"));
        foodCol.setCellFactory(TextFieldTableCell.<Restuarant>forTableColumn());
        foodCol.setOnEditCommit(
                (TableColumn.CellEditEvent<Restuarant, String> t) -> {
                    ((Restuarant) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setFoodType(t.getNewValue());
                }
        );

        TableColumn<Restuarant, String> actionCol = new TableColumn<>("Action");
        actionCol.setCellValueFactory(new PropertyValueFactory<>("action"));

        Callback<TableColumn<Restuarant, String>, TableCell<Restuarant, String>> cellFactory =
                new Callback<TableColumn<Restuarant, String>, TableCell<Restuarant, String>>() {
                    @Override
                    public TableCell call( final TableColumn<Restuarant, String> param ) {
                        final TableCell<Restuarant, String> cell = new TableCell<Restuarant, String>() {
                            final Button btn = new Button("Rate");

                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem( item, empty );
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                }
                                else {
                                    // action of 'Select' button click
                                    btn.setOnAction((ActionEvent event) -> {
                                                Restuarant person = getTableView().getItems().get(getIndex());
                                                String name = person.getNumber() + "." + person.getName() + " " + person.getAddress() + "" + person.getFoodType();
                                                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                                                a.setContentText(name);
                                                a.showAndWait();
                                            }
                                    );
                                    setGraphic(btn);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };
        actionCol.setCellFactory(cellFactory);

        tableView.getColumns().addAll(keyCol,NameCol, addressCol, foodCol, actionCol);
    }

    @FXML
    void buttonAction(ActionEvent event) {

        if (init) {
            initializeColumns();
            init = false;
        }
        MySQLConnect oc=new MySQLConnect("localhost","test","root","");
        try
        {
            String query = "select * from foodiesdhaka";
            ResultSet rs = oc.searchDB(query);
            System.out.println("Product List");
            System.out.println("Id	Name	Price	Description");
            int i = 0;
            while(rs.next())
            {
                keys[i] = rs.getInt("key");
                names[i] = rs.getString("name");
                adresses[i] = rs.getString("address");
                foods[i] = rs.getString("foodType");
                i++;
                System.out.print(rs.getInt("key"));
                System.out.print("	");
                System.out.print(rs.getString("name"));
                System.out.print("	");
                System.out.print(rs.getString("address"));
                System.out.print("	");
                System.out.println(rs.getString("foodType"));
            }
            numOfItem = i;
        }
        catch(Exception e)
        {
            System.out.println("Exception in listProducts: " + e);
        }
       finally
        {
            oc.close();
        }

        for(int j=0;j<numOfItem;j++) {
            array[j] = new Restuarant(keys[j],adresses[j], adresses[j], foods[j]);
        }
        final ObservableList<Restuarant> data = FXCollections.observableArrayList(array);


              /*  new Restuarant("Jacob", "Smith", "jacob.smith@example.com"),
                new Restuarant("Isabella", "Johnson", "isabella.johnson@example.com"),
                new Restuarant("Ethan", "Williams", "ethan.williams@example.com"),
                new Restuarant("Emma", "Jones", "emma.jones@example.com"),
                new Restuarant("Michael", "Brown", "michael.brown@example.com") */
           // );


        tableView.setEditable(true);
        tableView.setVisible(true);
        tableView.setItems(data);

        //Person p = new Person("A", "B", "C@D.com");
        //tableView.getItems().add(p);

    }
}

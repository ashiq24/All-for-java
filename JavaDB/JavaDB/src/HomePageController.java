/**
 * Created by user on 29-Nov-15.
 */

 import com.sun.org.apache.xpath.internal.SourceTree;
 import javafx.beans.Observable;
 import javafx.beans.value.ChangeListener;
 import javafx.beans.value.ObservableValue;
 import javafx.collections.FXCollections;
 import javafx.collections.ObservableList;
 import javafx.event.ActionEvent;
 import javafx.fxml.FXML;
 import javafx.fxml.Initializable;
 import javafx.scene.control.*;
 import javafx.scene.control.ChoiceBox;
 import javafx.scene.control.Tooltip;
 import javafx.scene.control.cell.PropertyValueFactory;
 import javafx.scene.control.cell.TextFieldTableCell;
 import javafx.util.Callback;
 import javafx.util.converter.NumberStringConverter;

 import java.net.URL;
 import java.sql.ResultSet;
 import java.util.ResourceBundle;

public class HomePageController {

    private MainTest main;
    @FXML
    private ChoiceBox<String> cbCity;//= new ChoiceBox<String>(FXCollections.observableArrayList("Dhaka","Cittagang","Rajshahi","Rangpur","Khulna","Shylhet","Barisal"));

    @FXML
    private ChoiceBox<String> cbSortBy;

    @FXML
    private ChoiceBox<String> cbArea;

    @FXML
    private ChoiceBox<String> cbFoodType;

    @FXML
    private TextField UserName;

    @FXML
    private TextField Password;

    @FXML
    private Button BtnReset;

    @FXML
    private Button BtnLogin;

    @FXML
    public TableView tableView;
    //private String Areas[] = new String[50];
    private  String Areas[] = {"Dhanmondi","Uttara","Shantinagar","Gulshan"};
    private URL url;

    private ResourceBundle resourcebundel;

    //  final String Areas[] = {"Dhaka","Cittagang","Rajshahi","Rangpur","Khulna","Shylhet","Barisal"};
    // ChoiceBox<String> cbCity = new ChoiceBox<String>(FXCollections.observableArrayList("Dhaka","Cittagang","Rajshahi","Rangpur","Khulna","Shylhet","Barisal"));
    //  cbCity.getItems()
    //  cbCity.setToolTip(new Tooltip("Select your Area")

  //  public HomePageController() {
        // initialize();
   // }
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
        keyCol.setCellValueFactory(new PropertyValueFactory<>("Number"));
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
        NameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
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
    void onLoad(ActionEvent event) {


            initializeColumns();

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
           //// String query2 = "CREATE TABLE table(Key int,Name Varchar(20))";
           // ResultSet rs2 = oc.searchDB(query2);
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
    public void initialize() {
      //  final ObservableList<String> data = FXCollections.observableArrayList(areas);
        cbCity.setItems(FXCollections.observableArrayList(
                        "Dhaka", "Chittagong", "Rajshahi", "Khulna", "Barisal", "Sylhet", "Rangpur")
        );
        cbArea.setItems(FXCollections.observableArrayList(Areas));
        cbFoodType.setItems(FXCollections.observableArrayList("Indian Food","Sea Food","Soft Drinks","Chinese"));
        cbSortBy.setItems(FXCollections.observableArrayList("All", "Area", "Food Type"));
      /*  cbCity.getSelectionModel().selectFirst();cbCity.getSelectionModel().selectedItemProperty()
                .addListener((ObservableValue observable,
                              Object oldValue, Object newValue) -> {
                     selectFunction();
                }); */
        cbCity.setTooltip(new Tooltip("Enter Your City"));
        cbCity.getSelectionModel().selectFirst();
        cbArea.getSelectionModel().selectFirst();
        cbFoodType.getSelectionModel().selectFirst();
        cbSortBy.getSelectionModel().selectFirst();
        System.out.println(cbCity.getSelectionModel().getSelectedItem());

    }



    @FXML
    void loginAction(ActionEvent event) {
        String validUserName = "admin";
        String validPassword = "123";
        String userName = UserName.getText();
        String password = Password.getText();
        if (userName.equals(validUserName) && password.equals(validPassword)) {
            // successful login
            try {
                main.AdminLoginPage();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            // failed login
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorrect Credentials");
            alert.setHeaderText("Incorrect Credentials");
            alert.setContentText("The username and password you provided is not correct.");
            alert.showAndWait();
        }

    }

    @FXML
    void resetAction(ActionEvent event) {
        UserName.setText(null);
        Password.setText(null);
    }


    public void setMain(MainTest main) {
        this.main = main;
    }

}



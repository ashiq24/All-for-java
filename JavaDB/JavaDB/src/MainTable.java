import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainTable extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml")); // for simple controls
        //Parent root = FXMLLoader.load(getClass().getResource("listview.fxml")); // for list view
        Parent root = FXMLLoader.load(getClass().getResource("tableview.fxml")); // for table view
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 500, 300));
        primaryStage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
}

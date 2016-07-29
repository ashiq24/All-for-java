/**
 * Created by user on 28-Nov-15.
 */

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;

import java.io.IOException;

public class MainTest extends Application {

    Stage Window;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Window = primaryStage;
        ShowHomePage();
    }
    public void ShowHomePage() throws IOException {
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getResource("HomePage.fxml"));
        Parent root = loader.load();
        HomePageController controller = loader.getController();
        controller.setMain(this);
        Scene scene = new Scene(root,749,570);
        Window.setScene(scene);
        Window.setTitle("Home Page");
        Window.show();
    }

    public void AdminLoginPage() throws IOException {
        Stage AdminStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AdminLogin.fxml"));
        Parent root = loader.load();
        AdminLoginController controller2 = loader.getController();
        controller2.setMain(this);
        Scene scene = new Scene(root,749,570);
        AdminStage.setScene(scene);
        AdminStage.setTitle("Admin Page");
        AdminStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

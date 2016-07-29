import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class AdminLoginController {

    private MainTest main;
    @FXML
    private ImageView AdminProfile;

    @FXML
    private Button button;

    public void ButtonClicked(ActionEvent e) throws IOException {
        main.ShowHomePage();
    }

    public void setMain(MainTest main) {
        this.main = main;
    }
}

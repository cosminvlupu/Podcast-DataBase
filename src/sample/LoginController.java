package sample;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

import java.awt.*;

public class LoginController {
    @FXML
    private TextField UserNameField;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private Button LoginBtn;

    public void Login(ActiveEvent login){
        if(UserNameField.getText().equals("user") && PasswordField.getText().equals("pass") ){
            System.out.println("Login successful");
        }else{
            System.out.println("Login failed");
        }
    }
}

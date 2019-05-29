package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

import java.awt.*;

public class SignUpController {
    @FXML
    private TextField nameInput;

    private String name;
    private String password;
    private String passwordAgain;

    @FXML
    private PasswordField passwordInput;

    @FXML
    private  PasswordField passwordRepeat;

    public void getUsername(){
        this.name = nameInput.getText();
    }

    public void getPassword(){
        this.password = passwordInput.getText();
    }

    public void getPasswordAgain(){
        this.passwordAgain = passwordRepeat.getText();
    }


    public void Signup(ActionEvent actionEvent) {
        //getUsername();
        getPassword();
        getPasswordAgain();
        if(password.equals(passwordAgain)) {
            System.out.println(name + "signed up!");
        } else {
            System.out.println("passwords don't match");
        }
    }
}

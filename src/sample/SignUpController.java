package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpController {
    @FXML
    private TextField signUpNameInput;

    @FXML
    private PasswordField signUpPasswordInput;

    @FXML
    private PasswordField signUpPasswordRepeat;


    public void Signup(ActionEvent actionEvent) {

        String name = signUpNameInput.getText();
        String password = signUpPasswordInput.getText();
        String passwordAgain = signUpPasswordRepeat.getText();

        if(name.isEmpty() || password.isEmpty() || passwordAgain.isEmpty()){
            System.out.println("All fields are required");
        }else {
            if (password.equals(passwordAgain)) {
                System.out.println(name + " signed up!");
            } else {
                System.out.println("Passwords don't match. Try again.");
            }
        }
    }
}

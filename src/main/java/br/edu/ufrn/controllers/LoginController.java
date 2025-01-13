package br.edu.ufrn.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Label errorMessageLabel;

    @FXML
    private void handleLogin(ActionEvent event) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.equals("admin") && password.equals("1234")) {
            System.out.println("Login bem-sucedido!");

            Parent root = FXMLLoader.load(getClass().getResource("/view/main.fxml"));

            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.setTitle("Sistema de Farmácia");
            newStage.show();

            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();

            
        } else {
            System.out.println("Usuário ou senha inválidos.");
            errorMessageLabel.setText("Usuário ou senha inválidos.");
        }
    }
}


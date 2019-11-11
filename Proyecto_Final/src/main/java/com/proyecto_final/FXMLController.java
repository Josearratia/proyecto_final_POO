package com.proyecto_final;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class FXMLController implements Initializable {
    
    
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Usuario;

    @FXML
    private Button btn_inicio;

    @FXML
    private PasswordField password;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       assert Usuario != null : "fx:id=\"Usuario\" was not injected: check your FXML file 'Scene.fxml'.";
       assert btn_inicio != null : "fx:id=\"btn_inicio\" was not injected: check your FXML file 'Scene.fxml'.";
       assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'Scene.fxml'.";

    }   
}

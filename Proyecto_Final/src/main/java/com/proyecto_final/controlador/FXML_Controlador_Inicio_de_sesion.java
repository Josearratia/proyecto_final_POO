package com.proyecto_final.controlador;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXML_Controlador_Inicio_de_sesion implements Initializable {
    @FXML
    private TextField Usuario;

    @FXML
    private Button btn_inicio;

    @FXML
    private PasswordField password;
    private String tipo_de_usuario;
    private String id_carrera;
    private coneccion conn;
    
    private void Inicio_Sesion(){
        btn_inicio.setOnAction((ActionEvent event) -> {
            String user = Usuario.getText();
            String pass = password.getText();
            user.replaceAll(" ", "");
            pass.replaceAll(" ", "");
            if(user.length() > 0 && pass.length() > 0){
                 ResultSet consulta = conn.ConsultaGet(null);
                try {
                    while (consulta.next()){
                        String temp_user = consulta.getString("clv_usuario");
                        String cont = consulta.getString("pass_usuario");
                        String temp_tipo = consulta.getString("tipo_usuario");
                        String carrera =consulta.getString("idcarrera");
                        if(user.equals(temp_user)  && pass.equals(cont)){
                            try {
                                conn.close();
                                Controlador_De_Stages menu = new Controlador_De_Stages();
                                conn.exit();
                                menu.menu((Stage) btn_inicio.getScene().getWindow());
                            } catch (Exception ex) {
                            }
                        }
                    }
                } catch (SQLException ex) {
                }
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Inicio_Sesion();
        conn = new coneccion();
    }   
}




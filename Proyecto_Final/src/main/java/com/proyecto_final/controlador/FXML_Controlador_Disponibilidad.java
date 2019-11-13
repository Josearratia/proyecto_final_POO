package com.proyecto_final.controlador;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class FXML_Controlador_Disponibilidad {
    @FXML
    private ComboBox<String> ComboBox_Disponibilidad_profesor = null;
    @FXML
    private ComboBox ComboBox_Disponibilidad_turno;
    private coneccion conn;
    
    @FXML
    public void initialize() throws SQLException {
        conn = new coneccion();
        ResultSet Usuarios = conn.ConsultaGet("SELECT * FROM usuarios");
        while(Usuarios.next()){
            String temp_tipo = Usuarios.getString("tipo_usuario");
            if(temp_tipo.equals("ADMI")){
                
            }else{
                System.out.println(Usuarios.getString("nombre_usuario"));
                ComboBox_Disponibilidad_profesor.getItems().add(Usuarios.getString("nombre_usuario"));
            }
        }
        conn.close();
    }  
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto_final.controlador;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author pintu
 */
public class FXML_Controlador_Menu {
    public static String id_user;
    public static String tipo_user;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Button Buton_Menu_Disponibilidad;
    
    @FXML
    private Label label_usuario;
    private coneccion conn;
    
    private void inicio(){
        if(tipo_user.length() <= 4){
            if(tipo_user.equals("ADMI")){
                tipo_user = "Administrador";
            }else if (tipo_user.equals("DIRE")){
                tipo_user = "Director";
            }else{
                tipo_user = "Profesor";
            }
        }
        label_usuario.setText(tipo_user + " : "+id_user);
        
        Buton_Menu_Disponibilidad.setOnAction((ActionEvent e) -> {
            try {
                Disponibilidad();
            } catch (Exception ex) {
                Logger.getLogger(FXML_Controlador_Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    //controlador disponibilidad
    public void Disponibilidad() throws Exception{
        Controlador_De_Stages DisponibilidadStage = new Controlador_De_Stages();
        DisponibilidadStage.disponibilidad((Stage) Buton_Menu_Disponibilidad.getScene().getWindow());
        conn.close();
        conn.exit();
    }

    
    @FXML
    void initialize() {
        inicio();
        conn = new coneccion();
    }
}

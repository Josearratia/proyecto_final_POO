package com.proyecto_final.controlador;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Controlador_De_Stages extends Application{
    private Parent root;
    private Scene scene;
    private Stage tem; 
    
    @Override
    @SuppressWarnings("empty-statement")
    public void start(Stage Inicio_Sesion) throws Exception {
        root = FXMLLoader.load(getClass().getResource("/fxml/Inicio_De_Sesion.fxml"));
        scene = new Scene(root);
        Inicio_Sesion.setTitle("Inicio De Sesion");
        Inicio_Sesion.setScene(scene);
        Inicio_Sesion.show();
    }
    
   public void menu(Stage OldWindows) throws Exception{
        OldWindows.close();
        root = FXMLLoader.load(getClass().getResource("/fxml/Menu_Inicio.fxml"));
        Stage menu = new Stage();
        menu.setTitle("Menu");
        menu.setScene(new Scene(root));
        menu.initStyle(StageStyle.UNIFIED);
        menu.show();
    }
   
   public void disponibilidad(Stage OldWindows) throws Exception{
       OldWindows.close();
       root = FXMLLoader.load(getClass().getResource("/fxml/Disponibilidad.fxml"));
       Stage disponibilidad = new Stage();
       disponibilidad.setTitle("Disponibilidad");
       disponibilidad.setScene(new Scene(root));
       disponibilidad.initStyle(StageStyle.UTILITY);
       disponibilidad.show();       
   }
} 

package com.proyecto_final.controlador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class coneccion {
    private final String driver = "com.mysql.jdbc.Driver";
    private final String database = "horarios";
    private final String hostname = "localhost";
    private final String port = "3306";
    private final String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";
    private final String username = "root";
    private final String password = "";
    private Connection conn = null;
    private Statement s = null;
    private ResultSet ejecucion_consulta = null;
    
    public coneccion() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e){
        }
    }
    
    public ResultSet ConsultaGet(String consulta){
        try{
            s = conn.createStatement();
            ejecucion_consulta = s.executeQuery("SELECT * FROM usuarios");
            return ejecucion_consulta;
        }catch (SQLException ex){   
        }
        
        return null;
    }
    
    public void ConsultaSet(String consulta){
        try{
            s = conn.createStatement();
            ejecucion_consulta = s.executeQuery(consulta);
        }catch (SQLException ex){   
        }
    }
    
    public void close() throws SQLException{
        if(ejecucion_consulta != null){
            ejecucion_consulta.close();
        }
    }
    
    public void exit() throws SQLException{
        conn.close();
    }
    
}

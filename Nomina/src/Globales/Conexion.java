/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Globales;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexandra
 */
public class Conexion {

    //Definicion de variables de coneccion
    private String user, pass, urlConectar, driver;//Definir quien va a ser el usuario cual será la contraseña y el driver
    //Variable de la clase connect para conectar la base de datos
    //Es el puente entre el lenguaje de programacion y labase de datos
    public Connection conection;
    //statament controla las conexiones y las ejecuciones de las sql
    public java.sql.Statement statement;//toma las ordenes de que se envian a la base de datos y ejecuta

    
    //public static String sql = "SELECT nombreTrab as nombre  FROM trabajadores where idTraba=1144076993 ";
    
    public Conexion() {
        user = "postgres";
        pass = "Al3xandra";
        driver = "org.postgresql.Driver";
        urlConectar = "jdbc:postgresql://localhost/talentohumano";

        try {
            Class.forName(driver);
            conection = DriverManager.getConnection(urlConectar, user, pass);
            System.out.println("SI SE CONECTA A LA DB");
            statement = conection.createStatement();
//executeQuery: Solo permite ejecutar sentencias de recuperación (SELECT). Si como parámetro hay una sentencia 
            //  de modificación, lanza una SQLException.
         
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("NO SE CONECTA A LA DB");
        }
    }

    public void cerrar() {
        try {
            conection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet consulta(String sql) {
        ResultSet resultado = null;
        try {
            statement = conection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            resultado = statement.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }



    public boolean transaccion(String sql) {
        try {
            statement = conection.createStatement();
            statement.execute(sql);
            statement.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
   /* public static void main(String[] args) {
        Conexion c=new Conexion();
    }*/
}

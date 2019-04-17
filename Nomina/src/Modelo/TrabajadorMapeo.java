/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Globales.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Alexandra
 */
public class TrabajadorMapeo {
    public Trabajador consultaExisteTrabajador(int cedula) throws SQLException{
        Trabajador trabajador=new Trabajador();
        Cargo cargo;
        String sql="SELECT * from trabajador where cedula="+cedula;
        Conexion conexion=new Conexion();
        boolean existe;
        ResultSet resultados = conexion.consulta(sql);
            while (resultados.next()) {
                
                trabajador=new Trabajador(resultados.getLong("cedula"), resultados.getString("nombre"),
                        resultados.getString("apellido"), null, false);
                
            }
            resultados.close();
            System.out.println("DATO: "+trabajador.getNombre()+" "+trabajador.getApellido());
            return trabajador;
    
    }
    
    
   /* public static void main(String[] args) throws SQLException {
        TrabajadorMapeo tm=new TrabajadorMapeo();
        tm.consultaExisteTrabajador(1144076993);
    }*/
}

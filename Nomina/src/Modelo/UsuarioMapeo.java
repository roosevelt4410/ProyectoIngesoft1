/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Globales.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioMapeo {

    public UsuarioMapeo() {
        
    
    }
    
    public Usuario validarUsuario(String usuario) throws SQLException{
        Conexion conexion= new Conexion();
        
        String sql = "select nombreUsuario,contrasena from usuarios where nombreUsuario = '"+usuario+"'";
        String nombreUsuario="";
        String nombreContrasena="";
        ResultSet resultado = conexion.consulta(sql);
        while(resultado.next()){
            nombreUsuario = resultado.getString("nombreUsuario");
            nombreContrasena = resultado.getString("contrasena");
            
        }
        conexion.cerrar();
        Usuario usuarioo = new Usuario(nombreUsuario, nombreContrasena);
        return usuarioo;
    } 


    public boolean InsertarNuevoUsuario(Usuario usuarioo)throws SQLException{            
         String sql="INSERT into usuarios(nombreusuario,contrasena,roles,cedulatrabajador)"
                + " VALUES("+usuarioo.getUsuario() +","+usuarioo.getContrasena()+ ","+null+","+usuarioo.getCedulaUsuario()+")";
         Conexion conexion=new Conexion();
         boolean guardar=conexion.transaccion(sql);
         conexion.cerrar();
         if(guardar){
             return true;
         }else{
            return false;
         }        
    }
}

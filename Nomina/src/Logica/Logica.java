/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.Usuario;
import Modelo.UsuarioMapeo;
import java.sql.SQLException;
import java.util.Vector;

public class Logica {
    String usuario;
    String contrasena;
    Vector<String> roles;
    String cedulaTrabajador;

    public Logica(String usuario, String contrasena,Vector<String> roles,String cedulaTrabajador) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.roles=roles;
        this.cedulaTrabajador=cedulaTrabajador;
        
    }
    
    public boolean validarUsuario() throws SQLException{
        UsuarioMapeo  mapeoUsuario = new UsuarioMapeo();
        Usuario usuarioo = mapeoUsuario.validarUsuario(usuario);
        if (usuarioo.getUsuario().equals(usuario)) {
            if(usuarioo.getContrasena().equals(contrasena)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
    public boolean ingresarUsuariobd() throws SQLException{
        UsuarioMapeo  mapeoUsuario = new UsuarioMapeo();
        Usuario usuarionuevo =new Usuario(usuario,contrasena,cedulaTrabajador,roles);
        boolean ingresoCorrectamente = mapeoUsuario.InsertarNuevoUsuario(usuarionuevo);
        return ingresoCorrectamente;        
    }
    
    
}
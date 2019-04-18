/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Vector;

public class Usuario {
    String usuario;
    String contrasena;
    String cedulaUsuario;
    Vector<String> roles=new Vector<String>(4);

    public void setCedulaUsuario(String cedulaUsuario) {
        this.cedulaUsuario = cedulaUsuario;
    }

    public void setRoles(Vector<String> roles) {
        this.roles = roles;
    }

    public String getCedulaUsuario() {
        return cedulaUsuario;
    }

    public Vector<String> getRoles() {
        return roles;
    }
    
    
    public Usuario(String usuario,String contrasena,String cedula,Vector<String> rol){
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.cedulaUsuario=cedula;
        this.roles = rol;
    }
    
    public Usuario(String usuario,String contrasena){
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
    
    public String getUsuario() {
	return usuario;
    }
    public void setUsuario(String usuario) {
	this.usuario = usuario;
    }
    
    public String getContrasena() {
	return contrasena;
    }
    public void setContrasena(String contrasena) {
	this.contrasena = contrasena;
    }
    

    
}
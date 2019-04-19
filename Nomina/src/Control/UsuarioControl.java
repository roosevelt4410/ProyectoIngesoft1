package Control;

import Logica.Logica;
import Modelo.Usuario;
import java.sql.SQLException;
import java.util.Vector;


public class UsuarioControl {
    String usuario;
    String contrasena;
    Vector<String> roles;
    String cedulaTrabajador;

    public UsuarioControl(String usuario, String contrasena,Vector<String> roles , String cedulaTrabajador) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.cedulaTrabajador=cedulaTrabajador;
        this.roles=roles;
        
    }
      
    public Logica devolverUsuario(){
        Logica logicaa = new Logica(usuario, contrasena,roles,cedulaTrabajador);
        return logicaa;
    }
  
    public boolean guardarUsuario() throws SQLException{
            Logica guardar=new Logica(usuario,contrasena,roles,cedulaTrabajador);
            return guardar.ingresarUsuariobd();
    }
}

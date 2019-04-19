package Control;

import Logica.Logica;
import Modelo.Usuario;
import java.sql.SQLException;
import java.util.Vector;


public class UsuarioControl {
    int idUsuario;
    String usuario;
    String contrasena;
    ArrayList rolesEscogidos = new ArrayList(4);
    String cedulaTrabajador;

    public UsuarioControl(int idUsuario,String usuario, String contrasena,ArrayList rolesEscogidos , String cedulaTrabajador) {
        this.idUsuario=idUsuario;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.cedulaTrabajador=cedulaTrabajador;
        this.rolesEscogidos=rolesEscogidos;
        
    }
      
    public UsuarioLogica devolverUsuario(){
        UsuarioLogica logicaa = new UsuarioLogica(idUsuario,usuario, contrasena,rolesEscogidos,cedulaTrabajador);
        return logicaa;
    }
  
    public boolean guardarUsuario() throws SQLException{
            UsuarioLogica guardar=new UsuarioLogica(idUsuario,usuario,contrasena,rolesEscogidos,cedulaTrabajador);
            return guardar.ingresarUsuariobd();
    }
}

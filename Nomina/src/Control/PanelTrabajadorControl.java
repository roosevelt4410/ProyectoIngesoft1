/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.util.Date;
import Logica.TrabajadorLogica;
import Modelo.Cargo;
import Modelo.Trabajador;
import static Modelo.Trabajador.LISTATRABAJADORES;
import javax.swing.JTextField;

/**
 *
 * @author HOME
 */
public class PanelTrabajadorControl {

    public TrabajadorLogica cttrabajador = new TrabajadorLogica();
    
    

    public boolean aseguramientoDatos(String identificacion, String nombre, String apellido, String direccion, String telefono, String celular, String fPension, String fSesantias, String arl, String estado) {
        return identificacion.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || direccion.isEmpty() || telefono.isEmpty() || celular.isEmpty() || fPension.isEmpty() || fSesantias.isEmpty() || arl.isEmpty();
    }

    public boolean verificarTrabajador(String identificacion, String nombre, String apellido, Date fecha, String direccion, String telefono, String celular, String fPension, String fSesantias, String arl, String estado,Cargo cargo,boolean esCapacitador) {
        cttrabajador.trabajador = new Trabajador(Long.parseLong(identificacion), nombre, apellido, fecha, direccion, Integer.parseInt(telefono), Long.parseLong(celular), fPension, fSesantias, arl, estado,cargo,esCapacitador);
        return cttrabajador.buscarTrabajador(cttrabajador.trabajador.getIdentificacion(), LISTATRABAJADORES);
    }

    public void setText(JTextField nombre, JTextField apellido, JTextField direccion, JTextField telefono, JTextField celular, JTextField arl, JTextField cedula, JTextField fPension, JTextField fcesantias) {
        apellido.setText("");
        nombre.setText("");
        direccion.setText("");
        telefono.setText("");
        celular.setText("");
        arl.setText("");
        cedula.setText("");
        fPension.setText("");
        fcesantias.setText("");
    }
}

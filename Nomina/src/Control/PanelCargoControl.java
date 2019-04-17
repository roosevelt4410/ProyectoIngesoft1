/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import Modelo.Cargo;
import Logica.CargoLogica;
import static Modelo.Cargo.LISTACARGOS;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author HOME
 */
public class PanelCargoControl {

    public CargoLogica conCargo = new CargoLogica();

    public boolean aseguramientoDatos(String nombreCargo, String codigoCargo, String descripcion, String salario) {
        return nombreCargo.isEmpty() || codigoCargo.isEmpty() || descripcion.isEmpty() || salario.isEmpty();
    }

    public boolean verificarCargo(String nombreCargo, String codigoCargo, String descripcion, String salario) {
        conCargo.cargo = new Cargo(nombreCargo, Integer.parseInt(codigoCargo), descripcion, Double.parseDouble(salario));
        return conCargo.buscarCargo(conCargo.cargo.getCodigoCargo(), LISTACARGOS);
    }
    
    public void setText(JTextField nombreCargo, JTextField codigoCargo, JTextArea descripcion, JTextField salario) {
        nombreCargo.setText("");
        codigoCargo.setText("");
        descripcion.setText("");
        salario.setText("");
    }
}

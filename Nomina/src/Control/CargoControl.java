/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Logica.CargoLogica;
import Modelo.Cargo;
import static Modelo.Cargo.LISTACARGOS;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HOME
 */
public class CargoControl {

    CargoLogica cargoL = new CargoLogica();

    public CargoControl(String nombreCargo, int codigoCargo, String descripcionCargo, double salario) throws SQLException {
        cargoL.crearCargo(nombreCargo, codigoCargo, descripcionCargo, salario);
    }

    public void controlRetornarIndice(long identificacion, ArrayList<Cargo> listaCargo) {
        cargoL.retornaIndice(identificacion, listaCargo);
    }

    public void controlActualizarCargo(String nombreCargo, int codigoCargo, String descripcionCargo, double salario, ArrayList<Cargo> listaCargo) {
        cargoL.actualizarCargo(nombreCargo, codigoCargo, descripcionCargo, salario, listaCargo);
    }

    public void controlBuscarCargo(int codigoCargo, ArrayList<Cargo> listaCargo) {
        cargoL.buscarCargo(codigoCargo, listaCargo);
    }

    public CargoControl() {

    }

    public DefaultTableModel listarCargosC() {
        return cargoL.listarCargos();
    }

    public Cargo getCargo(int codigoCargo) {

        for (int i = 0; i < LISTACARGOS.size(); i++) {
            Cargo cargo = LISTACARGOS.get(i);
            if (codigoCargo == cargo.getCodigoCargo()) {
                return cargo;
            }

        }
        return null;
    }
}

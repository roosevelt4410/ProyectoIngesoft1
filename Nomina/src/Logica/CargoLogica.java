/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.Cargo;
import static Modelo.Cargo.LISTACARGOS;
import Modelo.CargoMapeo;
import Modelo.Trabajador;
import static Modelo.Trabajador.LISTATRABAJADORES;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HOME
 */
public class CargoLogica {

    public Cargo cargo = new Cargo();
    public CargoMapeo cargoMapeo = new CargoMapeo();

    /*public void crearCargo(String nombreCargo, int codigoCargo, String descripcionCargo, double salario) {
        cargo = new Cargo(nombreCargo, codigoCargo, descripcionCargo, salario);
        LISTACARGOS.add(cargo);
    }*/

    public int retornaIndice(long identificacion, ArrayList<Cargo> listaCargo) {
        int aux = 0;
        for (int i = 0; i < listaCargo.size(); i++) {
            cargo = listaCargo.get(i);
            if (identificacion == cargo.getCodigoCargo()) {
                aux = i;
            }
        }
        return aux;
    }

    public void actualizarCargo(String nombreCargo, int codigoCargo, String descripcionCargo, double salario, ArrayList<Cargo> listaCargo) {
        for (int i = 0; i < listaCargo.size(); i++) {
            cargo = listaCargo.get(i);
            Cargo cargoModif = new Cargo(nombreCargo, codigoCargo, descripcionCargo, salario);
            if (codigoCargo == cargo.getCodigoCargo()) {
                LISTACARGOS.set(this.retornaIndice(codigoCargo, listaCargo), cargoModif);
                break;
            }

        }
    }

    public boolean buscarCargo(int codigoCargo, ArrayList<Cargo> listaCargo) {
        boolean auxTrabajador = false;

        for (int i = 0; i < listaCargo.size(); i++) {
            cargo = listaCargo.get(i);
            if (codigoCargo == cargo.getCodigoCargo()) {
                auxTrabajador = true;
            }
        }
        return auxTrabajador;
    }

    public DefaultTableModel listarCargos() {

        DefaultTableModel tablaCargo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int filas, int columnas) {

                if (columnas != 0) {
                    return false;
                }
                return true;
            }
        };

        tablaCargo.addColumn("Codigo");
        tablaCargo.addColumn("Nombre");
        tablaCargo.addColumn("Salario");

        for (int i = 0; i < LISTACARGOS.size(); i++) {
            cargo = LISTACARGOS.get(i);
            Object[] filaTabla = new Object[1];
            tablaCargo.addRow(filaTabla);
            tablaCargo.setValueAt(cargo.getCodigoCargo(), i, 0);
            tablaCargo.setValueAt(cargo.getNombreCargo(), i, 1);
            tablaCargo.setValueAt(cargo.getSalario(), i, 2);
        }
        return tablaCargo;

    }
    //------------------Mapeo---------------------------

    public void crearCargo( String nombreCargo,int codigoCargo, String descripcion, Double salario) throws SQLException {

        Cargo cargos = new Cargo(nombreCargo, codigoCargo, descripcion, salario);
        LISTACARGOS.add(cargos);
        cargoMapeo.insertCargo(cargos);

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.util.ArrayList;

/**
 *
 * @author HOME
 */
public class Cargo {

    public static ArrayList<Cargo> LISTACARGOS = new ArrayList<>();
    private String nombreCargo;
    private int codigoCargo;
    private String descripcionCargo;
    private double salario;

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    public int getCodigoCargo() {
        return codigoCargo;
    }

    public void setCodigoCargo(int codigoCargo) {
        this.codigoCargo = codigoCargo;
    }

    public String getDescripcionCargo() {
        return descripcionCargo;
    }

    public void setDescripcionCargo(String descripcionCargo) {
        this.descripcionCargo = descripcionCargo;
    }

    public Cargo() {
    }

    public Cargo(String nombreCargo, int codigoCargo, String descripcionCargo, double salario) {
        this.nombreCargo = nombreCargo;
        this.codigoCargo = codigoCargo;
        this.descripcionCargo = descripcionCargo;
        this.salario = salario;
    }

}

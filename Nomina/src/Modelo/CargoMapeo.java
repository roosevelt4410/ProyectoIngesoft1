/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Globales.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author HOME
 */
public class CargoMapeo {

    public void insertCargo(Cargo cargo) throws SQLException {

        String sql;
        sql = "insert into cargo(nombreCargo,codigoCargo,descripcionCargo,salario)"
                + " VALUES(" + "'" + cargo.getNombreCargo() + "'" + ","
                + "'" + cargo.getCodigoCargo() + "'" + ","
                + "'" + cargo.getDescripcionCargo() + "'" +","
                + cargo.getSalario() +");";

        System.out.println(sql);
        Conexion conexion = new Conexion();
        boolean guardar = conexion.transaccion(sql);
        System.out.println(guardar);
        conexion.cerrar();
        //return guardar;
    }

    public void subirALista() throws SQLException {
        Cargo cargo = new Cargo();
        String sql = "SELECT * from cargo";
        Conexion conexion = new Conexion();
        ResultSet resultados = conexion.consulta(sql);
        while (resultados.next()) {
            cargo = new Cargo(resultados.getString("nombreCargo"), resultados.getInt("codigoCargo"), resultados.getString("descripcionCargo"),
                    resultados.getDouble("salario"));
            Cargo.LISTACARGOS.add(cargo);
        }
        resultados.close();

    }
}

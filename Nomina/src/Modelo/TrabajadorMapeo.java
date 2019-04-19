/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Globales.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Alexandra
 */
public class TrabajadorMapeo {

    Trabajador tr = new Trabajador();

    public Trabajador consultaExisteTrabajador(long cedula) throws SQLException {
        Trabajador trabajador = new Trabajador();
        Cargo cargo;
        String sql = "SELECT * from trabajador where cedula=" + cedula;
        Conexion conexion = new Conexion();
        boolean existe;
        ResultSet resultados = conexion.consulta(sql);
        while (resultados.next()) {
            trabajador = new Trabajador(resultados.getLong("cedula"), resultados.getString("nombre"),
                    resultados.getString("apellido"), null, false);

        }
        resultados.close();
        System.out.println("DATO: " + trabajador.getNombre() + " " + trabajador.getApellido());
        return trabajador;

    }

    public Trabajador updateTrabajador(int cedula) throws SQLException {
        Trabajador trabajador = new Trabajador();
        Cargo cargo;
        String sql = "SELECT * from trabajador where cedula=" + cedula;
        Conexion conexion = new Conexion();
        boolean existe;
        ResultSet resultados = conexion.consulta(sql);
        while (resultados.next()) {
            trabajador = new Trabajador(resultados.getLong("cedula"), resultados.getString("nombre"),
                    resultados.getString("apellido"), null, false);

        }
        resultados.close();
        System.out.println("DATO: " + trabajador.getNombre() + " " + trabajador.getApellido());
        return trabajador;

    }

    public void insertTrabajador(Trabajador trabajador) throws SQLException {

        String sql;
        sql = "insert into trabajador(cedula,nombre,apellido,fechaN,direccion,telefono,celular ,fPension ,fCesantias,arl,estado)"
                + " VALUES(" + trabajador.getIdentificacion() + ","
                + "'"+trabajador.getNombre()+"'"+ ","
                + "'"+trabajador.getApellido()+"'" + ","
                + "to_date('" + this.cal(this.calendario(trabajador.getFechaN())) + "','YYYY/MMM/DD'),"
                + "'"+trabajador.getDireccion()+"'" + ","
                + +trabajador.getTelefono() + ","
                + +trabajador.getCelular()+ ","
                + "'"+trabajador.getfPension()+"'" + ","
                + "'"+trabajador.getfCesantias()+"'" + ","
                + "'"+trabajador.getArl()+"'" + ","
                + "'"+trabajador.getEstado()+"'" + ");";

        
        System.out.println(sql);
        Conexion conexion = new Conexion();
        boolean guardar = conexion.transaccion(sql);
        System.out.println(guardar);
        conexion.cerrar();
        //return guardar;
    }

    public void insertCargoTrabajador(Trabajador trabajador) throws SQLException {

        String sql = "insert into cargotrabajador(cedulatrabajador,codigocargo)"
                + " VALUES(" + trabajador.getIdentificacion() + ","
                + trabajador.getCargo().getCodigoCargo() + ");";
        /*+ novedadModelo.getCantidadHoras() + ",to_date('" + novedadModelo.getFechaInicio() + "','DD/MM/YYYY'),"
                + "to_date('" + novedadModelo.getFechaFin() + "','DD/MM/YYYY'))";*/
        System.out.println(sql);
        Conexion conexion = new Conexion();
        boolean guardar = conexion.transaccion(sql);
        conexion.cerrar();

    }

    public void subirALista() throws SQLException {
        Trabajador trabajador = new Trabajador();
        String sql = "SELECT * from trabajador";
        Conexion conexion = new Conexion();
        ResultSet resultados = conexion.consulta(sql);
        while (resultados.next()) {
            trabajador = new Trabajador(resultados.getLong("cedula"), resultados.getString("nombre"),
                    resultados.getString("apellido"), null, false);
            Trabajador.LISTATRABAJADORES.add(trabajador);
        }
        resultados.close();

    }

    public Calendar calendario(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public String cal(Calendar calendar) {
        String calendari;
        calendari = calendar.get(Calendar.YEAR) + "-" + "04" + "-" + calendar.get(Calendar.DAY_OF_MONTH);
        return calendari;
    }

    /*   public void llenarLista() throws SQLException {
        ArrayList<Trabajador> list = new ArrayList<>();
        list.add(this.subirALista());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getApellido());

        }
    }*/
    public static void main(String[] args) throws SQLException {
        TrabajadorMapeo tm = new TrabajadorMapeo();
        Trabajador tr = new Trabajador();
        tr = new Trabajador(788, "Camilo", "lido", null, "asdasd", 0, 0, "asdasd", "asdas", "asd", "asdasd");
        tm.insertTrabajador(tr);

    }
}

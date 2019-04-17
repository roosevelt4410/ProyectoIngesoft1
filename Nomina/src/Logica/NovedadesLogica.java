/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.NovedadModelo;
import Modelo.NovedadesMapeo;
import Modelo.TipoNovedadMapeo;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexandra
 */
public class NovedadesLogica {

    
    public NovedadesLogica() {
    }
    public void eliminarNovedad(int idNovedad){
        NovedadesMapeo novedadM=new NovedadesMapeo();
        novedadM.delete(idNovedad);
    }

    public boolean guardarNovedades(int idTrabajador, String nombreTipoNovedad, int cantHoras, String fechaInicio, String fechaFin) throws SQLException {
        NovedadModelo novedadModelo = new NovedadModelo(idTrabajador, nombreTipoNovedad, cantHoras, fechaInicio, fechaFin);
        NovedadesMapeo novedadesMapeo = new NovedadesMapeo();
        boolean resp = novedadesMapeo.insert(novedadModelo);
        return resp;

    }
    public NovedadModelo editarNovedades( int cantHoras,int idNovedad) throws SQLException{
        NovedadModelo novedadModelo;
        novedadModelo=consultarNovedadesPorID(idNovedad);
        novedadModelo.setCantidadHoras(cantHoras);
        NovedadesMapeo novedadesMapeo = new NovedadesMapeo();
        novedadesMapeo.update(novedadModelo);
        return novedadModelo;
    
    }
    public NovedadModelo consultarNovedadesPorID(int idNovedad) throws SQLException {
        NovedadesMapeo novedadesMapeo = new NovedadesMapeo();
        NovedadModelo nvM = novedadesMapeo.consultarNovedadPorIdNovedad(idNovedad);
        return nvM;

    }
    
    public ArrayList<NovedadModelo> consultarNovedades(int idTrabajador) throws SQLException {
        NovedadesMapeo novedadesMapeo = new NovedadesMapeo();
        ArrayList<NovedadModelo> nvM = novedadesMapeo.consultarNovedadPorIdTrabajador(idTrabajador);
        return nvM;

    }
    
    public ArrayList<String> consultarTiposDeNovedad(String simbolo) throws SQLException{
        if(simbolo.equals("A")){
            TipoNovedadMapeo tNM=new TipoNovedadMapeo();
            return tNM.consultarTiposDeNovedad();
        }else{
            TipoNovedadMapeo tNM=new TipoNovedadMapeo();
            return tNM.consultarPorTiposDeNovedad(simbolo);
        }
    }

    public DefaultTableModel listarNovedades(int idTrabajador) throws SQLException {
        ArrayList<NovedadModelo> novedadesModel = consultarNovedades(idTrabajador);

        DefaultTableModel tablaNovedades = new DefaultTableModel() {
            //Metodo para que en la tabla al hacer doble clic no se pueda editar
            @Override
            public boolean isCellEditable(int filas, int columnas) {

                if (columnas!= 2 ) {
                    return false;
                }
                return true;
            }
        };
        tablaNovedades.addColumn("No.");
        tablaNovedades.addColumn("Tipo de Novedad");
        tablaNovedades.addColumn("Horas");
        tablaNovedades.addColumn("Fecha de Inicio");
        tablaNovedades.addColumn("Fecha de Fin");

        for (int i = 0; i < novedadesModel.size(); i++) {
            System.out.println("prueba " + novedadesModel.get(i).getNombreNovedad());
            Object[] row = new Object[1];
            tablaNovedades.addRow(row);
            tablaNovedades.setValueAt(novedadesModel.get(i).getIdNovedades(), i, 0);
            tablaNovedades.setValueAt(novedadesModel.get(i).getNombreNovedad(), i, 1);
            tablaNovedades.setValueAt(novedadesModel.get(i).getCantidadHoras(), i, 2);
            tablaNovedades.setValueAt(novedadesModel.get(i).getFechaInicio(), i, 3);
            tablaNovedades.setValueAt(novedadesModel.get(i).getFechaFin(), i, 4);
        }
        return tablaNovedades;
    }
    

}

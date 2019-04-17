/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Logica.NovedadesLogica;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexandra
 */
public class NovedadesControl {
    

    public NovedadesControl(int idTrabajador, String nombreTipoNovedad, int cantHoras, String fechaInicio, String fechaFin) throws SQLException {
        guardarNovedades(idTrabajador, nombreTipoNovedad, cantHoras, fechaInicio, fechaFin);
    }
    public NovedadesControl(){
       
    }
    public void editarNovedades(int idNovedad, int cantHoras) throws SQLException{
         NovedadesLogica nl=new NovedadesLogica();
         nl.editarNovedades(cantHoras, idNovedad);
    }
    public void guardarNovedades(int idTrabajador, String nombreTipoNovedad, int cantHoras, String fechaInicio, String fechaFin) throws SQLException{
     NovedadesLogica nl=new NovedadesLogica();
     nl.guardarNovedades(idTrabajador, nombreTipoNovedad, cantHoras, fechaInicio, fechaFin);
    }
    public DefaultTableModel listaNovedades(int idTrabajador) throws SQLException{
        NovedadesLogica novedadesLogica=new NovedadesLogica();
        DefaultTableModel nvLTabla= novedadesLogica.listarNovedades(idTrabajador);
        return nvLTabla;
    }
   public ArrayList<String> tiposNovedad() throws SQLException{
       NovedadesLogica novedadesLogica=new NovedadesLogica();
        return novedadesLogica.consultarTiposDeNovedad("A");
   } 
     public ArrayList<String> tiposIncapacidad() throws SQLException{
       NovedadesLogica novedadesLogica=new NovedadesLogica();
        return novedadesLogica.consultarTiposDeNovedad("I");
   } 
    public void eliminarRegistro(int idNovedad){
        NovedadesLogica nvL=new NovedadesLogica();
        nvL.eliminarNovedad(idNovedad);
    }
    
    
}

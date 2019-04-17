/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Globales.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alexandra
 */

public class NovedadesMapeo {
    /*no consultar las novedades por id*/
    TipoNovedadMapeo tipoNovedadMapeo;
    public NovedadesMapeo() {
     tipoNovedadMapeo=new TipoNovedadMapeo();
    }
    
    public void delete(int id_novedades){
        Conexion conexion=new Conexion();
        String sql="DELETE from novedades where id_novedades= "+ id_novedades;
        conexion.transaccion(sql);
        conexion.cerrar();
    }
    public void update(NovedadModelo novedadModelo){
        Conexion conexion=new Conexion();
        String sql="UPDATE novedades set CANT_HORAS="+novedadModelo.getCantidadHoras()+",FECHA_INICIO="
                +"to_date('"+novedadModelo.getFechaInicio()+ "','DD/MM/YYYY')"
                + ",FECHA_FIN="+"to_date('" +novedadModelo.getFechaFin()+ "','DD/MM/YYYY')"
                +"where id_novedades= "+ novedadModelo.getIdNovedades();
        conexion.transaccion(sql);
        conexion.cerrar();
    }
    
     public boolean insert(NovedadModelo novedadModelo) throws SQLException{
         
         String sql="INSERT into novedades(IDTRABA,IDTIPO_NOVEDAD,CANT_HORAS,FECHA_INICIO,FECHA_FIN)"
                + " VALUES("+novedadModelo.getIdtrabajador() +","+
                 tipoNovedadMapeo.consultarIDTipoNovedad(novedadModelo.getNombreNovedad())+","+
                 novedadModelo.getCantidadHoras()+",to_date('"+novedadModelo.getFechaInicio()+ "','DD/MM/YYYY'),"+
                 "to_date('" +novedadModelo.getFechaFin()+ "','DD/MM/YYYY'))";
         System.out.println(sql);
         Conexion conexion=new Conexion();
         boolean guardar=conexion.transaccion(sql);
         conexion.cerrar();
         if(guardar){
             return true;
         }else{
            return false;
         }
       }
public NovedadModelo consultarNovedadPorIdNovedad(int idNovedad) throws SQLException{
        NovedadModelo novedades=new NovedadModelo();
        String sql="SELECT * from novedades where id_novedades="+idNovedad;
        Conexion conexion=new Conexion();
        ResultSet resultados = conexion.consulta(sql);
            while (resultados.next()) {
                novedades=new NovedadModelo(resultados.getInt("id_novedades"),resultados.getInt("idtraba"),
                "Alexandra CastañoCONSULTARENTRABAJOR",resultados.getInt("idtipo_novedad"),tipoNovedadMapeo.consultarNombreTipoNovporId( resultados.getInt("idtipo_novedad")),
                        resultados.getInt("cant_horas"), resultados.getString("fecha_inicio"),resultados.getString("fecha_fin"));
            }
            resultados.close();
        return novedades;
    }
     public ArrayList<NovedadModelo> consultarNovedadPorIdTrabajador(int idtraba) throws SQLException{
        ArrayList<NovedadModelo> novedades=new ArrayList<>();
        String sql="SELECT * from novedades where idtraba="+idtraba;
        Conexion conexion=new Conexion();
        ResultSet resultados = conexion.consulta(sql);
            while (resultados.next()) {
                novedades.add(new NovedadModelo(resultados.getInt("id_novedades"),resultados.getInt("idtraba"),
                "Alexandra CastañoCONSULTARENTRABAJOR",resultados.getInt("idtipo_novedad"),tipoNovedadMapeo.consultarNombreTipoNovporId( resultados.getInt("idtipo_novedad")),
                        resultados.getInt("cant_horas"), resultados.getString("fecha_inicio"),resultados.getString("fecha_fin")));
                
              //  System.out.println(novedad);
            }
            resultados.close();
        return novedades;
    }
           
   /*  public String update(){
        String sql="UPDATE ";
    
    }*/

}

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
public class TipoNovedadMapeo {

    public TipoNovedadMapeo() {
    }

    public String consultarNombreTipoNovporId(int id_tiponovedad) throws SQLException{
        Conexion conexion=new Conexion();
        String sql="SELECT NOMBRE_NOVEDAD FROM TIPO_NOVEDAD WHERE ID_TIPONOVEDAD="+id_tiponovedad;
        String nombreTipo="";
        ResultSet resultado=conexion.consulta(sql);
         while (resultado.next()) {
            nombreTipo= resultado.getString("nombre_novedad");
         }
        System.out.println(nombreTipo);    
        conexion.cerrar();
        return nombreTipo;
    }
          public int consultarIDTipoNovedad(String novedad) throws SQLException{
        String sql="SELECT ID_TIPONOVEDAD from TIPO_NOVEDAD where NOMBRE_NOVEDAD= '"+novedad+"'";
       //       System.out.println("tipoNovedad   "+sql);
         Conexion conexion=new Conexion();
         int idNovedad = 0;
            ResultSet resultados = conexion.consulta(sql);
            while (resultados.next()) {
               idNovedad=  resultados.getInt("ID_TIPONOVEDAD");
            }
         resultados.close();
       //  System.out.println("IDNOVEDAD "+idNovedad);
        return idNovedad;
    }
    public ArrayList<String> consultarTiposDeNovedad() throws SQLException{
       ArrayList<String> tipoNovedades=new ArrayList<>();
        String sql="SELECT * from TIPO_NOVEDAD";
         Conexion conexion=new Conexion();
            ResultSet resultados = conexion.consulta(sql);
            while (resultados.next()) {
               tipoNovedades.add(resultados.getString("nombre_novedad"));
            }
           resultados.close();
        return tipoNovedades;
    }
        public ArrayList<String> consultarPorTiposDeNovedad(String simbolo) throws SQLException{
       ArrayList<String> tipoNovedades=new ArrayList<>();
        String sql="SELECT * from TIPO_NOVEDAD where simbolo_novedad='"+simbolo+"'";
         Conexion conexion=new Conexion();
            ResultSet resultados = conexion.consulta(sql);
            while (resultados.next()) {
               tipoNovedades.add(resultados.getString("nombre_novedad"));
            }
           resultados.close();
        return tipoNovedades;
    }

}

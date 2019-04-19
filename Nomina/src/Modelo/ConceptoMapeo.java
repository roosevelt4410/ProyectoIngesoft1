/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Globales.Conexion;

import java.sql.SQLException;

/**
 *
 * @author jonie
 */
public class ConceptoMapeo {
    
        public ConceptoMapeo() {
    
    }
    
    public void delete(){
        Conexion conexion=new Conexion();
        String sql="DELETE ";
        conexion.transaccion(sql);
        conexion.cerrar();
    
    }
        public boolean insert(Conceptos conceptoN) throws SQLException{
         
         String sql="INSERT INTO conceptos(id,nombreconcepto,descripcionconcepto)"
                + " VALUES("+conceptoN.getIdConcepto()+","+"'"+conceptoN.getNombreConcepto()+"'"+","+
                 "'"+conceptoN.getDescripcion()+"'"+")"+";";
         System.out.println(sql);
         Conexion conexion=new Conexion();
         boolean guardar=conexion.transaccion(sql);
         if(guardar){
             return true;
         }else{
            return false;
         }
       }
          
}

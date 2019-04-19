/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import Logica.ConceptoLogica;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jonie
 */
public class ConceptosNomina {

  
    ArrayList <Conceptos> conceptosNom;
    Conceptos con;
    ConceptoMapeo conM;
    ConceptoLogica conL;
    public ConceptosNomina() {
        this.conceptosNom = new ArrayList();
        this.conL=new ConceptoLogica();
    }
    
    public void AgregarDatos(int id,String nombreConcepto, String descripcion) throws SQLException{
        this.con=new Conceptos(id,nombreConcepto,descripcion);
        this.conL.guardarNovedades(id, nombreConcepto, descripcion);
        conceptosNom.add(con);
        
        
    }
    public void imprimir(ArrayList <Conceptos> concepto){
        for(Conceptos con:concepto){
            
            System.out.println("ID:"+con.getIdConcepto());
            System.out.println("Nombre Concepto:"+con.getNombreConcepto());
            System.out.println("Descripcion:"+con.getDescripcion());
        }

    }
    public void imprimirD( ){
     
        System.out.println(conceptosNom.size());
     
    }
    
    
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.ConceptoMapeo;
import Modelo.Conceptos;
import java.sql.SQLException;

/**
 *
 * @author jonie
 */
public class ConceptoLogica {
    
    ConceptoMapeo conM=new ConceptoMapeo();
    public ConceptoLogica() {
    }
    
    
       public boolean guardarNovedades(int id,String nombreC,String Descripcion) throws SQLException{  
        Conceptos con = new Conceptos(id,nombreC,Descripcion);
        boolean resp= conM.insert(con);
        return resp;
    
    }
}


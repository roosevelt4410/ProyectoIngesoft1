/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author jonie
 */
public class Conceptos {
 
    private int idConcepto;
    private String nombreConcepto;
    private String descripcion;
    
    public Conceptos(int idConcepto, String nombreConcepto, String descripcion) {
        this.nombreConcepto = nombreConcepto;
        this.descripcion = descripcion;
        this.idConcepto=idConcepto;
    }

    public String getNombreConcepto() {
        return nombreConcepto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setNombreConcepto(String nombreConcepto) {
        this.nombreConcepto = nombreConcepto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(int idConcepto) {
        this.idConcepto = idConcepto;
    }
  
            
}

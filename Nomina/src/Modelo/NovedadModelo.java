/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Alexandra
 */
public class NovedadModelo {
   ArrayList <NovedadModelo> novedadModelo=new ArrayList<>();
   private int idtrabajador;
   private String nombreTrabajador;
   private int tipoNovedad;
   private String nombreNovedad;
   private int cantidadHoras;
   private String fechaInicio;
   private String fechaFin;
   private int idNovedades;

    public NovedadModelo() {
    }

    public NovedadModelo(int idtrabajador, String nombreNovedad,int cantidadHoras, String fechaInicio, String fechaFin) {
        this.nombreNovedad=nombreNovedad;
        this.idtrabajador=idtrabajador;
        this.cantidadHoras = cantidadHoras;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
   
    }

    public NovedadModelo(int idNovedades,int idtrabajador, String nombreTrabajador,
        int tipoNovedad, String nombreNovedad, int cantidadHoras, String fechaInicio, String fechaFin) {
        this.idNovedades=idNovedades;
        this.idtrabajador = idtrabajador;
        this.nombreTrabajador = nombreTrabajador;
        this.tipoNovedad = tipoNovedad;
        this.nombreNovedad = nombreNovedad;
        this.cantidadHoras = cantidadHoras;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        
    }

    public int getIdtrabajador() {
        return idtrabajador;
    }

    public void setIdtrabajador(int idtrabajador) {
        this.idtrabajador = idtrabajador;
    }

    public String getNombreTrabajador() {
        return nombreTrabajador;
    }

    public void setNombreTrabajador(String nombreTrabajador) {
        this.nombreTrabajador = nombreTrabajador;
    }

    public int getTipoNovedad() {
        return tipoNovedad;
    }

    public void setTipoNovedad(int tipoNovedad) {
        this.tipoNovedad = tipoNovedad;
    }

    public String getNombreNovedad() {
        return nombreNovedad;
    }

    public void setNombreNovedad(String nombreNovedad) {
        this.nombreNovedad = nombreNovedad;
    }

    public int getCantidadHoras() {
        return cantidadHoras;
    }

    public void setCantidadHoras(int cantidadHoras) {
        this.cantidadHoras = cantidadHoras;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getIdNovedades() {
        return idNovedades;
    }

    public void setIdNovedades(int idNovedades) {
        this.idNovedades = idNovedades;
    }


    public ArrayList<NovedadModelo> getNovedadModelo() {
        return novedadModelo;
    }

    public void setNovedadModelo(ArrayList<NovedadModelo> novedadModelo) {
        this.novedadModelo = novedadModelo;
    }

 



    
  
    
}

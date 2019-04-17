/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Logica.TrabajadorLogica;
import Modelo.Cargo;
import Modelo.Trabajador;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 *  * "El sistema debe permitir registrar datos de identificacion, nombres,
 * apellidos,fecha de nacimiento, direccion, telefono,fondo de salud, fondo de
 * pension , fondo de sesantias y ARL. El sistema debe permitir asignarle un
 * cargo a cada trabajador."
 */
public class TrabajadorControl {

    TrabajadorLogica trabajadorL = new TrabajadorLogica();

    public void crearTrabajadorC(long identificacion, String nombre, String apellido, Date fechaN, String direccion, int telefono, long celular, String fPension, String fSesantias, String arl, String estado,Cargo cargo,boolean esCapacitador) {
        trabajadorL.crearTrabajador(identificacion, nombre, apellido, fechaN, direccion, telefono, celular, fPension, fSesantias, arl, estado,cargo,esCapacitador);
    }

    public void controlRetornarIndice(long identificacion, ArrayList<Trabajador> listaTrabajador) {
        trabajadorL.retornaIndice(identificacion, listaTrabajador);
    }

    public void controlActualizarTrabajador(long identificacion, String nombre, String apellido, Date fechaN, String direccion, int telefono, long celular, String fPension, String fSesantias, String arl, String estado, ArrayList<Trabajador> listaTrabajador,Cargo cargo,boolean esCapacitador) {
        trabajadorL.actualizarTrabajador(identificacion, nombre, apellido, fechaN, direccion, telefono, celular, fPension, fSesantias, arl, estado, listaTrabajador,cargo,esCapacitador);
    }

    public void controlBuscarTrabajador(int codigoTrabajador, ArrayList<Trabajador> listaTrabajador) {
        trabajadorL.buscarTrabajador(codigoTrabajador, listaTrabajador);
    }
    public DefaultTableModel listarTrabajadoresControl(){
        return trabajadorL.listarTrabajador();
    }
    public void añadirCargo(long identificacion,ArrayList<Trabajador> listaTrabajador,Cargo cargo){
        
        trabajadorL.añadirCargo(identificacion, listaTrabajador, cargo);
        
    }
    public boolean ControlconvertirenTrueOfalse(int eleccion){
        return eleccion == 1;
    }
    /*
    public void crearTrabajador(Trabajador trabajador) {
        LISTATRABAJADORES.add(trabajador);
    }

    /*
    public void guardarArchivoC() {
        String archivoC = "ArchivoT.txt";
        try {
            FileWriter archivo = new FileWriter(archivoC);
            BufferedWriter constructorArc = new BufferedWriter(archivo);
            for (int i = 0; i < LISTATRABAJADORES.size(); i++) {
                Trabajador trabajador = LISTATRABAJADORES.get(i);
                constructorArc.write("!" + trabajador.getNombre() + "!"
                        + "?" + trabajador.getApellido() + "?"
                        + "*" + trabajador.getDireccion() + "*"
                        + "%" + trabajador.getTelefono() + "%"
                        + "+" + trabajador.getCelular() + "+"
                        + "&" + trabajador.getIdentificacion() + "&"
                        + "¿" + trabajador.getFechaN()+ "¿"
                        + "!" + trabajador.getArl() + "!"
                        + "$" + trabajador.getfPension() + "$"
                        + "¡" + trabajador.getfSesantias() + "¡"
                );
                constructorArc.newLine();
            }
            constructorArc.close();
            archivo.close();

        } catch (IOException e) {
            System.out.println("No  se puede abrir el archivo");

        }

    }

    public void leerArchivoC() {
        String line = null;
        try {
            FileReader archivo = new FileReader("ArchivoT.txt");
            BufferedReader constructorArc = new BufferedReader(archivo);

            while ((line = constructorArc.readLine()) != null) {
                String nombre = line.substring(line.indexOf("!") + 1, line.lastIndexOf("!"));
                String ape = line.substring(line.indexOf("?") + 1, line.lastIndexOf("?"));
                String direc = line.substring(line.indexOf("*") + 1, line.lastIndexOf("*"));
                String fecha = line.substring(line.indexOf("¿") + 1, line.lastIndexOf("¿"));
                String arl = line.substring(line.indexOf("!") + 1, line.lastIndexOf("!"));
                String fpension = line.substring(line.indexOf("$") + 1, line.lastIndexOf("$"));
                String fsesantias = line.substring(line.indexOf("¡") + 1, line.lastIndexOf("¡"));
                long cedula = Long.parseLong(line.substring(line.indexOf("&") + 1, line.lastIndexOf("&")));
                int tel = Integer.parseInt(line.substring(line.indexOf("%") + 1, line.lastIndexOf("%")));
                long cel = Long.parseLong(line.substring(line.indexOf("+") + 1, line.lastIndexOf("+")));

                Trabajador trabajador = new Trabajador(cedula, nombre, ape, fecha, direc, tel, cel, fpension, fsesantias, arl);
                trabajador.crearTrabajador(trabajador);

            }
            constructorArc.close();
            archivo.close();

        } catch (IOException e) {
            System.out.println("No  se puede abrir el archivo");
        } catch (NumberFormatException e) {
            System.out.println("No  se puedo convertir el string");
        }

    }
     */
 /*
    public int retornaIndice(long identificacion, ArrayList<Trabajador> listaTrabajador) {
        int aux = 0;
        for (int i = 0; i < listaTrabajador.size(); i++) {
            Trabajador trabajador = listaTrabajador.get(i);
            if (identificacion == trabajador.getIdentificacion()) {
                aux = i;
            }
        }
        return aux;
    }

    public boolean buscarTrabajador(long cedula, ArrayList<Trabajador> listaTrabajador) {
        boolean auxTrabajador = false;

        for (int i = 0; i < listaTrabajador.size(); i++) {
            Trabajador trabajador = listaTrabajador.get(i);
            if (cedula == trabajador.getIdentificacion()) {
                auxTrabajador = true;
            }
        }
        return auxTrabajador;
    }

    public void actualizarTrabajador(long identificacion, String nombre, String apellido, Date fecha, String direccion, int telefono, long celular, String fPension, String fCesantias, String arl, String estado, ArrayList<Trabajador> listaTrabajador) {
        for (int i = 0; i < listaTrabajador.size(); i++) {
            Trabajador trabajador = listaTrabajador.get(i);
            Trabajador trabajadorModif = new Trabajador(identificacion, nombre, apellido, fecha, direccion, telefono, celular, fPension, fCesantias, arl, estado);
            if (identificacion == trabajador.getIdentificacion()) {
                LISTATRABAJADORES.set(trabajador.retornaIndice(identificacion, listaTrabajador), trabajadorModif);
                break;
            }

        }
    }

    public void añadirPosibleT(long cedula, String nombre, String apellido, String direccion, long celular) {
        Trabajador t = new Trabajador(cedula, nombre, apellido, null, direccion, 0, celular, null, null, null, "Pendiente");
        crearTrabajador(t);
    }

    public DefaultTableModel listarTrabajador() {
        DefaultTableModel tablaTrabajador = new DefaultTableModel();
        tablaTrabajador.addColumn("Cedula");
        tablaTrabajador.addColumn("Nombre");
        tablaTrabajador.addColumn("Apellido");

        for (int i = 0; i < LISTATRABAJADORES.size(); i++) {
            Trabajador trabajador = LISTATRABAJADORES.get(i);
            Object[] filaTabla = new Object[1];
            tablaTrabajador.addRow(filaTabla);
            tablaTrabajador.setValueAt(trabajador.getIdentificacion(), i, 0);
            tablaTrabajador.setValueAt(trabajador.getNombre(), i, 1);
            tablaTrabajador.setValueAt(trabajador.getApellido(), i, 2);
            
            System.out.println(trabajador.getIdentificacion());

        }
        return tablaTrabajador;

    }
    
    public static void main(String[] args) {
       Trabajador t = new Trabajador();
       t.añadirPosibleT(114387568, "Camilo", "Acosta", "Cll 34", 311232015);
        System.out.println(LISTATRABAJADORES.get(0).getTelefono());
    }
     */
}

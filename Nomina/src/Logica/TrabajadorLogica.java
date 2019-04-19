/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.Cargo;
import Modelo.Trabajador;
import static Modelo.Trabajador.LISTATRABAJADORES;
import Modelo.TrabajadorMapeo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import Modelo.TrabajadorMapeo;
import java.util.Calendar;

/**
 *
 *  * "El sistema debe permitir registrar datos de identificacion, nombres,
 * apellidos,fecha de nacimiento, direccion, telefono,fondo de salud, fondo de
 * pension , fondo de sesantias y ARL. El sistema debe permitir asignarle un
 * cargo a cada trabajador."
 */
public class TrabajadorLogica {

    public Trabajador trabajador = new Trabajador();
    public TrabajadorMapeo trabajadorMapeo = new TrabajadorMapeo();

   /*public void crearTrabajador(Trabajador trabajador) {
        trabajador = new Trabajador();
    }*/

    public Trabajador consultaporCedulaGeneral(int cedula) throws SQLException {
        TrabajadorMapeo tbM = new TrabajadorMapeo();
        trabajador = tbM.consultaExisteTrabajador(cedula);
        return trabajador;
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
    public int retornaIndice(long identificacion, ArrayList<Trabajador> listaTrabajador) {
        int aux = 0;
        for (int i = 0; i < listaTrabajador.size(); i++) {
            trabajador = listaTrabajador.get(i);
            if (identificacion == trabajador.getIdentificacion()) {
                aux = i;
            }
        }
        return aux;
    }

    public Trabajador retornarTrabajador(long identificacion) {
        Trabajador t = new Trabajador();
        for (int i = 0; i < LISTATRABAJADORES.size(); i++) {
            trabajador = LISTATRABAJADORES.get(i);
            if (identificacion == trabajador.getIdentificacion()) {
                t = trabajador;
            }
        }
        return t;
    }

    public ArrayList listaMayorga() {
        ArrayList<Trabajador> listM = new ArrayList<>();
        for (int i = 0; i < LISTATRABAJADORES.size(); i++) {
            trabajador = LISTATRABAJADORES.get(i);
            if (trabajador.isEsCapacitador()) {
                listM.add(trabajador);
            }
        }
        return listM;
    }

    public boolean buscarTrabajador(long cedula, ArrayList<Trabajador> listaTrabajador) {
        boolean auxTrabajador = false;

        for (int i = 0; i < listaTrabajador.size(); i++) {
            trabajador = listaTrabajador.get(i);
            if (cedula == trabajador.getIdentificacion()) {
                auxTrabajador = true;
            }
        }
        return auxTrabajador;
    }

    public void actualizarTrabajador(long identificacion, String nombre, String apellido, Date fecha, String direccion, int telefono, long celular, String fPension, String fCesantias, String arl, String estado, ArrayList<Trabajador> listaTrabajador, Cargo cargo, boolean esCapacitador) {
        for (int i = 0; i < listaTrabajador.size(); i++) {
            trabajador = listaTrabajador.get(i);
            Trabajador trabajadorModif = new Trabajador(identificacion, nombre, apellido, fecha, direccion, telefono, celular, fPension, fCesantias, arl, estado, cargo, esCapacitador);
            if (identificacion == trabajador.getIdentificacion()) {
                LISTATRABAJADORES.set(this.retornaIndice(identificacion, listaTrabajador), trabajadorModif);
                break;
            }

        }
    }

    public void añadirCargo(long identificacion, ArrayList<Trabajador> listaTrabajador, Cargo cargo) {
        for (int i = 0; i < listaTrabajador.size(); i++) {
            trabajador = listaTrabajador.get(i);
            Trabajador trabajadorModif = new Trabajador(identificacion, trabajador.getNombre(), trabajador.getApellido(), trabajador.getFechaN(), trabajador.getDireccion(), trabajador.getTelefono(), trabajador.getCelular(), trabajador.getfPension(), trabajador.getfSesantias(), trabajador.getArl(), trabajador.getArl(), cargo, trabajador.isEsCapacitador());
            if (identificacion == trabajador.getIdentificacion()) {
                LISTATRABAJADORES.set(this.retornaIndice(identificacion, listaTrabajador), trabajadorModif);
                break;
            }

        }
    }

    public void añadirPosibleT(long cedula, String nombre, String apellido, String direccion, long celular, boolean esCapacitador) throws SQLException {
        crearTrabajador(cedula, nombre, apellido, null, direccion, 0, celular, null, null, null, "Pendiente", null, esCapacitador);
    }

    public DefaultTableModel listarTrabajador() {

        DefaultTableModel tablaTrabajador = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int filas, int columnas) {

                if (columnas != 0) {
                    return false;
                }
                return true;
            }
        };

        tablaTrabajador.addColumn("Cedula");
        tablaTrabajador.addColumn("Nombre");
        tablaTrabajador.addColumn("Apellido");
        tablaTrabajador.addColumn("Cargo");

        for (int i = 0; i < LISTATRABAJADORES.size(); i++) {
            trabajador = LISTATRABAJADORES.get(i);
            Object[] filaTabla = new Object[1];
            tablaTrabajador.addRow(filaTabla);
            tablaTrabajador.setValueAt(trabajador.getIdentificacion(), i, 0);
            tablaTrabajador.setValueAt(trabajador.getNombre(), i, 1);
            tablaTrabajador.setValueAt(trabajador.getApellido(), i, 2);
            if (!(trabajador.getCargo() == null)) {
                tablaTrabajador.setValueAt(trabajador.getCargo().getNombreCargo(), i, 3);

            } else {
                tablaTrabajador.setValueAt("Sin Asignar", i, 3);
            }

        }
        return tablaTrabajador;

    }

    //-------------------- Mapeo----------------------------
    public void crearCargoTrabajador(Trabajador trabajador) throws SQLException{
        trabajadorMapeo.insertCargoTrabajador(trabajador);
    }
    public void crearTrabajador(long identificacion, String nombre, String apellido, Date fechaN, String direccion, int telefono, long celular, String fPension, String fSesantias, String arl, String estado, Cargo cargo, boolean esCapacitador) throws SQLException {
        Trabajador trabajadorM = new Trabajador();
        trabajador = new Trabajador(identificacion, nombre, apellido, fechaN, direccion, telefono, celular, fPension, fSesantias, arl, estado, cargo, esCapacitador);
        trabajadorM = new Trabajador(identificacion, nombre, apellido, fechaN, direccion, telefono, celular, fPension, fSesantias, arl, estado);
        LISTATRABAJADORES.add(trabajador);
        trabajadorMapeo.insertTrabajador(trabajadorM);
        System.out.println(trabajador.getCargo().getCodigoCargo()+"----------"+trabajador.getIdentificacion());
        trabajadorMapeo.insertCargoTrabajador(trabajador);
        

    }

    public Calendar calendario(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public String cal(Calendar calendar) {
        String calendari;
        calendari = calendar.get(Calendar.DAY_OF_MONTH) + "-" + calendar.get(Calendar.MONTH) + 1 + "-" + calendar.get(Calendar.YEAR);
        return calendari;
    }

    public Trabajador consultaExisteTrabajador(long cedula) throws SQLException {
        return trabajadorMapeo.consultaExisteTrabajador(cedula);
    }
    

    public static void main(String[] args) {

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Vista.VistaAdministradorSistema;
import Control.Control;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANDRES
 */
public class crearUsuario extends javax.swing.JFrame {

    /**
     * Creates new form crearUsuario
     */
    public crearUsuario() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        usuarioNuevo = new javax.swing.JTextField();
        cedulaNueva = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        contrasenaNueva = new javax.swing.JPasswordField();
        Aceptar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        nuevoGestor = new java.awt.Checkbox();
        nuevoAdministrador = new java.awt.Checkbox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Atras = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(0, 0, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ventana para crear usuario nuevo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 250, 30));
        getContentPane().add(usuarioNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 150, 30));
        getContentPane().add(cedulaNueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 150, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cedula Trabajador :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 160, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Contraseña :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 120, 20));
        getContentPane().add(contrasenaNueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 150, 30));

        Aceptar.setBackground(new java.awt.Color(0, 0, 153));
        Aceptar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Aceptar.setForeground(new java.awt.Color(255, 255, 255));
        Aceptar.setText("Aceptar");
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });
        getContentPane().add(Aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 460, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Seleccionar Roles ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 140, 30));

        nuevoGestor.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(nuevoGestor, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, 20, -1));

        nuevoAdministrador.setBackground(new java.awt.Color(0, 0, 0));
        nuevoAdministrador.setName("asdasd"); // NOI18N
        getContentPane().add(nuevoAdministrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, 20, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Administrador Sistema");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 160, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Gestor de nomina");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, 150, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Nombre usuario :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 130, 30));

        Atras.setBackground(new java.awt.Color(0, 0, 102));
        Atras.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Atras.setForeground(new java.awt.Color(255, 255, 255));
        Atras.setText("Atras");
        Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtrasActionPerformed(evt);
            }
        });
        getContentPane().add(Atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoLogin.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        String nuevoUsuario = usuarioNuevo.getText();
        char[] arrayC = contrasenaNueva.getPassword(); 
        String pass = new String(arrayC); 
        String contrasenaNueva = pass;
        String nuevaCedula = cedulaNueva.getText();
        Vector<String> rolesEscogidos = new Vector<String>(2);
        if(nuevoGestor.isEnabled() && nuevoAdministrador.isEnabled()){
            rolesEscogidos.add("Administrador sistema");
            rolesEscogidos.add("Gestor nomina");
        }else if(nuevoGestor.isEnabled() && !nuevoAdministrador.isEnabled()){
            rolesEscogidos.add("Gestor nomina");
        }else if(!nuevoGestor.isEnabled() && nuevoAdministrador.isEnabled()){
            rolesEscogidos.add("Administrador sistema");
        }else{
            //pantalla donde se manda informacion al usuario de que no escogio ningun Rol para el nuevo usuario
        }
        
        Control controlCrearUsuario = new Control(nuevoUsuario,contrasenaNueva,rolesEscogidos,nuevaCedula);
        
        try {
            if(controlCrearUsuario.guardarUsuario()){
                vistaUsuarioCreado usuarioExitoso = new vistaUsuarioCreado();
                usuarioExitoso.setVisible(true);
            }else{
                //error al guardar por algun motivo
            }
                               
                } catch (SQLException ex) {
            Logger.getLogger(crearUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_AceptarActionPerformed

    private void AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasActionPerformed
        this.setVisible(false);
        VistaAdministradorSistema vistaanterior= new VistaAdministradorSistema();
        vistaanterior.setVisible(true);
    }//GEN-LAST:event_AtrasActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JButton Atras;
    private javax.swing.JTextField cedulaNueva;
    private javax.swing.JPasswordField contrasenaNueva;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private java.awt.Checkbox nuevoAdministrador;
    private java.awt.Checkbox nuevoGestor;
    private javax.swing.JTextField usuarioNuevo;
    // End of variables declaration//GEN-END:variables
}

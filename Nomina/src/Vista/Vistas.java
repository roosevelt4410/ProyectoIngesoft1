/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

/**
 *
 * @author Alexandra
 */
public class Vistas {
     public JInternalFrame returnInternal(JPanel panel,String text){
        JInternalFrame interno=new JInternalFrame(text);
        interno.add(panel);
        interno.setClosable(true);
        interno.pack();
        interno.setVisible(true);
        return interno;
    }  
}

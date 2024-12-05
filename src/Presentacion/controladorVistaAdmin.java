/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import Presentacion.vistaAdmin;

public class controladorVistaAdmin implements  ActionListener, MouseListener, KeyListener {

    private vistaAdmin vistaadmin;
    
    public controladorVistaAdmin(vistaAdmin vista){
        this.vistaadmin = vista;
        
        vista.admin.addMouseListener(this);
        vista.alumno.addMouseListener(this);
        vista.libros.addMouseListener(this);
        vista.tablet.addMouseListener(this);
        vista.prestamos.addMouseListener(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vistaadmin.admin) {
            administrador admin = new  administrador();
            vistaadmin.controladorvistas.removeAll();
            vistaadmin.controladorvistas.add(admin).setVisible(true);
        }else if (e.getSource() == vistaadmin.alumno) {
            alumnos alum = new alumnos();
            vistaadmin.controladorvistas.removeAll();
            vistaadmin.controladorvistas.add(alum).setVisible(true);
        }else if (e.getSource() == vistaadmin.libros) {
            libros lib = new libros();
            vistaadmin.controladorvistas.removeAll();
            vistaadmin.controladorvistas.add(lib).setVisible(true);
        }else if (e.getSource() == vistaadmin.tablet) {
            tablet tab = new tablet();
            vistaadmin.controladorvistas.removeAll();
            vistaadmin.controladorvistas.add(tab).setVisible(true);
        }else if (e.getSource() == vistaadmin.prestamos) {
            prestamos pres = new prestamos();
            vistaadmin.controladorvistas.removeAll();
            vistaadmin.controladorvistas.add(pres).setVisible(true);
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}

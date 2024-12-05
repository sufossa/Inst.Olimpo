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

public class controladorVistaRecepcionista implements  ActionListener, MouseListener, KeyListener {

    private vistaRecepcionista vistarecep;
    
    public controladorVistaRecepcionista(vistaRecepcionista vista){
        this.vistarecep = vista;
        
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
        if (e.getSource() == vistarecep.alumno) {
            alumnos alum = new alumnos();
            vistarecep.controladorvistas.removeAll();
            vistarecep.controladorvistas.add(alum).setVisible(true);
        }else if (e.getSource() == vistarecep.libros) {
            libros lib = new libros();
            vistarecep.controladorvistas.removeAll();
            vistarecep.controladorvistas.add(lib).setVisible(true);
        }else if (e.getSource() == vistarecep.tablet) {
            tablet tab = new tablet();
            vistarecep.controladorvistas.removeAll();
            vistarecep.controladorvistas.add(tab).setVisible(true);
        }else if (e.getSource() == vistarecep.prestamos) {
            prestamos pres = new prestamos();
            vistarecep.controladorvistas.removeAll();
            vistarecep.controladorvistas.add(pres).setVisible(true);
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

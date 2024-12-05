package BussinessObject;

import DataAccessObject.AlumnoDAO;
import DataAccessObject.Crud;
import TransferObject.AlumnoDTO;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Alumno{
    
    private AlumnoDTO alumnoDTO;
    private AlumnoDAO alumnoDAO;
    
    public Alumno() {
        alumnoDAO = new AlumnoDAO();
    }
    
    public List<AlumnoDTO> listar() {
        if (alumnoDAO.listar() != null) {
            List<AlumnoDTO> lista = alumnoDAO.listar();
            return lista;
        }
        return null;
    }
    
    public String agregar(String DNI, String CODIGO, String NOMBRE, String TELEFONO, String CORREO, String CARRERA) {      
        String mensaje;
        alumnoDTO = new AlumnoDTO(DNI, CODIGO, NOMBRE,TELEFONO, CORREO, CARRERA);
        if (alumnoDAO.agregar(alumnoDTO)) {
            mensaje = "El alumno se registró exitosamente";
            JOptionPane.showMessageDialog(null, mensaje);
        } else {
           mensaje = "Error , El alumno no se pudo registrar";
           JOptionPane.showMessageDialog(null, mensaje);
        }
        return mensaje;
    }
    
    public String eliminar(int ID_ALUMNO) {
        String mensaje;
        alumnoDTO = new AlumnoDTO(ID_ALUMNO);
        if (alumnoDAO.eliminar(alumnoDTO)) {
            mensaje = "El alumno se eliminó exitosamente";
            JOptionPane.showMessageDialog(null, mensaje);
        } else {
            mensaje = "Problemas para eliminar el alumno";
            JOptionPane.showMessageDialog(null, mensaje);
        }
        return mensaje;
    }
    
    public String actualizar(int ID_ALUMNO, String DNI, String CODIGO, String NOMBRE, String TELEFONO, String CORREO, String CARRERA) {
        String mensaje;
        alumnoDTO = new AlumnoDTO(ID_ALUMNO, DNI, CODIGO, NOMBRE,TELEFONO, CORREO, CARRERA);
        if (alumnoDAO.actualizar(alumnoDTO)) {
            mensaje = "El alumno se actualizó exitosamente";
            JOptionPane.showMessageDialog(null, mensaje);
        } else {
            mensaje = "Error , El alumno no se pudo actualizar";
            JOptionPane.showMessageDialog(null, mensaje);
        }
        return mensaje;
    }
    
    public List<AlumnoDTO> buscarPorDNI(String DNI) {
        if (alumnoDAO.buscarPorDNI(DNI) != null) {
            List<AlumnoDTO> lista = alumnoDAO.buscarPorDNI(DNI);
            return lista;
        }
        return null;
    }
    
    public List<AlumnoDTO> buscarPorCODIGO(String CODIGO) {
        if (alumnoDAO.buscarPorCODIGO(CODIGO) != null) {
            List<AlumnoDTO> lista = alumnoDAO.buscarPorCODIGO(CODIGO);
            return lista;
        }
        return null;
    }
    
    public List<AlumnoDTO> buscarPorNOMBRE(String NOMBRE) {
        if (alumnoDAO.buscarPorNOMBRE(NOMBRE) != null) {
            List<AlumnoDTO> lista = alumnoDAO.buscarPorNOMBRE(NOMBRE);
            return lista;
        }
        return null;
    }
}

package BussinessObject;

import DataAccessObject.AreaDAO;
import TransferObject.AreaDTO;
import java.util.List;
import javax.swing.JOptionPane;

public class Area {
    
    private AreaDTO areaDTO;
    private AreaDAO areaDAO;
    
    public Area() {
        areaDAO = new AreaDAO();
    }
    
    public List<AreaDTO> listar() {
        if (areaDAO.listar() != null) {
            List<AreaDTO> lista = areaDAO.listar();
            return lista;
        }
        return null;
    }
    
    public String agregar(String NOMBRE) {      
        String mensaje;
        areaDTO = new AreaDTO(0, NOMBRE); // ID_AREA is 0 because it's auto-generated by the database
        if (areaDAO.agregar(areaDTO)) {
            mensaje = "El área se registró exitosamente";
            JOptionPane.showMessageDialog(null, mensaje);
        } else {
            mensaje = "Error, el área no se pudo registrar";
            JOptionPane.showMessageDialog(null, mensaje);
        }
        return mensaje;
    }
    
    public String eliminar(int ID_AREA) {
        String mensaje;
        areaDTO = new AreaDTO(ID_AREA);
        if (areaDAO.eliminar(areaDTO)) {
            mensaje = "El área se eliminó exitosamente";
            JOptionPane.showMessageDialog(null, mensaje);
        } else {
            mensaje = "Problemas para eliminar el área";
            JOptionPane.showMessageDialog(null, mensaje);
        }
        return mensaje;
    }
    
    public String actualizar(int ID_AREA, String NOMBRE) {
        String mensaje;
        areaDTO = new AreaDTO(ID_AREA, NOMBRE);
        if (areaDAO.actualizar(areaDTO)) {
            mensaje = "El área se actualizó exitosamente";
            JOptionPane.showMessageDialog(null, mensaje);
        } else {
            mensaje = "Error, el área no se pudo actualizar";
            JOptionPane.showMessageDialog(null, mensaje);
        }
        return mensaje;
    }
    
    public List<AreaDTO> buscarPorNOMBRE(String NOMBRE) {
        if (areaDAO.buscarPorNOMBRE(NOMBRE) != null) {
            List<AreaDTO> lista = areaDAO.buscarPorNOMBRE(NOMBRE);
            return lista;
        }
        return null;
    }
}

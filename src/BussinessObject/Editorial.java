package BussinessObject;

import DataAccessObject.EditorialDAO;
import TransferObject.EditorialDTO;
import java.util.List;
import javax.swing.JOptionPane;

public class Editorial {

    private EditorialDTO editorialDTO;
    private EditorialDAO editorialDAO;

    public Editorial() {
        editorialDTO = new EditorialDTO();
        editorialDAO = new EditorialDAO();
    }

    public List<EditorialDTO> listar() {
        if (editorialDAO.listar() != null) {
            List<EditorialDTO> lista = editorialDAO.listar();
            return lista;
        }
        return null;
    }

    public String agregar(String nombre) {
        String mensaje;
        editorialDTO.setNOMBRE(nombre);
        if (editorialDAO.agregar(editorialDTO)) {
            mensaje = "Editorial agregada exitosamente";
            JOptionPane.showMessageDialog(null, mensaje);
        } else {
            mensaje = "Problemas para agregar la editorial";
            JOptionPane.showMessageDialog(null, mensaje);
        }
        return mensaje;
    }

    public String eliminar(int id) {
        String mensaje;
        editorialDTO.setID_EDITORIAL(id);
        if (editorialDAO.eliminar(editorialDTO)) {
            mensaje = "Editorial eliminada exitosamente";
            JOptionPane.showMessageDialog(null, mensaje);
        } else {
            mensaje = "Problemas para eliminar la editorial";
            JOptionPane.showMessageDialog(null, mensaje);
        }
        return mensaje;
    }

    public String actualizar(int id, String nombre) {
        String mensaje;
        editorialDTO.setID_EDITORIAL(id);
        editorialDTO.setNOMBRE(nombre);
        if (editorialDAO.actualizar(editorialDTO)) {
            mensaje = "Editorial actualizada exitosamente";
            JOptionPane.showMessageDialog(null, mensaje);
        } else {
            mensaje = "Problemas para actualizar la editorial";
            JOptionPane.showMessageDialog(null, mensaje);
        }
        return mensaje;
    }

    public List<EditorialDTO> buscarPorNombre(String nombre) {
        if (editorialDAO.buscarPorNombre(nombre) != null) {
            List<EditorialDTO> lista = editorialDAO.buscarPorNombre(nombre);
            return lista;
        }
        return null;
    }
}

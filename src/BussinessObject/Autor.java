package BussinessObject;

import DataAccessObject.AutorDAO;
import TransferObject.AutorDTO;
import java.util.List;
import javax.swing.JOptionPane;

public class Autor {

    private AutorDTO autorDTO;
    private AutorDAO autorDAO;

    public Autor() {
        autorDTO = new AutorDTO();
        autorDAO = new AutorDAO();
    }

    public List<AutorDTO> listar() {
        if (autorDAO.listar() != null) {
            List<AutorDTO> lista = autorDAO.listar();
            return lista;
        }
        return null;
    }

    public String agregar(String nombre) {
        String mensaje;
        autorDTO.setNOMBRE(nombre);
        if (autorDAO.agregar(autorDTO)) {
            mensaje = "Autor agregado exitosamente";
            JOptionPane.showMessageDialog(null, mensaje);
        } else {
            mensaje = "Problemas para agregar el autor";
            JOptionPane.showMessageDialog(null, mensaje);
        }
        return mensaje;
    }

    public String eliminar(int id) {
        String mensaje;
        autorDTO.setID_AUTOR(id);
        if (autorDAO.eliminar(autorDTO)) {
            mensaje = "Autor eliminado exitosamente";
            JOptionPane.showMessageDialog(null, mensaje);
        } else {
            mensaje = "Problemas para eliminar el autor";
            JOptionPane.showMessageDialog(null, mensaje);
        }
        return mensaje;
    }

    public String actualizar(int id, String nombre) {
        String mensaje;
        autorDTO.setID_AUTOR(id);
        autorDTO.setNOMBRE(nombre);
        if (autorDAO.actualizar(autorDTO)) {
            mensaje = "Autor actualizado exitosamente";
            JOptionPane.showMessageDialog(null, mensaje);
        } else {
            mensaje = "Problemas para actualizar el autor";
            JOptionPane.showMessageDialog(null, mensaje);
        }
        return mensaje;
    }

    public List<AutorDTO> buscarPorNombre(String nombre) {
        if (autorDAO.buscarPorNombre(nombre) != null) {
            List<AutorDTO> lista = autorDAO.buscarPorNombre(nombre);
            return lista;
        }
        return null;
    }
}

package DataAccessObject;

import DataSource.conexion;
import TransferObject.EditorialDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EditorialDAO implements Crud<EditorialDTO> {

    PreparedStatement ps; // insert, update, delete
    ResultSet rs; // select
    conexion conex;

    public EditorialDAO() {
        conex = new conexion();
    }

    @Override
    public List<EditorialDTO> listar() {
        List<EditorialDTO> lista = new ArrayList<>();
        try {
            ps = conex.conectar().prepareStatement("select * from editorial");
            rs = ps.executeQuery();
            while (rs.next()) {
                EditorialDTO e = new EditorialDTO();
                e.setID_EDITORIAL(rs.getInt("ID"));
                e.setNOMBRE(rs.getString("EDITORIAL"));
                lista.add(e);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            conex.cerrarConexion();
        }
        return lista;
    }

    @Override
    public boolean agregar(EditorialDTO e) {
        int r = 0;
        try {
            ps = conex.conectar().prepareStatement("insert into editorial(EDITORIAL) values(?)");
            ps.setString(1, e.getNOMBRE());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            conex.cerrarConexion();
        }
    }

    @Override
    public boolean actualizar(EditorialDTO e) {
        int r = 0;
        try {
            ps = conex.conectar().prepareStatement("update editorial set EDITORIAL=? where ID=?");
            ps.setString(1, e.getNOMBRE());
            ps.setInt(2, e.getID_EDITORIAL());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            conex.cerrarConexion();
        }
    }

    @Override
    public boolean eliminar(EditorialDTO e) {
        int r = 0;
        try {
            ps = conex.conectar().prepareStatement("delete from editorial where ID=?");
            ps.setInt(1, e.getID_EDITORIAL());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            conex.cerrarConexion();
        }
    }



public List<EditorialDTO> buscarPorNombre(String nombre) {
    List<EditorialDTO> lista = new ArrayList<>();
    String sql = "select * from editorial where EDITORIAL like ?";
    try {
        ps = conex.conectar().prepareStatement(sql);
        ps.setString(1, nombre + "%");
        rs = ps.executeQuery();
        while (rs.next()) {
            EditorialDTO editorial = new EditorialDTO();
            editorial.setID_EDITORIAL(rs.getInt("ID"));
            editorial.setNOMBRE(rs.getString("EDITORIAL"));
            lista.add(editorial);
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    } finally {
        conex.cerrarConexion();
    }
    return lista;
}


    @Override
    public EditorialDTO buscar(EditorialDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

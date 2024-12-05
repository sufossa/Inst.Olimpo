package DataAccessObject;

import DataSource.conexion;
import TransferObject.AutorDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutorDAO implements Crud<AutorDTO> {

    PreparedStatement ps; // insert, update, delete
    ResultSet rs; // select
    conexion conex;

    public AutorDAO() {
        conex = new conexion();
    }

    @Override
    public List<AutorDTO> listar() {
        List<AutorDTO> lista = new ArrayList<>();
        try {
            ps = conex.conectar().prepareStatement("select * from autor");
            rs = ps.executeQuery();
            while (rs.next()) {
                AutorDTO autor = new AutorDTO();
                autor.setID_AUTOR(rs.getInt("ID"));
                autor.setNOMBRE(rs.getString("AUTOR"));
                lista.add(autor);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            conex.cerrarConexion();
        }
        return lista;
    }

    @Override
    public boolean agregar(AutorDTO autor) {
        int r = 0;
        try {
            ps = conex.conectar().prepareStatement("insert into autor(AUTOR) values(?)");
            ps.setString(1, autor.getNOMBRE());
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
    public boolean actualizar(AutorDTO autor) {
        int r = 0;
        try {
            ps = conex.conectar().prepareStatement("update autor set AUTOR=? where ID=?");
            ps.setString(1, autor.getNOMBRE());
            ps.setInt(2, autor.getID_AUTOR());
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
    public boolean eliminar(AutorDTO autor) {
        int r = 0;
        try {
            ps = conex.conectar().prepareStatement("delete from autor where ID=?");
            ps.setInt(1, autor.getID_AUTOR());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            conex.cerrarConexion();
        }
    }

    public List<AutorDTO> buscarPorNombre(String nombre) {
        List<AutorDTO> lista = new ArrayList<>();
        String sql = "select * from autor where AUTOR like ?";
        try {
            ps = conex.conectar().prepareStatement(sql);
            ps.setString(1, nombre + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                AutorDTO autor = new AutorDTO();
                autor.setID_AUTOR(rs.getInt("ID"));
                autor.setNOMBRE(rs.getString("AUTOR"));
                lista.add(autor);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            conex.cerrarConexion();
        }
        return lista;
    }

    @Override
    public AutorDTO buscar(AutorDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

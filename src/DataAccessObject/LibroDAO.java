package DataAccessObject;

import DataSource.conexion;
import TransferObject.LibroDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO implements Crud<LibroDTO> {

    PreparedStatement ps; // insert, update, delete
    ResultSet rs; // select
    conexion conex;

    public LibroDAO() {
        conex = new conexion();
    }

    @Override
    public List<LibroDTO> listar() {
        List<LibroDTO> lista = new ArrayList<>();
        try {
            ps = conex.conectar().prepareStatement("SELECT * FROM libro");
            rs = ps.executeQuery();
            while (rs.next()) {
                LibroDTO libro = new LibroDTO();
                libro.setID_LIBRO(rs.getInt("ID"));
                libro.setNOMBRE(rs.getString("NOMBRE"));
                libro.setID_AUTOR(rs.getInt("ID_AUTOR"));
                libro.setID_EDITORIAL(rs.getInt("ID_EDITORIAL"));
                libro.setID_AREA(rs.getInt("ID_AREA"));
                libro.setSTOCK(rs.getString("STOCK"));
                libro.setANOEDICION(rs.getString("FECHA_EDICION"));
                lista.add(libro);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            conex.cerrarConexion();
        }
        return lista;
    }

    @Override
    public boolean agregar(LibroDTO libro) {
        int r = 0;
        try {
            ps = conex.conectar().prepareStatement("INSERT INTO libro (NOMBRE, ID_AUTOR, ID_EDITORIAL, ID_AREA, STOCK, FECHA_EDICION) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, libro.getNOMBRE());
            ps.setInt(2, libro.getID_AUTOR());
            ps.setInt(3, libro.getID_EDITORIAL());
            ps.setInt(4, libro.getID_AREA());
            ps.setString(5, libro.getSTOCK());
            ps.setString(6, libro.getANOEDICION());
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
  public boolean actualizar(LibroDTO libro) {
    conexion conex = new conexion(); // Asumiendo que tienes una clase para gestionar la conexión a la base de datos
    try {
        PreparedStatement ps = conex.conectar().prepareStatement(
            "UPDATE libro SET NOMBRE=?, ID_AUTOR=?, ID_EDITORIAL=?, ID_AREA=?, STOCK=?, FECHA_EDICION=? WHERE ID=?"
        );
        ps.setString(1, libro.getNOMBRE());
        ps.setInt(2, libro.getID_AUTOR());
        ps.setInt(3, libro.getID_EDITORIAL());
        ps.setInt(4, libro.getID_AREA());
        ps.setString(5, libro.getSTOCK());
        ps.setString(6, libro.getANOEDICION());
        ps.setInt(7, libro.getID_LIBRO());
        
        int r = ps.executeUpdate();
        
        // Verifica el resultado de la actualización
        if (r == 1) {
            System.out.println("Libro actualizado correctamente.");
            return true;
        } else {
            System.out.println("No se pudo actualizar el libro.");
            return false;
        }
    } catch (SQLException ex) {
        System.out.println("Error al actualizar el libro: " + ex.getMessage());
        return false;
    } finally {
        conex.cerrarConexion();
    }}



    @Override
    public boolean eliminar(LibroDTO libro) {
        int r = 0;
        try {
            ps = conex.conectar().prepareStatement("DELETE FROM libro WHERE ID=?");
            ps.setInt(1, libro.getID_LIBRO());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            conex.cerrarConexion();
        }
    }

public List<LibroDTO> buscarPorNombre(String nombre) {
    List<LibroDTO> lista = new ArrayList<>();
    String sql = "SELECT * FROM libro WHERE NOMBRE LIKE ?";
    try {
        ps = conex.conectar().prepareStatement(sql);
        ps.setString(1, nombre + "%");
        rs = ps.executeQuery();
        while (rs.next()) {
            LibroDTO libro = new LibroDTO();
            libro.setID_LIBRO(rs.getInt("ID"));
            libro.setNOMBRE(rs.getString("NOMBRE"));
            libro.setID_AUTOR(rs.getInt("ID_AUTOR"));
            libro.setID_EDITORIAL(rs.getInt("ID_EDITORIAL"));
            libro.setID_AREA(rs.getInt("ID_AREA"));
            libro.setSTOCK(rs.getString("STOCK"));
            libro.setANOEDICION(rs.getString("FECHA_EDICION"));
            lista.add(libro);
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    } finally {
        conex.cerrarConexion();
    }
    return lista;
}

  
    public List<LibroDTO> buscarPorArea(int idArea) {
        List<LibroDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM libro WHERE ID_AREA = ?";
        try {
            ps = conex.conectar().prepareStatement(sql);
            ps.setInt(1, idArea);
            rs = ps.executeQuery();
            while (rs.next()) {
                LibroDTO libro = new LibroDTO();
                libro.setID_LIBRO(rs.getInt("ID"));
                libro.setNOMBRE(rs.getString("NOMBRE"));
                libro.setID_AUTOR(rs.getInt("ID_AUTOR"));
                libro.setID_EDITORIAL(rs.getInt("ID_EDITORIAL"));
                libro.setID_AREA(rs.getInt("ID_AREA"));
                libro.setSTOCK(rs.getString("STOCK"));
                libro.setANOEDICION(rs.getString("FECHA_EDICION"));
                lista.add(libro);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            conex.cerrarConexion();
        }
        return lista;
    }

    public List<LibroDTO> buscarPorEditorial(int idEditorial) {
    List<LibroDTO> lista = new ArrayList<>();
    String sql = "SELECT * FROM libro WHERE ID_EDITORIAL = ?";
    try {
        ps = conex.conectar().prepareStatement(sql);
        ps.setInt(1, idEditorial);
        rs = ps.executeQuery();
        while (rs.next()) {
            LibroDTO libro = new LibroDTO();
            libro.setID_LIBRO(rs.getInt("ID"));
            libro.setNOMBRE(rs.getString("NOMBRE"));
            libro.setID_AUTOR(rs.getInt("ID_AUTOR"));
            libro.setID_EDITORIAL(rs.getInt("ID_EDITORIAL"));
            libro.setID_AREA(rs.getInt("ID_AREA"));
            libro.setSTOCK(rs.getString("STOCK"));
            libro.setANOEDICION(rs.getString("FECHA_EDICION"));
            lista.add(libro);
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    } finally {
        conex.cerrarConexion();
    }
    return lista;
}

    @Override
    public LibroDTO buscar(LibroDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

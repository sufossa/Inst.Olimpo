package DataAccessObject;

import DataSource.conexion;
import TransferObject.AlumnoDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO implements Crud<AlumnoDTO> {

    PreparedStatement ps;//insert , update, delete
    ResultSet rs; //select
    conexion conex;

    public AlumnoDAO() {
        conex = new conexion();
    }

    @Override
    public List<AlumnoDTO> listar() {
        List<AlumnoDTO> lista = new ArrayList<>();
        try {
            ps = conex.conectar().prepareStatement("select * from alumno");
            rs = ps.executeQuery();
            while (rs.next()) {
                AlumnoDTO t = new AlumnoDTO();
                t.setID_ALUMNO(rs.getInt(1));
                t.setDNI(rs.getString(2));
                t.setCODIGO(rs.getString(3));
                t.setNOMBRE(rs.getString(4));
                t.setTELEFONO(rs.getString(5));
                t.setCORREO(rs.getString(6));
                t.setCARRERA(rs.getString(7));
                lista.add(t);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conex.cerrarConexion();
        }
        return lista;
    }

    @Override
    public boolean agregar(AlumnoDTO t) {

        int r = 0;
        try {
            ps = conexion.conectar().prepareStatement("insert into alumno(DNI,CODIGO,NOMBRE,TELEFONO,CORREO,CARRERA) values(?,?,?,?,?,?)");
            ps.setString(1, t.getDNI());
            ps.setString(2, t.getCODIGO());
            ps.setString(3, t.getNOMBRE());
            ps.setString(4, t.getTELEFONO());
            ps.setString(5, t.getCORREO());
            ps.setString(6, t.getCARRERA());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            return false;
        } finally {
            conexion.cerrarConexion();
        }
    }

    @Override
    public boolean actualizar(AlumnoDTO t) {
        int r = 0;
        try {
            ps = conexion.conectar().prepareStatement("update alumno set DNI=?,CODIGO=?,NOMBRE=?,TELEFONO=?,CORREO=?,CARRERA=? where ID=?");
            ps.setString(1, t.getDNI());
            ps.setString(2, t.getCODIGO());
            ps.setString(3, t.getNOMBRE());
            ps.setString(4, t.getTELEFONO());
            ps.setString(5, t.getCORREO());
            ps.setString(6, t.getCARRERA());
            ps.setInt(7, t.getID_ALUMNO());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            return false;
        } finally {
            conexion.cerrarConexion();
        }
    }

    @Override
    public boolean eliminar(AlumnoDTO t) {
        int r = 0;
        try {
            ps = conexion.conectar().prepareStatement("delete from alumno where ID=?");
            ps.setInt(1, t.getID_ALUMNO());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            return false;
        } finally {
            conexion.cerrarConexion();
        }
    }

    @Override
    public AlumnoDTO buscar(AlumnoDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<AlumnoDTO> buscarPorDNI(String DNI) {
        List<AlumnoDTO> lista = new ArrayList<>();

        String sql = "select * from alumno where DNI like ?";
        try {
            ps = conex.conectar().prepareStatement(sql);
            ps.setString(1, DNI + "%");
            AlumnoDTO a;
            rs = ps.executeQuery();
            while (rs.next()) {
                a = new AlumnoDTO();
                a.setID_ALUMNO(rs.getInt(1));
                a.setDNI(rs.getString(2));
                a.setCODIGO(rs.getString(3));
                a.setNOMBRE(rs.getString(4));
                a.setTELEFONO(rs.getString(5));
                a.setCORREO(rs.getString(6));
                a.setCARRERA(rs.getString(7));
                lista.add(a);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            conex.cerrarConexion();
            return lista;
        }
    }
    
    public List<AlumnoDTO> buscarPorCODIGO(String CODIGO) {
        List<AlumnoDTO> lista = new ArrayList<>();

        String sql = "select * from alumno where CODIGO like ?";
        try {
            ps = conex.conectar().prepareStatement(sql);
            ps.setString(1, CODIGO + "%");
            AlumnoDTO a;
            rs = ps.executeQuery();
            while (rs.next()) {
                a = new AlumnoDTO();
                a.setID_ALUMNO(rs.getInt(1));
                a.setDNI(rs.getString(2));
                a.setCODIGO(rs.getString(3));
                a.setNOMBRE(rs.getString(4));
                a.setTELEFONO(rs.getString(5));
                a.setCORREO(rs.getString(6));
                a.setCARRERA(rs.getString(7));
                lista.add(a);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            conex.cerrarConexion();
            return lista;
        }
    }
    
    public List<AlumnoDTO> buscarPorNOMBRE(String NOMBRE) {
        List<AlumnoDTO> lista = new ArrayList<>();

        String sql = "select * from alumno where NOMBRE like ?";
        try {
            ps = conex.conectar().prepareStatement(sql);
            ps.setString(1, NOMBRE + "%");
            AlumnoDTO a;
            rs = ps.executeQuery();
            while (rs.next()) {
                a = new AlumnoDTO();
                a.setID_ALUMNO(rs.getInt(1));
                a.setDNI(rs.getString(2));
                a.setCODIGO(rs.getString(3));
                a.setNOMBRE(rs.getString(4));
                a.setTELEFONO(rs.getString(5));
                a.setCORREO(rs.getString(6));
                a.setCARRERA(rs.getString(7));
                lista.add(a);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            conex.cerrarConexion();
            return lista;
        }
    }
}

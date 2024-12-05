package DataAccessObject;

import DataSource.conexion;
import TransferObject.AreaDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AreaDAO implements Crud<AreaDTO> {

    PreparedStatement ps; // insert, update, delete
    ResultSet rs; // select
    conexion conex;

    public AreaDAO() {
        conex = new conexion();
    }

    @Override
    public List<AreaDTO> listar() {
        List<AreaDTO> lista = new ArrayList<>();
        try {
            ps = conex.conectar().prepareStatement("select * from area");
            rs = ps.executeQuery();
            while (rs.next()) {
                AreaDTO a = new AreaDTO();
                a.setID_AREA(rs.getInt("ID"));
                a.setNOMBRE(rs.getString("AREA"));
                lista.add(a);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conex.cerrarConexion();
        }
        return lista;
    }

  @Override
    public boolean agregar(AreaDTO a) {
        int r = 0;
        try {
            ps = conex.conectar().prepareStatement("insert into area(AREA) values(?)");
            ps.setString(1, a.getNOMBRE());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            return false;
        } finally {
            conex.cerrarConexion();
        }
    }

    @Override
public boolean actualizar(AreaDTO a) {
    int r = 0;
    try {
        ps = conex.conectar().prepareStatement("update area set AREA=? where ID=?");
        ps.setString(1, a.getNOMBRE());
        ps.setInt(2, a.getID_AREA());
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
public boolean eliminar(AreaDTO a) {
    int r = 0;
    try {
        ps = conex.conectar().prepareStatement("delete from area where ID=?");
        ps.setInt(1, a.getID_AREA());
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
    public AreaDTO buscar(AreaDTO a) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<AreaDTO> buscarPorNOMBRE(String NOMBRE) {
        List<AreaDTO> lista = new ArrayList<>();
        String sql = "select * from area where AREA like ?";
        try {
            ps = conex.conectar().prepareStatement(sql);
            ps.setString(1, NOMBRE + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                AreaDTO area = new AreaDTO();
                area.setID_AREA(rs.getInt("ID"));
                area.setNOMBRE(rs.getString("AREA"));
                lista.add(area);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conex.cerrarConexion();
        }
        return lista;
    }
}

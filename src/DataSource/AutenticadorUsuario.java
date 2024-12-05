package DataSource;

import DataSource.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Presentacion.vistaAdmin;
import Presentacion.vistaRecepcionista;

public class AutenticadorUsuario {

    public static boolean autenticacionExitosa;

    public static int autenticarUsuario(String usuario, String clave) {
        Connection conn = null;
        int idRecepcionista = -1; // Valor por defecto si no se encuentra ningún recepcionista

        try {
            conn = conexion.conectar(); // Establecer conexión
            String query = "SELECT ID, NOMBRE FROM usuario WHERE USUARIO = ? AND CLAVE = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, usuario);
            statement.setString(2, clave);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                idRecepcionista = rs.getInt("ID");
                String nombreCompleto = rs.getString("NOMBRE");
                JOptionPane.showMessageDialog(null, "¡Bienvenido, " + nombreCompleto + "!", "Instituto Olimpo", JOptionPane.INFORMATION_MESSAGE);
                autenticacionExitosa = true;

                // Verificar si el nombre es "Maria" y la contraseña es "123"
                if (usuario.equalsIgnoreCase("Juan2024") && clave.equals("AJuanSie")) {
                     vistaAdmin.main(null);
                } else {
                     vistaRecepcionista.main(null);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                autenticacionExitosa = false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos: " + e.getMessage());
        } finally {
            if (conn != null) {
                conexion.cerrarConexion(); // Cerrar conexión
            }
        }

        return idRecepcionista;
    }

}

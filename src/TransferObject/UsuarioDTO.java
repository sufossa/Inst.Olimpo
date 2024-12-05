package TransferObject;

public class UsuarioDTO {

    private int ID_USUARIO;
    private String USUARIO;
    private String NOMBRE;
    private String CORREO;
    private String CLAVE;

    public UsuarioDTO() {
    }

    public UsuarioDTO(int ID_USUARIO, String USUARIO, String NOMBRE, String CORREO, String CLAVE) {
        this.ID_USUARIO = ID_USUARIO;
        this.USUARIO = USUARIO;
        this.NOMBRE = NOMBRE;
        this.CORREO = CORREO;
        this.CLAVE = CLAVE;
    }

    public int getID_USUARIO() {
        return ID_USUARIO;
    }

    public void setID_USUARIO(int ID_USUARIO) {
        this.ID_USUARIO = ID_USUARIO;
    }

    public String getUSUARIO() {
        return USUARIO;
    }

    public void setUSUARIO(String USUARIO) {
        this.USUARIO = USUARIO;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getCORREO() {
        return CORREO;
    }

    public void setCORREO(String CORREO) {
        this.CORREO = CORREO;
    }

    public String getCLAVE() {
        return CLAVE;
    }

    public void setCLAVE(String CLAVE) {
        this.CLAVE = CLAVE;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" + "ID_USUARIO=" + ID_USUARIO + ", USUARIO=" + USUARIO + ", NOMBRE=" + NOMBRE + ", CORREO=" + CORREO + ", CLAVE=" + CLAVE + '}';
    }
}

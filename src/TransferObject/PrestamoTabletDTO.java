package TransferObject;

public class PrestamoTabletDTO {
    
    private int ID_PRTABLET;
    private int ID_USUARIO;
    private int ID_ESTUDIANTE;
    private String CODIGO;
    private int ID_TABLET;
    private String N_SERIE;
    private String CANTIDAD;
    private String F_PRESTAMO;
    private String F_DEVOLUCION;
    private String ESTADO;

    public PrestamoTabletDTO() {
    }

    public PrestamoTabletDTO(int ID_PRTABLET, int ID_USUARIO, int ID_ESTUDIANTE, String CODIGO, int ID_TABLET, String N_SERIE, String CANTIDAD, String F_PRESTAMO, String F_DEVOLUCION, String ESTADO) {
        this.ID_PRTABLET = ID_PRTABLET;
        this.ID_USUARIO = ID_USUARIO;
        this.ID_ESTUDIANTE = ID_ESTUDIANTE;
        this.CODIGO = CODIGO;
        this.ID_TABLET = ID_TABLET;
        this.N_SERIE = N_SERIE;
        this.CANTIDAD = CANTIDAD;
        this.F_PRESTAMO = F_PRESTAMO;
        this.F_DEVOLUCION = F_DEVOLUCION;
        this.ESTADO = ESTADO;
    }

    public int getID_PRTABLET() {
        return ID_PRTABLET;
    }

    public void setID_PRTABLET(int ID_PRTABLET) {
        this.ID_PRTABLET = ID_PRTABLET;
    }

    public int getID_USUARIO() {
        return ID_USUARIO;
    }

    public void setID_USUARIO(int ID_USUARIO) {
        this.ID_USUARIO = ID_USUARIO;
    }

    public int getID_ESTUDIANTE() {
        return ID_ESTUDIANTE;
    }

    public void setID_ESTUDIANTE(int ID_ESTUDIANTE) {
        this.ID_ESTUDIANTE = ID_ESTUDIANTE;
    }

    public String getCODIGO() {
        return CODIGO;
    }

    public void setCODIGO(String CODIGO) {
        this.CODIGO = CODIGO;
    }

    public int getID_TABLET() {
        return ID_TABLET;
    }

    public void setID_TABLET(int ID_TABLET) {
        this.ID_TABLET = ID_TABLET;
    }

    public String getN_SERIE() {
        return N_SERIE;
    }

    public void setN_SERIE(String N_SERIE) {
        this.N_SERIE = N_SERIE;
    }

    public String getCANTIDAD() {
        return CANTIDAD;
    }

    public void setCANTIDAD(String CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }

    public String getF_PRESTAMO() {
        return F_PRESTAMO;
    }

    public void setF_PRESTAMO(String F_PRESTAMO) {
        this.F_PRESTAMO = F_PRESTAMO;
    }

    public String getF_DEVOLUCION() {
        return F_DEVOLUCION;
    }

    public void setF_DEVOLUCION(String F_DEVOLUCION) {
        this.F_DEVOLUCION = F_DEVOLUCION;
    }

    public String getESTADO() {
        return ESTADO;
    }

    public void setESTADO(String ESTADO) {
        this.ESTADO = ESTADO;
    }

    @Override
    public String toString() {
        return "PrestamoTabletDTO{" + "ID_PRTABLET=" + ID_PRTABLET + ", ID_USUARIO=" + ID_USUARIO + ", ID_ESTUDIANTE=" + ID_ESTUDIANTE + ", CODIGO=" + CODIGO + ", ID_TABLET=" + ID_TABLET + ", N_SERIE=" + N_SERIE + ", CANTIDAD=" + CANTIDAD + ", F_PRESTAMO=" + F_PRESTAMO + ", F_DEVOLUCION=" + F_DEVOLUCION + ", ESTADO=" + ESTADO + '}';
    }
}

package TransferObject;

public class PrestamoLibroDTO {
    
    private int ID_PRLIBRO;
    private int ID_USUARIO;
    private int ID_ESTUDIANTE;
    private String CODIGO;
    private int ID_LIBRO;
    private String AREA;
    private String CANTIDAD;
    private String F_PRESTAMO;
    private String F_DEVOLUCION;
    private String ESTADO;

    public PrestamoLibroDTO() {
    }

    public PrestamoLibroDTO(int ID_PRLIBRO, int ID_USUARIO, int ID_ESTUDIANTE, String CODIGO, int ID_LIBRO, String AREA, String CANTIDAD, String F_PRESTAMO, String F_DEVOLUCION, String ESTADO) {
        this.ID_PRLIBRO = ID_PRLIBRO;
        this.ID_USUARIO = ID_USUARIO;
        this.ID_ESTUDIANTE = ID_ESTUDIANTE;
        this.CODIGO = CODIGO;
        this.ID_LIBRO = ID_LIBRO;
        this.AREA = AREA;
        this.CANTIDAD = CANTIDAD;
        this.F_PRESTAMO = F_PRESTAMO;
        this.F_DEVOLUCION = F_DEVOLUCION;
        this.ESTADO = ESTADO;
    }

    public int getID_PRLIBRO() {
        return ID_PRLIBRO;
    }

    public void setID_PRLIBRO(int ID_PRLIBRO) {
        this.ID_PRLIBRO = ID_PRLIBRO;
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

    public int getID_LIBRO() {
        return ID_LIBRO;
    }

    public void setID_LIBRO(int ID_LIBRO) {
        this.ID_LIBRO = ID_LIBRO;
    }

    public String getAREA() {
        return AREA;
    }

    public void setAREA(String AREA) {
        this.AREA = AREA;
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
        return "PrestamoLibroDTO{" + "ID_PRLIBRO=" + ID_PRLIBRO + ", ID_USUARIO=" + ID_USUARIO + ", ID_ESTUDIANTE=" + ID_ESTUDIANTE + ", CODIGO=" + CODIGO + ", ID_LIBRO=" + ID_LIBRO + ", AREA=" + AREA + ", CANTIDAD=" + CANTIDAD + ", F_PRESTAMO=" + F_PRESTAMO + ", F_DEVOLUCION=" + F_DEVOLUCION + ", ESTADO=" + ESTADO + '}';
    } 
}

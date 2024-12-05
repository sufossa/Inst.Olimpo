package TransferObject;

public class AlumnoDTO {
    
    private int ID_ALUMNO;
    private String DNI;
    private String CODIGO;
    private String NOMBRE;
    private String TELEFONO;
    private String CORREO;
    private String CARRERA;

    public AlumnoDTO() {
    }

    public AlumnoDTO(int ID_ALUMNO, String DNI, String CODIGO, String NOMBRE, String TELEFONO, String CORREO, String CARRERA) {
        this.ID_ALUMNO = ID_ALUMNO;
        this.DNI = DNI;
        this.CODIGO = CODIGO;
        this.NOMBRE = NOMBRE;
        this.TELEFONO = TELEFONO;
        this.CORREO = CORREO;
        this.CARRERA = CARRERA;
    }

    public AlumnoDTO(String DNI, String CODIGO, String NOMBRE, String TELEFONO, String CORREO, String CARRERA) {
        this.DNI = DNI;
        this.CODIGO = CODIGO;
        this.NOMBRE = NOMBRE;
        this.TELEFONO = TELEFONO;
        this.CORREO = CORREO;
        this.CARRERA = CARRERA;
    }
    
    public AlumnoDTO(int ID_ALUMNO) {
        this.ID_ALUMNO = ID_ALUMNO;
    }
    
    public int getID_ALUMNO() {
        return ID_ALUMNO;
    }

    public void setID_ALUMNO(int ID_ALUMNO) {
        this.ID_ALUMNO = ID_ALUMNO;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getCODIGO() {
        return CODIGO;
    }

    public void setCODIGO(String CODIGO) {
        this.CODIGO = CODIGO;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getTELEFONO() {
        return TELEFONO;
    }

    public void setTELEFONO(String TELEFONO) {
        this.TELEFONO = TELEFONO;
    }

    public String getCORREO() {
        return CORREO;
    }

    public void setCORREO(String CORREO) {
        this.CORREO = CORREO;
    }

    public String getCARRERA() {
        return CARRERA;
    }

    public void setCARRERA(String CARRERA) {
        this.CARRERA = CARRERA;
    }

    @Override
    public String toString() {
        return "AlumnoDTO{" + "ID_ALUMNO=" + ID_ALUMNO + ", DNI=" + DNI + ", CODIGO=" + CODIGO + ", NOMBRE=" + NOMBRE + ", TELEFONO=" + TELEFONO + ", CORREO=" + CORREO + ", CARRERA=" + CARRERA + '}';
    }   
}

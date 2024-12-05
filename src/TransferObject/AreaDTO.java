package TransferObject;

public class AreaDTO {
    
    private int ID_AREA;
    private String NOMBRE;

    public AreaDTO() {
    }

    public AreaDTO(int ID_AREA, String NOMBRE) {
        this.ID_AREA = ID_AREA;
        this.NOMBRE = NOMBRE;
    }

public AreaDTO(int ID_AREA) {
    this.ID_AREA = ID_AREA;
    this.NOMBRE = NOMBRE; // Otra inicialización que tenga sentido para tu caso
}


    public int getID_AREA() {
        return ID_AREA;
    }

    public void setID_AREA(int ID_AREA) {
        this.ID_AREA = ID_AREA;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    @Override
    public String toString() {
        return "AreaDTO{" + "ID_AREA=" + ID_AREA + ", NOMBRE=" + NOMBRE + '}';
    }

    public Object getID_EDITORIAL() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}

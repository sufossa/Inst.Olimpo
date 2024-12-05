package TransferObject;

public class LibroDTO {
    
    private int ID_LIBRO;
    private String NOMBRE;
    private int ID_AUTOR;
    private int ID_EDITORIAL;
    private int ID_AREA;
    private String STOCK;
    private String ANOEDICION;

    public LibroDTO() {
    }

    public LibroDTO(int ID_LIBRO, String NOMBRE, int ID_AUTOR, int ID_EDITORIAL, int ID_AREA, String STOCK, String ANOEDICION) {
        this.ID_LIBRO = ID_LIBRO;
        this.NOMBRE = NOMBRE;
        this.ID_AUTOR = ID_AUTOR;
        this.ID_EDITORIAL = ID_EDITORIAL;
        this.ID_AREA = ID_AREA;
        this.STOCK = STOCK;
        this.ANOEDICION = ANOEDICION;
    }

    public int getID_LIBRO() {
        return ID_LIBRO;
    }

    public void setID_LIBRO(int ID_LIBRO) {
        this.ID_LIBRO = ID_LIBRO;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public int getID_AUTOR() {
        return ID_AUTOR;
    }

    public void setID_AUTOR(int ID_AUTOR) {
        this.ID_AUTOR = ID_AUTOR;
    }

    public int getID_EDITORIAL() {
        return ID_EDITORIAL;
    }

    public void setID_EDITORIAL(int ID_EDITORIAL) {
        this.ID_EDITORIAL = ID_EDITORIAL;
    }

    public int getID_AREA() {
        return ID_AREA;
    }

    public void setID_AREA(int ID_AREA) {
        this.ID_AREA = ID_AREA;
    }

    public String getSTOCK() {
        return STOCK;
    }

    public void setSTOCK(String STOCK) {
        this.STOCK = STOCK;
    }

    public String getANOEDICION() {
        return ANOEDICION;
    }

    public void setANOEDICION(String ANOEDICION) {
        this.ANOEDICION = ANOEDICION;
    }

    @Override
    public String toString() {
        return "LibroDTO{" + "ID_LIBRO=" + ID_LIBRO + ", NOMBRE=" + NOMBRE + ", ID_AUTOR=" + ID_AUTOR + ", ID_EDITORIAL=" + ID_EDITORIAL + ", ID_AREA=" + ID_AREA + ", STOCK=" + STOCK + ", ANOEDICION=" + ANOEDICION + '}';
    } 

    public boolean actualizar(LibroDTO libro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

public void setFECHA_EDICION(String fecha_edicion) {
    this.ANOEDICION = fecha_edicion;
}

}

package TransferObject;

public class AutorDTO {
    
    private int ID_AUTOR;
    private String NOMBRE;

    public AutorDTO() {
    }

    public AutorDTO(int ID_AUTOR, String NOMBRE) {
        this.ID_AUTOR = ID_AUTOR;
        this.NOMBRE = NOMBRE;
    }

    public int getID_AUTOR() {
        return ID_AUTOR;
    }

    public void setID_AUTOR(int ID_AUTOR) {
        this.ID_AUTOR = ID_AUTOR;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    @Override
    public String toString() {
        return "AutorDTO{" + "ID_AUTOR=" + ID_AUTOR + ", NOMBRE=" + NOMBRE + '}';
    }
    
    
}

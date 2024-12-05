package TransferObject;

public class EditorialDTO {
    
    private int ID_EDITORIAL;
    private String NOMBRE;

    public EditorialDTO() {
    }

    public EditorialDTO(int ID_EDITORIAL, String NOMBRE) {
        this.ID_EDITORIAL = ID_EDITORIAL;
        this.NOMBRE = NOMBRE;
    }

public EditorialDTO(int ID_EDITORIAL) {
    this.ID_EDITORIAL = ID_EDITORIAL;
    this.NOMBRE = NOMBRE; // Otra inicialización que tenga sentido para tu caso
}


    public int getID_EDITORIAL() {
        return ID_EDITORIAL;
    }

    public void setID_EDITORIAL(int ID_EDITORIAL) {
        this.ID_EDITORIAL = ID_EDITORIAL;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    @Override
    public String toString() {
        return "EDITORIALDTO{" + "ID_EDITORIAL=" + ID_EDITORIAL + ", NOMBRE=" + NOMBRE + '}';
    }
    
    
}


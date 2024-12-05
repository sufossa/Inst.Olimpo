package TransferObject;

public class TabletDTO {
    
    private int ID_TABLET;
    private String N_SERIE;
    private String MODELO;
    private String MARCA;
    private String ESTADO;

    public TabletDTO() {
    }

    public TabletDTO(int ID_TABLET, String N_SERIE, String MODELO, String MARCA, String ESTADO) {
        this.ID_TABLET = ID_TABLET;
        this.N_SERIE = N_SERIE;
        this.MODELO = MODELO;
        this.MARCA = MARCA;
        this.ESTADO = ESTADO;
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

    public String getMODELO() {
        return MODELO;
    }

    public void setMODELO(String MODELO) {
        this.MODELO = MODELO;
    }

    public String getMARCA() {
        return MARCA;
    }

    public void setMARCA(String MARCA) {
        this.MARCA = MARCA;
    }

    public String getESTADO() {
        return ESTADO;
    }

    public void setESTADO(String ESTADO) {
        this.ESTADO = ESTADO;
    }

    @Override
    public String toString() {
        return "TabletDTO{" + "ID_TABLET=" + ID_TABLET + ", N_SERIE=" + N_SERIE + ", MODELO=" + MODELO + ", MARCA=" + MARCA + ", ESTADO=" + ESTADO + '}';
    }
}

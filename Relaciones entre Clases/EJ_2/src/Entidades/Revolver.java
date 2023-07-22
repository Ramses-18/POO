package Entidades;

public class Revolver {
        
    private Integer posTambor;
    private Integer posAgua;

    public Revolver() {
    }

    public Revolver(Integer posTambor, Integer posAgua) {
        this.posTambor = posTambor;
        this.posAgua = posAgua;
    }

    public Integer getPosTambor() {
        return posTambor;
    }

    public void setPosTambor(Integer posTambor) {
        this.posTambor = posTambor;
    }

    public Integer getPosAgua() {
        return posAgua;
    }

    public void setPosAgua(Integer posAgua) {
        this.posAgua = posAgua;
    }
    
    @Override
    public String toString() {
        return "RevolverDeAgua{" + "posTambor=" + posTambor + ", posAgua=" + posAgua + '}';
    }
    
    
    
}

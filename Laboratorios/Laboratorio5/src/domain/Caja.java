package domain;

public class Caja {
    private boolean enDestino;

    public Caja() {
        this.enDestino = false;
    }

    public boolean isEnDestino() {
        return enDestino;
    }

    public void setEnDestino(boolean enDestino) {
        this.enDestino = enDestino;
    }
}
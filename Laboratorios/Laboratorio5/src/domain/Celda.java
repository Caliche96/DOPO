package domain;

public class Celda {
    private TipoCelda tipo;
    private Caja caja;
    private boolean tieneJugador;

    public Celda(TipoCelda tipo) {
        this.tipo = tipo;
        this.caja = null;
        this.tieneJugador = false;
    }

    public TipoCelda getTipo() {
        return tipo;
    }

    public void setTipo(TipoCelda tipo) {
        this.tipo = tipo;
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }

    /**
     * @return
     * 
     */
    public boolean tieneCaja() {
        return this.caja != null;
    }

    public boolean tieneJugador() {
        return this.tieneJugador;
    }

    public void setTieneJugador(boolean tieneJugador) {
        this.tieneJugador = tieneJugador;
    }

    public boolean esVacia() {
        return this.tipo == TipoCelda.VACIO;
    }

    public boolean esPared() {
        return this.tipo == TipoCelda.PARED;
    }

    public boolean esDestino() {
        return this.tipo == TipoCelda.DESTINO;
    }

    public boolean estaLibre() {
        return !esPared() && !tieneCaja() && !tieneJugador();
    }
}

package domain;

public class EasySokoban {
    private Tablero tablero;

    public EasySokoban() {
        this.tablero = new Tablero(9, 7);
    }

    public EasySokoban(int alto, int ancho) {
        this.tablero = new Tablero(alto, ancho);
    }

    public Tablero getTablero() {
        return this.tablero;
    }

    public void moverArriba() {
        tablero.moverJugador(-1, 0);
    }

    public void moverAbajo() {
        tablero.moverJugador(1, 0);
    }

    public void moverIzquierda() {
        tablero.moverJugador(0, -1);
    }

    public void moverDerecha() {
        tablero.moverJugador(0, 1);
    }

    public int getCajasEnDestino() {
        return tablero.contarCajasDestino();
    }

}

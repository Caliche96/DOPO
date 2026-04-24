package domain;

public class Jugador{
    private int fila;
    private int col;

    public Jugador(int fila, int col){
        this.fila = fila;
        this.col = col;
    }
    
    public int getFila() {
        return fila;
    }

    public int getCol() {
        return col;
    }
}
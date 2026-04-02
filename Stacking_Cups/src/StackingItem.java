package src;

/**
 * Representa un elemento que se puede apilar en la torre, como una taza o una tapa.
 */

public abstract class StackingItem{
    private int number;
    private int height;
    private String color;

    /**
     * Constructor para crear un nuevo elemento de apilamiento con el número, altura y color especificados.
     * @param number El número del elemento.
     * @param height La altura del elemento.
     * @param color El color del elemento.
     */
    public StackingItem(int number, int height, String color) {
        this.number = number;
        this.height = height;
        this.color = color;
    }

    /**
     * Devuelve el número del elemento de apilamiento.
     * @return El número del elemento.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Devuelve la altura del elemento de apilamiento.
     * @return La altura del elemento.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Devuelve el color del elemento de apilamiento.
     * @return El color del elemento.
     */
    public String getColor() {
        return color;
    }

    /**
     * Devuelve el tipo del elemento de apilamiento.
     * @return El tipo del elemento.
     */
    public String getType() {
        return "StackingItem";
    }
}

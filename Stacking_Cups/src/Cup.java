/**
 * Represents a cup in the Stacking Items simulator.
 * Each cup has a unique number identifier, a height of (2i-1) cm,
 * and is visually represented as a Rectangle.
 *
 * @author Nicolas Bernal & Carlos Rojas
 * @version 1.0 - 2026-1
 */
public class Cup extends StackingItem {

    private int height;
    private Rectangle shape;
    private boolean visible;

    /**
     * Crea una taza con el número y color dados
     * 
     * @param number El número de la taza
     * @param color  El color de la taza
     */

    public Cup(int number, String color) {
        super(number, 2 * number - 1, color);
    }

    /**
     * Devuelve el tipo del elemento
     * 
     * @return "Cup"
     */
    @Override
    public String getType() {
        return "Cup";
    }

    public Rectangle getShape() {
        return shape;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
<<<<<<< HEAD
package src;

=======
/**
 * Represents a cup in the Stacking Items simulator.
 * Each cup has a unique number identifier, a height of (2i-1) cm,
 * and is visually represented as a Rectangle.
 *
 * @author Nicolas Bernal & Carlos Rojas
 * @version 1.0 - 2026-1
 */
>>>>>>> 596a0adb08a3526b8e24f786e3ffca7b8b830971
public class Cup extends StackingItem {
    private Rectangle shape;

    /**
     * Crea una taza con el número y color dados
     * 
     * @param number El número de la taza
     * @param color  El color de la taza
     */

    public Cup(int number, String color) {
        super(number, 2 * number - 1, color);
        this.shape = new Rectangle(getHeight() * 2);
        shape.changeColor(color);
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
<<<<<<< HEAD
}
=======

    @Override
    public Rectangle getShape() {
        return shape;
    }

    @Override
    public void setCovered(boolean covered) {
        if (covered) {
            shape.changeColor("black");
        } else {
            shape.changeColor(getColor());
        }
    }
}
>>>>>>> 596a0adb08a3526b8e24f786e3ffca7b8b830971

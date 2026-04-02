<<<<<<< HEAD
package src;

=======
/**
 * Representa una tapa que se pude apilar en la torre.
 * La altura de la tapa es 1cm
 */
>>>>>>> 596a0adb08a3526b8e24f786e3ffca7b8b830971
public class Lid extends StackingItem {

    private Rectangle shape;

    /**
     * Crea una tapa con el número y color dados
     * La altura es siempre 1 cm
     * 
     * @param number El número identificador de la tapa
     * @param color  El color de la tapa, debe coinicdir con el de su taza.
     */
    public Lid(int number, String color) {
        super(number, 1, color);
        this.shape = new Rectangle(getHeight() * 4);
        shape.changeColor(color);
    }

    /**
     * Devuelve el tipo del elemento
     * 
     * @return "Lid"
     */
    @Override
    public String getType() {
        return "Lid";
    }
<<<<<<< HEAD
}
=======

    @Override
    public Rectangle getShape() {
        return shape;
    }

    // DE ESTA MANERA SABEMOS QUE LA TAPA YA ESTA TAPANDO UNA COPA

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

/**
 * Representa una taza que se pude apilar en la torre.
 * La altura de la taza es (2*number-1)cm
 */
public class Cup extends StackingItem {
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
}
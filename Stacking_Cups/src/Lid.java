/**
 * Representa una tapa que se pude apilar en la torre.
 * La altura de la tapa es 1cm
 */
public class Lid extends StackingItem {
    /**
     * Crea una tapa con el número y color dados
     * La altura es siempre 1 cm
     * 
     * @param number El número identificador de la tapa
     * @param color  El color de la tapa, debe coinicdir con el de su taza.
     */
    public Lid(int number, String color) {
        super(number, 1, color); // La tapa siempre mide 1cm
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
}
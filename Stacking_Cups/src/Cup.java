public class Cup extends StackingItem {
    public Cup(int number, String color) {
        super(number, number, color); // El alto de la raza es igual a su numero
    }

    @Override
    public String getType() {
        return "Cup";
    }
}
public class Lid extends StackingItem {
    public Lid(int number, String color) {
        super(number, 1, color);        //La tapa siempre mide 1cm
    }

    @Override
    public String getType() {
        return "Lid";
    }
}
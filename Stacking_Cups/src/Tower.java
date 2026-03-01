import java.util.*;

public class Tower {
    private int width;
    private int maxHeight;
    private ArrayList<StackingItem> items;
    private boolean ok;
    private HashMap<Integer, String> colorMap;
    private static final String[] COLORS={
        "red","blue","green","yellow","orange","purple","pink","brown","black","white",
        "cyan","magenta","lime","maroon","navy","olive","teal","violet","indigo","gray",
        "silver","gold","bronze","coral","crimson","fuchsia","khaki","lavender","salmon","tan"
    };

    /**
     * Crea una torre con el ancho y la altura dados
     * @param width El ancho de la torre
     * @param maxHeight La altura máxima de la torre
     */
    public Tower(int width, int maxHeight) {
        this.width = width;
        this.maxHeight = maxHeight;
        this.items = new ArrayList<>();
        this.ok = true;
        this.colorMap = new HashMap<>();
    }

    /**
     * Agrega una taza con el numero dado a la cima de la torre.
     * @param i  numero de la raza(tambien es su altura)
     */
    public void pushCup(int i) {
        if (cupExists(i)) {
            ok=false;
            return;
        }
        String color = assignColor(i);
        Cup cup = new Cup(i, color);
        if (height() +cup.getHeight() >maxHeight) {
            ok=false;
            return;
        }
        items.add(cup);
        ok=true;
    }

    /**
     * Elimina la taza de la cima de la torre.
     */
    public void popCup() {
        if (items.isEmpty()){
            ok=false;
            return;
        }
        StackingItem topItem = items.get(items.size() - 1);
        //No usar instance OF
        if (!topItem.getType().equals("Cup")) {
            ok=false;
            return;
        }
        items.remove(topItem);
        ok=true;
    }


    /***
     * Elimina una taza específica de la torre.
     * @param i
     */
    public void removeCup(int i) {
        int index = findItem("cup", i);
        if (index == -1) {
            ok=false;
            return;
        }
        if(index+1 <items.size()){
            StackingItem aboveItem = items.get(index + 1);
            if (aboveItem.getType().equals("Lid")) {
                ok=false;
                return;
            }
        }
        items.remove(index);
        ok=true;
    }

    /**
     * Agrega una tapa con el numero dado a la cima de la torre
     * solo puede haber una tapa por numero
     * @param i
     */
    public void pushLid(int i) {
        if (lidExists(i)) {
            ok=false;
            return;
        }
        String color = assignColor(i);
        Lid lid = new Lid(i, color);
        if (height() +lid.getHeight() >maxHeight) {
            ok=false;
            return;
        }
        items.add(lid);
        ok=true;
    }

    /**
     * Elimina la tapa de la cima de la torre.
     */
    public void popLid() {
        if (items.isEmpty()){
            ok=false;
            return;
        }
        StackingItem topItem = items.get(items.size() - 1);
        //No usar instance OF
        if (!topItem.getType().equals("Lid")) {
            ok=false;
            return;
        }
        items.remove(topItem);
        ok=true;
    }


    /**
     * Elimina una tapa específica de la torre.
     * @param i
     */
    public void removeLid(int i) {
        int index = findItem("Lid", i);
        if (index == -1) {
            ok=false;
            return;
        }
        
        items.remove(index);
        ok=true;
    }

    /**
     * Ordena los elementos de la torre de mayor a menor(base a cima).
     * Si hay elementos con el mismo número, las tazas deben ir debajo de las tapas.
     * El numero menor queda en la cima y el numero mayor en la base.
     */
    
    public void orderTower() {
        // Ordenar por número de mayor a menor, y si hay empate, las tazas van debajo de las tapas
    }


    /**
     * Reverses the tower by rearranging the cups and lids in the opposite order.
     */
    public void reverseTower() {
        System.out.println("Reversing the tower.");
    }


    /**
     * Returns the current height of the tower.
     * @return
     */
    public int height() {
        int total =0;
        for (StackingItem item : items) {
            total += item.getHeight();
        }
        return total;
    }


    /**
     * Returns the number of cups currently in the tower.
     * @return
     */
    public int lidedCups() {
        return width;
    }


    /**
     * Returns a 2D array representing the current arrangement of cups and lids in the tower.
     * @return
     */
    public String[][] stackingItems(){
        String[][] items = new String[maxHeight][width];
        for (int i = 0; i < maxHeight; i++) {
            for (int j = 0; j < width; j++) {
                items[i][j] = "Cup " + (i * width + j);
            }
        }
        return items;
    }


    /**
     * Makes the tower visible.
     */
    public void makeVisible() {
        System.out.println("Making the tower visible.");
    }


    /**
     * Makes the tower invisible.
     */
    public void makesInvisible() {
        System.out.println("Making the tower invisible.");
    }


    /**
     * Exits the tower and performs any necessary cleanup.
     */
    public void exit() {
        System.out.println("Exiting the tower.");
    }


    /**
     * Indica si la útlima operación realizada en la torre fue exitosa o no.
     * @return
     */
    public boolean ok() {
        return ok;
    }


    public boolean cupExists(int i) {
        return findItem("Cup", i) != -1;
    }

    public boolean lidExists(int i) {
        return findItem("Lid", i) != -1;
    }

    private int findItem(String type, int number) {
        for (int index = 0; index < items.size(); index++) {
            StackingItem item = items.get(index);
            if (item.getType().equals(type) && item.getNumber() == number) {
                return index;
            }
        }
        return -1;
    }

    private String assignColor(int number) {
        if (colorMap.containsKey(number)) {
            return colorMap.get(number);
        }
        String color = COLORS[number % COLORS.length];
        colorMap.put(number, color);
        return color;
    }



}

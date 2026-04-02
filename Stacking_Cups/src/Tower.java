import java.util.*;

/**
 * Represnta la torre en el simulador de Stacking Items.
 * Gestiona una coleccion de tazas y tapas apiladas
 */
public class Tower {
    private int width;
    private int maxHeight;
    private ArrayList<StackingItem> items;
    private boolean ok;
    private boolean isVisible;
    private HashMap<Integer, String> colorMap;
    private static final String[] COLORS = {
            "red", "blue", "green", "yellow", "orange", "purple", "pink", "brown", "black", "white",
            "cyan", "magenta", "lime", "maroon", "navy", "olive", "teal", "violet", "indigo", "gray",
            "silver", "gold", "bronze", "coral", "crimson", "fuchsia", "khaki", "lavender", "salmon", "tan"
    };

    /**
     * Crea una torre con el ancho y la altura dados
     * 
     * @param width     El ancho de la torre
     * @param maxHeight La altura máxima de la torre
     */
    public Tower(int width, int maxHeight) {
        this.width = width;
        this.maxHeight = maxHeight;
        this.items = new ArrayList<>();
        this.ok = true;
        this.isVisible = false;
        this.colorMap = new HashMap<>();
    }

    /**
     * Método de Ciclo II
     * Crea una torre con tazas numeradas del 1 al número dado.
     * No incluye tapas. El ancho y alto se calculan automáticamente.
     * Ej: cips=4 crea las tazas 1,2,3 y 4 de alturas 1,3,5 y 7
     * 
     * @param cups Número de tazas a crear
     */
    public Tower(int cups) {
        this.width = cups * 2;
        this.maxHeight = 0;
        this.items = new ArrayList<>();
        this.ok = true;
        this.isVisible = false;
        this.colorMap = new HashMap<>();
        for (int i = 1; i <= cups; i++) {
            Cup cup = new Cup(i, assignColor(i));
            items.add(cup);
            this.maxHeight += cup.getHeight();
        }
    }

    /**
     * Agrega una taza con el numero dado a la cima de la torre.
     * Falla si la taza ya existe o no cabe
     * 
     * @param i numero de la taza
     */
    public void pushCup(int i) {
        if (cupExists(i)) {
            ok = false;
            return;
        }
        String color = assignColor(i); // No esta demás para no perdernos el como se le asigna el color
        Cup cup = new Cup(i, color);
        if (height() + cup.getHeight() > maxHeight) {
            ok = false;
            return;
        }
        items.add(cup);
        ok = true;
    }

    /**
     * Elimina la taza de la cima de la torre.
     * Falla si la cima no es una taza
     */
    public void popCup() {
        if (items.isEmpty()) {
            ok = false;
            return;
        }
        StackingItem topItem = items.get(items.size() - 1);
        if (!topItem.getType().equals("Cup")) {
            ok = false;
            return;
        }
        items.remove(topItem);
        ok = true;
    }

    /***
     * Elimina una taza específica de la torre.
     * Falla si la taza no existe o si hay una tapa encima de la taza
     * 
     * @param i el número de la taza a eliminar
     */
    public void removeCup(int i) {
        int index = findItem("cup", i);
        if (index == -1) {
            ok = false;
            return;
        }
        if (index + 1 < items.size() && items.get(index + 1).getType().equals("Lid")) {
            ok = false;
            return;
        }
        items.remove(index);
        ok = true;
    }

    /**
     * Agrega una tapa con el numero dado a la cima de la torre
     * solo puede haber una tapa por numero
     * Falla si la tapa ya existe o no cabe
     * 
     * @param i el número de la tapa a agregar
     */
    public void pushLid(int i) {
        if (lidExists(i)) {
            ok = false;
            return;
        }
        String color = assignColor(i);
        Lid lid = new Lid(i, color);
        if (height() + lid.getHeight() > maxHeight) {
            ok = false;
            return;
        }
        items.add(lid);
        ok = true;
    }

    /**
     * Elimina la tapa de la cima de la torre.
     */
    public void popLid() {
        if (items.isEmpty()) {
            ok = false;
            return;
        }
        StackingItem topItem = items.get(items.size() - 1);
        // No usar instance OF
        if (!topItem.getType().equals("Lid")) {
            ok = false;
            return;
        }
        items.remove(topItem);
        ok = true;
    }

    /**
     * Elimina una tapa específica de la torre.
     * Falla si la tapa no existe o si hay una taza debajo de la tapa
     * 
     * @param i el número de la tapa a eliminar
     */
    public void removeLid(int i) {
        int index = findItem("Lid", i);
        if (index == -1) {
            ok = false;
            return;
        }

        items.remove(index);
        ok = true;
    }

    /**
     * Ordena los elementos de la torre de mayor a menor(base a cima).
     * Si una taza y una tapa estan presentes, la tapa va inmediatamente encima.
     * Solo incluye los elementos que quepan en la torre.
     */
    public void orderTower() {
        ArrayList<StackingItem> orderedItems = sortedByNumber(false);
        items = trimToHeight(orderedItems);
        ok = true;
    }

    /**
     * Coloca los elementos en orden inverso: de menor a mayor(base a cima).
     * Solo incluye los elementos que quepan en la torre.
     */
    public void reverseTower() {
        ArrayList<StackingItem> orderedItems = sortedByNumber(true);
        items = trimToHeight(orderedItems);
        ok = true;
    }

    /**
     * Método de Ciclo II
     * Elimina todas las tazas y tapas de la torre.
     */
    public void swap(String[] o1, String[] o2) {
        int index1 = findItem(o1[0], Integer.parseInt(o1[1]));
        int index2 = findItem(o2[0], Integer.parseInt(o2[1]));
        if (index1 == -1 || index2 == -1) {
            ok = false;
            return;
        }
        boolean covered1 = isCovered(index1);
        boolean covered2 = isCovered(index2);
        if (covered1 && covered2) {
            swapCovered(index1, index2);
        } else if (covered1) {
            swapCoveredWithSingle(index1, index2);
        } else if (covered2) {
            swapCoveredWithSingle(index2, index1);
        } else {
            Collections.swap(items, index1, index2);
        }
        ok = true;
    }

    /**
     * Tapa todas las tazas que tienen su tapa en la torre.
     * La tapa se coloca inmediatamente encima de su taza.
     * Si la taza ya está tapada, no se realiza ningún cambio.
     */
    public void cover() {
        for (int i = 0; i < items.size(); i++) {
            StackingItem item = items.get(i);
            if (!item.getType().equals("Cup"))
                continue;
            int lidIndex = findItem("Lid", item.getNumber());
            if (lidIndex == -1 || isCovered(i))
                continue;
            StackingItem lid = items.remove(lidIndex);
            items.add(i + 1, lid);
            item.setCovered(true);
            i++;
        }
        ok = true;
    }

    /**
     * Devuelve la altura actual de los elementos apilados.
     * 
     * @return Altura en cm.
     */
    public int height() {
        int total = 0;
        for (StackingItem item : items) {
            total += item.getHeight();
        }
        return total;
    }

    /**
     * Retorna los números de las tazas tapadas por su tapa
     * Ordenados de menor a mayor.
     * 
     * @return array con los números de las tazas tapadas
     */
    public int[] lidedCups() {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < items.size() - 1; i++) {
            if (items.get(i).getType().equals("Cup") && items.get(i + 1).getType().equals("Lid")) {
                result.add(items.get(i).getNumber());
            }
        }
        Collections.sort(result);
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }

    /**
     * Retorna los elementos apilados de base a cima
     * Cada entrada es {"cup" o "lid", "<numero>"} en minusculas.
     * Ejemplo: {{"cup", "1"}, {"cup", "2"}, {"lid", "2"}}
     * 
     * @return Arreglo 2D de los elementos apilados
     */
    public String[][] stackingItems() {
        String[][] grid = new String[maxHeight][width];
        for (int i = 0; i < maxHeight; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = "Cup " + (i * width + j);
            }
        }
        return grid;
    }

    /**
     * Consulta que intercambio de dos elementos reduciria más la altura de la torre
     * Los objetos se identifican por su tipo y número.
     * Ejemplo: {"cup", "4"} y {"lid", "4"}
     * 
     * @return Par de identificadfores del intercambio que más reduce la altura, o
     *         null si ningún intercambio la reduce.
     */
    public String[][] swapToReduce() {
        String[][] bestSwap = null;
        int bestHeight = height();
        for (int i = 0; i < items.size(); i++) {
            for (int j = i + 1; j < items.size(); j++) {
                Collections.swap(items, i, j);
                int newHeight = height();
                if (newHeight < bestHeight) {
                    bestHeight = newHeight;
                    bestSwap = buildSwapResult(i, j);
                }
                Collections.swap(items, i, j);
            }
        }
        ok = bestSwap != null;
        return bestSwap;
    }

    /**
     * Muestra la torre.
     */
    public void makeVisible() {
        isVisible = true;
        for (StackingItem item : items) {
            item.getShape().makeVisible();
        }
    }

    /**
     * Oculta la torre.
     */
    public void makeInvisible() {
        isVisible = false;
        for (StackingItem item : items) {
            item.getShape().makeInvisible();
        }
    }

    /**
     * Termina el simulador ocultando todos los elementos.
     */
    public void exit() {
        makeInvisible();
    }

    /**
     * Indica si la útlima operación realizada en la torre fue exitosa o no.
     * 
     * @return true si la última operación fue exitosa, false en caso contrario
     */
    public boolean ok() {
        return ok; // Este ya está implementado, no modificarlo
    }

    // --------------------------------------
    // Métodos auxiliares. No borrar!!
    // --------------------------------------
    /**
     * Devuelve true si existe una taza con el número dado.
     * 
     * @param i el número de la taza
     * @return true si existe la taza, false en caso contrario
     */
    public boolean cupExists(int i) {
        return findItem("Cup", i) != -1;
    }

    /**
     * Devuelve true si existe una tapa con el número dado.
     * 
     * @param i el número de la tapa
     * @return true si existe la tapa, false en caso contrario
     */
    public boolean lidExists(int i) {
        return findItem("Lid", i) != -1;
    }

    /**
     * Busca un elemento por tipo y número.
     * 
     * @param type   el tipo de elemento
     * @param number el número del elemento
     * @return el índice del elemento si existe, -1 en caso contrario
     */
    private int findItem(String type, int number) {
        for (int index = 0; index < items.size(); index++) {
            StackingItem item = items.get(index);
            if (item.getType().equals(type) && item.getNumber() == number) {
                return index;
            }
        }
        return -1;
    }

    /**
     * Asigna un color a un número dado.
     * 
     * @param number el número
     * @return el color asignado
     */
    private String assignColor(int number) {
        if (colorMap.containsKey(number)) {
            return colorMap.get(number);
        }
        String color = COLORS[number % COLORS.length];
        colorMap.put(number, color);
        return color;
    }

    /**
     * Construye una lista ordenada de todos los elementos actuales.
     * Orden descendente(menor a mayor); si reversed es true, ascendente.
     * Cuando una taza y su tapa estan presentes, la tapa va justo encima
     * 
     * @param reversed true para ordenar de menor a mayor, false para ordenar de
     *                 mayor a menor
     * @return lista ordenada de elementos
     */
    private ArrayList<StackingItem> sortedByNumber(boolean reversed) {
        ArrayList<StackingItem> sortedItems = new ArrayList<>(items);
        Collections.sort(sortedItems, (item1, item2) -> {
            if (reversed) {
                return Integer.compare(item2.getNumber(), item1.getNumber());
            } else {
                return Integer.compare(item1.getNumber(), item2.getNumber());
            }
        });
        return sortedItems;
    }

    /**
     * Trunca la lista de elementos para que no exceda la altura máxima.
     * 
     * @param items lista de elementos
     * @return lista truncada
     */
    private ArrayList<StackingItem> trimToHeight(ArrayList<StackingItem> items) {
        ArrayList<StackingItem> result = new ArrayList<>();
        int currentHeight = 0;
        for (StackingItem item : items) {
            if (currentHeight + item.getHeight() <= maxHeight) {
                result.add(item);
                currentHeight += item.getHeight();
            }
        }
        return result;
    }

    // Métodos Auxiliares Ciclo II
    // Métodos Auxiliares para llevar a cabo el swap

    /**
     * Verifica si un elemento está tapado
     * 
     * @param index indice del elemento
     * @return true si está tapado, false en caso contrario
     */
    private boolean isCovered(int index) {
        if (index + 1 >= items.size()) {
            return false;
        }
        StackingItem current = items.get(index);
        StackingItem next = items.get(index + 1);
        return current.getType().equals("Cup") && next.getType().equals("Lid")
                && current.getNumber() == next.getNumber();
    }

    /**
     * Intercambia dos elementos tapados
     * 
     * @param index1 indice del primer elemento
     * @param index2 indice del segundo elemento
     */
    private void swapCovered(int index1, int index2) {
        StackingItem cup1 = items.get(index1);
        StackingItem lid1 = items.get(index1 + 1);
        StackingItem cup2 = items.get(index2);
        StackingItem lid2 = items.get(index2 + 1);
        items.set(index1, cup2);
        items.set(index1 + 1, lid2);
        items.set(index2, cup1);
        items.set(index2 + 1, lid1);
    }

    /**
     * Intercambia un elemento tapado con uno no tapado
     * 
     * @param coveredIndex indice del elemento tapado
     * @param singleIndex  indice del elemento no tapado
     */
    private void swapCoveredWithSingle(int coveredIndex, int singleIndex) {
        StackingItem cup = items.get(coveredIndex);
        StackingItem lid1 = items.get(coveredIndex + 1);
        StackingItem single = items.get(singleIndex);
        items.set(coveredIndex, single);
        items.set(coveredIndex + 1, cup);
        items.set(singleIndex, lid1);
    }

    /**
     * Construye el resultado del swap
     * 
     * @param i indice del primer elemento
     * @param j indice del segundo elemento
     * @return resultado del swap
     */
    private String[][] buildSwapResult(int i, int j) {
        StackingItem item1 = items.get(i);
        StackingItem item2 = items.get(j);
        return new String[][] {
                { item1.getType().toLowerCase(), String.valueOf(item1.getNumber()) },
                { item2.getType().toLowerCase(), String.valueOf(item2.getNumber()) }
        };
    }

}

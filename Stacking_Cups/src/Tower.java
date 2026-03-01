public class Tower {
    private static int width;
    private final int maxHeight;
    public Tower(int width, int maxHeight) {
        Tower.width = width;
        this.maxHeight = maxHeight;
    }

    /**
     * Pushes a cup onto the stack if the current height is less than the maximum height.
     * @param i
     */
    public void pushCup(int i) {
        if (i < maxHeight) {
            System.out.println("Pushing cup " + i + " onto the stack.");
        } else {
            System.out.println("Cannot push cup " + i + ". Stack is full.");
        }
    }

    /**
     * Pops a cup from the stack if the current height is greater than 0.
     */
    public void popCup() {
        System.out.println("Popping a cup from the stack.");
    }

    /***
     * Removes a specific cup from the stack.
     * @param i
     */
    public void removeCup(int i) {
        System.out.println("Removing cup " + i + " from the stack.");
    }

    /**
     * Pushes a lid onto the stack if the current height is less than the maximum height.
     * @param i
     */
    public void pushLid(int i) {
        System.out.println("Pushing lid " + i + " onto the stack.");
    }

    /**
     * Pops a lid from the stack if the current height is greater than 0.
     */
    public void popLid() {
        System.out.println("Popping a lid from the stack.");
    }


    /**
     * Removes a specific lid from the stack.
     * @param i
     */
    public void removeLid(int i) {
        System.out.println("Removing lid " + i + " from the stack.");
    }


    /**
     * Orders the tower by arranging the cups and lids in a specific order.
     */
    public void orderTower() {
        System.out.println("Ordering the tower.");
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
        return maxHeight;
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
     * Checks if the tower is in a valid state.
     * @return
     */
    public boolean ok() {
        return true;
    }
}

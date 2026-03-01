public class Tower {
    private int width;
    private int maxHeight;
    public Tower(int width, int maxHeight) {
        this.width = width;
        this.maxHeight = maxHeight;
    }

    public void pushCup(int i) {
        if (i < maxHeight) {
            System.out.println("Pushing cup " + i + " onto the stack.");
        } else {
            System.out.println("Cannot push cup " + i + ". Stack is full.");
        }
    }

    public void manageCup(String action) {
        if (action.equals("add")) {
            numCups++;
        } else if (action.equals("remove") && numCups > 0) {
            numCups--;
        }

    }

    public void manageLid(String action) {
        if (action.equals("add")) {
            numStacks++;
        } else if (action.equals("remove") && numStacks > 0) {
            numStacks--;
        }
    }

    public void reorganizeTower(String action) {
        if (action.equals("order")) {
            numStacks = (int) Math.ceil((double) numCups / (numStacks * numStacks));
        } else if (action.equals("reverse")) {
            numStacks = (int) Math.ceil((double) numCups / (numStacks * numStacks));
        }
    }

    public void consultInformation() {
        System.out.println("Number of cups: " + numCups);
        System.out.println("Number of stacks: " + numStacks);
    }

    public void visibility(String action) {
        if (action.equals("show")) {
            System.out.println("Cups and stacks are visible.");
        } else if (action.equals("hide")) {
            System.out.println("Cups and stacks are hidden.");
        }
    }
    
    public void exitSimulatior() {
        System.out.println("Exiting the simulator. Goodbye!");
    }
}

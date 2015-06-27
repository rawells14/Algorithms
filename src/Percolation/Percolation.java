package Percolation;

//This class uses
public class Percolation {
    private boolean[][] grid;
    //A model of the grid; True is an open slot, false is an closed slot
    private int gridSize;
    //size of grid
    private int numberOfSlotsOpened;

    //creates a percolation system, n being the size of the grid
    public Percolation(int n) {

    }

    //opens the site
    public void open(int i, int j) {
        grid[i][j] = true;
        numberOfSlotsOpened++;
    }

    //returns if the current slot is open
    public boolean isOpen(int i, int j){
        return grid[i][j];
    }

    //checks if the grid can percolate from the top to bottom
    public boolean percolates() {

    }

}

/**
 * Author: Ryan Wells
 * 6/27/15
 * The percolation class is a system that models various scientific experiments with metals, porous materials, and water-flow.
 */
public class Percolation {
    private boolean[][] grid;
    //A model of the grid; True is an open slot, false is an closed slot
    private int n;
    //size of grid
    private int numberOfSlotsOpened = 0;
    private WeightedQuickUnionUF uf;


    //creates a percolation system, n being the size of the grid
    public Percolation(int n) {

        uf = new WeightedQuickUnionUF(n * n);
        //creates a new union system with n^2 coords
        this.n = n;
        grid = new boolean[n][n];
        //Creates a "virtual" connection between all of the top and bottom cells in the
        //UF system
        //top
        for (int i = 0; i < n; i++) {
            uf.union(0, i);
        }
        //bottom
        for (int i = n * n - 1; i >= n * n - n; i--) {
            uf.union(n * n - 1, i);
        }
    }

    //opens the site (THIS IS 1 INDEXED), if not already
    public void open(int i, int j) {
        if (!isOpen(i, j)) {
            grid[i - 1][j - 1] = true;
            numberOfSlotsOpened++;

            i -= 1;
            j -= 1;

            //if the above slot is open, union it to the opened slot
            if (isValid(i + 1, j) && isOpen(i + 1 + 1, j + 1)) {
                uf.union(getID(i, j), getID(i + 1, j));
            }

            //if the below slot is open, union it to the opened slot
            if (isValid(i - 1, j) && isOpen(i - 1 + 1, j + 1)) {
                uf.union(getID(i, j), getID(i - 1, j));
            }

            //if the right slot is open, union it to the opened slot
            if (isValid(i, j + 1) && isOpen(i + 1, j + 1 + 1)) {
                uf.union(getID(i, j), getID(i, j + 1));
            }

            //if the left slot is open, union it to the opened slot
            if (isValid(i, j - 1) && isOpen(i + 1, j - 1 + 1)) {
                uf.union(getID(i, j), getID(i, j - 1));
            }
        }


    }

    //returns if the current slot is open (1 based)
    public boolean isOpen(int i, int j) {
        return grid[i - 1][j - 1];
    }

    //checks if the grid can percolate from the top to bottom
    public boolean percolates() {
        return uf.connected(0, n * n - 1);
    }


    //------------------------------------------------------------------------
    //helper methods

    public double getThreshold() {
        return (double) (numberOfSlotsOpened) / (n * n);
    }

    //prints each cell, X being closed, O, being open
    public void printGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]) {
                    System.out.print("O ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    //send in 2D coords, get back 1D coords
    private int getID(int i, int j) {

        return i * n + j;
    }

    //zero based
    private boolean isValid(int i, int j) {
        return (i >= 0 && i < n) && (j >= 0 && j < n);
    }


}

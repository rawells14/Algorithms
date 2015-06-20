public class QuickUnion {
    private int[] id;
    //a data structure used to represent nodes in trees based on their index


    public QuickUnion(int n) {
        id = new int[n];
        //initialize id as size of n
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        //sets values as the same as indices
    }

    public int getRoot(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        //while the index is not equal to the value, go up one node in the tree
        return i;
    }

    public boolean isConnected(int p, int q) {
        return getRoot(p) == getRoot(q);
    }

    public void union(int p, int q) {
        int pRoot = getRoot(p);
        int qRoot = getRoot(q);
        id[pRoot] = q;
    }

    public void printIDArr(){
        for (int i = 0; i < id.length; i++) {
            System.out.print(id[i] + " ");
        }
    }
}

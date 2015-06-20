
public class WeightedQuickUnion {
    private int id[];
    //models the trees with their values
    private int treeSize[];
    //Model of tree size

    public WeightedQuickUnion(int n) {
        id = new int[n];
        treeSize = new int[n];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
        //indices are equal to the values

        for (int i = 0; i < treeSize.length; i++) {
            treeSize[i] = 1;
        }
        //the size of all trees starts as 1

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
        if (pRoot == qRoot)
            return;
        if (treeSize[pRoot] > treeSize[qRoot]) {
            id[qRoot] = pRoot;
            treeSize[pRoot] += treeSize[qRoot];
        } else {
            id[pRoot] = qRoot;
            treeSize[qRoot] += treeSize[pRoot];
        }
    }

    public void printIDArr() {
        for (int i = 0; i < id.length; i++) {
            System.out.print(id[i] + " ");
        }
    }
}

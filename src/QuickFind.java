class QuickFind {
    private int id[];

    public QuickFind(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        //initialize the id array with indices matching their value
    }

    public void union(int p, int q) {
        int pID = id[p];
        int qID = id[q];
        for (int i = 0; i < id.length; i++) {
            if (pID == id[i]) {
                id[i] = qID;
            }
        }
    }


    public boolean isConnected(int p, int q) {
        return id[p] == id[q];
    }

    public void printIDArr() {
        for (int i = 0; i < id.length; i++) {
            System.out.print(id[i] + " ");
        }
    }
}

class QuickFind {
    private int id[];

    public QuickFind(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = n;
        }
        //initialize the id array with indices matching their value
    }

    public void union(int p, int q) {

    }


    public boolean isConnected(int p, int q) {
        return true;
    }
}

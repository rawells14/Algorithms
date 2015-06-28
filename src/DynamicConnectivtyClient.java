import java.util.Scanner;


public class DynamicConnectivtyClient {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        WeightedQuickUnion qf = new WeightedQuickUnion(10);
        //QuickUnion qf = new QuickUnion(10);
        //QuickFind qf = new QuickFind(10);
        qf.union(5, 6);
        qf.union(9, 2);
        qf.union(8, 3);
        qf.union(4, 7);
        qf.union(6, 4);
        qf.union(6, 0);
        qf.union(6, 1);
        qf.union(3, 9);
        qf.union(8, 6);
        qf.printIDArr();
    }
}

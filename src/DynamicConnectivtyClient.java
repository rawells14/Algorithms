import java.util.Scanner;


public class DynamicConnectivtyClient {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        QuickFind qf = new QuickFind(10);
        qf.union(0, 5);
        qf.union(0, 4);
        qf.union(9, 2);
        qf.union(4, 6);
        qf.union(6, 1);
        qf.union(7, 8);
        qf.printIDArr();
    }
}

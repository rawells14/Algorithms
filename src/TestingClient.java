//a main testing class for testing various methods of each class
public class TestingClient {

    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();
        Percolation p = new Percolation(4);
        long time2 = System.currentTimeMillis();
        System.out.println((time2 - time1) / 1000.0 + " seconds to create the system.");
        System.out.println(p.percolates());




    }
}

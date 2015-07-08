/**
 * Author: Ryan Wells
 * 6/27/15
 * This apparatus performs T experiments on an N by N grid to determine the
 * percolation threshold mean of the experiments, the standard deviation,
 * and the 95% confidence interval.
 */


public class PercolationStats {
    private double sum = 0;//sum Of Thresholds
    private double[] trialThreshold;//Each trial will have it's threshold recorded
    private int N;
    private int T;

    public PercolationStats(int N, int T) {
        if (T <= 0 || N <= 0) {
            throw new IllegalArgumentException("N and T must be greater than or equal to 1");
        }
        this.trialThreshold = new double[T];
        this.N = N;
        this.T = T;
        //Performs the Experiment T times
        for (int i = 0; i < T; i++) {

            //creates a new percolation system N by N in size
            Percolation p = new Percolation(N);

            //there are no sites initially open
            int sitesOpen = 0;

            //repeat until it can percolate
            while (!p.percolates()) {
                //randomly open a new site
                int x = StdRandom.uniform(1, N + 1);
                int y = StdRandom.uniform(1, N + 1);
                if (!p.isOpen(x, y)) {
                    p.open(x, y);
                    sitesOpen++;
                }
                //one more site has been opened
            }

            //sets all of the statistics for later calls

            //threshold is the amount of sites opened divided by the amount of sites in all
            double threshold = (sitesOpen) / (double) (this.N * this.N);
            sum += threshold;
            trialThreshold[i] = threshold;
        }
    }


    //returns the average percolation threshold
    public double mean() {
        return (double) (this.sum / this.T);
    }


    //returns the standard deviation of the percolation threshold
    public double stddev() {

        if (T == 1) {
            return Double.NaN;
        }

        double numerator = 0;
        for (int i = 0; i < trialThreshold.length; i++) {
            numerator += Math.pow(trialThreshold[i] - mean(), 2);
        }

        return Math.sqrt(numerator / (this.T - 1));

    }

    public double confidenceLo() {
        return mean() - ((1.96 * stddev()) / Math.sqrt(T));
    }

    public double confidenceHi() {
        return mean() + ((1.96 * stddev()) / Math.sqrt(T));
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        int T = StdIn.readInt();
        PercolationStats experiment = new PercolationStats(N, T);
        StdOut.println("mean = " + experiment.mean());
        StdOut.println("stddev = " + experiment.stddev());
        StdOut.println("95% confidence interval = " + experiment.confidenceLo() + ", " + experiment.confidenceHi());
    }
}


//helper methods

/**
 *
 * @author Valeria
 */
public class InterpolationNewton {

    public static void newton(double[] x, double[] y) {
        int n = x.length;
        double[][] A = new double[n][n];
        for (int j = 0; j < n; j++) {
            A[j][0] = y[j];
        }
        int p = 0;
        for (int k = 0; k < n; k++) {
            p = 0;
            for (int i = k + 1; i < n; i++) {
                A[i][k + 1] = (A[i][k] - A[i - 1][k]) / (x[i] - x[p]);
                p = p + 1;
            }
        }
        System.out.println("Table of divided differences: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(A[i][j] + "     ");
            }
            System.out.println("");
        }

        System.out.println("\nNewton's Polynomial coefficients: ");
        for (int j = 0; j < n; j++) {
            System.out.print(A[j][j] + "     ");
        }
        System.out.println("");
        
        System.out.println("\nNewton's Polynomial: ");
        for (int j = 0; j < n; j++) {
            if (j==0){
                System.out.print(A[j][j]);
            }else{
                if(A[j][j]>0){
                    System.out.print(" + " + A[j][j]);
                    for (int i = 0; i < j; i++) {
                        if(x[i]>0){
                            System.out.print("(x - " + x[i] + ")");
                        }else{
                            System.out.print("(x + " +  Math.abs(x[i]) + ")");
                        }
                    }
                }else{
                    System.out.print(" - " + Math.abs(A[j][j]));
                    for (int i = 0; i < j; i++) {
                        if(x[i]>0){
                            System.out.print("(x - " + x[i] + ")");
                        }else{
                            System.out.print("(x + " +  Math.abs(x[i]) + ")");
                        }
                    }
                }
            }
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        double[] x = {-1, 0, 3, 4};
        double[] y = {15.5, 3, 8, 1};
        newton(x, y);
    }
}
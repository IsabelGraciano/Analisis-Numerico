/**
 *
 * @author Valeria
 */
public class Jacobi {

    public static double[] jacobi(double[][] A, double[] b, double t, int iter, double[] x0) {
        int n = A.length;
        int l = A[0].length;
        double[][] T = new double[n][n];
        double[] C = new double[n];
        if (n != l) {
            System.out.println("A is not a square matrix.");
            return new double[0];
        } else {
            double[] x = new double[n];
            double aux;
            int cont = 0;
            double E = t + 1;
            int iteration = 1;
            while (E > t && cont <= iter) {
                System.out.println("iter: " + iteration);
                E = 0;
                for (int i = 0; i < n; i++) {
                    double sum = 0;
                    for (int j = 0; j < n; j++) {
                        if (i != j) {
                            sum = sum + A[i][j] * x0[j];
                            T[i][j] = -A[i][j] / A[i][i];
                            C[i] = b[i] / A[i][i];
                        }
                    }
                    x[i] = (b[i] - sum) / A[i][i];
                    aux = x[i] - x0[i];
                    E = E + Math.pow(aux, 2);
                }
                E = Math.pow(E, 0.5);
                System.out.println("E = " + E);
                for (int i = 0; i < n; i++) {
                    x0[i] = x[i];
                    System.out.println("x" + (i + 1) + ": " + x0[i]);

                }
                System.out.println("");
                iteration++;
                cont = cont++;
            }
            System.out.println("T: ");
            for (int i = 0; i < T.length; i++) {
                for (int j = 0; j < T.length; j++) {
                    System.out.print(T[i][j] + "      ");
                }
                System.out.println(" ");
            }
            System.out.println("C: ");
            for (int i = 0; i < T.length; i++) {
                System.out.print(C[i] + "      ");
            }
            System.out.println(" ");
            if (E < t) {
                return x;
            } else {
                System.out.println("Can not find a solution in " + iter + " iterations");
                return new double[0];
            }
        }
    }

    public static void main(String[] args) {
        double[][] A
                = {
                    {4, -1, 0, 3},
                    {1, 15.5, 3, 8},
                    {0, -1.3, -4, 1.1},
                    {14, 5, -2, 30}
                };
        double[] b = {1, 1, 1, 1};
        double[] x0 = {0, 0, 0, 0};
        jacobi(A, b, Math.pow(10, -7), 100, x0);
    }
}

public class Doolittle {

    public static void doolittle(double A[][], double[] b, int n) {
        double[][] L = new double[n][n];
        double[][] U = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                L[j][j] = 1;
                if (i < j) {
                    L[i][j] = 0;
                } else if (i > j) {
                    U[i][j] = 0;
                }
            }
        }

        for (int k = 1; k < n + 1; k++) {
            System.out.println("Stage " + k + ": ");
            double suma = 0;
            for (int p = 0; p < k - 1; p++) {
                suma += L[k - 1][p] * U[p][k - 1];
            }
            U[k - 1][k - 1] = (A[k - 1][k - 1] - suma) / L[k - 1][k - 1];

            for (int j = k + 1; j < n + 1; j++) {
                suma = 0;
                for (int p = 0; p < k - 1; p++) {

                    suma += L[k - 1][p] * U[p][j - 1];
                }
                U[k - 1][j - 1] = (A[k - 1][j - 1] - suma) / L[k - 1][k - 1];
            }
            System.out.println("L:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(L[i][j] + "     ");
                }
                System.out.println("");
            }
            System.out.println("");
            for (int i = k + 1; i < n + 1; i++) {
                suma = 0;
                for (int p = 0; p < k - 1; p++) {
                    suma += L[i - 1][p] * U[p][k - 1];
                }
                L[i - 1][k - 1] = (A[i - 1][k - 1] - suma) / U[k - 1][k - 1];
            }
            System.out.println("U:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(U[i][j] + "     ");
                }
                System.out.println("");
            }
            System.out.println("");
        }

        double[] z = ProgressiveSubstitution(L, b);
        System.out.println("\nProgressive Substitution and Regressive Substitution");
        double[] x = RegressiveSubstitution(U, z);
        for (int i = 0; i < x.length; i++) {
            System.out.println("x" + (i + 1) + " = " + x[i]);
        }
    }

    public static double[] ProgressiveSubstitution(double[][] L, double[] b) {
        int n = L.length;
        double x[] = new double[n];
        for (int i = 1; i < n + 1; i++) {
            double summ = 0;
            for (int p = i - 1; p > 0; p--) {
                double a = L[i - 2][p];
                double c = x[p - 1];
                summ += (L[i - 1][p - 1] * x[p - 1]);
            }
            x[i - 1] = (b[i - 1] - summ) / L[i - 1][i - 1];
        }
        return x;
    }

    public static double[] RegressiveSubstitution(double[][] U, double[] z) {
        int n = U.length;
        double[] x = new double[n];

        for (int i = n - 1; i >= 0; i--) {
            double suma = 0;
            for (int j = i + 1; j < n; j++) {
                suma += U[i][j] * x[j];
            }
            x[i] = (z[i] - suma) / U[i][i];
        }
        return x;
    }

    public static void main(String[] args) {

        double[][] A = {{4, -1, 0, 3},
                        {1, 15.5, 3, 8},
                        {0, -1.3, -4, 1.1},
                        {14, 5, -2, 30}
                        };
        double[] b = {1, 1, 1, 1};
        int n = A.length;

        System.out.println("Stage 0: ");
        System.out.println("A:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(A[i][j] + "     ");
            }
            System.out.println("");
        }
        System.out.println("");

        doolittle(A, b, n);
    }
}

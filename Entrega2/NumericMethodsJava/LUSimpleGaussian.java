/**
 *
 * @author Manuel Gutierrez
 */
public class LUSimpleGaussian {

    public static double[][] gaussianElimination(int n, double[][] matrix, double[][] l) {
        System.out.println("Original matrix");
        printMatrix(matrix, n);

        for (int k = 1; k < n; k++) {
            System.out.println("Stage " + k);
            System.out.println("Goal: Fill with zeros under the element A" + k + "," + k + "= " + matrix[k - 1][k - 1]);
            System.out.println("\nMultipliers:");
            for (int i = k + 1; i < n + 1; i++) {
                double multiplier = matrix[i - 1][k - 1] / matrix[k - 1][k - 1];
                for (int j = k; j < n + 2; j++) {
                matrix[i - 1][j - 1] = matrix[i - 1][j - 1] - multiplier * matrix[k - 1][j - 1];
                }

                System.out.println("Multipliers" + i + "," + k + " : " + multiplier);
                l[i - 1][k - 1] = multiplier;
            }
            System.out.println(" ");
            printMatrix(matrix, n);
        }
        return matrix;
    }

    public static void regressiveSubstitution(double[][] uz, int n) {
        double[] x = new double[n];
        for (int i = n; i > 0; i--) {
            double ctrl = 0;
            for (int p = i + 1; p <= n; p++) {
                ctrl += uz[i - 1][p - 1] * x[p - 1];
            }
            x[i - 1] = (uz[i - 1][n] - ctrl) / uz[i - 1][i - 1];
            System.out.println("x" + i + " = " + x[i - 1]);
        }
    }

    public static double[] progressiveSubstitution(double[][] lb, int n) {
        double[] z = new double[n];
        for (int i = 0; i < lb.length; i++) {
            double ctrl = 0;
            for (int j = 0; j < i; j++) {
                ctrl += lb[i][j] * z[j];
            }
            z[i] = (lb[i][n] - ctrl) / lb[i][i];
        }
        return z;
    }

    public static void fillU(double[][] uAux, double[][] u) {
        for (int i = 0; i < u.length; i++) {
            for (int j = 0; j < u[0].length; j++) {
                u[i][j] = uAux[i][j];
            }
        }
    }

    public static double[][] fillAugmentedMatrix(double[][] matrix, double[] b) {
        int bIterator = 0;
        double[][] augmentedMatrix = new double[matrix.length][matrix[0].length + 1];

        for (int i = 0; i < augmentedMatrix.length; i++) {
            for (int j = 0; j < augmentedMatrix[0].length; j++) {
                if (j == augmentedMatrix[0].length - 1) {
                    augmentedMatrix[i][j] = b[bIterator];
                    bIterator++;
                } else {
                    augmentedMatrix[i][j] = matrix[i][j];
                }
            }
        }
        return augmentedMatrix;
    }

    public static void fillLDiagonal(double[][] l) {
        for (int i = 0; i < l.length; i++) {
            for (int j = 0; j < l[0].length; j++) {
                if (i == j) {
                    l[i][j] = 1;
                }
            }
        }
    }

    public static void printMatrix(double[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.print(matrix[i][j]);
                printSpaces(String.valueOf(matrix[i][j]).length(), 30);
            }
            System.out.print("\n");
        }
        System.out.println("");
    }

    public static void printSpaces(int n, int k) {
        if (n < k) {
            for (int i = 0; i < k - n; i++) {
                System.out.print(" ");
            }
        }
    }

    public static void main(String[] args) {
        double[][] a = {
            {4, -1, 0, 3},
            {1, 15.5, 3, 8},
            {0, -1.3, -4, 1.1},
            {14, 5, -2, 30}
        };
        double[] b = {1, 1, 1, 1};
        final int n = a.length;
        double[][] l = new double[a.length][a.length];
        double[][] u = new double[a.length][a.length];

        double[][] ab = fillAugmentedMatrix(a, b);
        fillLDiagonal(l);
        double[][] uAux = gaussianElimination(n, ab, l);
        fillU(uAux, u);
        double[][] lb = fillAugmentedMatrix(l, b);
        double[] z = progressiveSubstitution(lb, n);
        double[][] uz = fillAugmentedMatrix(u, z);
        printMatrix(lb,n);
        printMatrix(uz,n);
        regressiveSubstitution(uz, n);
    }
}

package NumericMethods;

/**
 *
 * @author Manuel Gutierrez
 */
public class PartialPivoting {

    static double[][] ab
            = {
                {2, -1, 0, 3, 1},
                {1, 0.5, 3, 8, 1},
                {0, 13, -2, 11, 1},
                {14, 5, -2, 3, 1}
            };

    static int n = 4;

    public static void gaussianElimination() {
        for (int x = 1; x < n; x++) {
            firstStep(x);
            for (int i = x + 1; i < n + 1; i++) {
                double scalar = ab[i - 1][x - 1] / ab[x - 1][x - 1];
                for (int j = x; j < n + 2; j++) {
                    ab[i - 1][j - 1] = ab[i - 1][j - 1] - scalar * ab[x - 1][j - 1];
                }
            }
            printMatrix();
            System.out.println('\n');
        }
        System.out.println('\n');
        printMatrix();
        System.out.println('\n');
        regressiveSubstitution();
    }

    public static void firstStep(int x) {
        int row = x - 1;
        int column = x - 1;

        double largest = Math.abs(ab[row][column]);

        //I'll find the largest number in the column with it's row
        for (int i = x - 1; i < n; i++) {
            double aux = Math.abs(ab[i][x - 1]);
            if (aux > largest) {
                largest = Math.abs(ab[i][x - 1]);
                row = i;
            }
        }

        if (largest == 0) {
            System.out.println("Fallo la ejecucion del metodo");
            System.exit(0);
        } else {
            if (row != x - 1) {
                for (int i = 0; i < ab[0].length; i++) {
                    double aux = ab[x - 1][i];
                    ab[x - 1][i] = ab[row][i];
                    ab[row][i] = aux;
                }
            }
        }
    }

    public static void regressiveSubstitution() {
        double[] answers = new double[n];
        for (int i = n; i > 0; i--) {
            double ctrl = 0;
            for (int p = i + 1; p <= n; p++) {
                ctrl += ab[i - 1][p - 1] * answers[p - 1];
            }
            answers[i - 1] = (ab[i - 1][n] - ctrl) / ab[i - 1][i - 1];
            System.out.println("x" + i + " = " + answers[i - 1]);
        }
    }

    public static void printMatrix() {
        for (int i = 0; i < ab.length; i++) {
            for (int j = 0; j < ab[i].length; j++) {
                System.out.print(ab[i][j] + " ");
            }
            System.out.println();
        }
    }
}

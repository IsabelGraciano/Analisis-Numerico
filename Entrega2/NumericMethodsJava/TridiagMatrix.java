package NumericMethods;

public class TridiagMatrix {

    public static double[][] gaussianElimination(double[][] matrix) {
        double multiplier;
        int rowA = 1;
        int colA = 0;
        for (int i = 0; i < matrix.length - 1; i++) {
            multiplier = matrix[rowA][colA] / matrix[rowA - 1][colA];
            matrix[rowA][colA + 1] -= multiplier * matrix[rowA - 1][colA + 1];
            matrix[rowA][matrix.length - 1] -= multiplier * matrix[rowA - 1][matrix.length - 1];
            matrix[rowA][colA] = 0;
            rowA++;
            colA++;
        }
        regressiveSubstitution(matrix);
        return matrix;
    }

    public static void regressiveSubstitution(double[][] matrix) {
        int n = matrix.length;
        double[] answers = new double[n];
        for (int i = n; i > 0; i--) {
            double ctrl = 0;
            for (int p = i + 1; p <= n; p++) {
                ctrl += matrix[i - 1][p - 1] * answers[p - 1];
            }
            answers[i - 1] = (matrix[i - 1][n] - ctrl) / matrix[i - 1][i - 1];
            System.out.println("x" + i + " = " + answers[i - 1]);
        }
    }
}

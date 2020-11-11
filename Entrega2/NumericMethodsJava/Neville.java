package NumericMethods;

public class Neville {
    public static double[][] run(double[] x, double[] y, double xConst) {
        double[][] matrix = new double[x.length - 1][x.length - 1];
        int count = 0;
        int countXPointer = 0;
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = count; i < matrix.length; i++) {
                if (j == 0) {
                    matrix[i][j] = calculate(xConst, x[i], x[i + 1], y[i + 1], y[i]);
                } else {
                    matrix[i][j] = calculate(xConst, x[countXPointer],x[countXPointer+j+1], matrix[i][j-1], matrix[i-1][j-1]);
                    countXPointer++;
                }
            }
            count++;
            countXPointer = 0;
        }
        return matrix;
    }

    public static double calculate(double x, double xiPrev, double xi, double pi, double pil1) {
        return (((x - xiPrev) * pi) - ((x - xi) * pil1)) / (xi - xiPrev);
    }
}

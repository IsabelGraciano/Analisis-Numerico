package NumericMethods;

public class Splines {

    public static double[][] linearSpline(double[] x) {
        double[][] matrix = new double[2 * (x.length - 1)][2 * (x.length - 1)];
        int countPair = 0;
        for (int i = 0; i < x.length; i++) {
            matrix[i][countPair] = x[i];
            matrix[i][countPair + 1] = 1;
            if (i != 0) {
                countPair += 2;
            }
        }
        countPair = 0;
        int count = x.length;//this variable has the count of where the matrix continues being building.
        for (int i = 1; i < x.length - 1; i++) {
            matrix[count][countPair] = x[i];
            matrix[count][countPair + 1] = 1;
            matrix[count][countPair + 2] = -x[i];
            matrix[count][countPair + 3] = -1;
            countPair += 2;
            count++;
        }

        return matrix;
    }

    public static double[][] squareSpline(double[] x) {
        double[][] matrix = new double[3 * (x.length - 1)][3 * (x.length - 1)];
        int countPair = 0;
        for (int i = 0; i < x.length; i++) {
            matrix[i][countPair] = Math.pow(x[i], 2);
            matrix[i][countPair + 1] = x[i];
            matrix[i][countPair + 2] = 1;
            if (i != 0) {
                countPair += 3;
            }
        }
        countPair = 0;
        int count = x.length;//this variable has the count of where the matrix continues being building.
        for (int i = 1; i < x.length - 1; i++) {
            matrix[count][countPair] = Math.pow(x[i], 2);
            matrix[count][countPair + 1] = x[i];
            matrix[count][countPair + 2] = 1;
            matrix[count][countPair + 3] = -Math.pow(x[i], 2);
            matrix[count][countPair + 4] = -x[i];
            matrix[count][countPair + 5] = -1;
            countPair += 3;
            count++;
        }
        countPair = 0;
        for (int i = 1; i < x.length - 1; i++) {
            matrix[count][countPair] = 2 * x[i];
            matrix[count][countPair + 1] = 1;
            matrix[count][countPair + 3] = -2 * x[i];
            matrix[count][countPair + 4] = -1;
            countPair += 3;
            count++;
        }
        matrix[count][0] = 2;
        return matrix;
    }

    public static double[][] cubicSpline(double[] x) {
        double[][] matrix = new double[4 * (x.length - 1)][4 * (x.length - 1)];
        int countPair = 0;
        for (int i = 0; i < x.length; i++) {
            matrix[i][countPair] = Math.pow(x[i], 3);
            matrix[i][countPair + 1] = Math.pow(x[i], 2);
            matrix[i][countPair + 2] = x[i];
            matrix[i][countPair + 3] = 1;
            if (i != 0) {
                countPair += 4;
            }
        }
        countPair = 0;
        int count = x.length;//this variable has the count of where the matrix continues being building.
        for (int i = 1; i < x.length - 1; i++) {
            matrix[count][countPair] = Math.pow(x[i], 3);
            matrix[count][countPair + 1] = Math.pow(x[i], 2);
            matrix[count][countPair + 2] = x[i];
            matrix[count][countPair + 3] = 1;
            matrix[count][countPair + 4] = -Math.pow(x[i], 3);
            matrix[count][countPair + 5] = -Math.pow(x[i], 2);
            matrix[count][countPair + 6] = -x[i];
            matrix[count][countPair + 7] = -1;
            countPair += 4;
            count++;
        }
        countPair = 0;
        for (int i = 1; i < x.length - 1; i++) {
            matrix[count][countPair] = 3 * Math.pow(x[i], 2);
            matrix[count][countPair + 1] = 2 * x[i];
            matrix[count][countPair + 2] = 1;
            matrix[count][countPair + 4] = -3 * Math.pow(x[i], 2);
            matrix[count][countPair + 5] = -2 * x[i];
            matrix[count][countPair + 6] = -1;
            countPair += 4;
            count++;
        }
        countPair = 0;
        for (int i = 1; i < x.length - 1; i++) {
            matrix[count][countPair] = 6 * x[i];
            matrix[count][countPair + 1] = 2;
            matrix[count][countPair + 4] = -6 * x[i];
            matrix[count][countPair + 5] = -2;
            countPair += 4;
            count++;
        }
        matrix[count][0] = 6 * x[0];
        matrix[count][1] = 2;
        count++;
        matrix[count][matrix.length - 4] = 6 * x[x.length - 1];
        matrix[count][matrix.length - 3] = 2;
        return matrix;
    }
}
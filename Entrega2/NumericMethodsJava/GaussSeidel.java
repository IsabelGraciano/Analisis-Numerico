
/**
 *
 * @author Valeria
 */
public class GaussSeidel {

    public static double[] gaussSeidel(double[][] A, double[] b, double t, int iter, double[] x0) {
        int n = A.length;
        int l = A[0].length;
        if (n != l) {
            System.out.println("A is not a square matrix.");
            return new double[0];
        } else {
            double[] x = new double[n];
            double aux;
            int cont = 0;
            double E = t + 1;
            int iterations = 1;
            while (E > t && cont <= iter) {
                System.out.println("iter: " + iterations);
                E = 0;
                for (int i = 0; i < n; i++) {
                    double sum = 0;
                    for (int j = 0; j < n; j++) {
                        if (i != j) {
                            sum = sum + A[i][j] * x0[j];
                        }
                    }
                    x[i] = (b[i] - sum) / A[i][i];
                    aux = x[i] - x0[i];
                    E = E + Math.pow(aux, 2);
                    x0[i] = x[i];
                    System.out.println("x" + (i + 1) + ": " + x0[i]);
                }
                E = Math.pow(E, 0.5);
                System.out.println("E = " + E);
                System.out.println("");
                iterations++;
                cont = cont++;
            }
            
            if (E < t) {
                return x;
            } else {
                System.out.println("Can not find a solution in  " + iter + " iterations");
                return new double[0];
            }
        }
    }
    
    
    
   public static void system(double[][] A, double[] b) {
        int n = A.length;
        double[][] D = new double[n][n];
        double[][] L = new double[n][n];
        double[][] DL = new double[n][n];
        double[][] U = new double[n][n];
        double[][] T = new double[n][n];
        double[] C = new double[n];

        System.out.println("\nT: ");
        for (int i = 0; i < D.length; i++) {
            D[i][i] = A[i][i];
        }
        for (int i = 0; i < L.length; i++) {
            for (int j = i + 1; j < L.length; j++) {
                L[j][i] = A[j][i] - (A[j][i] * 2);
            }
        }
        for (int i = 0; i < U.length; i++) {
            for (int j = i + 1; j < U.length; j++) {
                U[i][j] = A[i][j] - (A[i][j] * 2);
            }
        }
        //(D-L)
        for (int i = 0; i < D.length; i++) {
            for (int j = 0; j < D.length; j++) {
                DL[i][j] = (D[i][j] - L[i][j]);
            }
        }
        //(D-L)^1
        DL = inverseMatrix(DL);
        
        //((D-L)^-1)*U
        for (int i = 0; i < DL.length; i++) {
            for (int j = 0; j < U[0].length; j++) {
                for (int k = 0; k < DL[0].length; k++) {
                    T[i][j] += DL[i][k] * U[k][j];
                }
            }
        }
        for (int i = 0; i < T.length; i++) {
            for (int j = 0; j < T.length; j++) {
                System.out.print(T[i][j] + "      ");
            }
            System.out.println(" ");
        }

        //C=((D-L)^-1)*b
        System.out.println("\nC: ");
        for (int i = 0; i < DL.length; i++) {
            for (int j = 0; j < b.length; j++) {
                C[i] += DL[i][j] * b[j];
            }
            System.out.print(C[i] + "   ");
        }
        System.out.println("");
    }


    public static double[][] inverseMatrix(double[][] matrix) {
        double det = 1 / determinant(matrix);
        double[][] nmatrix = attachedMatrix(matrix);
        multiplyMatrix(det, nmatrix);
        return nmatrix;
    }

    public static void multiplyMatrix(double n, double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] *= n;
            }
        }
    }

    public static double[][] attachedMatrix(double[][] matrix) {
        return transposedMatrix(cofactorsMatrix(matrix));
    }

    public static double[][] cofactorsMatrix(double[][] matrix) {
        double[][] nm = new double[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                double[][] det = new double[matrix.length - 1][matrix.length - 1];
                double detValue;
                for (int k = 0; k < matrix.length; k++) {
                    if (k != i) {
                        for (int l = 0; l < matrix.length; l++) {
                            if (l != j) {
                                int index1 = k < i ? k : k - 1;
                                int index2 = l < j ? l : l - 1;
                                det[index1][index2] = matrix[k][l];
                            }
                        }
                    }
                }
                detValue = determinant(det);
                nm[i][j] = detValue * (double) Math.pow(-1, i + j + 2);
            }
        }
        return nm;
    }

    public static double[][] transposedMatrix(double[][] matrix) {
        double[][] newm = new double[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                newm[i][j] = matrix[j][i];
            }
        }
        return newm;
    }

    public static double determinant(double[][] matrix) {
        double det;
        if (matrix.length == 2) {
            det = (matrix[0][0] * matrix[1][1]) - (matrix[1][0] * matrix[0][1]);
            return det;
        }
        double sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            double[][] nm = new double[matrix.length - 1][matrix.length - 1];
            for (int j = 0; j < matrix.length; j++) {
                if (j != i) {
                    for (int k = 1; k < matrix.length; k++) {
                        int index = -1;
                        if (j < i) {
                            index = j;
                        } else if (j > i) {
                            index = j - 1;
                        }
                        nm[index][k - 1] = matrix[j][k];
                    }
                }
            }
            if (i % 2 == 0) {
                sum += matrix[i][0] * determinant(nm);
            } else {
                sum -= matrix[i][0] * determinant(nm);
            }
        }
        return sum;
    }
    

    public static void main(String[] args) {
        //Seidel(double[][] A, double[] b, double t, int iter, double[] x0) {
        double[][] A
                = {
                    {4, -1, 0, 3},
                    {1, 15.5, 3, 8},
                    {0, -1.3, -4, 1.1},
                    {14, 5, -2, 30}
                };
        double[] b = {1, 1, 1, 1};
        double[] x0 = {0, 0, 0, 0};

        gaussSeidel(A, b, Math.pow(10, -7), 100, x0);
        system(A, b);
    }
}


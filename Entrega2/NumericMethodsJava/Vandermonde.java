/**
 *
 * @author Valeria Suárez
 */
public class Vandermonde {


    static int n = 4;
    static int positions[] = new int[n];

    public static void gaussianElimination(double[][] ab) {
        for (int x = 1; x < n; x++) {
            //firstStep(x);
            int row = x - 1;
            int column = x - 1;

            double largest = Math.abs(ab[row][column]);

            //I'll find the largest number in the matrix with it's row and column
            for (int i = x - 1; i < n; i++) {
                for (int j = x - 1; j < n; j++) {
                    double aux = Math.abs(ab[i][j]);
                    if (aux > largest) {
                        largest = aux;
                        row = i;
                        column = j;
                    }
                }
            }
            if (largest == 0) {
                System.out.println("Error, this method can't execute");
                System.exit(0);
            } else {
                //With this part of I'll change the largest value to x-1 column
                if (column != x - 1) {
                    for (int i = 0; i < ab.length; i++) {
                        double aux = ab[i][x - 1];
                        ab[i][x - 1] = ab[i][column];
                        ab[i][column] = aux;
                    }
                    int auxPositions = positions[x - 1];
                    positions[x - 1] = column;
                    positions[column] = auxPositions;
                }
                if (row != x - 1) {
                    for (int i = 0; i < ab[0].length; i++) {
                        double aux = ab[x - 1][i];
                        ab[x - 1][i] = ab[row][i];
                        ab[row][i] = aux;
                    }
                }
            }
            //_______________________________________________________________________

            for (int i = x + 1; i < n + 1; i++) {
                double scalar = ab[i - 1][x - 1] / ab[x - 1][x - 1];
                for (int j = x; j < n + 2; j++) {
                    ab[i - 1][j - 1] = ab[i - 1][j - 1] - scalar * ab[x - 1][j - 1];
                }
            }
        }
        System.out.println('\n');
        //regressiveSubstitution();
        double[] answers = new double[n];
        for (int i = n; i > 0; i--) {
            double ctrl = 0;
            for (int p = i + 1; p <= n; p++) {
                ctrl += ab[i - 1][p - 1] * answers[p - 1];
            }
            answers[i - 1] = (ab[i - 1][n] - ctrl) / ab[i - 1][i - 1];
        }
        System.out.println("Polynomial coefficients: ");
        for (int i = 0; i < answers.length; i++) {
            System.out.print(answers[i] + "  ");
        }
        System.out.println("");
        System.out.println("\nPolynomial: ");
        int cont=answers.length-1;
        for (int i = 0; i < answers.length; i++) {
            if(cont==0){
                System.out.println(answers[i]);
            }else{
                if(answers[i+1]<0){
                    System.out.print(answers[i] + "x^" + cont + " ");
                    cont--;
                }else{
                    System.out.print(answers[i] + "x^" + cont + " + ");
                    cont--;
                }
            }
        }
        //_______________________________________
    }

    public static void fillPositions() {
        for (int i = 0; i < positions.length; i++) {
            positions[i] = i;
        }
    }

    public static void main(String[] args) {
        int x[] = {-1,0,3,4};
        double y [] = {15.5, 3, 8, 1};
        double[][] ab = new double[n][n + 1];
        int expo = n - 1;
        for (int i = 0; i < ab.length; i++) {
            for (int j = 0; j < ab[i].length; j++) {
                if (j == (n)) {
                    ab[i][j] = y[i];
                } else {
                    ab[i][j] = Math.pow(x[i], expo);
                    expo--;
                }
            }
            expo = n - 1;
        }
        System.out.println("Vandermonde Matrix: ");
        for (int f = 0; f < ab.length; f++) {
            for (int c = 0; c < ab[f].length; c++) {
                System.out.print(ab[f][c] + "   ");
            }
            System.out.println();
        }
        System.out.println();
        fillPositions();
        gaussianElimination(ab);
    }
}

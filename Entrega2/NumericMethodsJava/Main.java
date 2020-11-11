package NumericMethods;

import com.sun.xml.internal.ws.wsdl.writer.document.Part;

import java.util.Scanner;

public class Main {

    private static int nMaxCounter;
    private static double tolerance;
    private static int nMax;

    public static void main(String[] args) {
        System.out.println("Welcome to Numerikiando." +
                "\n The next menu will help you to test our codes:");
        Scanner user = new Scanner(System.in);
        int option = 0;
        nMaxCounter = 0;
        tolerance = 0.0000001;
        nMax = 100;
        while (true) {
            System.out.println("\n METHODS:" +
                    "\n 1. Incremental search" +
                    "\n 2. Bisection" +
                    "\n 3. Fake rule" +
                    "\n 4. Fixed point" +
                    "\n 5. Newton" +
                    "\n 6. Secant" +
                    "\n 7. Multiple roots" +
                    "\n 8. Gaussian elimination" +
                    "\n 9. Partial pivot" +
                    "\n 10. Total pivot" +
                    "\n 11. Steffensen" +
                    "\n 12. Muller" +
                    "\n 13. Aitken" +
                    "\n CONFIGURATION:" +
                    "\n 14. set nMax or tolerance values" +
                    "\n The current nMax value=" + nMax +
                    "\n The current tolerance value=" + tolerance +
                    "\n 15. exit");
            option = user.nextInt();
            switch (option) {
                case 1:
                    IncrementalSearch BI = new IncrementalSearch(user, nMax);
                    break;
                case 2:
                    System.out.println("to change the equation please change the code of the method f in Bisection class and re-run the program");
                    System.out.println("Enter the right end of the interval");
                    double aBis = Double.parseDouble(user.next());
                    System.out.println("Enter the left end of the interval");
                    double bBis = Double.parseDouble(user.next());
                    Bisection.bisection(aBis, bBis, nMax, tolerance);
                    break;
                case 3:
                    nMaxCounter = 0;
                    System.out.println("to change the equation please change the code of the method evaluateF and re-run the program");
                    System.out.println("Enter the right end of the interval");
                    double a = Double.parseDouble(user.next());
                    System.out.println("Enter the left end of the interval");
                    double b = Double.parseDouble(user.next());
                    System.out.println("| iter|     a         |     xm        |     b          |     f(Xm)  |     E     |");
                    fakeRule(a, b);
                    break;
                case 4:
                    nMaxCounter = 0;
                    System.out.println("to change the equation please change the code of the methods evaluateF and evaluateG and re-run the program");
                    System.out.println("Enter the initial approach");
                    double xFP = Double.parseDouble(user.next());
                    System.out.println("| iter|     xi         |     g(xi)      |   f(xi)   |     E     |");
                    fixedPoint(xFP);
                    break;
                case 5:
                    nMaxCounter = 0;
                    System.out.println("to change the equation please change the code of the methods evaluateF and evaluateFDerived and re-run the program");
                    System.out.println("Enter the initial approach");
                    double xNewton = Double.parseDouble(user.next());
                    System.out.println("| iter|     xi         |   f(xi)   |     E     |");
                    newton(xNewton);
                    break;
                case 6:
                    nMaxCounter = 0;
                    System.out.println("to change the equation please change the code of the methods evaluateF and evaluateFDerived and re-run the program");
                    System.out.println("Enter the initial approach #1");
                    double xSecant1 = Double.parseDouble(user.next());
                    System.out.println("Enter the initial approach #2");
                    double xSecant2 = Double.parseDouble(user.next());
                    System.out.println("| iter|     xi         |   f(xi)   |     E     |");
                    secant(xSecant1, xSecant2);
                    break;
                case 7:
                    System.out.println("to change the equation please change the code of the method f in MultipleRoots class and re-run the program");
                    System.out.println("Enter the initial approach");
                    double xMR = Double.parseDouble(user.next());
                    MultipleRoots.roots(xMR, tolerance, nMax);
                    break;
                case 8:
                    System.out.println("to change the matrix please change the code of the switch case 8 in the main class and re-run the program");
                    double[][] matrix
                            = {
                            {-1, 7, 7, 4, 2.5},
                            {1.1, -7.6999, -1, 1, 3.7},
                            {5, -3, 0, 6, 2.2},
                            {-12, 1, 9, 0, -32}
                    };
                    int n = 4;
                    GaussianElimination.gaussianElimination(n, matrix);
                    break;
                case 9:
                    System.out.println("to change the matrix please change the code of partial pivoting class and re-run the program");
                    PartialPivoting.gaussianElimination();
                    break;
                case 10:
                    System.out.println("to change the matrix please change the code of total pivoting class and re-run the program");
                    TotalPivoting.fillPositions();
                    TotalPivoting.gaussianElimination();
                    break;
                case 11:
                    nMaxCounter = 0;
                    System.out.println("to change the equation please change the code of the method evaluateF and re-run the program");
                    System.out.println("Enter the initial approach");
                    double xStf = Double.parseDouble(user.next());
                    System.out.println("| iter|     xi     |   f(xi)   |     E     |");
                    steffensen(xStf);
                    break;
                case 12:
                    nMaxCounter = 0;
                    System.out.println("to change the equation please change the code of the method f in MullerMethod class and re-run the program");
                    System.out.println("Enter the a number");
                    double aM = Double.parseDouble(user.next());
                    System.out.println("Enter the b number");
                    double bM = Double.parseDouble(user.next());
                    System.out.println("Enter the c number");
                    double cM = Double.parseDouble(user.next());
                    MullerMethod.Muller(aM, bM, cM);
                    break;
                case 13:
                    Aitken aitken = new Aitken(user);
                    break;
                case 14:
                    System.out.println("Please give the new values of tolerance and nMax:");
                    System.out.println("nMax=");
                    nMax = user.nextInt();
                    System.out.println("tolerance=");
                    tolerance = Double.parseDouble(user.next());
                    System.out.println(nMax + "; " + tolerance);
                    break;
                case 15:
                    break;
                case 16:
                    double[] x = {0, 2, 3, 4, 5, 6, 7};
                    double[] fx = {1.1247, -0.8540, 0.5864, 4, -0.9062, 0.9081, -0.2700};
                    double[] bn = InterpolationNewton.solucionar(x, fx);
                    for (int i = 0; i < bn.length; i++) {
                        System.out.println("b" + i + ": " + bn[i]);
                    }
                    System.out.println("f(" + 2.45 + ") = " + InterpolationNewton.calcularValor(2.45, bn, x));
                    break;
                case 17:
                    double[] xs = {-1, 0, 3, 4};
                    double[] ys = {15.5, 3, 8, 1};
                    double[][] matrixSpline = addToMatrix(Splines.linearSpline(xs), ys);
                    printMatrix(matrixSpline);
                    PartialPivoting.setAttrib(matrixSpline);
                    PartialPivoting.gaussianElimination();
                    break;
                case 18:
                    double[] sxs = {-1, 0, 3, 4};
                    double[] sys = {15.5, 3, 8, 1};
                    double[][] squareMatrixSpline = addToMatrix(Splines.squareSpline(sxs), sys);
                    printMatrix(squareMatrixSpline);
                    PartialPivoting.setAttrib(squareMatrixSpline);
                    PartialPivoting.gaussianElimination();
                    break;
                case 19:
                    double[] cxs = {-1, 0, 3, 4};
                    double[] cys = {15.5, 3, 8, 1};
                    double[][] cubicMatrixSpline = addToMatrix(Splines.cubicSpline(cxs), cys);
                    printMatrix(cubicMatrixSpline);
                    PartialPivoting.setAttrib(cubicMatrixSpline);
                    PartialPivoting.gaussianElimination();
                    break;
                case 20:
                    double[] nxs = {1, 1.2, 1.4, 1.6, 1.8, 2};
                    double[] nys = {0.674732261, 0.849196173, 1.121407696, 1.492135973, 1.960735619, 2.525897371};
                    double xConst = 1.45;
                    double[][] matrixNeville = Neville.run(nxs, nys, xConst);
                    printMatrix(matrixNeville);
                    break;
                case 21:
                    double[][] tridiag = {
                            {5, 2, 0, 0, 0, 0, 12},
                            {1, 4, 2, 0, 0, 0, 24},
                            {0, -4, 10, 3, 0, 0, -8},
                            {0, 0, 3, 12, -8, 0, 13},
                            {0, 0, 0, 5, -25, 4, -30},
                            {0, 0, 0, 0, 7, 12, 9},
                    };
                    printMatrix(TridiagMatrix.gaussianElimination(tridiag));
                    break;

            }
            if (option == 15) {
                break;
            }
        }
    }

    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("{ ");
            for (int j = 0; j < matrix[0].length; j++) {
                if (j != matrix[0].length - 1) {
                    System.out.print(matrix[i][j] + ", ");
                } else {
                    System.out.print(matrix[i][j]);
                }
            }
            System.out.println("},");
        }
    }

    public static double[][] addToMatrix(double[][] matrix, double[] ys) {
        double[][] matrixAb = new double[matrix.length][matrix.length + 1];
        for (int i = 0; i < matrixAb.length; i++) {
            for (int j = 0; j < matrixAb[0].length; j++) {
                if (j != matrixAb[0].length - 1) {
                    matrixAb[i][j] = matrix[i][j];
                } else {
                    if (i < ys.length) {
                        matrixAb[i][j] = ys[i];
                    }
                }
            }
        }
        return matrixAb;
    }

    public static double fakeRule(double a, double b) {
        double aEvaluated = evaluateF(a);
        double bEvaluated = evaluateF(b);
        double r = ((a * bEvaluated) - (b * aEvaluated)) / (bEvaluated - aEvaluated);
        double rEvaluated = evaluateF(r);
        if (rEvaluated * aEvaluated < 0) {
            if (Math.abs(r - b) < tolerance || nMaxCounter == nMax) {
                System.out.println("| " + nMaxCounter + " " + "| " + a + " " + "| " + r + " " + "| " + b + " " + "| " + rEvaluated + " " + "| " + Math.abs(r - b) + " |");
                System.out.println("The root reached was " + r);
                return r;
            } else {
                System.out.println("| " + nMaxCounter + " " + "| " + a + " " + "| " + r + " " + "| " + b + " " + "| " + rEvaluated + " " + "| " + Math.abs(r - b) + " |");
                nMaxCounter++;
                return fakeRule(a, r);
            }
        } else if (rEvaluated * bEvaluated < 0) {
            if (Math.abs(r - a) < tolerance || nMaxCounter == nMax) {
                System.out.println("| " + nMaxCounter + " " + "| " + a + " " + "| " + r + " " + "| " + b + " " + "| " + rEvaluated + " " + "| " + Math.abs(r - a) + " |");
                System.out.println("The root reached was " + r);
                return r;
            } else {
                System.out.println("| " + nMaxCounter + " " + "| " + a + " " + "| " + r + " " + "| " + b + " " + "| " + rEvaluated + " " + "| " + Math.abs(r - a) + " |");
                nMaxCounter++;
                return fakeRule(r, b);
            }
        } else {
            System.out.println("There isn't sign change");
            return 0;
        }
    }

    public static double fixedPoint(double x) {
        double xi = evaluateG(x);
        if (Math.abs(xi - x) < tolerance || nMaxCounter == nMax) {
            System.out.println("| " + nMaxCounter + " " + "|  " + x + "  " + "|  " + xi + "  " + "|  " + evaluateF1(x) + "  " + "|  " + Math.abs(xi - x) + "  |");
            System.out.println("The root reached was " + xi);
            return xi;
        } else {
            System.out.println("| " + nMaxCounter + " " + "|  " + x + "  " + "|  " + xi + "  " + "|  " + evaluateF1(x) + "  " + "|  " + Math.abs(xi - x) + "  |");
            nMaxCounter++;
            return fixedPoint(xi);
        }
    }

    public static double newton(double x) {
        double xi = x - (evaluateF(x) / evaluateFDerived(x));
        if (Math.abs(xi - x) < tolerance || nMaxCounter == nMax) {
            System.out.println("| " + nMaxCounter + " " + "|  " + xi + "  " + "|  " + evaluateF(xi) + "  " + "|  " + Math.abs(xi - x) + "  |");
            System.out.println("The root reached was " + xi);
            return xi;
        } else {
            System.out.println("| " + nMaxCounter + " " + "|  " + x + "  " + "|  " + evaluateF(x) + "  " + "|  " + Math.abs(xi - x) + "  |");
            nMaxCounter++;
            return newton(xi);
        }
    }

    public static double secant(double x, double xPrev) {
        double xEvaluated = evaluateF(x);
        double xi = x - (xEvaluated * (x - xPrev) / (xEvaluated - evaluateF(xPrev)));
        if (Math.abs(xi - x) < tolerance || nMaxCounter == nMax) {
            System.out.println("| " + nMaxCounter + " " + "|  " + xi + "  " + "|  " + evaluateF(xi) + "  " + "|  " + Math.abs(xi - x) + "  |");
            System.out.println("The root reached was " + xi);
            return xi;
        } else {
            System.out.println("| " + nMaxCounter + " " + "|  " + x + "  " + "|  " + evaluateF(x) + "  " + "|  " + Math.abs(xi - x) + "  |");
            nMaxCounter++;
            return secant(xi, x);
        }
    }

    public static double steffensen(double x) {
        double xEvaluated = evaluateF(x);
        double xi = x - (Math.pow(xEvaluated, 2) / (evaluateF(x + xEvaluated) - xEvaluated));
        if (Math.abs(xi - x) < tolerance || nMaxCounter == nMax) {
            System.out.println("| " + nMaxCounter + " " + "|  " + xi + "  " + "|  " + evaluateF(xi) + "  " + "|  " + Math.abs(xi - x) + "  |");
            System.out.println("The root reached was " + xi);
            return xi;
        } else {
            System.out.println("| " + nMaxCounter + " " + "|  " + x + "  " + "|  " + xEvaluated + "  " + "|  " + Math.abs(xi - x) + "  |");
            nMaxCounter++;
            return steffensen(xi);
        }
    }

    public static double evaluateF(double x) {
        //evaluate the f(x) function, please edit the next equation
        //return Math.log(Math.pow(Math.sin(x), 2) + 1) - (1.0 / 2.0);
        return Math.pow(x, 2);
    }

    public static double evaluateFDerived(double x) {
        //evaluate the f'(x) function, please edit the next equation
        return 2 * Math.pow(Math.pow(Math.sin(x), 2) + 1, -1) * Math.sin(x) * Math.cos(x);
    }

    public static double evaluateF1(double x) {
        //evaluate the f(x) function, please edit the next equation
        return Math.log(Math.pow(Math.sin(x), 2) + 1) - (1.0 / 2.0) - x;
    }

    public static double evaluateG(double x) {
        //evaluate the g(x) function, please edit the next equation
        return Math.log(Math.pow(Math.sin(x), 2) + 1) - (1.0 / 2.0);
    }
}

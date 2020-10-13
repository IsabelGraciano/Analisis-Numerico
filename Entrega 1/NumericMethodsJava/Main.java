package NumericMethods;

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
                    MullerMethod.Muller(aM,bM,cM);
                    break;
                case 13:
                    Aitken aitken=new Aitken(user);
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
            }
            if (option == 15) {
                break;
            }
        }
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
        return Math.log(Math.pow(Math.sin(x), 2) + 1) - (1.0 / 2.0);
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

package NumericMethods;

/**
 * @author Valeria
 */
public class Bisection {

    //the function
    public static double f(double x) {
        return ((Math.log((Math.pow((Math.sin(x)), 2)) + 1)) - (0.5));
    }

    //bisection method
    public static void bisection(double a, double b, double iterations, double tolerance) {

        double x0 = 0;
        double y0 = 0;
        int i = 1;
        double xm = (a + b) / 2;
        double result = f(xm);

        //Method data input control
        if (iterations < 1) {
            System.out.println("Iterations must be greater than 0");
        }
        if (result == 0) {
            System.out.println(xm + " Its a root");
        }
        if (f(a) * f(b) > 0) {
            System.out.println("There is no root in this interval");
        }

        //First iteration
        System.out.println("Iter: " + i);
        System.out.println("a: " + a);
        System.out.println("xm: " + xm);
        System.out.println("b: " + b);
        System.out.println("f(xm): " + f(xm));
        System.out.println("E: ");
        System.out.println("");
        i++;

        //Loop start
        while (result != 0 && i <= iterations && Math.abs(x0 - xm) > tolerance) {
            System.out.println("Iter: " + i);
            if (result * f(a) < 0) {
                a = a;
                b = xm;
            } else {
                b = b;
                a = xm;
            }
            x0 = xm;
            y0 = result;
            xm = (a + b) / 2;
            result = f(xm);
            i++;
            System.out.println("a: " + a);
            System.out.println("xm: " + xm);
            System.out.println("b: " + b);
            System.out.println("f(xm): " + f(xm));
            System.out.println("E: " + (Math.abs(x0 - xm)));
            System.out.println("");
        }

        //Method data output control
        if (result == 0) {
            System.out.println("An approximation of the root was found in " + (xm));
        } else if (i > iterations) {
            System.out.println("Iteration limit reached");
        } else {
            if (Math.abs(x0 - xm) < tolerance) {
                System.out.println("The maximum tolerance permitted " + (tolerance) + ". In the iteration " + (i) + " the maximum tolerance was reached " + (Math.abs(x0 - xm)) + "\n");
                System.out.println("Data in the last iteration");
                System.out.println("Iteration " + (i - 1));
                System.out.println("xm= " + (xm));
                System.out.println("f(xm)= " + f(xm));
                System.out.println("E= " + (Math.abs(x0 - xm)));
            }
        }
    }
}

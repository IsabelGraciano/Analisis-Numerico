package NumericMethods;

/**
 *
 * @author Valeria
 */
public class MultipleRoots {

    public static double f(double x) {
        //h(x) =e^x - x - 1
        return (Math.pow((Math.exp(1)), x)) - x - 1;
    }

    public static double df1(double x) {
        //h'(x) =e^x - 1
        return (Math.pow((Math.exp(1)), x)) - 1;
    }

    public static double df2(double x) {
        //h''(x) =e^x
        return (Math.pow((Math.exp(1)), x));
    }

    public static void roots(double x0, double tolerance, int iterations) {

        double resultf = f(x0);
        double resultf1 = df1(x0);
        double resultf2 = df2(x0);
        int i = 0;

        //Method data input control
        if (iterations < 1) {
            System.out.println("Iterations must be greater than 0");
        }
        if (resultf == 0) {
            System.out.println(x0 + " Its a root");
        }

        //First iteration (iteration 0)
        System.out.println("Iter: " + i);
        System.out.println("x0: " + x0);
        System.out.println("f(xi): " + f(x0));
        System.out.println("E: ");
        System.out.println("");
        i++;

        double xi = x0 - ((resultf * resultf1) / (Math.pow(resultf1, 2) - (resultf * resultf2)));
        System.out.println("Luego de hacer la super operacion: " + Math.abs(xi - x0));
        //Loop start
        while (resultf != 0 && i <= iterations && Math.abs(xi - x0) > tolerance) {
            double error = Math.abs(xi - x0);
            x0 = xi;
            resultf = f(x0);
            resultf1 = df1(x0);
            resultf2 = df2(x0);
            xi = x0 - ((resultf * resultf1) / (Math.pow(resultf1, 2) - (resultf * resultf2)));

            System.out.println("Iter: " + i);
            System.out.println("xi: " + x0);
            System.out.println("f(xi): " + resultf);
            System.out.println("E: " + error);
            System.out.println("");
            i++;
        }

        //Method data output control
        if (resultf == 0) {
            System.out.println("An approximation of the root was found in " + (xi));
        } else if (i > iterations) {
            System.out.println("Iteration limit reached");
        } else {
            if (Math.abs(xi - x0) < tolerance) {
                System.out.println("The maximum tolerance permitted " + (tolerance) + ". In the iteration " + (i) + " the maximum tolerance was reached " + (Math.abs(xi - x0)) + "\n");
                System.out.println("Data in the last iteration");
                System.out.println("Iteration " + (i - 1));
                System.out.println("x0= " + (x0));
                System.out.println("f(x0)= " + f(x0));
                System.out.println("E= " + (Math.abs(xi - x0)));
            }
        }
    }
}

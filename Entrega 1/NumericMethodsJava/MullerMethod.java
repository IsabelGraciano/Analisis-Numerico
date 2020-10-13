package NumericMethods;

public class MullerMethod {

    static final int n = 10000;

    // function to calculate f(x) 
    static double f(double x) {
        // Taking f(x) = x ^ 3 + 2x ^ 2 + 10x - 20 
        return 1 * Math.pow(x, 3) + 2 * x * x + 10 * x - 20;
    }

    static void Muller(double a, double b, double c) {
        int i;
        double res;

        for (i = 0;; ++i) {
            // Calculating various constants required 
            // to calculate x3 
            double f1 = f(a);
            double f2 = f(b);
            double f3 = f(c);
            double d1 = f1 - f3;
            double d2 = f2 - f3;
            double h1 = a - c;
            double h2 = b - c;
            double a0 = f3;
            double a1 = (((d2 * Math.pow(h1, 2)) - (d1 * Math.pow(h2, 2)))
                    / ((h1 * h2) * (h1 - h2)));
            double a2 = (((d1 * h2) - (d2 * h1)) / ((h1 * h2) * (h1 - h2)));
            double x = ((-2 * a0) / (a1 + Math.abs(Math.sqrt(a1 * a1 - 4 * a0 * a2))));
            double y = ((-2 * a0) / (a1 - Math.abs(Math.sqrt(a1 * a1 - 4 * a0 * a2))));

            // Taking the root which is closer to x2 
            if (x >= y) {
                res = x + c;
            } else {
                res = y + c;
            }

            // checking for resemblance of x3 with x2 till 
            // two decimal places 
            double m = res * 100;
            double n = c * 100;
            m = Math.floor(m);
            n = Math.floor(n);
            if (m == n) {
                break;
            }
            a = b;
            b = c;
            c = res;
            if (i > n) {
                System.out.println("Root cannot be found using"
                        + " Muller's method");
                break;
            }
        }
        if (i <= n) {
            System.out.println("The value of the root is " + res);
        }
    }
}

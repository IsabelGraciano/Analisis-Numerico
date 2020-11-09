/**
 *
 * @author Valeria
 */
public class Lagrange {

    public static void lagrange(double x[], double y[], int n) {
        double [] aux = new double[n];
        double den = 0;
        double mul = 1;
        for (int i = 0; i < n; i++) {
            System.out.print("L" + i + "= ");
            for (int j = 0; j < n; j++) {
                if(i!=j){
                    den = (x[i]-x[j]);
                    mul=mul*den;
                    System.out.print("(x - " + x[j] + ")");
                }
            }
            System.out.println(" " + ((1/mul)*y[i]) +"\n");
            mul=1;
        }
        
    }

    public static void main(String[] args) {
        double x[] = {-2,-1,2,3};
        double y[] = {12.13533528, 6.367879441, -4.610943901, 2.085536923};
        int n = x.length;

        lagrange(x, y, n);
    }
}

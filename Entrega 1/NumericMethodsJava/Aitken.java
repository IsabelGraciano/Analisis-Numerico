package NumericMethods;

import java.util.Scanner;

public class Aitken {
    double function, x1, x2, x3, x4, y;
    int n = 5;
    double ESP = 0.0000001;

    public Aitken(Scanner s){
        readX1(s);
        run();
    }

    public double evaluateFunction(double x) {
        function = 1 - 0.5*x*x;  //WRITE YOUR FUNCTION HERE
        return function;
    }
    
    public void run(){
        for(int i=1;i<=n;i++){
            x2=evaluateFunction(x1);
            x3=evaluateFunction(x2);

            if(Math.abs(x3-x2)<ESP){
                System.out.println(x3);
            }
            else{
                y=x3-2*x2+x1; 
                x1=x3-(((x3-x2)*(x3-x2))/y);  
            }
        }
    }
    
    public void readX1(Scanner s){
        System.out.println("Insert X1:");
        try {
            x1 = Float.parseFloat(s.next());
        } catch (NumberFormatException e) {
            System.out.println("Insert a valid X1");
            readX1(s);
        }
    }
}

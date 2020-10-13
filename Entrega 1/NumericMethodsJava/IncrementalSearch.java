package NumericMethods;

import java.util.Scanner;

public class IncrementalSearch {

    double start, increase;
    int iteration;
    double function;

    public IncrementalSearch(Scanner s,int nMax) {
        ReadPrevious(s);
        ReadIteration(s);
        iteration = nMax;
        RunSearch();
    }

    public double evaluateF(double x) {
        function = ( Math.log( (Math.pow(Math.sin(x),2) ) + 1) ) - 0.5;  //WRITE YOUR FUNCTION HERE
        return function;
    }

    public void RunSearch() {
        boolean negative = false;
        boolean positive = false;
        boolean root = false;
        double valuePositive = 0;
        double valueNegative = 0;
        
        for(double i=start; i<iteration; i+=increase){
            double value = evaluateF(i);
            if(value==0){ 
                System.out.println(i+" is a root of the function.");
            } else {
                if(value <0) {
                    negative = true;
                    valuePositive = i;
                }
                
                if(value>0){
                    positive = true;
                    valueNegative = i;
                }
                
                if(i!=start){
                    if(negative==true&&positive==true){
                        if(valueNegative<valuePositive) System.out.println("There is a root between ["+valueNegative+" , "+valuePositive+"]");
                        else System.out.println("There is a root between ["+valuePositive+" , "+valueNegative + "]");
                        
                        root = true;
                        negative = positive = false;
                    }
                }
            }
        }
        
        if(root == false){
            System.out.println("The root was not found");
        }
    }
    
    public void ReadPrevious(Scanner s){
        System.out.println("Insert a start value:");
        try {
            start = Double.parseDouble(s.next());;
        } catch (NumberFormatException e) {
            System.out.println("Insert a valid start value");
            ReadPrevious(s);
        }
    }
    
    public void ReadIteration(Scanner s){
        System.out.println("Insert an increase value:");
        try {
            increase = Double.parseDouble(s.next());;
        } catch (NumberFormatException e) {
            System.out.println("Insert a valid increase value");
            ReadIteration(s);
        }
    }
}
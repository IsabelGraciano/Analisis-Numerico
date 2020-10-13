package NumericMethods;

public class GaussianElimination {
    
    
    public static void gaussianElimination(int n, double[][] matrix){
        System.out.println("Original matrix");
        printMatrix(matrix,n);
        
        for(int k = 1; k < n; k++){
            System.out.println("Stage "+ k);
            System.out.println("Goal: Fill with zeros under the element A"+ k +","+k + "= " + matrix[k-1][k-1]);
             System.out.println("\nMultipliers:");
            for(int i = k+1; i < n+1; i++){
                double multiplier = matrix[i-1][k-1]/matrix[k-1][k-1];
                for(int j = k ; j < n+2; j++){
                    matrix[i-1][j-1] = matrix[i-1][j-1] - multiplier*matrix[k-1][j-1];
                }
                
               
                System.out.println("Multipliers"+ i+","+k +" : " + multiplier);
            }
            System.out.println(" ");
            printMatrix(matrix,n);
        }
        double x[] = new double[n];
        System.out.println("Backward substitution");
        for(int i = n; i>0;i--){
                double sum = 0;
                for(int p = i+1; p <= n; p++){
                        sum = sum + matrix[i-1][p-1]*x[p-1];
                }
                x[i-1] = (matrix[i-1][n]-sum)/matrix[i-1][i-1];
                System.out.println( "X"+i+" = "+x[i-1]);
        }
    }
    
    public static void printMatrix(double [][] matrix, int n){
        for(int i=0; i< n;i++){
            for(int j=0; j <n+1; j++){
                System.out.print(matrix[i][j]);
                printSpaces(String.valueOf(matrix[i][j]).length(),30);
            }
            System.out.print("\n");
        }
        System.out.println("");
    }
    
    public static void printSpaces(int n, int k){
        if(n<k){
            for(int i = 0; i<k-n;i++){
                System.out.print(" ");
            }
        }
    }
}
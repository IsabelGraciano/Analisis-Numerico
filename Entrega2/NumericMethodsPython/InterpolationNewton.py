
#Author: Valeria

def newton(x, y):
    n = len(x)
    A = []
    for i in range(n):
        A.append([0]*n)
    for j in range(0,n):
        A[j][0] = y[j]
    
    p = 0
    for k in range(0,n):
        p = 0
        for i in range(k+1,n):
            A[i][k + 1] = (A[i][k] - A[i - 1][k]) / (x[i] - x[p])
            p = p + 1
        
    
    print("Table of divided differences: ")
    for i in range(0,n):
        for j in range(0,n):
            print(A[i][j] , end = "     ")
        
        print("")
    

    print("\nNewton's Polynomial coefficients: ")
    for j in range(0,n):
        print(A[j][j] ,end= "     ")
    
    print("")
    
    print("\nNewton's Polynomial: ")
    for j in range(0,n):
        if (j==0):
            print(A[j][j], end="")
        else:
            if(A[j][j]>0):
                print(" + " , A[j][j], end="")
                for i in range(0,j): 
                    if(x[i]>0):
                        print("(x - " , x[i] , ")", end="");
                    else:
                        print("(x + " , abs(x[i]) , ")", end="")
                    
                
            else:
                print(" - " , abs(A[j][j]), end="")
                for i in range(0,j):
                    if(x[i]>0):
                        print("(x - " , x[i] , ")", end="")
                    else:
                        print("(x + " , abs(x[i]) , ")", end="")
                    
                
            
        
    
    print("")


x = [-1, 0, 3, 4]
y = [15.5, 3, 8, 1]
newton(x, y)

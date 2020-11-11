
import math
import numpy as np
#Author Valeria

def jacobi(A, b, t, iter,x0):
    n = len(A)
    l = len(A)
    if (n != l):
        print("A no es una matriz cuadrada.")
        return 0
    else:
        x = [n]
        T = []
        for i in range(n):
            T.append([0]*n)
        C = []
        aux = 0
        cont = 0
        E = t + 1
        iteration = 1
        while (E > t and cont <= iter):
            print("iter: " , iteration)
            E = 0;
            for i in range(0,n):
                suma = 0
                for j in range(0,n):
                    if (i != j):
                        suma = suma + A[i][j] * x0[j]
                        T[i][j] = -A[i][j] / A[i][i]
                C.append(b[i] / A[i][i])
                x.append((b[i] - suma) / A[i][i])
                aux = x[i] - x0[i]
                E = E + math.pow(aux, 2)
            
            E = math.pow(E, 0.5)
            print("E = " , E)
            for i in range(n):
                x0[i] = x[i]
                print("x" , (i + 1) , ": " , x0[i])
            
            print("\nT: ")
            for i in range(0,n):
                for j in range(0,n):
                    print(T[i][j] , end="      ")
                
                print(" ")
            
            print("C: ")
            for i in range(0,n):
                print(C[i] , end= "      ")
            print(" ")
            print(" ")
            
            values, normalized_eigenvectors = np.linalg.eig(T) # T es la matriz
            spectral_radius = max(abs(values))
            print("Spectral Radius: ", spectral_radius)

            iteration = iteration + 1 
            cont = cont + 1
        
        if (E < t):
            return x
        else:
            print("no se llegó a la solución en " + iter + " iteraciones");
            return 0

A = [[4, -1, 0, 3],
    [1, 15.5, 3, 8],
    [0, -1.3, -4, 1.1],
    [14, 5, -2, 30]]
b = [1, 1, 1, 1]
x0 = [0, 0, 0, 0]
t = math.pow(10, -7)
iter = 100
jacobi(A, b, t, iter, x0)


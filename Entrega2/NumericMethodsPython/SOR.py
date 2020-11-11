
import math
import numpy as np
#Author Valeria

def sor(A, b, tol, ite, x0, lam):
    n = len(A)
    l = len(A[0])
    mat = []

    if (n != l):
        print("A is not a square matrix.")
        return mat
    else:
        cont = 0
        E = tol + 1
        ite = 1
        x = [None]*n

        while (E > tol) and (cont <= ite):
            print("Iteration: " + str(ite))
            E = 0

            for i in range(0, n):
                summ = 0
                for j in range(0,n):
                    if (i != j):
                        summ = summ + A[i][j] * x0[j]
                x[i] = lam * ((b[i] - summ) / A[i][i]) + (1 - lam) * x0[i]
                aux = x[i] - x0[i]
                E = E + np.power(aux, 2)
                x0[i] = x[i]
                print("x" + str(i+1) + ": " + str(x0[i]))
            E = np.power(E, 0.5)
            print("Error: " + str(E))
            print("")

            ite = ite + 1
            cont = cont + 1
        if (E < tol):
            return x
        else:
            print("Can not find a solution in " + str(ite) + " iterations")
            return mat


A = [[4, -1, 0, 3],
    [1, 15.5, 3, 8],
    [0, -1.3, -4, 1.1],
    [14, 5, -2, 30]]
b = [1, 1, 1, 1]
x0 = [0, 0, 0, 0]
t = math.pow(10, -7)
iter = 100
w=1.5
sor(A, b, t, iter, x0, w)

D = np.diag(np.diag(A))
U = -np.triu(A,1)
L = -np.tril(A,-1)
T = (np.dot((np.linalg.inv(D-(w*L))), ((1-w)*D+(w*U))))
C = (w*np.dot((np.linalg.inv(D-(w*L))), b))
print("T: ")
print(T)
print("C:")
print(C)
values, normalized_eigenvectors = np.linalg.eig(T) # T es la matriz
spectral_radius = max(abs(values))
print("\nSpectral Radius: ", spectral_radius)
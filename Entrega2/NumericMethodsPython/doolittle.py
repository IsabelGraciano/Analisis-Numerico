import sympy as sm
import math
import sys
import json
import base64
import numpy as np

class Doolittle():
    def doolittle(self,A,b,size):
        A = np.array(A)
        b = np.array(b)
        L = np.eye(size)
        U = np.eye(size)
        print("Etapa 0:")
        print("Matriz L: ")
        print(L)
        print("Matriz U: ")
        print(U)
        for i in range(size):
            print("Etapa " + str(i+1))
            for k in range(i, size): 
                suma = 0;
                for j in range(i):
                    suma += (L[i][j] * U[j][k]);
                U[i][k] = A[i][k] - suma;
            for k in range(i, size):
                if (i == k):
                    L[i][i] = 1;
                else:
                    suma = 0;
                    for j in range(i):
                        suma += (L[k][j] * U[j][i]);
                    L[k][i] = ((A[k][i] - suma)/U[i][i]);

            print("Matriz L: ")
            print(L)
            print("Matriz U: ")
            print(U)
        z = self.frontSubstitution(L, b)
        x = self.backSubstitution(U, z)
        self.printResultVector(x)

    def frontSubstitution(self,A, b):
        n = len(A)
        x = np.zeros((n))
        for i in range(n):
            sum = 0
            for j in range(i):
                sum +=  A[i][j] * x[j]
            x[i] = (b[i] - sum) / A[i][i]
        return x

    def backSubstitution(self,A, b):
        n = len(A)
        x = np.zeros((n))
        for i in range(n-1, -1, -1):
            sum = 0.0
            for j in range (i+1, n):
                sum += A[i][j] * x[j]
            x[i] = (b[i] - sum) / A[i][i]
        return x

    def printResultVector(self,vector):
        n = len(vector)
        for i in range(n):
            print('x' + str(i + 1) + ': ' + str(vector[i]))



n=4
A = np.array([  [4, -1, 0, 3],
                [1, 15.5, 3, 8],
                [0, -1.3, -4, 1.1],
                [14, 5, -2, 30]
                ])
b = np.array([1,1,1,1])

doolittle = Doolittle()
doolittle.doolittle(A,b,n)
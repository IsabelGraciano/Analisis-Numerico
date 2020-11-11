import numpy as np

class Cholesky:
    def Choleskyy(self, A, b, n):
        L = [[0 for col in range(n)] for row in range(n)]
        U = [[0 for col in range(n)] for row in range(n)]

        for i in range(0,n):
            for j in range (0,n):
                if (i<j):
                    U[i][j] = float('inf')
                    L[i][j] = 0
                elif (i>j):
                    L[i][j] = float('inf')
                    U[i][j] = 0
                elif (i==j):
                    L[i][j] = float('inf')
                    U[i][j] = float('inf')
        
        print("Stage 0")
        print("Matrix A")
        self.printMatrix(A,n)

        print("Matrix L")
        self.printMatrix(L,n)

        print("Matrix U")
        self.printMatrix(U,n)

        for k in range(1,n+1):
            print("Stage " + str(k))
            print("Find the column " + str(k) + " of L and the row " + str(k) + " of U")
            print("Matrix A")
            self.printMatrix(A,n)

            summ = 0

            for p in range(0,k-1):
                summ += L[k-1][p] * U[p][k-1]

            U[k-1][k-1] = np.sqrt(A[k-1][k-1] - summ)
            L[k-1][k-1] = U[k-1][k-1]

            for j in range(k+1, n+1):
                summ1=0
                for p in range(0,k-1):
                    summ1 += L[j-1][p] * U[p][k-1]
                L[j-1][k-1] = (A[j-1][k-1] - summ1) / L[k-1][k-1]
            
            print("Matrix L")
            self.printMatrix(L,n)

            for i in range(k+1, n+1):
                summ1=0
                for p in range(0,k-1):
                    summ1 += L[k-1][p] * U[p][i-1]
                U[k-1][i-1] = (A[k-1][i-1] - summ1)/L[k-1][k-1]
            print("Matrix U")
            self.printMatrix(U,n)

            print("\n Progressive Substitution Lz=b")
            z = self.ProgressiveSubstitution(L,b)

            print("Z: " + str(z))
            print("\n Regressive Substitution")

            x = self.RegressiveSubstitution(U,z)

            for i in range(0,len(x)):
                print("X" + str(i+1) + " = " + str(x[i]))

    def ProgressiveSubstitution(self,L,b):
        n = len(L)
        x = [None]*n

        for i in range(1,n+1):
            summ = 0
            for p in range(i-1,0,-1):
                a = L[i-2][p]
                c = x[p-1]
                summ += (L[i-1][p-1] * x[p-1])
            x[i-1] = (b[i-1] - summ) / L[i-1][i-1]
        return x
    
    def RegressiveSubstitution(self,U,z):
        n = len(U)
        x = [None]*n

        for i in range(n-1,0,-1):
            summ=0
            for j in range(i+1,n,-1):
                summ += U[i][j] * x[j]
            x[i] = (z[i]- summ) /U[i][i]
        return x

    def printMatrix(self, matrix, n):
        for i in range(0,n):
            for j in range(0, n):
                print (matrix[i][j], end='')
                self.printSpaces(len(str(matrix[i][j])), 30)
            print("\n", end = '')
        print("")
    
    def printSpaces(self, n, k):
        if(n < k):
            for i in range(0, k-n):
                print(" ", end='')

import numpy as np

class GaussianElimination:
    def Gaussian(self, n, matrix):
        print("Original matrix")
        self.printMatrix(matrix, n)

        for k in range(1, n):
            print("Stage " + str(k))
            print("Goal: Fill with zeros under the element A " + str(k) + "," + str(k) + "= " + str(matrix[k-1][k-1]))
            print("\nMultipliers: ")
            for i in range(k+1, n+1):
                multiplier = matrix[i-1][k-1] / matrix[k-1][k-1]
                for j in range(k, n+2):
                    matrix[i-1][j-1] = matrix[i-1][j-1] - multiplier * matrix[k-1][j-1]
                print("Multipliers " + str(i) + " , " + str(k) + ": " + str(multiplier))
            print(" ")
            self.printMatrix(matrix, n)
        
        x = [None]*n
        print("Backward substitution")
        for i in range(n, 0, -1):
            summ = 0
            for p in range(i+1, n+1):
                summ = summ + matrix[i-1][p-1] * x[p-1]
            x[i-1] = (matrix[i-1][n] - summ) / matrix[i-1][i-1]
            print("X" + str(i) + " = " + str(x[i-1]))

    
    def printMatrix(self, matrix, n):
        for i in range(0,n):
            for j in range(0, n+1):
                print (matrix[i][j], end='')
                self.printSpaces(len(str(matrix[i][j])), 30)
            print("\n", end = '')
        print("")
    
    def printSpaces(self, n, k):
        if(n < k):
            for i in range(0, k-n):
                print(" ", end='')


matrix = np.array([
            [2, -1, 0, 3, 1],
            [1, 0.5, 3, 8, 1],
            [0, 13, -2, 11, 1],
            [14, 5, -2, 3, 1]
            ])
n = 4
gaussian = GaussianElimination()
gaussian.Gaussian(n, matrix)
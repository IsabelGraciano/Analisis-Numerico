import numpy as np
import sys


def gaussianElimination(n, matrix, l, b):
    for x in range(1, n):
        firstStep(matrix, x, n, b)
        for i in range(x+1, n+1):
            scalar = matrix[i-1][x-1] / matrix[x-1][x-1]
            for j in range(x, n+2):
                matrix[i-1][j-1] = matrix[i-1][j-1] - scalar*matrix[x-1][j-1]
            print('Multipliers', i, ',', x, ':', scalar)
            l[i-1][x-1] = scalar
        print('AB')
        print(ab)
        print('L')
        print(l)
        print('\n')
    print(ab)
    return ab


def regressiveSubstitution(uz, n):
    answers = [0]*n
    for i in range(n, 0, -1):
        ctrl = 0
        for p in range(i+1, n+1):
            ctrl = ctrl + uz[i-1][p-1] * answers[p-1]
        answers[i-1] = (uz[i-1][n]-ctrl)/uz[i-1][i-1]
        print("x", i, "=", answers[i-1])


def progressiveSubstitution(lb, n):
    z = [0]*n
    for i in range(len(lb)):
        ctrl = 0
        for j in range(i):
            ctrl = ctrl + lb[i][j] * z[j]
        z[i] = (lb[i][n] - ctrl) / lb[i][i]
    return z


def firstStep(matrix, x, n, b):
    row = x-1
    column = x-1

    largest = np.abs(ab[row][column])

    '''
    I'll find the largest number in the column with it's row
    '''
    for i in range(x-1, n):
        aux = np.abs(ab[i][x-1])
        if(aux > largest):
            largest = aux
            row = i

    if(largest == 0):
        print("This method can't be executed")
        sys.exit(0)
    else:
        auxB = b[x-1]
        b[x-1] = b[row]
        b[row] = auxB
        if(row != x-1):
            for i in range(0, ab.shape[1]):
                aux = matrix[x-1][i]
                matrix[x-1][i] = matrix[row][i]
                matrix[row][i] = aux


# Main
n = 4
a = np.array([
    [4, -1, 0, 3],
    [1, 15.5, 3, 8],
    [0, -1.3, -4, 1.1],
    [14, 5, -2, 30]
])

b = np.array([1, 1, 1, 1])
ab = np.c_[a, b]
l = np.identity(n)
uz = gaussianElimination(n, ab, l, b)
lb = np.c_[l, b]
regressiveSubstitution(uz, n)

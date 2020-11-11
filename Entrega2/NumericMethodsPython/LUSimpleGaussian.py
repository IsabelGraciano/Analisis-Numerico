import numpy as np
import sys


def gaussianElimination(ab, l):
    for x in range(1, n):
        for i in range(x+1, n+1):
            scalar = ab[i-1][x-1] / ab[x-1][x-1]
            for j in range(x, n+2):
                ab[i-1][j-1] = ab[i-1][j-1] - scalar*ab[x-1][j-1]
            print('Multipliers', i, ',', x, ':', scalar)
            l[i-1][x-1] = scalar        
        print('AB')
        print(ab)
        print('L')
        print(l)
        print('\n')
    print(ab)
    return ab

def regressiveSubstitution(uz,n):
    answers = [0]*n
    for i in range(n, 0, -1):
        ctrl = 0
        for p in range(i+1, n+1):
            ctrl = ctrl + uz[i-1][p-1] * answers[p-1]
        answers[i-1] = (uz[i-1][n]-ctrl)/uz[i-1][i-1]
        print("x", i, "=", answers[i-1])


def progressiveSubstitution(lb,n):
    z = [0]*n
    for i in range(len(lb)):
        ctrl = 0
        for j in range(i):
            ctrl = ctrl + lb[i][j] * z[j]
        z[i] = (lb[i][n] - ctrl) / lb[i][i]
    return z

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
uz = gaussianElimination(ab, l)
lb = np.c_[l,b]
regressiveSubstitution(uz,n)

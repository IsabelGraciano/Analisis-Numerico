import numpy as np
import sys

def gaussianElimination():
    for x in range(1, n):
        firstStep(x)
        for i in range(x+1, n+1):
            scalar = ab[i-1][x-1] / ab[x-1][x-1]
            for j in range(x, n+2):
                ab[i-1][j-1] = ab[i-1][j-1] - scalar*ab[x-1][j-1]
        print(ab)
        print('\n')
    regressiveSubstitution()
    print(ab)

def firstStep(x):
    largest = np.abs(ab[x-1][x-1])
    relativeValues = [0]*n
    for i in range(x-1,len(ab)):
        firstElement = np.abs(ab[x-1][x-1])
        for j in range(x-1,n):
            aux = np.abs(ab[i][j])
            if(aux > largest):
                largest = np.abs(ab[i][j])
        relativeValues[i] = firstElement/largest

    findLargestRelative(x,relativeValues)

def findLargestRelative(x,relativeValues):
    index = 0
    largestRelative = relativeValues[0]
    for i in range(len(relativeValues)):
        aux = relativeValues[i]
        if(aux > largestRelative):
            largestRelative = aux
            index = i
    
    swapRows(index,x,largestRelative)

def swapRows(row,x,largest):
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
        if(row != x-1):
            for i in range(0, ab.shape[1]):
                aux = ab[x-1][i]
                ab[x-1][i] = ab[row][i]
                ab[row][i] = aux


def regressiveSubstitution():
    answers = [0]*n
    for i in range(n, 0,-1):
        ctrl = 0
        for p in range(i+1, n+1):
            ctrl = ctrl + ab[i-1][p-1] * answers[p-1]
        answers[i-1] = (ab[i-1][n]-ctrl)/ab[i-1][i-1]
        print("x", i, "=", answers[i-1])

ab = np.array([[2, -1, 0, 3, 1],
               [1, 0.5, 3, 8, 1],
               [0, 13, -2, 11, 1],
               [14, 5, -2, 3, 1]])

n = 4
gaussianElimination()

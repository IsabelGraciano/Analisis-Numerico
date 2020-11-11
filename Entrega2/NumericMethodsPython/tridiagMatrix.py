import math
import numpy

def gaussianElimination(matrix):
  multiplier=0
  rowA=1
  colA=0
  for i in range(0,len(matrix)-1):
    multiplier = matrix[rowA][colA]/matrix[rowA-1][colA]
    matrix[rowA][colA+1] -= multiplier*matrix[rowA-1][colA+1]
    matrix[rowA][len(matrix)-1] -= multiplier*matrix[rowA-1][len(matrix)-1]
    matrix[rowA][colA] = 0
    rowA += 1
    colA += 1
  regressiveSubstitution(matrix)
  return matrix

def regressiveSubstitution(matrix):
  n= len(matrix)
  answers= numpy.zeros(shape=(n))
  for i in range(n,0):
    ctrl=0
    for p in range(i+1, n):
      ctrl += matrix[i-1][p-1]*answers[p-1]
    answers[i-1]= (matrix[i-1][n]-ctrl)/matrix[i-1][i-1]
    print("x"+i+" = "+answers[i-1])
  return answers

matrix=[
  [5, 2, 0, 0, 0, 0, 12],
  [1, 4, 2, 0, 0, 0, 24],
  [0, -4, 10, 3, 0, 0, -8],
  [0, 0, 3, 12, -8, 0, 13],
  [0, 0, 0, 5, -25, 4, -30],
  [0, 0, 0, 0, 7, 12, 9],
]
print(gaussianElimination(matrix))

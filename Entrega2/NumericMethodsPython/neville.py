import math
import numpy

def runNeville(x,y,xConst):
  matrix = numpy.zeros(shape=(len(x)-1,len(x)-1))
  count=0
  countXPointer=0
  for j in range(len(matrix[0])):
    for i in range(count, len(matrix)):
      if j==0:
        matrix[i][j]= calculate(xConst, x[i], x[i+1], y[i+1], y[i])
      else:
        matrix[i][j]= calculate(xConst, x[countXPointer], x[countXPointer+j+1], matrix[i][j-1], matrix[i-1][j-1])
        countXPointer+=1
    count+=1
    countXPointer=0
  return matrix

def calculate(x, xiPrev, xi, pi, pil1):
  return (((x - xiPrev) * pi) - ((x - xi) * pil1)) / (xi - xiPrev);

print(runNeville([1, 1.2, 1.4, 1.6, 1.8, 2],[0.674732261, 0.849196173, 1.121407696, 1.492135973, 1.960735619, 2.525897371],1.45))

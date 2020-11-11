import math
import os
import numpy

def clear(): os.system('clear')

def linearSpline(x):
  matrix=numpy.zeros(shape=(2*(len(x)-1),2*(len(x)-1)))
  countPair=0
  for i in range(len(x)):
    matrix[i][countPair]= x[i]
    matrix[i][countPair + 1]= 1
    if i != 0:
      countPair +=2
  
  countPair=0
  count= len(x)
  for i in range(1, len(x)-1):
    matrix[count][countPair]=x[i]
    matrix[count][countPair+1]=1
    matrix[count][countPair+2]=-x[i]
    matrix[count][countPair+3]=-1
    countPair += 2
    count += 1
  return matrix

def squareSpline(x):
  matrix=numpy.zeros(shape=(3*(len(x)-1),3*(len(x)-1)))
  countPair=0
  for i in range(len(x)):
    matrix[i][countPair]= x[i]**2
    matrix[i][countPair + 1]= x[i]
    matrix[i][countPair + 2]= 1
    if i != 0:
      countPair +=3

  countPair=0
  count= len(x)
  for i in range(1, len(x)-1):
    matrix[count][countPair]=x[i]**2
    matrix[count][countPair+1]=x[i]
    matrix[count][countPair+2]=1
    matrix[count][countPair+3]=-(x[i]**2)
    matrix[count][countPair+4]=-x[i]
    matrix[count][countPair+5]=-1
    countPair += 3
    count += 1

  countPair=0
  for i in range(1, len(x)-1):
    matrix[count][countPair]=2*x[i]
    matrix[count][countPair+1]=1
    matrix[count][countPair+3]=-2*x[i]
    matrix[count][countPair+4]=-1
    countPair += 3
    count += 1
  
  matrix[count][0]=2

  return matrix

def cubicSpline(x):
  matrix=numpy.zeros(shape=(4*(len(x)-1),4*(len(x)-1)))
  countPair=0
  for i in range(len(x)):
    matrix[i][countPair]= x[i]**3
    matrix[i][countPair + 1]= x[i]**2
    matrix[i][countPair + 2]= x[i]
    matrix[i][countPair + 3]= 1
    if i != 0:
      countPair +=4

  countPair=0
  count= len(x)
  for i in range(1, len(x)-1):
    matrix[count][countPair]=x[i]**3
    matrix[count][countPair + 1]=x[i]**2
    matrix[count][countPair + 2]=x[i]
    matrix[count][countPair + 3]=1
    matrix[count][countPair + 4]=-(x[i]**3)
    matrix[count][countPair + 5]=-(x[i]**2)
    matrix[count][countPair + 6]=-x[i]
    matrix[count][countPair + 7]=-1
    countPair += 4
    count += 1

  countPair=0
  for i in range(1, len(x)-1):
    matrix[count][countPair]=3*(x[i]**2)
    matrix[count][countPair+1]=2*x[i]
    matrix[count][countPair+2]=1
    matrix[count][countPair+4]=-3*(x[i]**2)
    matrix[count][countPair+5]=-2*x[i]
    matrix[count][countPair+6]=-1
    countPair += 4
    count += 1

  countPair=0
  for i in range(1,len(x)-1):
    matrix[count][countPair]=6*x[i]
    matrix[count][countPair+1]=2
    matrix[count][countPair+4]=-6*x[i]
    matrix[count][countPair+5]=-2
    countPair += 4
    count += 1

  matrix[count][0]=6*x[0]
  matrix[count][1]=2
  count+=1
  matrix[count][len(matrix)-4]= 6*x[len(x)-1]
  matrix[count][len(matrix)-3]= 2

  return matrix

print(linearSpline([-1,0,3,4])) 
print(squareSpline([-1,0,3,4]))
print(cubicSpline([-1,0,3,4]))

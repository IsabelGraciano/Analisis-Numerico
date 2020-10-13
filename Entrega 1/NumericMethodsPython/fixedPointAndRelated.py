import math
import os

nMaxCounter=0;
tolerance=0.0000001;
nMax=100;

def clear(): os.system('clear')

def fixedPoint(x):
  xi= evaluateG(x)
  global nMaxCounter
  global nMax
  if abs( xi - x ) < tolerance or nMaxCounter == nMax:
    print("| " + str(nMaxCounter) + " " + "|  " + str(x) + "  " + "|  " + str(xi) + "  " + "|  " + str(evaluateF1(x)) + "  " + "|  " + str(abs(xi - x)) + "  |")
    print("The root reached was " + str(xi))
    return xi
  else:
    print("| " + str(nMaxCounter) + " " + "|  " + str(x) + "  " + "|  " + str(xi) + "  " + "|  " + str(evaluateF1(x)) + "  " + "|  " + str(abs(xi - x)) + "  |")
    nMaxCounter+=1
    return fixedPoint(xi)

def newton(x):
  xi= x-(evaluateF(x)/evaluateFDerived(x))
  global nMaxCounter
  global nMax
  if abs( xi - x ) < tolerance or nMaxCounter == nMax:
    print("| " + str(nMaxCounter) + " " + "|  " + str(xi) + "  " + "|  " + str(evaluateF(xi)) + "  " + "|  " + str(abs(xi - x)) + "  |")
    print("The root reached was " + str(xi))
    return xi
  else:
    print("| " + str(nMaxCounter) + " " + "|  " + str(x) + "  " + "|  " + str(evaluateF(x)) + "  " + "|  " + str(abs(xi - x)) + "  |")
    nMaxCounter+=1
    return newton(xi)

def secant(x,xPrev):
  xEvaluated= evaluateF(x)
  xi= x-(xEvaluated*(x-xPrev)/(xEvaluated-evaluateF(xPrev)))
  global nMaxCounter
  global nMax
  if abs( xi - x ) < tolerance or nMaxCounter == nMax:
    print("| " + str(nMaxCounter) + " " + "|  " + str(xi) + "  " + "|  " + str(evaluateF(xi)) + "  " + "|  " + str(abs(xi - x)) + "  |")
    print("The root reached was " + str(xi))
    return xi
  else:
    print("| " + str(nMaxCounter) + " " + "|  " + str(x) + "  " + "|  " + str(evaluateF(x)) + "  " + "|  " + str(abs(xi - x)) + "  |")
    nMaxCounter+=1
    return secant(xi,x)

def fakeRule(a,b):
  global nMaxCounter
  global nMax
  aEvaluated=evaluateF(a);
  bEvaluated=evaluateF(b);
  r=((a*bEvaluated)-(b*aEvaluated))/(bEvaluated-aEvaluated)
  rEvaluated=evaluateF(r);
  if rEvaluated*aEvaluated<0:
    if abs(r-b)<tolerance or nMaxCounter==nMax:
      print("| " + str(nMaxCounter) + " " + "| " + str(a) + " " + "| " + str(r) + " " + "| " + str(b) + " " + "| " + str(rEvaluated) + " " + "| " + str(abs(r - b)) + " |")
      print("The root reached was " + str(r))
      return r
    else:
      print("| " + str(nMaxCounter) + " " + "| " + str(a) + " " + "| " + str(r) + " " + "| " + str(b) + " " + "| " + str(rEvaluated) + " " + "| " + str(abs(r - b)) + " |")
      nMaxCounter+=1
      return fakeRule(a,r)
  elif rEvaluated*bEvaluated<0:
    if abs(r-a)<tolerance or nMaxCounter==nMax:
      print("| " + str(nMaxCounter) + " " + "| " + str(a) + " " + "| " + str(r) + " " + "| " + str(b) + " " + "| " + str(rEvaluated) + " " + "| " + str(abs(r - a)) + " |")
      print("The root reached was " + str(r))
      return r
    else:
      print("| " + str(nMaxCounter) + " " + "| " + str(a) + " " + "| " + str(r) + " " + "| " + str(b) + " " + "| " + str(rEvaluated) + " " + "| " + str(abs(r - a)) + " |")
      nMaxCounter+=1
      return fakeRule(r,b)
  else:
    print("There isn't sign change")
    return 0

def steffensen(x):
  global nMaxCounter
  global nMax
  xEvaluated= evaluateF(x)
  xi= x-(pow(xEvaluated,2)/(evaluateF(x+xEvaluated)-xEvaluated))
  if abs( xi - x ) < tolerance or nMaxCounter == nMax:
    print("| " + str(nMaxCounter) + " " + "|  " + str(xi) + "  " + "|  " + str(evaluateF(xi)) + "  " + "|  " + str(abs(xi - x)) + "  |")
    print("The root reached was " + str(xi))
    return xi
  else:
    print("| " + str(nMaxCounter) + " " + "|  " + str(x) + "  " + "|  " + str(evaluateF(x)) + "  " + "|  " + str(abs(xi - x)) + "  |")
    nMaxCounter+=1
    return steffensen(xi)

def evaluateF(x):
  return math.log(pow(math.sin(x),2)+1)-(1.0/2)

def evaluateFDerived(x):
  return 2*pow(pow(math.sin(x),2)+1, -1)*math.sin(x)*math.cos(x)

def evaluateF1(x):
  return math.log(pow(math.sin(x),2)+1)-(1.0/2)-x

def evaluateG(x):
  return math.log(pow(math.sin(x),2)+1)-(1.0/2)

clear()
print("|ite|          xi           |         g(xi).         |         f(xi)         |          E          |")
fixedPoint(-0.5)

nMaxCounter=0
print("|ite|          xi           |         f(xi)         |          E          |")
newton(0.5)

nMaxCounter=0
print("|ite|          xi           |         f(xi)         |          E          |")
secant(1,0.5)

nMaxCounter=0
print("| iter |     a         |     xm        |     b          |     f(Xm)  |     E     |")
fakeRule(0,1)

nMaxCounter=0
print("|ite|          xi           |         f(xi)         |          E          |")
steffensen(-0.5)

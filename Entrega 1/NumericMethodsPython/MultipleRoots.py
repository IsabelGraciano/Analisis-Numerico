
import math

# author Valeria

def f(x):
    #return h(x) =e^x - x - 1
    return (math.pow((math.exp(1)), x)) - x - 1

def df1(x):
    #return h'(x) =e^x - 1
    return (math.pow((math.exp(1)), x)) - 1

def df2(x):
    #return h''(x) =e^x
    return (math.pow((math.exp(1)), x))

def roots(x0, tolerance, iterations):

    resultf = f(x0)
    resultf1 = df1(x0)
    resultf2 = df2(x0)
    i = 0;

    #Method data input control
    if iterations < 1:
        print("Iterations must be greater than 0")

    if resultf == 0:
        print(x0 + "Its a root")
    
    #First iteration (iteration 0)
    print("Iter: " , i)
    print("x0: " ,x0)
    print("f(xi): " , f(x0))
    print("E: ")
    print("")
    i += 1
    xi = x0 - ((resultf * resultf1) /(math.pow(resultf1, 2) - (resultf * resultf2)))

    #Loop start
    while(resultf != 0 and i <= iterations and abs(xi - x0) > tolerance):
        error = abs(xi - x0)
        x0 = xi
        resultf = f(x0)
        resultf1 = df1(x0)
        resultf2 = df2(x0)
        xi = x0 - ((resultf * resultf1) / (math.pow(resultf1, 2) - (resultf * resultf2)))

        print("Iter: " , i)
        print("x0: " , x0)
        print("f(xi): " , resultf)
        print("E: " , error)
        print("")
        i += 1

    if resultf == 0:
        print("An approximation of the root was found in " , (xi))
    elif i > iterations:
        print("Iteration limit reached")
    elif (abs(xi - x0) < tolerance):
        print("The maximum tolerance permitted " , (tolerance) , ". In the iteration " , (i) , " the maximum tolerance was reached " , abs(xi - x0))
        print("Data in the last iteration")
        print("Iteration " , (i - 1))
        print("x0= " , (x0))
        print("f(x0)= " + f(x0))
        print("E= " , (abs(xi - x0)))


roots(1, math.pow(10, -7), 100)
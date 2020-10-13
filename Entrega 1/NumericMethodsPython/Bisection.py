
import math

# author Valeria

def f(x):
    # function
    return ((math.log((math.pow((math.sin(x)), 2)) + 1)) - (0.5))

#bisection method
def bisection(a, b, iterations, tolerance):
    x0 = 0
    y0 = 0
    i = 1
    xm = (a + b) / 2
    result = f(xm)

    #Method data input control
    if iterations < 1:
        print("Iterations must be greater than 0")

    if result == 0:
        print(xm + " Its a root")
        
    if f(a) * f(b) > 0:
        print("There is no root in this interval")
    
    #First iteration
    print("Iter: " , i)
    print("a: " , a)
    print("xm: " , xm)
    print("b: " , b)
    print("f(xm): " , f(xm))
    print("E: ")
    print("")
    i += 1

    #Loop start
    while (result != 0 and i <= iterations and abs(x0 - xm) > tolerance):
        print("Iter: " , i)
        if (result * f(a) < 0):
            a = a
            b = xm
        else:
            b = b
            a = xm
        
        x0 = xm
        y0 = result
        xm = (a + b) / 2
        result = f(xm);
        i += 1

        print("a: " , a)
        print("xm: " , xm)
        print("b: " , b)
        print("f(xm): " , f(xm))
        print("E: " , (abs(x0 - xm)))
        print("")
        
        

    #Method data output control
    if (result == 0):
        print("An approximation of the root was found in " , (xm))
    elif (i > iterations):
        print("Iteration limit reached")
    elif (abs(x0 - xm) < tolerance):
        print("The maximum tolerance permitted " , (tolerance) , ". In the iteration " , (i) , " the maximum tolerance was reached " , (abs(x0 - xm)))
        print("Data in the last iteration")
        print("Iteration " , (i-1))
        print("xm= " , (xm))
        print("f(xm)= " , f(xm))
        print("E= " , (abs(x0 - xm)))
        
        

bisection(0, 1, 100, math.pow(10, -7))
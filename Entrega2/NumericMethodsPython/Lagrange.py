

#Author Valeria

def lagrange(x,y,n):
    aux = []
    den = 0
    mul = 1
    for i in range(n):
        print("L" , i , "= ", end=" ")
        for j in range(n):
            if(i!=j):
                den = (x[i]-x[j])
                mul=mul*den
                print("(x - " , x[j] , ")", end=" ")
            
        
        print(" " , ((1/mul)*y[i]) ,"\n")
        mul=1
    


x = [-2,-1,2,3]
y = [12.13533528, 6.367879441, -4.610943901, 2.085536923]
n = len(x)

lagrange(x, y, n);

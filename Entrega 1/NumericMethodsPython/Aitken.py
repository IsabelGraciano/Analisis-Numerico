import numpy as np

class Aitken:
    def __init__(self):
        self.function = None
        self.x1 = None
        self.x2 = None
        self.x3 = None
        self.x4 = None
        self.y = None
        self.ESP = 0.0000001
        self.n = 5

    def evaluateFunction(self, x):
        self.function = 1 - 0.5*x*x
        return self.function

    def run(self):
        for i in range(1, self.n, 1):
            self.x2 = self.evaluateFunction(self.x1)
            self.x3 = self.evaluateFunction(self.x2)

            if(abs(self.x3-self.x2)<self.ESP):
                print(self.x3)
            else:
                self.y = self.x3 - 2 * self.x2 + self.x1
                self.x1 = self.x3-(((self.x3-self.x2)*(self.x3-self.x2))/self.y) 
    
    def readX1(self):
        print("Insert X1")
        x1input = input()
        try:
            self.x1 = float(x1input)
        except:
            print("Insert a valid X1")
            self.readX1()

aitken = Aitken()
aitken.readX1()
aitken.run()
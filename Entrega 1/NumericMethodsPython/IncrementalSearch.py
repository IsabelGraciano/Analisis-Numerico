import numpy as np


class IncrementalSearch():
    def __init__(self):
        self.start = None
        self.increase = None
        self.iteration = 50
        self.function = None     

    def evaluate_function(self, x):
        self.function = ( np.log( np.power( np.sin(x), 2 ) + 1 ) ) -0.5
        return self.function

    def runSearch(self):
        negative = False
        positive = False
        root = False
        valuePositive = 0
        valueNegative = 0

        for i in np.arange(self.start, self.iteration, self.increase):
            value = self.evaluate_function(i)
            if(value == 0):
                print(i + " is a root of the function.")
            else:
                if(value < 0):
                    negative = True
                    valuePositive = i
                
                if(value>0):
                    positive = True
                    valueNegative = i

                if(i != self.start):
                    if((negative == True) and (positive == True)):
                        if(valueNegative < valuePositive):
                            print("There is a root between [" + str(valueNegative) + " , " + str(valuePositive) + "]")
                        else:
                            print("There is a root between [" + str(valuePositive) + " , " + str(valueNegative) + "]")
                        root = True
                        negative = positive = False
        
        if (root == False):
            print("The root was not found")


    def readPrevious(self):
        print("Insert a start value")
        startinput = input()
        try:
            self.start = float(startinput)
        except:
            print("Insert a valid start value")
            self.readPrevious()


    def readIncrease(self):
        print("Insert an increase value")
        increaseinput = input()
        try:
            self.increase = float(increaseinput)
        except:
            print("Insert a valid increase value")
            self.readIncrease()

incs = IncrementalSearch()
incs.readPrevious()
incs.readIncrease()
incs.runSearch()

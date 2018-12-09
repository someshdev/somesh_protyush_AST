import numpy as np
import time
class Robot(object):
    """docstring for Robot."""
    def __init__(self):
        self.object=[("knife",1),("scissor",2),("fork", 3),("spoon", 4),("keys", 5)]
        self.RGBD = None
        self.RGB=None
        self.Sensor3=None
        self.Sensor4=None
        #print "constructor"

    def input(self,reading1=None,reading2=None):
        #print "Input"
        found= False
        #since we have only 5 objects for detection we check for 5 values in a reading
        if reading1 is not None:
            #print "not None check1"
            self.RGBD = np.empty((5,3),dtype=reading1.dtype)
            length1=reading1.shape[0]

            for i in range(5):
                found= False
                for j in range(length1):
                    #print i+1,reading1[j,1]
                    if (i+1)==int(reading1[j,1]):
                        found= True
                        self.RGBD[i]=reading1[j]
                        break
                if not found:
                    self.RGBD[i]=(None,None,None)
                #print self.RGBD[i]




        else:
            self.RGBD=None
        print self.RGBD
        if reading2 is not None:
            #print "not None check2"
            self.RGB=np.empty((5,3),dtype=reading2.dtype)
            length2=reading2.shape[0]
            for i in range(5):
                found= False
                for j in range(length2):
                    #print i+1,reading2[j,1]
                    if (i+1)==int(reading2[j,1]):
                        #print i
                        #print "found"
                        found= True
                        #print self.RGB[i]
                        self.RGB[i]=reading2[j]
                        #print self.RGB[i]
                        break
                if not found:
                    self.RGB[i]=(None,None,None)
                #print self.RGB[i]
        else:
            self.RGB=None
        print self.RGB


    def recognise(self):
        if self.RGBD is None:
            return self.RGB
        if self.RGB is None:
            return self.RGBD
        recognised=list()
        for i in range(5):
            a=float(self.RGBD[i,2])
            b=float(self.RGB[i,2])
            if a is None:
                if b!=None:
                    t=(float(self.RGB[i,2]),)
                    recognised.append((self.object[i]+t))
                continue
            if b is None:
                if a!=None:
                    t=(float(self.RGBD[i,2]),)
                    recognised.append((self.object[i]+t))
                continue

            if a-b>0:
                t=(float(self.RGBD[i,2]),)
                recognised.append((self.object[i]+t))

            else:
                t=(float(self.RGB[i,2]),)
                recognised.append((self.object[i]+t))
        print recognised
        return recognised

reading1=np.array([("knife",1, 0.99), ("scissor", 2, 0.65), ("spoon", 3, 0.33), ("spoon", 4, 0.80), ("keys", 5, 0.95)])
reading2=np.array([ ("keys", 5, 0.95), ("spoon", 4, 0.99),("fork", 3, 0.99), ("scissor", 2, 0.95), ("knife",1, 0.55)])
reading=Robot()
reading.input(reading1,reading2)
reading.recognise()

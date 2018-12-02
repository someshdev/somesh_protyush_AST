import numpy as np
class Robot(object):
    """docstring for Robot."""
    def __init__(self, RGBD,RGB):
        self.RGBD = RGBD
        self.RGB=RGB
        self.Sensor3=None
        self.Sensor4=None

    def recognise(self):
        length=self.RGBD.shape[0]
        recognised=list()
        for i in range(length):
            a=float(self.RGBD[i,2])
            b=float(self.RGB[i,2])
            if a-b>0:
                recognised.append(self.RGBD[i])

            else:
                recognised.append(self.RGB[i])

        return recognised

RGBD=np.array([("knife",1, 0.99), ("scissor", 2, 0.65), ("spoon", 3, 0.33), ("spoon", 4, 0.80), ("keys", 5, 0.95)])
RGB=np.array([("knife",1, 0.55), ("scissor", 2, 0.95), ("fork", 3, 0.99), ("spoon", 4, 0.99), ("keys", 5, 0.95)])
reading=Robot(RGBD,RGB)
print reading.recognise()

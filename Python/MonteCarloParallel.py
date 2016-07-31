from math import sqrt
from multiprocessing import Pool
import random
import time

def MonteCarlo(n):
    inside = 0
    for i in range(0,n):    
        x=random.uniform(-1,1)
        y=random.uniform(-1,1)
        if sqrt((x*x)+(y*y))<=1:
            inside+=1
    pi=inside/n*4
    print ("The approximation of pi with ", n, " values is", pi)

startTime = time.time()
p = Pool(1)
print(p.map(MonteCarlo, [100, 1000, 10000]))
endTime = time.time()
print('With 1 process, it took %s seconds to calculate.' % (endTime - startTime),"\n")

startTime = time.time()
p = Pool(4)
print(p.map(MonteCarlo, [100, 1000, 10000]))
endTime = time.time()
print('With 4 processes, it took %s seconds to calculate.' % (endTime - startTime),"\n")

startTime = time.time()
p = Pool(10)
print(p.map(MonteCarlo, [100, 1000, 10000]))
endTime = time.time()
print('With 10 processes, it took %s seconds to calculate.' % (endTime - startTime),"\n")

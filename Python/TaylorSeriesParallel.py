import math
import time
from multiprocessing import Pool

def factorial(n):
    if n == 0:
        return 1
    else:
        return n * factorial(n-1)

def e(n): 
    eRes = 0
    for i in range(n):
        res = (1**i)/factorial(i)
        eRes += res
    print("The Taylor Series approximation of e with", n, "values is",eRes)

startTime = time.time()
p = Pool(1)
print(p.map(e, [10, 20, 30]))
endTime = time.time()
print('With 1 process, it took %s seconds to calculate.' % (endTime - startTime),"\n")


startTime = time.time()
p = Pool(4)
print(p.map(e, [10, 20, 30]))
endTime = time.time()
print('With 4 processes, it took %s seconds to calculate.' % (endTime - startTime),"\n")


startTime = time.time()
p = Pool(10)
print(p.map(e, [10, 20, 30]))
endTime = time.time()
print('With 10 processes, it took %s seconds to calculate.' % (endTime - startTime),"\n")


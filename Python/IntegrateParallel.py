import math
import time
from multiprocessing import Pool

def f(x):
    result = math.sin(x)
    return result

def integrate(n):
    a = 0
    b = math.pi
    s = 0
        
    first = (b-a)/n
    second = f(a) / 2
    third = (b-a)/n
    fourth = f(b) / 2

    for k in range(0, n-1):
        i = a + k*third
        s = s + f(i)

    integ = first * ((second + s) + fourth)
    print ("The integration with a n value of", n, "is", integ)

startTime = time.time()
p = Pool(1)
print(p.map(integrate, [100, 1000, 10000]))
endTime = time.time()
print('With 1 process, it took %s seconds to calculate.' % (endTime - startTime),"\n")

startTime = time.time()
p = Pool(4)
print(p.map(integrate, [100, 1000, 10000]))
endTime = time.time()
print('With 4 processes, it took %s seconds to calculate.' % (endTime - startTime),"\n")

startTime = time.time()
p = Pool(10)
print(p.map(integrate, [100, 1000, 10000]))
endTime = time.time()
print('With 10 processes, it took %s seconds to calculate.' % (endTime - startTime),"\n")


import time
from random import choice
import numpy as np
from collections import deque

import random


genRandom=np.random.randint(1,100 , 20)
print(genRandom)

list=[n for n in range(100)]
stack=[n for n in range(100)]
queue=[n for n in range(100)]

set={n for n in range(100)}

def dictInitialization():
    Dict = {}
    for i in range(100):
        Dict[i] = i

    return Dict;

dict=dictInitialization();

print (102 in dict.values())


def findNormalList():
    cnt=0
    for i in range(10):
       for elem in list :
           if elem == genRandom[i]:
            cnt+=1
    return cnt

def findFucntionList():
    cnt = 0
    for i in range(10):
        if genRandom[i] in list:
            cnt += 1
    return cnt

def findElemsinDict():
    cnt=0
    for i in range(10):
        cnt+= dict.get(genRandom[i])
    return cnt

def findElemsinSet():
    cnt=0
    for i in range(10):
        if genRandom[i] in set:
            cnt +=1
    return cnt
# the list container can be use as a stack so it will be skipped

def test_findElemsinDict(benchmark):
    # benchmark something

    benchmark(findElemsinDict)

def test_findFucntionList(benchmark):
    # benchmark something

    benchmark(findFucntionList)


def test_findNormalList(benchmark):
    # benchmark something

    benchmark(findNormalList)


def test_findElemsinSet(benchmark):
    benchmark(findElemsinSet)

# def test_addElementDict(benchmark):
#     benchmark.pedantic(addElementDict, args=(dict, random.randrange(0,100), random.randrange(0,100)))

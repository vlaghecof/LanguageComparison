import time
from random import choice
import numpy as np
from collections import deque

import random


genRandom=np.random.randint(100,1000 , 20)
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


def NotFindNormalList():
    cnt=0
    for i in range(10):
       for elem in list :
           if elem == genRandom[i]:
            cnt+=1
    return cnt

def NotFindFucntionList():
    cnt = 0
    for i in range(10):
        if genRandom[i] in list:
            cnt += 1
    return cnt

def NotFindElemsinDict():
    cnt=0
    for i in range(10):
        dict.get(genRandom[i])
        cnt+=1
    return cnt

def NotFindElemsinSet():
    cnt=0
    for i in range(10):
        if genRandom[i] in set:
            cnt +=1
    return cnt
# the list container can be use as a stack so it will be skipped

def test_NotFindElemsinDict(benchmark):
    # benchmark something

    benchmark(NotFindElemsinDict)

def test_NotfindFucntionList(benchmark):
    # benchmark something

    benchmark(NotFindFucntionList)


def test_NotfindNormalList(benchmark):
    # benchmark something

    benchmark(NotFindNormalList)


def test_NotfindElemsinSet(benchmark):
    benchmark(NotFindElemsinSet)

# def test_addElementDict(benchmark):
#     benchmark.pedantic(addElementDict, args=(dict, random.randrange(0,100), random.randrange(0,100)))

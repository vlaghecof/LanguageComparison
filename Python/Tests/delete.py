import time
from random import choice
import numpy as np
from collections import deque

import random


genRandom= [ n for n in random.sample(range(1,40) , 20)]



list=[n for n in range(100)]
list1=[n for n in range(100)]
list2=[n for n in range(100)]
stack=[n for n in range(100)]
queue=[n for n in range(100)]

set={n for n in range(100)}

def dictInitialization():
    Dict = {}
    for i in range(100):
        Dict[i] = i

    return Dict;

def listInit():
   list=[n for n in range(100)]
   return list

dict=dictInitialization();

print(list )
print(genRandom)




def deleteNormalListElement(list12):

    for i in range(10):
           list12.remove(genRandom[i]);

    return 3421




def deleteNormalListIndex(list1):
    for i in range(10):
           list1.pop(genRandom[i]);

    return list.__len__()



def deleteNormalListFunction(list2):

    for i in range(10):
         del list2[genRandom[i]]

    return 4235

print("dict:",dict)

def deleteElemsinDict(dict:{}):
    cnt=0

    for i in range(10):
         del dict[i] #  dict.pop(i+1)
         cnt+=1
    return cnt

print("set:",set)
print("rand:",genRandom)

def deleteElemsinSet():
    cnt=0
    for i in range(10):
        set.discard(genRandom[i])
        cnt+=1
    return cnt
# the list container can be use as a stack so it will be skipped


def test_deleteElemsinSet(benchmark):
    benchmark(deleteElemsinSet)

def test_deleteElemsinDict(benchmark):
    dict=dictInitialization()
    benchmark.pedantic(deleteElemsinDict, args=(dictInitialization(),))


def test_deleteNormalListFunction(benchmark):
    benchmark.pedantic(deleteNormalListFunction, args=(listInit(),))


def test_deleteNormalListIndex(benchmark):
    benchmark.pedantic(deleteNormalListIndex, args=(listInit(),))




def test_deleteNormalListElement(benchmark):
    benchmark.pedantic(deleteNormalListElement, args=(listInit(),))



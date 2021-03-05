import time
from random import choice
import numpy as np
from collections import deque

import random

selectedRandom=[]
genRandom=np.random.randint(1,100 , 20)
print(genRandom)

list=[n for n in range(100)]
stack=[n for n in range(100)]
queue=[n for n in range(100)]

set={n for n in range(100)}

def dictInitialization():
    Dict = {}
    for i in range(100):
        Dict[i] = random.randrange(100, 200)
    return Dict;

dict=dictInitialization();


def select(list,range):
    for _ in range(range):
         selectedRandom.append(choice(list))


def AddList():
    """
    Function that needs some serious benchmarking.
    """
    for i in range(10):
       list.append(genRandom[i])
    return list


def AddQueue():
    """
    Function that needs some serious benchmarking.
    """
    for i in range(10):
       queue.append(genRandom[i])

    return 124

def AddStack():
    """
    Function that needs some serious benchmarking.
    """
    for i in range(10):
       stack.append(genRandom[i])
    return 124

def addElementDict(dict, key, elem):
    dict[elem] = key

def AddSet():
    """
    Function that needs some serious benchmarking.
    """
    for i in range(10):
       set.add(genRandom[i]+102)

    return set

# the list container can be use as a stack so it will be skipped

def test_Add_Set(benchmark):
    # benchmark something

    result=benchmark(AddSet)

def test_Add_List(benchmark):
    # benchmark something

    result=benchmark(AddList)


def test_Add_Queue(benchmark):
    # benchmark something

    benchmark(AddQueue)

def test_Add_Stack(benchmark):
    # benchmark something

    benchmark(AddStack)

def test_addElementDict(benchmark):
    benchmark.pedantic(addElementDict, args=(dict, random.randrange(0,100), random.randrange(0,100)))

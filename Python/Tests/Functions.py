import math

a=[1]
t=1




def StackIncrement():
    x=0
    x+=1
    return x

def HeapIncrement():
    y=t+1
    return y


# string searv
def StringSearch():
    if "test" in "Prepare test for class" :
        return True


def ClasicalStringSearch():
    input = "Prepare test for class".split()
    for word in input :
        if word=="test":
            return True


def ArgsTest(*args):
    result = 0
    for x in args:
        result += x
    return result

def ClasicArgsTest(a:[]):
    result = 0
    for i in range(len(a)):
     result +=a[i]
    return result

def KwargsTest(**kwargs): #pass a key value (As a dict) pair
    result = 0
    for key, value in kwargs.items():
        result += value
    return result

# def helpKwargsTest():
#     return KwargsTest(a="Real", b="Python", c="Is", d="Great", e="!")





def helpKwargsTest():
    return KwargsTest(a=2, b=4, c=5, d=5)


def factorialTestNomal():
    fact=1
    for i in range(1, 100 + 1):
        fact = fact * i
    return fact

def factorialTestRecursive(n):
    if n == 1:
        return n
    else:
        return n * factorialTestRecursive(n - 1)

def buildInFactorial():
    return math.factorial(100)




def test_StackIncrement(benchmark):
 benchmark(StackIncrement)

def test_HeapIncrement(benchmark):
 benchmark(HeapIncrement)

def test_StringSearch(benchmark):
 benchmark(StringSearch)

def test_ClasicalStringSearch(benchmark):
 benchmark(ClasicalStringSearch)


def test_ArgsTest(benchmark):

    benchmark.pedantic(ArgsTest, args=(1,2,3,4))

def test_ClasicArgsTest(benchmark):

    lst=[1,2,3,4]
    benchmark.pedantic(ClasicArgsTest, args=( lst ,)  )

def test_helpKwargsTest(benchmark):
   benchmark(helpKwargsTest)


def test_factorialTestNomal(benchmark):
 benchmark(factorialTestNomal)

def test_factorialTestRecursive(benchmark):
    benchmark.pedantic(factorialTestRecursive, args=(100,))

def test_buildInFactorial(benchmark):
 benchmark(buildInFactorial)




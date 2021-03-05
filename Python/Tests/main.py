import math
import time
import pyperclip

# import lin
#

'''the part where you design the time measuring'''
'''  class test() :
    
        def __init__(self,tt : int) -> None:
            super().__init__()
            self.tt=tt
    
    def f1(degrees):
        return math.cos(degrees)
    
    
    def f2(degrees):
        e = 2.718281828459045
        return (
            (e**(degrees * 1j) + e**-(degrees * 1j)) / 2
        ).real
    
    
    
    
    @profile
    def f5():
        x=test(2)
        x.tt+=1
    #
    @profile
    def f6():
        x=2
        x+=1
    
    x= "AWESOME"
    def f3 () :
        x = "AWESOME3"
        return x + "True"
    
    
    
    def f4 ():
       return x + "True"
    
    
    f3()
    f4()
    
    
    # Assertions
    # assert f1(100) == f2(100) == 0.862318872287684
    # assert f1(1) == f2(1) == 0.5403023058681398
    
    
    # Reporting
    import time
    import random
    import statistics
    
    functions = f6, f5
    times = {f.__name__: [] for f in functions}
    
    print(times)
    
    
    
    for i in range(100):  # adjust accordingly so whole thing takes a few sec
        func = random.choice(functions)
        t0 =time.perf_counter_ns()
        func()
        t1=time.perf_counter_ns()
        times[func.__name__].append((t1 - t0) * 1000)
    
    
    for name, numbers in times.items():
        print('FUNCTION:', name, 'Used', len(numbers), 'times')
        print('\tMEDIAN', statistics.median(numbers))
        print('\tMEAN  ', statistics.mean(numbers))
        print('\tSTDEV ', statistics.stdev(numbers))

'''



'''this is with line profiler '''
"""  if __name__ == '__main__':
       # fast_function()
       #slow_function()
       f5()
       f6()
"""

'''this is with the build in timeit from python '''


def my_function():
    try:
        1 / 0
    except ZeroDivisionError:
        pass

def f6():
        x=2
        x+=1




def something2(duration):
    """
    Function that needs some serious benchmarking.
    """
    time.sleep(duration)
    # You may return anything you want, like the result of a computation
    return 123

def test_my_stuff33(benchmark):
    # benchmark something
    def setup():
        # can optionally return a (args, kwargs) tuple
        return {1},{}

    result=benchmark.pedantic(something2, setup=setup)

    # Extra code, to verify that the run completed correctly.
    # Sometimes you may want to check the result, fast functions
    # are no good if they return incorrect results :-)
    assert result == 123

# pytest main.py , pytest --help

# if __name__ == "__main__":
#     import timeit
#
#     setup = "from __main__ import f6"
#     x=timeit.timeit("f6()", setup=setup,number=1000)/1000
#     y=timeit.timeit("f6()", setup=setup,number=1)
#     # print ( x, "\n" ,y ," \n")
#     #
#     # print( x)
#
#
#


# pytest-benchmark compare 0001  --csv=oooooasdasd.csv








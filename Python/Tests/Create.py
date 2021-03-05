def normalCreation(size:int) -> []:
    """
    Function that needs some serious benchmarking.
    """
    list=[];
    for i in range(size):
        list.append(2*i)
    # You may return anything you want, like the result of a computation
    return list

def Generators(size:int) -> []:
    """
    Function that needs some serious benchmarking.
    """
    list= [ 2*n for n in range(size)]


    # You may return anything you want, like the result of a computation
    return list

def Lambda(size:int) -> []:
    """
    Function that needs some serious benchmarking.
    """
    lists= list(map(lambda x: x*2, range(size)))


    # You may return anything you want, like the result of a computation
    return lists

def test_NormalCreation(benchmark):
    # benchmark something
    def setup():
        # can optionally return a (args, kwargs) tuple
        return {100},{}

    result=benchmark.pedantic(normalCreation, setup=setup)

    # Extra code, to verify that the run completed correctly.
    # Sometimes you may want to check the result, fast functions
    # are no good if they return incorrect results :-)
    assert result != 123

def test_GeneratorCreation(benchmark):
    # benchmark something

    def setup():
        # can optionally return a (args, kwargs) tuple
        return {100}, {}

    result=benchmark.pedantic(Generators, setup=setup)

    # Extra code, to verify that the run completed correctly.
    # Sometimes you may want to check the result, fast functions
    # are no good if they return incorrect results :-)
    assert result != 123

def test_LambdaCreation(benchmark):
    # benchmark something

    def setup():
        # can optionally return a (args, kwargs) tuple
        return {100}, {}

    result=benchmark.pedantic(Lambda, setup=setup)

    # Extra code, to verify that the run completed correctly.
    # Sometimes you may want to check the result, fast functions
    # are no good if they return incorrect results :-)
    assert result != 123


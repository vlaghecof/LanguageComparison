from typing import Any


class Vehicle :

    def __init__(self):
        self.brand="Ford"
        self.year=1990
        self.numberOfSeats=3

    def getBrand(self):
        return  self.brand

    def setBrand(self,name):
        self.brand=name

    def getYear(self):
        return self.year

    def setYear(self, year):
        self.year = year

    def getNumberOfSeats(self):
        return self.numberOfSeats

    def setNumberSeats(self, seats):
        self.numberOfSeats = seats

    def  calculatePrice(self):

        price = 0

        if len(self.brand) > 5:
            price += 8000
        else:
            price += 3000

        return price + self.numberOfSeats * 400 + self.year * 1000;

class Car (Vehicle):

    def __init__(self):
        Vehicle.__init__(self)
        self.modelName = "model";
        self.horsePower = 100;
        self.engineType = 220;

    def getModelName(self):
        return self.modelName
    def setModelName(self,Val):
        self.modelName=Val

    def getHorsePower(self):
        return self.horsePower

    def setHorsePower(self,val):
        self.horsePower=val

    def getEngineType(self):
        return self.engineType

    def setEngineType(self,val):
        self.engineType = val

    def Affordable(self,budget):
        return ((self.calculatePrice()< 40000) and (self.getYear(self) > 2006))

def TestGetterParrentObjectwith():
    vehicle= Vehicle()
    year=0
    for i in range(100):
        year+= vehicle.getYear()

    return year

def TestGetterChildObject():
    car = Car()
    hp=0
    for i in range(100):
        hp+= car.getHorsePower()

    return hp

def TestGetterParrentAtribFromChildObject():
    car = Car()
    year = 0
    for i in range(100):
        year += car.getYear()

    return year

def TestSetterParrentObject():
    veh= Vehicle()
    for i in range(100):
        veh.setYear(i)
    return veh.getYear()

def TestSetterChildObject():
    car = Car()
    for i in range(100):
        car.setHorsePower(100)
    return car.getHorsePower()

def testSetterParrentAtribFromChildObject():
    car = Car()
    for i in range(100):
        car.setYear(i)
    return car.getYear()

def TestParrentMethod():
    veh = Vehicle()
    sum=0
    for i in range(100):
        sum+= veh.calculatePrice()
    return sum

def TestChildMethod():
    car= Car()
    for i in range(100):
        aff=car.Affordable(1000)
    return aff


def test_TestChildMethod(benchmark):
 benchmark(TestChildMethod)

def test_TestParrentMethod(benchmark):
 benchmark(TestParrentMethod)

def test_testSetterParrentAtribFromChildObject(benchmark):
 benchmark(testSetterParrentAtribFromChildObject)

def test_TestSetterChildObject(benchmark):
 benchmark(TestSetterChildObject)

def test_TestSetterParrentObject(benchmark):
 benchmark(TestSetterParrentObject)

def test_TestGetterParrentAtribFromChildObject(benchmark):
 benchmark(TestGetterParrentAtribFromChildObject)

def test_TestGetterChildObject(benchmark):
 benchmark(TestGetterChildObject)

def test_TestGetterParrentObjectwith(benchmark):
 benchmark(TestGetterParrentObjectwith)

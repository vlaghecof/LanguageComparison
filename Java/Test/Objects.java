package com.Test;


import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
public class Objects {

    public class Vehicle  // base class (parent)
    {   private String brand;
        private int year;
        private int numberOfSeats;

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getNumberOfSeats() {
            return numberOfSeats;
        }

        public void setNumberOfSeats(int numberOfSeats) {
            this.numberOfSeats = numberOfSeats;
        }

        public Vehicle() {
            this.brand = "Ford";
            this.year = 1990;
            this.numberOfSeats = 3;
        }

        public Vehicle(String brand , int year, int numberOfSeats) {
            this.brand = brand;
            this.year = year;
            this.numberOfSeats = numberOfSeats;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vehicle vehicle = (Vehicle) o;
            return year == vehicle.year &&
                    numberOfSeats == vehicle.numberOfSeats &&
                    java.util.Objects.equals(brand, vehicle.brand);
        }






        public int calculatePrice()
        {
            int price = 0;

            if (this.brand.length() > 5)
                price += 8000;
            else
                price += 3000;

            return price = price + numberOfSeats * 400 + year * 1000;
        }
    }

public class Car extends  Vehicle
{
    public Car() {
        this.modelName = "model";
        this.horsePower = 100;
        this.engineType = 220;
    }

    public Car(String brand, int year, int numberOfSeats, String modelName, int horsePower, int engineType) {
        super(brand, year, numberOfSeats);
        this.modelName = modelName;
        this.horsePower = horsePower;
        this.engineType = engineType;
    }

    private String modelName;
    private int horsePower;
    private int engineType;

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void setEngineType(int engineType) {
        this.engineType = engineType;
    }

    public String getModelName() {
        return modelName;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public int getEngineType() {
        return engineType;
    }

    public boolean Affordable(int budget)
    {
        return ((calculatePrice() < 40000) && (this.getYear() > 2006));

    }

}

    @Param({ "100",  "1000" })
    public int size;

    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 2, time = 1)
    @Warmup(iterations = 1, time = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public int TestGetterParrentObjectwith()
    {
        Vehicle vehicle = new Vehicle();
        int year = 0;
        for (int i = 0; i < size; i++)
        {
            year += vehicle.getYear();
        }

        return year;
    }

    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 2, time = 1)
    @Warmup(iterations = 1, time = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public int TestGetterChildObject()
    {
        Car car = new Car();
        int hp = 0;
        for (int i = 0; i < size; i++)
        {
            hp += car.getHorsePower();
        }

        return hp;
    }

    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 2, time = 1)
    @Warmup(iterations = 1, time = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public int TestGetterParrentAtribFromChildObject()
    {
        Car car = new Car();
        int year = 0;
        for (int i = 0; i < size; i++)
        {
            year += car.getYear();
        }
        return year;
    }



    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 2, time = 1)
    @Warmup(iterations = 1, time = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public int TestSetterParrentObject()
    {
        Vehicle vehicle = new Vehicle();
        for (int i = 0; i < size; i++)
        {
            vehicle.setYear(1);
        }
        //  year = vehicle.Year;
        return vehicle.getYear();
    }

    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 2, time = 1)
    @Warmup(iterations = 1, time = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public int TestSetterChildObject()
    {
        Car car = new Car();
        for (int i = 0; i < size; i++)
        {
            car.setHorsePower(i);
        }

        return car.getHorsePower();
    }

    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 2, time = 1)
    @Warmup(iterations = 1, time = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public int TestSetterParrentAtribFromChildObject()
    {
        Car car = new Car();
        for (int i = 0; i < size; i++)
        {
            car.setYear(i) ;
        }
        return car.getYear();
    }


    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 2, time = 1)
    @Warmup(iterations = 1, time = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
          public int TestParrentMethod()
          {
              Vehicle veh = new Vehicle();
              int sum=0;
              for (int i = 0; i < size; i++)
              {
                sum+=  veh.calculatePrice();
              }
              return sum;
          }

    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 2, time = 1)
    @Warmup(iterations = 1, time = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public int TestParrentMethodFromChild()
    {
        Car veh = new Car();
        int sum=0;
        for (int i = 0; i < size; i++)
        {
            sum+=  veh.calculatePrice();
        }
        return sum;
    }



    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 2, time = 1)
    @Warmup(iterations = 1, time = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
          public boolean  TestChildMethod()
          {
              Car car = new Car();
              boolean aff=true;
              for (int i = 0; i < size; i++)
              {
                  aff = car.Affordable(1000);
              }
              return aff;
          }


    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 2, time = 1)
    @Warmup(iterations = 1, time = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
          public int TestParrentEquality()
          {
              Vehicle vehicle  = new Vehicle();
              Vehicle vehicle1 = new Vehicle();
              int sum = 0;

              for (int i = 0; i < size; i++)
              {
                  if (vehicle.equals(vehicle1))
                      sum++;
              }
              return sum;
          }


    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 2, time = 1)
    @Warmup(iterations = 1, time = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
          public int TestChildEquality()
          {
              Car car = new Car();
              Car car2 = new Car();
              int sum=0;

              for (int i = 0; i < size; i++)
              {
                  if (car.equals(car2))
                      sum++;
              }
              return sum;
          }


}

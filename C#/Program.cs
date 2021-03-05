using BenchmarkDotNet.Attributes;
using BenchmarkDotNet.Running;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Threading;
using static Benchmarker.Objects;

namespace Benchmarker
{
    [SimpleJob(launchCount: 3, warmupCount: 1, targetCount: 3)]
    public class ListCreateBenchmarker
    {
        [Params(1000, 100)]
        public int N;

        [Benchmark]
        public void ArrayAdd()
        {
            var array = new int[N + 3];
            for (int i = 0; i < N; i++)
            {
                array[i] = i;
            }
        }

        public void ArrayListAdd()
        {
            var list = new ArrayList();
            for (int i = 0; i < N; i++)
            {
                list.Add(i);
            }
        }


        [Benchmark]
        public void StackAdd()
        {
            var myStack = new Stack<int>();
            for (int i = 0; i < N; i++)
            {
                myStack.Push(i);
            }
        }


        [Benchmark]
        public void QueueAdd()
        {
            var queue = new Queue<int>();
            for (int i = 0; i < N; i++)
            {
                queue.Enqueue(i);
            }
        }

        [Benchmark]
        public void ListFixedAdd()
        {
            var list = new List<int>(N);
            for (int i = 0; i < N; i++)
            {
                list.Add(i);
            }


        }


        [Benchmark]
        public void ListUnspecifiedAdd()
        {
            var list = new List<int>();
            for (int i = 0; i < N; i++)
            {
                list.Add(i);
            }
        }

        [Benchmark]
        public void LinkedListFirstAdd()
        {
            var list = new LinkedList<int>();
            for (int i = 0; i < N; i++)
            {
                list.AddFirst(i);
            }
        }


        [Benchmark]
        public void LinkedListLastAdd()
        {
            var list = new LinkedList<int>();
            for (int i = 0; i < N; i++)
            {
                list.AddLast(i);
            }
        }






        [Benchmark]
        public void HashSetAdd()
        {
            var set = new HashSet<int>();
            for (int i = 0; i < N; i++)
            {
                set.Add(i);
            }
        }











    }


    [SimpleJob(launchCount: 3, warmupCount: 1, targetCount: 3)]
    public class ListFindBenchmarker
    {
        [Params(1000, 100, 10000)]
        public int N;


        int[] randomNumbers = new int[11];

        int[] myarray;

        Stack<int> myStack;
        Queue<int> queue;
        List<int> list;
        HashSet<int> set;
        ArrayList arrList;
        LinkedList<int> linkedList;



        public Stack<int> MyStack { get => myStack; set => myStack = value; }
        public Queue<int> myQueue { get => queue; set => queue = value; }
        public List<int> myList { get => list; set => list = value; }
        public HashSet<int> mySet { get => set; set => set = value; }
        public int[] Myarray { get => myarray; set => myarray = value; }
        public int[] RandomNumbers { get => randomNumbers; set => randomNumbers = value; }
        public ArrayList ArrList { get => arrList; set => arrList = value; }
        public LinkedList<int> LinkedList { get => linkedList; set => linkedList = value; }

        [GlobalSetup]
        public void GlobalSetup()
        {


            var array = new int[N];
            var myStack = new Stack<int>();
            var queue = new Queue<int>();
            var list = new List<int>(N);
            var linkedList = new LinkedList<int>();
            var set = new HashSet<int>();
            var arrList = new ArrayList();

            for (int i = 0; i < N; i++)
            {
                array[i] = i;
                myStack.Push(i);
                queue.Enqueue(i);
                list.Add(i);
                linkedList.AddLast(i);
                set.Add(i);
                arrList.Add(i);


            }

            Myarray = array;
            myQueue = queue;
            MyStack = myStack;
            myList = list;
            mySet = set;
            ArrList = arrList;
            LinkedList = linkedList;

            Random rnd = new Random();

            for (int i = 0; i < 10; i++)
            {
                RandomNumbers[i] = rnd.Next(N % 2, N - 1);
            }




        }


        public void print(int[] arr)
        {
            for (int i = 0; i < 10; i++)
            {
                Console.WriteLine(this.randomNumbers[i]);
            }
        }

        [Benchmark]
        public int ArrayFind()
        {
            int cnt = 0;
            for (int j = 0; j < 10; j++)
                for (int i = 0; i < N; i++)
                {
                    if (Myarray[i] == RandomNumbers[j])
                    {
                        cnt = RandomNumbers[j];
                        cnt++;
                        break;
                    }
                }
            return cnt;
        }



        [Benchmark]
        public int ArrayListBinaryFind()
        {
            int cnt = 0;
            for (int j = 0; j < 10; j++)

            { cnt = ArrList.BinarySearch(RandomNumbers[j]);
                cnt++;
            }
            return cnt;
        }

        [Benchmark]
        public int LinkedListFind()
        {
            int cnt = 0;
            for (int j = 0; j < 10; j++)

            {
                //here its returned a node , so we need to do an extra stept to generate an int 
                var node = LinkedList.Find(RandomNumbers[j]);
                cnt = node.Value;
                cnt++;
            }
            return cnt;
        }


        [Benchmark]
        public int ListFind()
        {
            int cnt = 0;
            for (int j = 0; j < 10; j++)

            {
                //here its returned an int , but a lambda function is required to operate  
                cnt = myList.Find(x => x == RandomNumbers[j]);
                cnt++;
            }
            return cnt;
        }




        [Benchmark]
        public int SetFind()
        {
            int cnt = 0;
            for (int j = 0; j < 10; j++)

            {

                if (mySet.Contains(RandomNumbers[j]))
                {
                    cnt = RandomNumbers[j];
                    cnt++;

                }

            }
            return cnt;
        }



    }



    [SimpleJob(launchCount: 3, warmupCount: 1, targetCount: 3)]
    public class ListNotFindBenchmarker
    {
        [Params(1000, 100, 10000)]
        public int N;


        int[] randomNumbers = new int[11];

        int[] myarray;

        Stack<int> myStack;
        Queue<int> queue;
        List<int> list;
        HashSet<int> set;
        ArrayList arrList;
        LinkedList<int> linkedList;



        public Stack<int> MyStack { get => myStack; set => myStack = value; }
        public Queue<int> myQueue { get => queue; set => queue = value; }
        public List<int> myList { get => list; set => list = value; }
        public HashSet<int> mySet { get => set; set => set = value; }
        public int[] Myarray { get => myarray; set => myarray = value; }
        public int[] RandomNumbers { get => randomNumbers; set => randomNumbers = value; }
        public ArrayList ArrList { get => arrList; set => arrList = value; }
        public LinkedList<int> LinkedList { get => linkedList; set => linkedList = value; }

        [GlobalSetup]
        public void GlobalSetup()
        {


            var array = new int[N];
            var myStack = new Stack<int>();
            var queue = new Queue<int>();
            var list = new List<int>(N);
            var linkedList = new LinkedList<int>();
            var set = new HashSet<int>();
            var arrList = new ArrayList();

            for (int i = 0; i < N; i++)
            {
                array[i] = i;
                myStack.Push(i);
                queue.Enqueue(i);
                list.Add(i);
                linkedList.AddLast(i);
                set.Add(i);
                arrList.Add(i);


            }

            Myarray = array;
            myQueue = queue;
            MyStack = myStack;
            myList = list;
            mySet = set;
            ArrList = arrList;
            LinkedList = linkedList;

            Random rnd = new Random();

            for (int i = 0; i < 10; i++)
            {
                RandomNumbers[i] = N + rnd.Next(N % 2, N - 1);
            }




        }


        public void print(int[] arr)
        {
            for (int i = 0; i < 10; i++)
            {
                Console.WriteLine(this.randomNumbers[i]);
            }
        }

        [Benchmark]
        public int ArrayNotFind()
        {
            int cnt = 0;
            for (int j = 0; j < 10; j++)
                for (int i = 0; i < N; i++)
                {
                    if (Myarray[i] == RandomNumbers[j])
                    {
                        cnt = RandomNumbers[j];
                        cnt++;
                        break;
                    }
                    cnt++;
                }
            return cnt;
        }



        [Benchmark]
        public int ArrayListBinaryNotFind()
        {
            int cnt = 0;
            for (int j = 0; j < 10; j++)

            {
                cnt = ArrList.BinarySearch(RandomNumbers[j]);
                cnt++;
            }
            return cnt;
        }




        [Benchmark]
        public int ListNotFind()
        {
            int cnt = 0;
            for (int j = 0; j < 10; j++)

            {
                //here its returned an int , but a lambda function is required to operate  
                cnt = myList.Find(x => x == RandomNumbers[j]);
                cnt++;
            }
            return cnt;
        }

        [Benchmark]
        public int LinkedListNotFind()
        {
            int cnt = 0;
            for (int j = 0; j < 10; j++)

            {

                var node = LinkedList.Find(RandomNumbers[j]);
                cnt++;
            }
            return cnt;
        }




        [Benchmark]
        public int SetNotFind()
        {
            int cnt = 0;
            for (int j = 0; j < 10; j++)

            {

                if (mySet.Contains(RandomNumbers[j]))
                {
                    cnt = RandomNumbers[j];
                    cnt++;

                }
                cnt++;

            }
            return cnt;
        }



    }


    [SimpleJob(launchCount: 3, warmupCount: 1, targetCount: 3)]
    public class ListRemoveBenchmarker
    {
        [Params(1000, 100, 10000)]
        public int N;


        int[] randomNumbers = new int[11];

        int[] myarray;

        Stack<int> myStack;
        Queue<int> queue;
        List<int> list;
        HashSet<int> set;
        ArrayList arrList;
        LinkedList<int> linkedList;



        public Stack<int> MyStack { get => myStack; set => myStack = value; }
        public Queue<int> myQueue { get => queue; set => queue = value; }
        public List<int> myList { get => list; set => list = value; }
        public HashSet<int> mySet { get => set; set => set = value; }
        public int[] Myarray { get => myarray; set => myarray = value; }
        public int[] RandomNumbers { get => randomNumbers; set => randomNumbers = value; }
        public ArrayList ArrList { get => arrList; set => arrList = value; }
        public LinkedList<int> LinkedList { get => linkedList; set => linkedList = value; }

        [GlobalSetup]
        public void GlobalSetup()
        {


            var array = new int[N];
            var myStack = new Stack<int>();
            var queue = new Queue<int>();
            var list = new List<int>(N);
            var linkedList = new LinkedList<int>();
            var set = new HashSet<int>();
            var arrList = new ArrayList();

            for (int i = 0; i < N; i++)
            {
                array[i] = i;
                myStack.Push(i);
                queue.Enqueue(i);
                list.Add(i);
                linkedList.AddLast(i);
                set.Add(i);
                arrList.Add(i);


            }

            Myarray = array;
            myQueue = queue;
            MyStack = myStack;
            myList = list;
            mySet = set;
            ArrList = arrList;
            LinkedList = linkedList;

            Random rnd = new Random();

            for (int i = 0; i < 10; i++)
            {
                RandomNumbers[i] = rnd.Next(N % 2, N - 1);
            }




        }


        public void print(int[] arr)
        {
            for (int i = 0; i < 10; i++)
            {
                Console.WriteLine(this.randomNumbers[i]);
            }
        }

        [Benchmark]
        public int ArrayRemove()
        {
            //nothing more than a find and an override .
            int cnt = 0;
            for (int j = 0; j < 10; j++)
                for (int i = 0; i < N; i++)
                {
                    if (Myarray[i] == RandomNumbers[j])
                    {
                        for (int q = i; q < N - 1; q++)
                        {
                            Myarray[q] = Myarray[q + 1];

                        }
                        Myarray[N - 1] = 0;
                        cnt++;
                        break;
                    }
                    cnt++;
                }
            return cnt;
        }



        [Benchmark]
        public int ArrayListRemove()
        {
            int cnt = 0;
            for (int j = 0; j < 10; j++)

            {
                ArrList.Remove(RandomNumbers[j]);
                cnt++;
            }
            return cnt;
        }




        [Benchmark]
        public int ListRemove()
        {
            int cnt = 0;
            for (int j = 0; j < 10; j++)

            {
                myList.Remove(RandomNumbers[j]);
                cnt++;
            }
            return cnt;
        }



        [Benchmark]
        public int ListLinkedRemove()
        {
            int cnt = 0;
            for (int j = 0; j < 10; j++)

            {
                LinkedList.Remove(RandomNumbers[j]);
                cnt++;
            }
            return cnt;
        }



        [Benchmark]
        public int SetRemove()
        {
            int cnt = 0;
            for (int j = 0; j < 10; j++)

            {
                mySet.Remove(RandomNumbers[j]);
                cnt++;

            }
            return cnt;
        }



    }


    [SimpleJob(launchCount: 3, warmupCount: 1, targetCount: 3)]
    public class ListAddBenchmarker
    {   //here we have a full list and we eant to add more elements at the end

        [Params(1000, 100, 10000)]
        public int N;


        int[] randomNumbers = new int[11];

        int[] myarray;

        Stack<int> myStack;
        Queue<int> queue;
        List<int> list;
        HashSet<int> set;
        ArrayList arrList;
        LinkedList<int> linkedList;



        public Stack<int> MyStack { get => myStack; set => myStack = value; }
        public Queue<int> myQueue { get => queue; set => queue = value; }
        public List<int> myList { get => list; set => list = value; }
        public HashSet<int> mySet { get => set; set => set = value; }
        public int[] Myarray { get => myarray; set => myarray = value; }
        public int[] RandomNumbers { get => randomNumbers; set => randomNumbers = value; }
        public ArrayList ArrList { get => arrList; set => arrList = value; }
        public LinkedList<int> LinkedList { get => linkedList; set => linkedList = value; }

        [GlobalSetup]
        public void GlobalSetup()
        {


            var array = new int[N + 12];
            var myStack = new Stack<int>();
            var queue = new Queue<int>();
            var list = new List<int>(N + 12);
            var linkedList = new LinkedList<int>();
            var set = new HashSet<int>();
            var arrList = new ArrayList();

            for (int i = 0; i < N; i++)
            {
                array[i] = i;
                myStack.Push(i);
                queue.Enqueue(i);
                list.Add(i);
                linkedList.AddLast(i);
                set.Add(i);
                arrList.Add(i);


            }

            Myarray = array;
            myQueue = queue;
            MyStack = myStack;
            myList = list;
            mySet = set;
            ArrList = arrList;
            LinkedList = linkedList;

            Random rnd = new Random();

            for (int i = 0; i < 10; i++)
            {
                RandomNumbers[i] = rnd.Next(N % 2, N - 1);
            }




        }


        public void print(int[] arr)
        {
            for (int i = 0; i < 10; i++)
            {
                Console.WriteLine(this.randomNumbers[i]);
            }
        }

        [Benchmark]
        public int ArrayAdd()
        {
            //to add am element at each step you need to resize the array to be able to add something

            int[] myArr = Myarray;


            int cnt = 0;

            for (int i = 0; i < 10; i++)
            {
                Array.Resize(ref myArr, myArr.Length + 1);
                myArr[myArr.Length - 1] = RandomNumbers[i];
                cnt++;
            }

            return cnt;
        }



        [Benchmark]
        public int ArrayListAdd()
        {
            int cnt = 0;
            for (int j = 0; j < 10; j++)

            {
                ArrList.Add(RandomNumbers[j]);
                cnt++;
            }
            return cnt;
        }



        /*
                [Benchmark]
                public int ListAdd()
                {
                   // Console.WriteLine(myList.Count);
                    int cnt = 0;
                    for (int j = 0; j < 10; j++)

                    {
                        myList.Add(RandomNumbers[j]);
                        cnt++;
                    }
                    return cnt;
                }



                [Benchmark]
                public int ListLinkedAdd()
                {//linked list works with nodes
                    int cnt = 0;
                    for (int j = 0; j < 10; j++)

                    {
                        LinkedList.AddLast(RandomNumbers[j]);
                        cnt++;
                    }
                    return cnt;
                }*/



    }


    [MemoryDiagnoser]
    [SimpleJob(launchCount: 3, warmupCount: 1, targetCount: 3)]
    public class Functions
    {
        [Params(1000, 100, 10000)]
        public int N;

        Func<int, int> factorial;

        public Func<int, int> Factorial1 { get => factorial; set => factorial = value; }

        [GlobalSetup]
        public void GlobalSetup()
        {
            // Just so we can refer to it
            Factorial1 = x => x <= 1 ? 1 : x * factorial(x - 1);

        }



        public int increment()
        {
            int x = 0;
            return x + 3;
        }

        public string concat()
        {
            string s = "";
            return s + "A";
        }



        [Benchmark]
        public int Stack()
        {
            int cnt = 0;
            for (int i = 0; i < N; i++)
            {
                cnt = increment();
            }
            return cnt;
        }

        [Benchmark]
        public int Heap()
        {
            int cnt = 0;
            string str = "";
            for (int i = 0; i < N; i++)
            {
                cnt++;
                str = concat();
            }
            return cnt;
        }


//not recursion
        public static double Factorial(int number)
        {
            if (number == 0)
                return 1;

            double factorial = 1;
            for (int i = number; i >= 1; i--)
            {
                factorial = factorial * i;
            }
            return factorial;
        }


        public double factorial_Recursion(int number)
        {
            if (number == 1)
                return 1;
            else
                return number * factorial_Recursion(number - 1);
        }


        [Benchmark]
        public double NoRecursion()
        {
            return Factorial(N);
        }

        [Benchmark]
        public double ClasicalRecursion()
        {
            return factorial_Recursion(N);
        }

        [Benchmark]
        public double FunctionalProgramingRecursion()
        {
            return Factorial1(N);
        }





    }




    [SimpleJob(launchCount: 3, warmupCount: 1, targetCount: 3)]
    public class Objects
    {
        [Params(1000, 100, 10000)]
        public int N;


        public class Vehicle  // base class (parent) 
        {

            private string brand;
            private int year;
            private int numberOfSeats;


            public Vehicle(string brand = "Ford", int year = 1990, int numberOfSeats = 2)
            {
                this.brand = brand;
                this.year = year;
                this.numberOfSeats = numberOfSeats;
            }


            public string Brand { get => this.brand; set => this.brand = value; }
            public int Year { get => this.year; set => this.year = value; }
            public int NumberOfSeats { get => this.numberOfSeats; set => this.numberOfSeats = value; }

            public override bool Equals(object obj)
            {
                return obj is Vehicle vehicle &&
                       brand == vehicle.brand &&
                       year == vehicle.year &&
                       numberOfSeats == vehicle.numberOfSeats;
            }


            public int calculatePrice()
            {
                int price = 0;

                if (this.brand.Length > 5)
                    price += 8000;
                else
                    price += 3000;

                return price = price + numberOfSeats * 400 + year * 1000;
            }




        }


        public class Car : Vehicle
        {

            private string modelName;
            private int horsePower;
            private int engineType;

            public string ModelName { get => modelName; set => modelName = value; }
            public int HorsePower { get => horsePower; set => horsePower = value; }
            public int EngineType { get => engineType; set => engineType = value; }

            public Car(string brand = "Ford", int year = 1900, int numberOfSeats = 1, string modelName = "Xnvid", int horsePower = 1000, int engineType = 220) : base(brand, year, numberOfSeats)
            {

                this.modelName = modelName;
                this.horsePower = horsePower;
                this.engineType = engineType;
            }

            public override bool Equals(object obj)
            {
                return obj is Car car &&
                       base.Equals(obj) &&
                       modelName == car.modelName &&
                       horsePower == car.horsePower &&
                       engineType == car.engineType;
            }

            public bool Affordable(int budget)
            {
                return ((base.calculatePrice() < 40000) && (base.Year > 2006));

            }

        }








        [Benchmark]
        public Vehicle CreateParentObject()
        {
            Vehicle par = new Vehicle("aa",199,1);
            for (int i = 0; i < N; i++)
            {
                par = new Vehicle(year: N);
            }
            return par;
        }

         [Benchmark]
         public Car CreateChildObject()
         {
             Car par = new Car();
             for (int i = 0; i < N; i++)
             {
                  par = new Car(year:N,engineType:N+44);
             }

             return par;
         }

/*
        [Benchmark]
        public int TestGetterParrentObject()
        {
            Vehicle vehicle = new Vehicle();
            int year = 0;
            for (int i = 0; i < N; i++)
            {
                year = vehicle.Year;
            }
            //  year = vehicle.Year;
            return year;
        }

        [Benchmark]
        public int TestGetterChildObject()
        {
            Car car = new Car();
            int hp = 0;
            for (int i = 0; i < N; i++)
            {
                hp = car.HorsePower;
            }

            return hp;
        }

        [Benchmark]
        public int TestGetterParrentAtribFromChildObject()
        {
            Car car = new Car();
            int year = 0;
            for (int i = 0; i < N; i++)
            {
                year = car.Year;
            }
            return year;
        }



        [Benchmark]
        public int TestSetterParrentObject()
        {
            Vehicle vehicle = new Vehicle();
            for (int i = 0; i < N; i++)
            {
                vehicle.Year = i;
            }
            //  year = vehicle.Year;
            return vehicle.Year;
        }

        [Benchmark]
        public int TestSetterChildObject()
        {
            Car car = new Car();
            for (int i = 0; i < N; i++)
            {
                car.HorsePower = i;
            }

            return car.HorsePower;
        }

        [Benchmark]
        public int TestSetterParrentAtribFromChildObject()
        {
            Car car = new Car();
            for (int i = 0; i < N; i++)
            {
                car.Year = i;
            }
            return car.Year;
        }*/


        /*  [Benchmark]
          public int TestParrentMethod()
          {
              Vehicle veh = new Vehicle();
              int sum=0;
              for (int i = 0; i < N; i++)
              {
                sum+=  veh.calculatePrice();
              }
              return sum;
          }

          [Benchmark]
          public bool TestChildMethod()
          {
              Car car = new Car();
              bool aff=true;
              for (int i = 0; i < N; i++)
              {
                  aff = car.Affordable(1000);
              }
              return aff;
          }


          [Benchmark]
          public int TestParrentEquality()
          {
              Vehicle vehicle  = new Vehicle();
              Vehicle vehicle1 = new Vehicle();
              int sum = 0;

              for (int i = 0; i < N; i++)
              {
                  if (vehicle.Equals(vehicle1))
                      sum++;
              }
              return sum;
          }


          [Benchmark]
          public int TestChildEquality()
          {
              Car car = new Car();
              Car car2 = new Car();
              int sum=0;

              for (int i = 0; i < N; i++)
              {
                  if (car.Equals(car2))
                      sum++;
              }
              return sum;
          }*/

    }



    [MemoryDiagnoser]
    [SimpleJob(launchCount: 3, warmupCount: 1, targetCount: 3)]
    public class Threads
    {
        [Params(10,  50 , 100)]
        public int N;



    class Department
    {
        private Object thisLock = new Object();

        int salary;

        Random r = new Random();

        public Department(int initial)
        {
            salary = initial;
        }

        int Withdraw(int amount)
        {  
            
            {
            salary = salary - amount;
            return salary;             
            }
        }


        int WithdrawSinc(int amount)
        {
            lock (thisLock)
            {
             
            salary = salary - amount;
            return salary;
            
               
            }
        }

            public void DoTransactions()
            { 
                Withdraw(r.Next(1, 100));   
            }


            public void DoOrderedTransactions()
            {
                WithdrawSinc(r.Next(1, 100));
            }
        }


        Department dep;
        private Thread[] threads;

        private Department Dep { get => dep; set => dep = value; }
        private Thread[] ThreadsArr { get => threads; set => threads = value; }


        [GlobalSetup]
        public void GlobalSetup()
        {
            Dep = new Department(10000);
            ThreadsArr = ThreadCreation();


        }

        [Benchmark]
       public Thread[]  ThreadCreation()
        {
            Thread[] threads = new Thread[N];
            for (int i = 0; i < N; i++)
            {
                Thread t = new Thread(new ThreadStart(Dep.DoTransactions));
                threads[i] = t;
            }
            return threads;
       }


        public Thread[] ThreadCreationSinc()
        {
            Thread[] threads = new Thread[N];
            for (int i = 0; i < N; i++)
            {
                Thread t = new Thread(new ThreadStart(Dep.DoOrderedTransactions));
                threads[i] = t;
            }
            return threads;
        }


        [Benchmark]
        public int ThreadRunningSinc()
        {
            int cnt = 1;
            Thread[] threads = ThreadCreation();
            for (int i = 0; i < N; i++)
            {
                threads[i].Start();
                cnt++;
            }
            

            return cnt;
        }

        [Benchmark]
        public int ThreadRunning()
        {
            int cnt = 1;
            Thread[] threads = ThreadCreationSinc();
            for (int i = 0; i < N; i++)
            {
                threads[i].Start();
                cnt++;
            }


            return cnt;
        }



    }
    public class Program
    {


        class Department
        {
            private Object thisLock = new Object();
            int salary;
            Random r = new Random();

            public Department(int initial)
            {
                salary = initial;
            }

            int Withdraw(int amount)
            {
                // This condition never is true unless the lock statement  
                // is commented out.  
                /*if (salary < 0)
                {
                    Console.WriteLine("salary after Withdrawal  :  NEGATIVE ");
                        return 0;
                        throw new Exception("Negative Balance");

                }*/
                // Comment out the next line to see the effect of leaving out   
                // the lock keyword.  
                 lock (thisLock)
                {
                    if (salary >= amount)
                    {
                        Console.WriteLine("When i got here Salary was {0} and i took {1}", salary, amount);
                        salary = salary - amount;
                        return amount;
                    }
                    else
                    {
                        return 0;
                    }
                }
            }
            public void DoTransactions()
            {
                for (int i = 0; i < 100; i++)
                {

                    Withdraw(r.Next(1, 100));
                }
            }
        }

        public static void Main(string[] args)
        {
            // var summary = BenchmarkRunner.Run<ListCreateBenchmarker>();
            //var summary = BenchmarkRunner.Run<ListNotFindBenchmarker>();
            // var summary = BenchmarkRunner.Run<ListFindBenchmarker>();
            // var summary = BenchmarkRunner.Run<ListNotFindBenchmarker>();

            // var summary = BenchmarkRunner.Run<ListRemoveBenchmarker>();
            //var summary = BenchmarkRunner.Run<Functions>();
            var summary = BenchmarkRunner.Run<Objects>();
             //var summary = BenchmarkRunner.Run<Threads>();


     
           

        }
    }
}
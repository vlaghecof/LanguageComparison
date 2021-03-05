import threading

sum = 0



def increment(n):
    global sum
    sum += 1


arr = [1]*50 + [2] * 50
print(arr)


def thread_task(arr, left,right,):

    for i in range(left,right):
      increment(arr[i])



def NormalSum(arr2:[]):
   for i in range(len(arr2)):
        increment(arr2[i])



def main_task():
    global sum

    sum=1;


    t1 = threading.Thread(target=thread_task,args=(arr,0,49,))
    t2 = threading.Thread(target=thread_task,args=(arr,50,100,))



    t1.start()
    t2.start()

    t1.join()
    t2.join()


def mainSumCalc():
    global sum

    sum=0;
    NormalSum(arr)


def threads():
        main_task()
        # print("The sum with threads is {0}".format( sum))

def oneThread():
    mainSumCalc()

def test_oneThread(benchmark):
 benchmark(oneThread)

def test_threads(benchmark):
 benchmark(threads)

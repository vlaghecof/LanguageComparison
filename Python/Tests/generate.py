import os

commands=['pytest-benchmark compare 0001 --csv=unversioned_20201204_173733.json',
 'pytest-benchmark compare 0002 --csv=unversioned_20201204_174545.json',
 'pytest-benchmark compare 0003 --csv=unversioned_20201205_143241.json',
 'pytest-benchmark compare 0004 --csv=tests.json',
 'pytest-benchmark compare 0020 --csv=add.json',
 'pytest-benchmark compare 0021 --csv=ttt.json',
 'pytest-benchmark compare 0022 --csv=find.json',
 'pytest-benchmark compare 0023 --csv=find.json',
 'pytest-benchmark compare 0024 --csv=find.json',
 'pytest-benchmark compare 0025 --csv=find.json',
 'pytest-benchmark compare 0026 --csv=find.json',
 'pytest-benchmark compare 0027 --csv=notfind.json',
 'pytest-benchmark compare 0028 --csv=notfind.json',
 'pytest-benchmark compare 0034 --csv=Functions.csv.json',
 'pytest-benchmark compare 0035 --csv=ThreadBeggin.json',
 'pytest-benchmark compare 0036 --csv=MultiProcessing.json',
 'pytest-benchmark compare 0037 --csv=MultiProcessing.json',
 'pytest-benchmark compare 0038 --csv=OOP.json']


for com in commands:
    com=com.replace(".json",".csv")
    com=com.replace("--csv=","--csv=Generate\\")
    os.system(com)
    print(com)

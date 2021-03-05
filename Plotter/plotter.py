import matplotlib.pyplot as plt
import pandas as pd
import numpy as np
import seaborn as sns
import os, shutil


Java=1
C=2
Python=3


JavaFile=r"Java"
CFile=r"C#"
PythonFile=r"Python"

my_path = os.path.abspath(__file__)


print(os.path.join(JavaFile,'img.pgn'))

def PrintPlot (  fileCsv,**kwargs):
    plt.style.use('bmh')
    df = pd.read_csv('Functions.csv')

    df["Benchmark"]=df['Benchmark'].apply(lambda t: t[19:])
    df["Score"]=df['Score'].apply(lambda t:float(t.replace(",",".")))
    df=df.sort_values(by=['Score'])

    # df= df[:4]

    x = df['Benchmark']
    y = df['Score']

    # for p in ax.patches:
    #     ax.annotate(str(p.get_height()), (p.get_x() * 1.005, p.get_height() * 1.005))

    df.to_csv('outputfile.csv',
                     index = False)



    plt.xlabel('test', fontsize=18,)
    plt.ylabel('ns/unit', fontsize=16)
    plt.bar(x, y,color='mcbkyrg')
    plt.xticks(rotation=90)
    plt.yticks(y)
    plt.yscale(scale='log')
    plt.show();
    plt.savefig("ttt.png")


def PrintPlotDataFrame (  dataframe,**kwargs):
    plt.style.use('bmh')
    df = dataframe
    print(kwargs.items())
    type=kwargs.setdefault('Type','Test')
    file=kwargs.setdefault('file','SavedGraph')




    x = df['Benchmark']
    y = df['Score']

    df.to_csv('outputfile.csv',
                     index = False)

    ax = df.plot.bar(title=type)
    for p in ax.patches:
        ax.annotate("%.2f" % p.get_height(), (p.get_x() + p.get_width() / 2., p.get_height()), ha='center', va='center',
                    xytext=(0, 10), textcoords='offset points')

    ax.set_xticklabels( x, rotation = 0)

    plt.xlabel(file[:-4], fontsize=18,)
    plt.ylabel('ns/unit', fontsize=16)
    plt.bar(x, y,color='mcbkyrg')
    plt.xticks(rotation=45,ha='right')
    plt.yticks(y)
    plt.xticks(x)
    plt.yscale(value='log')
    file=file.replace("-","_")

    if type == "C#":
        adress=os.path.join(type, file[24:]+".png")
    else:
        if type=="Python":
            adress = os.path.join(type, file[18:] + ".png")
        else:
            adress=os.path.join(type, file+".png")
    print("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"+adress)
    plt.savefig(adress,bbox_inches='tight')
    # plt.savefig(type+file[:-4]+".png",bbox_inches='tight')
    plt.show();


def PrintPlotDataFrameComparison (  dataframe,**kwargs):
        plt.style.use('bmh')
        df = dataframe
        print(kwargs.items())
        type = kwargs.setdefault('Type', 'Test')
        file = kwargs.setdefault('file', 'SavedGraph')

        x = df['Benchmark']
        y = df['Score']

        df.to_csv('outputfile.csv',
                  index=False)


        plt.xlabel(file[:-4], fontsize=18, )
        plt.ylabel('ns/unit', fontsize=16)
        plt.bar(x, y, color='mcbkyrg')
        plt.xticks(rotation=45, ha='right')
        plt.yticks(y)
        plt.xticks(x)
        plt.yscale(value='log')
        file = file.replace("-", "_")

        if type == "C#":
            adress = os.path.join(type, file[24:] + ".png")
        else:
            if type == "Python":
                adress = os.path.join(type, file[18:] + ".png")
            else:
                adress = os.path.join(type, file + ".png")
        print("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" + adress)
        ax1 = plt.axes()
        x_axis = ax1.axes.get_xaxis()
        x_axis.set_visible(False)
        plt.savefig(adress, bbox_inches='tight')
        # plt.savefig(type+file[:-4]+".png",bbox_inches='tight')
        plt.show();


def preparePythonDF(file):
    print(file)

    df = pd.read_csv(file)
    df1 = df[['name', 'mean']]
    df1=df1.rename(columns={"name":"Benchmark","mean":"Score"})

    df1["Benchmark"] =  df1["Benchmark"].apply(lambda t: (str(t).split("::")[1])[5:]  )
    df1["Score"] = df1['Score'].apply(lambda t: str(t).replace(",", ""))
    df1["Score"] = df1['Score'].apply(lambda t: float(t.split(" ")[0]) *1000 ) #covert to ns

    df1 = df1.sort_values(by=['Score'])

    df1.to_csv(file[:-4]+"Transformed.csv")
    return df1


for files in (os.listdir("Reports/Python_us")):
   if "Transformed"  in files :
    shutil.move(src="Reports/Python_us/"+files,dst="Reports/PythonTransformed/"+files)


def prepareCDF(file):
    print(file)

    df = pd.read_csv(file)
    df1 = df[['Method', 'Mean', "N"]]
    df1=df1.rename(columns={"Method":"Benchmark","Mean":"Score"})
    df1["Benchmark"] = df1['Benchmark'] + df1['N'].apply(lambda t : "_"+str(t))
    df1=df1[["Benchmark", "Score"]]
    # df1.to_csv("ztest.csv")
    # df1 = df1[:6]
    df1["Score"] = df1['Score'].apply(lambda t: t.replace(",",""))
    df1["Score"] = df1['Score'].apply(lambda t: float(t.split(" ")[0])  )

    df1 = df1.sort_values(by=['Score'])

    return df1

def prepareJavaDf(file):
    df = pd.read_csv(file)
    try:
        df["Benchmark"] = df['Benchmark'] + df['Param: size'].apply(lambda t : "_"+str(t))
    except :
        pass
    df["Benchmark"]=df['Benchmark'].apply(lambda t: (t.replace("com.Test.", "")))
    df["Score"] = df['Score'].apply(lambda t: float(t.replace(",", ".")))
    df = df.sort_values(by=['Score'])
    df = df[["Benchmark", "Score"]]
    return df


def mergeDF(frames):
    df = pd.concat(frames)
    df = df[["Benchmark", "Score"]]

    return df;

def compareDF(frames):
    df = pd.merge(frames[0], frames[1] ,on='Benchmark').merge(frames[2],on="Benchmark")
    ax = df[["Benchmark", "Score_x", "Score_y","Score"]].plot(
                                                        kind='bar',
                                                        color=["g", "b","r"],
                                                        rot=45)
    ax.legend(["Java", "C#","RT"]);
    plt.show()
    return df




def generateGraph(file:str,type:int):
    if type==Java :
        df = prepareJavaDf(file)
        t=file[14:]
        PrintPlotDataFrame(df,Type="Java",file=file[14:])
    elif type == C :
        df = prepareCDF(file)
        PrintPlotDataFrame(df,Type="C#",file=file)
    elif type==Python :
        df=preparePythonDF(file)
        PrintPlotDataFrame(df, Type="Python", file=file)

    return df



def getJavaPlots(directory:str):
    listDirectory=os.listdir(directory)
    for dir in listDirectory:
        generateGraph(os.path.join(directory,dir),Java)


def getCPlots(directory:str):
    listDirectory=os.listdir(directory)
    for dir in listDirectory:
           if ".csv" in dir :
               generateGraph(os.path.join(directory,dir),C)
               l=os.path.join(directory,dir)
               print(l)

def generateComp(df):
    dfEmpty = pd.read_csv("Reports/empty2.csv")
    dfEmpty1 = pd.read_csv("Reports/empty.csv")
    PrintPlotDataFrameComparison(mergeDF([df[0], dfEmpty, df[1], dfEmpty1, df[2]]), Type="Comparison")

generateGraph("Reports/JavaB/create100.csv", Java)

while(True):
    inputStr=input("Comanda :")
    if ":q" in inputStr or ".csv" not in inputStr:
        break

    att=inputStr.split()
    type=att[0].strip()
    inp=att[1].strip()

    print(type,inp)
    if type[:2].lower() == "py":
        generateGraph(inp,Python)
    if type[:2].lower() == "ja":
        generateGraph(inp, Java)
    if type[:2].lower() == "c#":
            generateGraph(inp, C)

# oop
# df3 = prepareJavaDf("Reports/JavaB/Objects.csv");
# df4 = prepareCDF("Reports/C#P/Benchmarker.Objects-report.csv") #  generateGraph("Reports/C#P/Benchmarker.Objects-report.csv",C)
# df5=preparePythonDF("Reports/Python_us/OOP.csv")

# # factorial
# df3 = prepareJavaDf("Reports/fatorialJava.csv");
# df4 = prepareCDF("Reports/C#P/factorial.csv") #  generateGraph("Reports/C#P/Benchmarker.Objects-report.csv",C)
# df5=preparePythonDF("Reports/Python_us/factorial.csv")

#find

# df3 = prepareJavaDf("Reports/JavaB/FindTest.csv");
# df4 = prepareCDF("Reports/C#P/Benchmarker.ListFindBenchmarker-report.csv") #  generateGraph("Reports/C#P/Benchmarker.Objects-report.csv",C)
# df5=preparePythonDF("Reports/Python_us/find.csv")


# generateComp([df3,df4,df5])

exit(0)
# getJavaPlots(r"Reports\JavaB")
# getCPlots(r"Reports/C#P")




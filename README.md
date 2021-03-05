"# LanguageComparison" 

The purpose of this project is to establish a set of Microbenches in order to study
the performance of various programming languages . In this paper we will crate a set of tests
to see how different programming languages perform in a various set of scenarios , in the end
providing a comparison between them . To this purpose, the languages that we will be studied
are Java , C# and Python.  

Java and C# are were chosen because they very popular choices when it comes to
working with the Object Oriented programming paradigm (OOP), and we want to observe their
strong points.  

Python was selected because it has recently became the most popular programming
language, according to the PYPL index. The strength of the language is in the fact that is a very
versatile programming language, that can be applied to anything.
In the end we also want to establish a comparison between two types of typing , static
typing ( represented by the Java , C#) and dynamic typing (Python)

  
The TEST , that we wanted to measure were : Memory allocation , work with containers ( lists, hash tables ) , OOP capabilities , and Threading potential .

  
Plotter      
This python script was written using, pandas and NumPy, in order to offer a graphical representation of the measurement that we made. The script reads the CSV files corresponding to each measurement, processes the data bringing all the CSV files to the same format ( same name of columns, and groups the measurements together), and after that, it creates a bar graph that displays the measurements. The script can also generate a comparison graph between two or more categories ( e.g the comparison of OOP between Java and C# ).
After the plots were generated, the program will save the graph in the respected folder ( if it displays a python measurement, it will save it in the python corresponding file for images ).
  

# biggestIsoscelesTriangle
## Intern Task

Write a program for finding the largest isosceles triangle in area.

Input files contain data on the coordinates of the vertices of the triangles on the plane. Data
written in a line as 6 consecutive integers, separated by a space
(each line of the file is a new set of triangle coordinates). The first 2 numbers are the coordinates
the first point, the second - the second, etc.

The result of the program should be a new file with coordinates in the format
input file, which will contain the coordinates of the vertices of the largest in area
isosceles triangle from those presented in the input file or empty if
there are no such triangles.

## Realization

Throws IllegalArgumentException if number of arguments less or more than 2.
Prints "(Warning)Wrong input file name." if input file does not exists. Equals to empty input file.
Prints "(Error)Unable to create output file. Have no permissions or directory does not exist." if application can't create output file. 
Returns first triangle with max area.
## Run instructions

You can run application from application folder.
Windows
```
gradlew runApp --args="inputFileName outputFileName"
```
or
```
.\gradlew runApp --args="inputFileName outputFileName"
```
Linux
```
./gradlew runApp --args="inputFileName outputFileName"
```

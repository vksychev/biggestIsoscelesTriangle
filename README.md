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


gradlew runApp --args="src\main\resources\input.txt src\main\resources\out.txt"

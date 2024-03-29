import java.io.*;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

    static class Point {
        private double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        double getX() {
            return x;
        }

        double getY() {
            return y;
        }

        @Override
        public String toString() {
            DecimalFormat format = new DecimalFormat("0.#");
            return format.format(x) + " " + format.format(y);
        }

        static double getLen(Point p1, Point p2) {
            return Math.sqrt((p1.getX() - p2.getX()) * (p1.getX() - p2.getX())
                    + (p1.getY() - p2.getY()) * (p1.getY() - p2.getY()));
        }

        static Point getMid(Point p1, Point p2) {
            return new Point((p1.getX() + p2.getX()) / 2, (p1.getY() + p2.getY()) / 2);
        }
    }


    static class IsoscelesTriangle {
        private Point[] points = new Point[3];
        private double area;

        IsoscelesTriangle(double[] arr) {
            for (int i = 0; i < points.length; i++) {
                points[i] = new Point(arr[i * 2], arr[i * 2 + 1]);
            }
        }

        private void calculateArea(Point top, Point left, Point right) {
            Point m = Point.getMid(left, right);
            double h = Point.getLen(top, m);
            double l = Point.getLen(left, right);
            area = 0.5 * h * l;
        }


        private void processArea() {
            double l1 = Point.getLen(points[0], points[1]);
            double l2 = Point.getLen(points[0], points[2]);
            double l3 = Point.getLen(points[1], points[2]);
            if (l1 == l2) {
                calculateArea(points[0], points[1], points[2]);
            } else if (l1 == l3) {
                calculateArea(points[1], points[0], points[2]);
            } else if (l2 == l3) {
                calculateArea(points[2], points[0], points[1]);
            } else {
                area = -1;
            }

        }

        /**
         * Returns size of area if triangle is isosceles.
         * Returns -1 if it is not.
         *
         * @return -1 if triangle is not isosceles
         */
        double getArea() {
            if (area == 0) {
                processArea();
            }
            return area;
        }

        @Override
        public String toString() {
            return points[0].toString() + " " + points[1].toString() + " " + points[2].toString();
        }
    }

    private static boolean isDoubleArray(String[] arr) {
        for (String s : arr) {
            if (!s.matches("-?\\d+(\\.\\d+)?")) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        if (args.length != 2) {
            throw new IllegalArgumentException("(Error)Missing arguments");
        }

        File file = new File(args[0]);
        IsoscelesTriangle max = null;
        if (file.exists()) {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] array = line.split(" ");
                if (array.length == 6 && isDoubleArray(array)) {
                    IsoscelesTriangle current = new IsoscelesTriangle(
                            Arrays.stream(array)
                                    .mapToDouble(Double::parseDouble)
                                    .toArray()
                    );

                    if ((max == null || max.getArea() < current.getArea()) && current.getArea() > 0) {
                        max = current;
                    }
                }
            }
            scanner.close();
        } else {
            System.out.println("(Warning)Wrong input file name.");
        }

        File out = new File(args[1]);
        try {
            FileWriter writer = new FileWriter(out);
            writer.write((max == null) ? " " : max.toString());
            writer.close();
        } catch (IOException e) {
            System.out.println("(Error)Unable to create output file. Have no permissions or directory does not exist.");
        }
    }
}
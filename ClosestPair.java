/*Michael Gieras
 * 
 * CS 463 Algorithms
 * 
 * Program for finding 2 points with shortest distance
 * using brute force algorithm
 */
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

class Point {
    final double x;
    final double y;
    public Point(double x, double y) {
        this.x = x; this.y = y;
    }

    public double distance(Point that) {
        double distance;
        /* Compute the distance between this and that */
    	distance = Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2);
        return distance;    
    }
}
class Pair {
    Point one;
    Point two;
    public Pair(Point one, Point two) {
        this.one = one; this.two = two;
    }
}

public class ClosestPair {

    private static Pair findClosestPair(List<Point> points) {
        /*  DO THE THING! */
    	Pair closestPair = new Pair(points.get(0), points.get(1));
    	double dSquare = Double.POSITIVE_INFINITY;
    	double distance = dSquare;
    	for (int i = 0; i < points.size() - 1; i++) {
    		for (int j = i + 1; j < points.size(); j++) {
    			dSquare = Math.min(dSquare, points.get(i).distance(points.get(j)));
    		    if (dSquare < distance) {
    		    	distance = dSquare;
					closestPair = new Pair(points.get(i), points.get(j));
    		    }
    		}
    	}
    	return closestPair;
    }

    public static void main(String[] args) {
    	System.out.println("Enter number of points ");
        Scanner scanner =  new Scanner(System.in);
        int N = scanner.nextInt();
        List<Point> points = new ArrayList<>();
        System.out.println("Enter x and y values of point with space inbetween ");
        for (int i = 0; i < N; i+=1) {
            points.add(new Point(scanner.nextDouble(), scanner.nextDouble()));
        }
        scanner.close();

        Pair closest = findClosestPair(points);
        System.out.println("The closest points are ");
        System.out.println(closest.one.x + " " + closest.one.y);
        System.out.println(closest.two.x + " " + closest.two.y);
    }

}


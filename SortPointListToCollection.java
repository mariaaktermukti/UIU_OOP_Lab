import java.util.ArrayList;
import java.util.Collections;

public class SortPointListToCollection {
    static class Point implements Comparable<Point> {
        private int x, y;
        public Point(int x, int y)
        {
            this.x = x; this.y = y;
        }
        public int compareTo(Point other)
        {
            return Integer.compare(other.x + other.y, this.x + this.y);
        }
        public String toString()
        {
            return "(" + x + ", " + y + ")";
        }
    }

    public static void main(String[] args)
    {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(1,2 ));
        points.add(new Point(3,4));
        points.add(new Point(5,6));
        points.add(new Point(7,8));

        System.out.println("Before: " + points);
        Collections.sort(points);
        System.out.println("After (by x+y desc): " + points);
    }
}

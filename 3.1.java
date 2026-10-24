
import java.util.Objects;

class Point {
    private int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }

    public boolean equals(Point p) {
        return x == p.x && y == p.y;
    }
}

class Main5{
    public static void main(String args[]) {

        Point[] points = {
                new Point(1, 2),
                new Point(3, 4),
                new Point(1, 2),
                new Point(5, 6),
                new Point(3, 4)
        };

        int diff = 0;

        int i,j;
        for (i = 0; i < points.length; i++) {

            boolean found = false;

            for (j = 0; j < i; j++)
            {
                if (points[i].equals(points[j]))
                {
                    found = true;
                    break;
                }
            }

            if (!found)
                diff++;
        }

        System.out.println("Distinct: " + diff);
    }
}




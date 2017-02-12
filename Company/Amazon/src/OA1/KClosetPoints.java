package OA1;
import java.util.*;

class Point {
    public int x;
    public int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class KClosetPoints {
    public List<Point> findKClosest(Point[] array, final Point origin, int k) {
        PriorityQueue<Point> points = new PriorityQueue<Point>(k, new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                return  (int)(getDistance(b, origin) - getDistance(a, origin));//true, return a, max heap
            }
        });


        for (int i = 0; i < array.length; i++) {
            if (i < k) {
                points.add(array[i]);
            } else {
                if (getDistance(points.peek(), origin) > getDistance(array[i], origin)) {
                    points.poll();
                    points.add(array[i]);
                }
            }
        }

        List<Point> res = new ArrayList<>();
        while(!points.isEmpty()) {
            res.add(points.poll());
        }
        return res;


    }

    private double getDistance(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y -b.y);
    }

    public static void main(String[] args) {
        Point[] test = new Point[20];
        test[0] = new Point(3, 14);
        test[1] = new Point(2, 4);
        test[2] = new Point(3, 9);
        test[3] = new Point(1, 12);
        test[4] = new Point(6, 8);
        test[5] = new Point(3, 4);
        test[6] = new Point(7, 41);
        test[7] = new Point(3, 4);
        test[7] = new Point(9, 11);
        test[8] = new Point(3, 5);
        test[9] = new Point(34, 4);
        test[10] = new Point(36, 16);
        test[11] = new Point(12, 14);
        test[12] = new Point(13, 11);
        test[13] = new Point(2, 24);
        test[14] = new Point(6, 4);
        test[15] = new Point(31, 4);
        test[16] = new Point(24, 10);
        test[17] = new Point(15, 24);
        test[18] = new Point(17, 4);
        test[19] = new Point(14, 13);
        Point origin = new Point(0 , 0);
        KClosetPoints m = new KClosetPoints();
        List<Point> res;
        res = m.findKClosest(test, origin, 12);
        for(Point item : res) {
            System.out.print("point: " + item.x + " " + item.y + " ");
            //point: 12 14 point: 17 4 point: 13 11 point: 3 14 point: 9 11 point: 1 12 point: 6 8 point: 3 9 point: 6 4 point: 3 5 point: 3 4 point: 2 4
        }
    }

}

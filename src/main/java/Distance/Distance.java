package Distance;

public class Distance {


    public static double getDistance(Point a, Point b){

        return Math.sqrt((b.x-a.x)*(b.x-a.x)+(b.y-a.y)*(b.y-a.y));
    }
}

public class Ride {
    public int a, b, x, y, start, finish;
    int distance;

    public Ride(int a, int b, int x, int y, int start, int finish) {
        this.a = a;
        this.b = b;
        this.x = x;
        this.y = y;
        this.start = start;
        this.finish = finish;
        this.distance = Math.abs(a - x) + Math.abs(b - y);
    }

}

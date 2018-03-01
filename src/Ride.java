public class Ride {
    public int id, a, b, x, y, start, finish, distance;

    public Ride(int id, int a, int b, int x, int y, int start, int finish) {
        this.id = id;
        this.a = a;
        this.b = b;
        this.x = x;
        this.y = y;
        this.start = start;
        this.finish = finish;
        this.distance = Math.abs(a - x) + Math.abs(b - y);
    }
}

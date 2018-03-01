public class Car implements Comparable<Car> {
  public int id;
  public Ride currentRide;
  public boolean taken;
  public int currentTick;

  public Car(int id) {
    this.id = id;
    taken = false;
  }

  public void takeRide(Ride r) {
    this.currentRide = r;
    this.currentTick += r.distance;
    taken = true;
  }

  @Override public int compareTo(Car o) {
    return this.currentTick - o.currentTick;
  }
}

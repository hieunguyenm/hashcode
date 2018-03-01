public class Car {
  public int id;
  public Ride currentRide;
  public boolean taken;

  public Car(int id) {
    this.id = id;
    taken = false;
  }

  public void takeRide(Ride r) {
    this.currentRide = r;
  }

}

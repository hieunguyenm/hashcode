import java.util.ArrayList;

public class Pair {
    ArrayList<Ride> rides;
    ArrayList<Car> cars;

    Pair(ArrayList<Ride> rides, ArrayList<Car> cars) {
        this.cars = cars;
        this.rides = rides;
    }

    public ArrayList<Ride> getKey() {
        return rides;
    }

    public ArrayList<Car> getValue() {
        return cars;
    }
}

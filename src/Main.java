import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    private static final String FILE = "a_example.in";

    private static ArrayList<Ride> rides = new ArrayList<>();
    private static ArrayList<Car> cars = new ArrayList<>();

    public static void main(String[] args) {
        ReadFile reader = new ReadFile();
        PriorityQueue<Car> queue = new PriorityQueue<>();
        Jobs jobList = new Jobs(cars.size());

        try {
            Pair p = reader.readFile(FILE);
            rides = p.getKey();
            cars = p.getValue();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Car c : cars) {
            c.takeRide(rides.get(0));
            jobList.insertRide(c.id, rides.get(0).id);
            rides.remove(0);
            queue.add(c);
        }

        while (!rides.isEmpty()) {
            Car c = queue.poll();
            int nextRideID = getNext(c);
            c.takeRide(rides.get(nextRideID));
            jobList.insertRide(c.id, nextRideID);
            rides.remove(nextRideID);
            queue.add(c);
        }
    }

    private static int getNext(Car c) {
        int closest = 0;
        int currentDist = Integer.MAX_VALUE;

        for (Ride r : rides) {
            if (Math.abs(r.a - c.currentRide.x) + Math.abs(r.b - c.currentRide.y) < currentDist) {
                closest = r.id;
            }
        }

        return closest;
    }
}
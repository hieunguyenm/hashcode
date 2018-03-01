import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    private static final String FILE = "c_no_hurry.in";

    private static ArrayList<Ride> rides = new ArrayList<>();
    private static ArrayList<Car> cars = new ArrayList<>();
    private static ArrayList<Ride> ridesCopy = new ArrayList<>();

    public static void main(String[] args) {
        ReadFile reader = new ReadFile();
        PriorityQueue<Car> queue = new PriorityQueue<>();
        Jobs jobList = new Jobs(cars.size());

        try {
            Pair p = reader.readFile(FILE);
            rides = p.getKey();
            cars = p.getValue();
            jobList = new Jobs(cars.size());
        } catch (IOException e) {
            e.printStackTrace();
        }

        ridesCopy.addAll(rides);

        for (Car c : cars) {
            c.takeRide(ridesCopy.get(0));
            jobList.insertRide(c.id, ridesCopy.get(0).id);
            ridesCopy.remove(0);
            queue.add(c);
        }

        while (!ridesCopy.isEmpty()) {
            Car c = queue.poll();
            int nextRideID = getNext(c);
            c.takeRide(rides.get(nextRideID));
            jobList.insertRide(c.id, nextRideID);
            ridesCopy.remove(rides.get(nextRideID));
            queue.add(c);
        }

        for (int i = 0; i < cars.size(); i++) {
            ArrayList<Integer> jobs = jobList.getRides(i);
            System.out.print(jobs.size() + " ");

            for (Integer j : jobs) {
                System.out.print(j + " ");
            }

            System.out.println();
        }
    }

    private static int getNext(Car c) {
        int closest = 0;
        int currentDist = Integer.MAX_VALUE;

        for (Ride r : ridesCopy) {
            if (Math.abs(r.a - c.currentRide.x) + Math.abs(r.b - c.currentRide.y) < currentDist
                && c.currentTick +  Math.abs(c.currentRide.x - r.a) + Math.abs(c.currentRide.y - r.b) + r.distance < r.finish) {
                closest = r.id;
            }
        }

        return closest;
    }

    private static int getNext1(Car c) {
        int closest = 0;
        int currentDist = Integer.MAX_VALUE;

        for (Ride r : ridesCopy) {
            if (r.distance < currentDist && c.currentTick +  Math.abs(c.currentRide.x - r.a) + Math.abs(c.currentRide.y - r.b) + r.distance < r.finish) {
                closest = r.id;
            }
        }

        return closest;
    }
}
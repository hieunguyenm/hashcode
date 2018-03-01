import java.util.ArrayList;
import java.util.HashMap;

public class Jobs {
    private HashMap<Integer, ArrayList<Integer>> jobs;

    public Jobs(int cars) {
        jobs = new HashMap<>();

        for (int i = 0; i < cars; i++) {
            jobs.put(i, new ArrayList<>());
        }
    }

    public ArrayList<Integer> getRides(int car) {
        return jobs.get(car);
    }

    public void insertRide(int car, int ride) {
        ArrayList<Integer> carJobs = jobs.get(car);
        carJobs.add(ride);
        jobs.put(car, carJobs);
    }

    public void display() {
        for(Integer car : jobs.keySet()) {
            ArrayList<Integer> rides = jobs.getOrDefault(car, new ArrayList<>());
            System.out.printf("%d %d\n", car, rides.size());
            rides.forEach(r -> System.out.printf("%d ", r));
            System.out.println();
        }
    }
}

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static final String FILE = "a_example.in";

    public static void main(String[] args) {
        ArrayList<Ride> rides = null;
        ArrayList<Car> cars = null;
        ReadFile reader = new ReadFile();

        try {
            reader.readFile(FILE, rides, cars);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

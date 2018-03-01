import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class ReadFile {
    public Pair readFile(String fileName) throws IOException {
        Scanner input = new Scanner(new File(fileName));
        int R, C, F, N, B, T;

        String[] temp = input.nextLine().split(" ");
        R = tI(temp[0]);
        C = tI(temp[1]);
        F = tI(temp[2]);
        N = tI(temp[3]);
        B = tI(temp[4]);
        T = tI(temp[5]);

        ArrayList<Ride> rides = new ArrayList<>(N);
        ArrayList<Car> cars = new ArrayList<>(F);

        for(int i = 0; i < F; ++i) {
          cars.add(new Car(i));
        }

        for (int i = 0; i < N; ++i) {
            temp = input.nextLine().split(" ");
            rides.add(new Ride(i, tI(temp[0]), tI(temp[1]), tI(temp[2]), tI(temp[3]), tI(temp[4]), tI(temp[5])));
        }

        return new Pair(rides, cars);
    }

    public int tI(String n) {
        return Integer.parseInt(n);
    }
}

import java.util.Scanner;

abstract class Booking {
    double distance;
    static final double BOOKING_FEE = 50.0;

    Booking(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();

    double calculateTotal() {
        return calculateFare() + BOOKING_FEE;
    }

    abstract String getMode();
}

class Bus extends Booking {
    Bus(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 2;
    }

    String getMode() {
        return "BUS";
    }
}

class Train extends Booking {
    Train(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 1.5;
    }

    String getMode() {
        return "TRAIN";
    }
}

class Flight extends Booking {
    Flight(double distance) {
        super(distance);
    }

    double calculateFare() {
        return 2500 + distance * 4;
    }

    String getMode() {
        return "FLIGHT";
    }
}

public class Problem5w9p9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Booking[] bookings = new Booking[n];

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();

            if (mode.equalsIgnoreCase("BUS")) {
                bookings[i] = new Bus(distance);
            } else if (mode.equalsIgnoreCase("TRAIN")) {
                bookings[i] = new Train(distance);
            } else if (mode.equalsIgnoreCase("FLIGHT")) {
                bookings[i] = new Flight(distance);
            }
        }

        for (Booking b : bookings) {
            System.out.printf("%s: %.2f%n",
                    b.getMode(), b.calculateTotal());
        }

        sc.close();
    }
}

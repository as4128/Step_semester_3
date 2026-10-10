
import java.util.*;

abstract class Room {
    int units;
    Room(int units) {
        this.units = units;
    }
    abstract double calculate();
}

class SingleRoom extends Room {
    SingleRoom(int u) { super(u); }
    double calculate() { return units * 8; }
}

class SharedRoom extends Room {
    int occupants;
    SharedRoom(int u, int o) {
        super(u);
        occupants = o;
    }
    double calculate() {
        return (units * 6.0) / occupants;
    }
}

class AcRoom extends Room {
    AcRoom(int u) { super(u); }
    double calculate() { return units * 10 + 200; }
}

public class Problem3w8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            Room r;

            switch (type) {
                case "SINGLE":
                    r = new SingleRoom(units);
                    break;
                case "SHARED":
                    int occupants = sc.nextInt();
                    r = new SharedRoom(units, occupants);
                    break;
                default:
                    r = new AcRoom(units);
            }

            double bill = r.calculate();
            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
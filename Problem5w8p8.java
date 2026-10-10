
import java.util.*;

abstract class Transport {
    double distance;
    Transport(double d) {
        distance = d;
    }
    abstract double calculate();
}

class Bus extends Transport {
    Bus(double d) { super(d); }
    double calculate() {
        return Math.min(10, 2 + distance * 0.10);
    }
}

class Train extends Transport {
    Train(double d) { super(d); }
    double calculate() {
        return 3 + distance * 0.15;
    }
}

class Metro extends Transport {
    double factor;
    Metro(double d, double f) {
        super(d);
        factor = f;
    }
    double calculate() {
        return (1.5 + distance * 0.20) * factor;
    }
}

public class Problem5w8p8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();
            Transport t;

            switch (type) {
                case "BUS":
                    t = new Bus(distance);
                    break;
                case "TRAIN":
                    t = new Train(distance);
                    break;
                default:
                    double factor = sc.nextDouble();
                    t = new Metro(distance, factor);
            }

            double fare = t.calculate();
            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

import java.util.*;

abstract class Delivery {
    double weight, distance;
    Delivery(double w, double d) {
        weight = w;
        distance = d;
    }
    abstract double calculate();
}

class Standard extends Delivery {
    Standard(double w, double d) { super(w, d); }
    double calculate() {
        return 5 + weight * 0.5 + distance * 0.1;
    }
}

class Express extends Delivery {
    Express(double w, double d) { super(w, d); }
    double calculate() {
        return 15 + weight + distance * 0.2;
    }
}

class International extends Delivery {
    double customs;
    International(double w, double d, double c) {
        super(w, d);
        customs = c;
    }
    double calculate() {
        return 25 + weight * 2 + distance * 0.5 + customs;
    }
}

public class Problem3w8p8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double w = sc.nextDouble();
            double d = sc.nextDouble();
            Delivery delivery;

            switch (type) {
                case "STANDARD":
                    delivery = new Standard(w, d);
                    break;
                case "EXPRESS":
                    delivery = new Express(w, d);
                    break;
                default:
                    double c = sc.nextDouble();
                    delivery = new International(w, d, c);
            }

            double fee = delivery.calculate();
            System.out.printf("%s: %.2f%n", type, fee);
            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
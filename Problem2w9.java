import java.util.Scanner;

abstract class Parcel {
    double weight, value;

    Parcel(double w, double v) {
        weight = w;
        value = v;
    }

    abstract double charge();

    double insurance() {
        return 0;
    }

    double total() {
        return charge() + insurance();
    }
}

class Standard extends Parcel {
    Standard(double w, double v) { super(w, v); }
    double charge() { return 40 + 10 * weight; }
}

class Express extends Parcel {
    Express(double w, double v) { super(w, v); }
    double charge() { return 80 + 15 * weight; }
    double insurance() { return value * 0.02; }
}

class Fragile extends Parcel {
    Fragile(double w, double v) { super(w, v); }
    double charge() { return 40 + 10 * weight + 50; }
    double insurance() { return value * 0.02; }
}

public class Problem2w9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grand = 0;

        while (n-- > 0) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();
            Parcel p;

            switch (type) {
                case "STANDARD": p = new Standard(weight, value); break;
                case "EXPRESS": p = new Express(weight, value); break;
                default: p = new Fragile(weight, value);
            }

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                type, p.charge(), p.insurance(), p.total()
            );
            grand += p.total();
        }

        System.out.printf("Grand Total: %.2f%n", grand);
        sc.close();
    }
}
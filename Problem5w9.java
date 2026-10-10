import java.util.Scanner;

interface SaverMode {
}

abstract class Appliance {
    double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double power();

    double units(boolean saver) {
        double u = power() * hours / 1000;
        return saver ? u * 0.75 : u;
    }

    double cost(double units) {
        return units * 8;
    }
}

class Fridge extends Appliance {
    Fridge(double h) { super(h); }
    double power() { return 150; }
}

class AC extends Appliance implements SaverMode {
    AC(double h) { super(h); }
    double power() { return 1500; }
}

class TV extends Appliance {
    TV(double h) { super(h); }
    double power() { return 100; }
}

class Washer extends Appliance implements SaverMode {
    Washer(double h) { super(h); }
    double power() { return 500; }
}

public class Problem5w9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        while (n-- > 0) {
            String type = sc.next();
            double hours = sc.nextDouble();
            boolean saver = sc.hasNext("SAVER");

            if (saver)
                sc.next();

            Appliance a;

            switch (type) {
                case "FRIDGE": a = new Fridge(hours); break;
                case "AC": a = new AC(hours); break;
                case "TV": a = new TV(hours); break;
                default: a = new Washer(hours);
            }

            if (saver && !(a instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
            } else {
                double units = a.units(saver);
                double cost = a.cost(units);

                System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n", type, units, cost
                );
                total += cost;
            }
        }

        System.out.printf("Total Cost: %.2f%n", total);
        sc.close();
    }
}
import java.util.Scanner;

abstract class Seat {
    static final double FEE = 20;
    int count;

    Seat(int count) {
        this.count = count;
    }

    abstract double price();

    double amount() {
        return (price() + FEE) * count;
    }
}

class Regular extends Seat {
    Regular(int c) { super(c); }
    double price() { return 150; }
}

class Premium extends Seat {
    Premium(int c) { super(c); }
    double price() { return 250; }
}

class Recliner extends Seat {
    Recliner(int c) { super(c); }
    double price() { return 400; }
}

public class Problem1w9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        while (n-- > 0) {
            String type = sc.next();
            int count = sc.nextInt();
            Seat s;

            switch (type) {
                case "REGULAR": s = new Regular(count); break;
                case "PREMIUM": s = new Premium(count); break;
                default: s = new Recliner(count);
            }

            double amount = s.amount();
            System.out.printf("%s: %.2f%n", type, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
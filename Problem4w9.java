import java.util.Scanner;

interface NightService {
}

abstract class Cab {
    double rate;

    Cab(double rate) {
        this.rate = rate;
    }

    double fare(double km, boolean night) {
        double amount = Math.max(100, km * rate);
        if (night && this instanceof NightService)
            amount *= 1.20;
        return amount;
    }
}

class Mini extends Cab {
    Mini() { super(10); }
}

class Sedan extends Cab implements NightService {
    Sedan() { super(14); }
}

class SUV extends Cab implements NightService {
    SUV() { super(18); }
}

public class Problem4w9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        while (n-- > 0) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();
            boolean night = time.equals("NIGHT");
            Cab cab;

            switch (type) {
                case "MINI": cab = new Mini(); break;
                case "SEDAN": cab = new Sedan(); break;
                default: cab = new SUV();
            }

            if (night && !(cab instanceof NightService)) {
                System.out.println(type + ": night service not available");
            } else {
                double fare = cab.fare(km, night);
                System.out.printf("%s: %.2f%n", type, fare);
                total += fare;
            }
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
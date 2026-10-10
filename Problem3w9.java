import java.util.Scanner;

abstract class Student {
    String name;
    static final double BUS_FEE = 12000;

    Student(String name) {
        this.name = name;
    }

    abstract double tuition();

    boolean usesBus() {
        return true;
    }

    double extraFee() {
        return 0;
    }

    double totalFee() {
        return tuition() + extraFee() + (usesBus() ? BUS_FEE : 0);
    }
}

class DayScholar extends Student {
    DayScholar(String n) { super(n); }
    double tuition() { return 40000; }
}

class Hosteller extends Student {
    Hosteller(String n) { super(n); }
    double tuition() { return 40000; }
    double extraFee() { return 60000; }
    boolean usesBus() { return false; }
}

class Scholar extends Student {
    Scholar(String n) { super(n); }
    double tuition() { return 20000; }
}

public class Problem3w9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        while (n-- > 0) {
            String type = sc.next();
            String name = sc.next();
            Student s;

            switch (type) {
                case "DAY_SCHOLAR": s = new DayScholar(name); break;
                case "HOSTELLER": s = new Hosteller(name); break;
                default: s = new Scholar(name);
            }

            double fee = s.totalFee();
            System.out.printf("%s: %.2f%n", name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}
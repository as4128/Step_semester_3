
import java.util.Scanner;

public class Problem3w10 {

    static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        String[] rotated = new String[n];

        k = k % n;

        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = names[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of names: ");
        int n = sc.nextInt();

        String[] names = new String[n];

        System.out.println("Enter the names:");
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }

        System.out.print("Enter rotation value k: ");
        int k = sc.nextInt();

        String[] result = rotateRoster(names, k);

        System.out.print("Rotated roster: [");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        sc.close();
    }
}

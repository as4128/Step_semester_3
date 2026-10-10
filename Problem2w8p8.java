
import java.util.*;
import java.time.LocalDate;

abstract class LibraryItem {
    String title;
    LibraryItem(String title) {
        this.title = title;
    }
    abstract int getLoanDays();
}

class Book extends LibraryItem {
    Book(String t) { super(t); }
    int getLoanDays() { return 14; }
}

class DVD extends LibraryItem {
    DVD(String t) { super(t); }
    int getLoanDays() { return 7; }
}

class Magazine extends LibraryItem {
    Magazine(String t) { super(t); }
    int getLoanDays() { return 3; }
}

public class Problem2w8p8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        LocalDate today = LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String type = line.substring(0, line.indexOf(' '));
            String title = line.substring(line.indexOf(' ') + 1)
                                .replace("\"", "");
            LibraryItem item;

            switch (type) {
                case "BOOK": item = new Book(title); break;
                case "DVD": item = new DVD(title); break;
                default: item = new Magazine(title);
            }

            System.out.println(title + ": " +
                today.plusDays(item.getLoanDays()));
        }
        sc.close();
    }
}
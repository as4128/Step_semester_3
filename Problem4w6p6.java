class Problem4w6p6 {

    String name;
    int booksIssued;

    // Constructor
    Problem4w6p6(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }

    public static void main(String[] args) {

        // Create Ravi's card
        Problem4w6p6 ravi = new Problem4w6p6("Ravi", 0);

        // Both variables refer to the same object
        Problem4w6p6 duplicate = ravi;

        // Change using duplicate
        duplicate.booksIssued = 3;

        // Create a separate object
        Problem4w6p6 separate = new Problem4w6p6("Ravi", 3);

        System.out.println(
            "Ravi's booksIssued (via first variable): "
            + ravi.booksIssued
        );

        System.out.println("duplicate == ravi: " + (duplicate == ravi));

        System.out.println(
            "separate == ravi: " + (separate == ravi)
        );
    }
}
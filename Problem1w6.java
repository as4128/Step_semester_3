class Problem1w6 {

    String title;
    String author;
    int copiesAvailable;

    // Constructor
    Problem1w6(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    // Method to print book details
    void printEntry() {
        System.out.println(title + " by " + author + " - "
                + copiesAvailable + " copies available");
    }

    // Main method
    public static void main(String[] args) {

        Problem1w6[] books = {
            new Problem1w6("Clean Code", "Robert C. Martin", 3),
            new Problem1w6("Effective Java", "Joshua Bloch", 5),
            new Problem1w6("Refactoring", "Martin Fowler", 0),
            new Problem1w6("Design Patterns", "GoF", 2)
        };

        for (Problem1w6 book : books) {
            book.printEntry();
        }
    }
}
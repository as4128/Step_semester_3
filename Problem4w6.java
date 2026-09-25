class Problem4w6 {

    String studentName;
    int seatNumber;

    // Constructor
    Problem4w6(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }

    public static void main(String[] args) {

        // Create one object
        Problem4w6 priya = new Problem4w6("Priya", 0);

        // Both variables refer to the same object
        Problem4w6 copy = priya;

        // Change through second variable
        copy.seatNumber = 45;

        // Create separate object
       Problem4w6 separate = new Problem4w6("Priya", 45);

        System.out.println("Priya's seatNumber (via first variable):");
        System.out.println(priya.seatNumber);

        System.out.println("copy == priya: " + (copy == priya));
        System.out.println("separate == priya: " + (separate == priya));
    }
}
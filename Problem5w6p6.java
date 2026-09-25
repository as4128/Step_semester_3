class Problem5w6p6 {

    String name;
    double attendance;

    static String collegeName =
        "SRM Institute of Science and Technology";

    static int studentCount = 0;

    // Constructor
    Problem5w6p6(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    // Static method
    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {

        Problem5w6p6 s1 = new Problem5w6p6("Ravi", 85);
        Problem5w6p6 s2 = new Problem5w6p6("Anitha", 90);

        Problem5w6p6.printCollegeInfo();
    }
}
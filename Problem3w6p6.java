class Problem3w6p6 {

    String code;
    String title;
    int credits;
    int labCredits;

    // Constructor with lab credits
    public Problem3w6p6(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    // Constructor for theory-only course
    public Problem3w6p6(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    // Calculate total credits
    public int totalCredits() {
        return credits + labCredits;
    }

    public static void main(String[] args) {

        Problem3w6p6 theory = new Problem3w6p6(
            "21CSC201J",
            "Data Structures",
            4
        );

        Problem3w6p6 lab = new Problem3w6p6(
            "21CSC205L",
            "DSA Lab",
            3,
            1
        );

        System.out.println(
            theory.code + " total credits: " + theory.totalCredits()
        );

        System.out.println(
            lab.code + " total credits: " + lab.totalCredits()
        );
    }
}
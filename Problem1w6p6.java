class Problem1w6p6 {

    String studentName;
    String company;
    double packageLpa;

    // Constructor
    Problem1w6p6(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    // Print record
    void printRecord() {
        System.out.println(studentName + " -> " + company + " @ "
                + packageLpa + " LPA");
    }

    public static void main(String[] args) {

        Problem1w6p6[] records = {
            new Problem1w6p6("Ravi", "TCS", 4.5),
            new Problem1w6p6("Anitha", "Zoho", 6.2),
            new Problem1w6p6("Karthik", "Infosys", 4.0)
        };

        for (Problem1w6p6 record : records) {
            record.printRecord();
        }
    }
}
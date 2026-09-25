class Problem5w6 {

    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    // Constructor
    Problem5w6(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    // Static method
    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {

        Problem5w6 e1 = new Problem5w6("Divya", 65000);
        Problem5w6 e2 = new Problem5w6("Arjun", 50000);
        Problem5w6 e3 = new Problem5w6("Priya", 55000);

        Problem5w6.printCompanyInfo();
    }
}
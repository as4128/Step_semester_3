class Problem3w6 {

    String empId;
    String empName;
    double salary;
    boolean isIntern;

    // Constructor for permanent employee
    public Problem3w6(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    // Constructor for intern
    public Problem3w6(String empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    // Print employee profile
    public void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs "
                + salary + " | Intern: " + isIntern);
    }

    public static void main(String[] args) {

        Problem3w6 permanent = new Problem3w6("E-101", "Divya", 65000);
        Problem3w6 intern = new Problem3w6("E-102", "Arjun");

        permanent.printProfile();
        intern.printProfile();
    }
}
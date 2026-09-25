class Problem2w6 {

    private double basicSalary;
    private double bonus;

    // Constructor
    public Problem2w6(double basicSalary) {
        if (basicSalary < 0) {
            System.out.println("Warning: Negative salary not allowed.");
            this.basicSalary = 0;
        } else {
            this.basicSalary = basicSalary;
        }

        this.bonus = 0;
    }

    // Credit bonus
    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid bonus amount.");
        } else {
            bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }

    // Deduct tax
    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Invalid tax percentage.");
        } else {
            basicSalary = basicSalary - (basicSalary * percent / 100);
            System.out.println("Tax deducted: " + percent + "%");
        }
    }

    // Get net salary
    public double getNetSalary() {
        return basicSalary + bonus;
    }

    public static void main(String[] args) {

        Problem2w6 account = new Problem2w6(50000);

        account.creditBonus(5000);
        account.deductTax(10);

        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}
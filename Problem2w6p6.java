class Problem2w6p6 {

    private double balance;

    // Constructor
    public Problem2w6p6(double balance) {
        if (balance < 0) {
            System.out.println("Warning: Negative balance not allowed");
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    // Add money
    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected");
        } else {
            balance = balance + amount;
            System.out.println("Balance after top-up: " + balance);
        }
    }

    // Deduct money
    public void deduct(double amount) {
        if (amount > balance) {
            System.out.println("Deduct rejected: insufficient balance");
        } else {
            balance = balance - amount;
            System.out.println("Amount deducted: " + amount);
        }
    }

    // Get balance
    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {

        Problem2w6p6 wallet = new Problem2w6p6(500);

        wallet.topUp(200);
        wallet.deduct(1000);

        System.out.println("Final balance: " + wallet.getBalance());
    }
}
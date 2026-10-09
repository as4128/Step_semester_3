
class PasswordChecker {
    private final String password;

    PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        int len = password.length();

        if (len < 6)
            return "Weak";
        else if (len <= 9)
            return "Medium";
        else
            return "Strong";
    }
}

public class Problem3w7 {
    public static void main(String[] args) {
        PasswordChecker p1 = new PasswordChecker("abcd");
        PasswordChecker p2 = new PasswordChecker("abcdefgh");
        PasswordChecker p3 = new PasswordChecker("abcdefghijkl");

        System.out.println(p1.getStrength());
        System.out.println(p2.getStrength());
        System.out.println(p3.getStrength());
    }
}
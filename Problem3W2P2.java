public class Problem3W2P2 {

    static String validateFileExtension(String filename) {

        int dotPosition = filename.lastIndexOf('.');

        String extension = filename.substring(dotPosition + 1);

        if (extension.equalsIgnoreCase("pdf") ||
            extension.equalsIgnoreCase("docx") ||
            extension.equalsIgnoreCase("zip")) {

            return "Accepted";

        } else {
            return "Rejected — invalid file type";
        }
    }

    public static void main(String[] args) {

        String filename = "Assignment1.PDF";

        System.out.println(validateFileExtension(filename));
    }
}
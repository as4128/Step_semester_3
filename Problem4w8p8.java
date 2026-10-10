
import java.util.*;
import java.io.*;
import java.util.regex.*;

abstract class Question {
    String correct, answer;
    double points;

    Question(String c, String a, double p) {
        correct = c;
        answer = a;
        points = p;
    }

    abstract double grade();
}

class MCQ extends Question {
    MCQ(String c, String a, double p) { super(c, a, p); }
    double grade() {
        return answer.equals(correct) ? points : 0;
    }
}

class TF extends Question {
    TF(String c, String a, double p) { super(c, a, p); }
    double grade() {
        return answer.equals(correct) ? points : 0;
    }
}

class Essay extends Question {
    Essay(String c, String a, double p) { super(c, a, p); }

    double grade() {
        int count = 0;
        for (String word : correct.split(",")) {
            if (answer.toLowerCase().contains(
                    word.trim().toLowerCase()))
                count++;
        }
        if (count >= 2) return points * 0.75;
        if (count == 1) return points * 0.50;
        return 0;
    }
}

public class Problem4w8p8 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        double total = 0;
        Pattern pattern = Pattern.compile("\"([^\"]*)\"");

        for (int i = 0; i < n; i++) {
            String line = br.readLine().trim();
            Matcher m = pattern.matcher(line);
            String[] data = new String[3];

            for (int j = 0; j < 3; j++) {
                m.find();
                data[j] = m.group(1);
            }

            String type = line.substring(0,
                    line.indexOf('"')).trim();
            double points = Double.parseDouble(
                    line.substring(line.lastIndexOf('"') + 1).trim());

            Question q;
            if (type.equals("MCQ"))
                q = new MCQ(data[1], data[2], points);
            else if (type.equals("TF"))
                q = new TF(data[1], data[2], points);
            else
                q = new Essay(data[1], data[2], points);

            double score = q.grade();
            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
    }
}
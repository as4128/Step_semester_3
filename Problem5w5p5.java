import java.util.Arrays;

class Candidate implements Comparable<Candidate> {

    String name;
    double cgpa;
    int codingScore;

    Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    double compositeScore() {
        return cgpa * 10 + codingScore;
    }

    public int compareTo(Candidate c) {
        return Double.compare(c.compositeScore(), this.compositeScore());
    }
}

public class Problem5w5p5 {

    static String shortlistAndRank(Candidate[] candidates) {

        Candidate[] shortlisted = new Candidate[candidates.length];
        int count = 0;

        for (int i = 0; i < candidates.length; i++) {

            if (Candidate.isEligible(candidates[i].cgpa) ||
                Candidate.isEligible(candidates[i].cgpa,
                                     candidates[i].codingScore)) {

                shortlisted[count] = candidates[i];
                count++;
            }
        }

        Arrays.sort(shortlisted, 0, count);

        String result = "";

        for (int i = 0; i < count; i++) {

            result += (i + 1) + ". "
                    + shortlisted[i].name
                    + " (" + shortlisted[i].compositeScore() + ")";

            if (i < count - 1) {
                result += " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Candidate[] candidates = {

            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 10)
        };

        System.out.println(shortlistAndRank(candidates));
    }
}
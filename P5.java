import java.util.Arrays;

public class P5 implements Comparable<P5> {

    private String name;
    private double cgpa;
    private int codingScore;

    public P5(String name, double cgpa, int codingScore) {
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

    @Override
    public int compareTo(P5 other) {

        double s1 = cgpa * 10 + codingScore * 0.5;
        double s2 = other.cgpa * 10 + other.codingScore * 0.5;

        return Double.compare(s2, s1);
    }

    static String shortlistAndRank(P5[] candidates) {

        int count = 0;

        for (P5 c : candidates) {
            if (isEligible(c.cgpa) ||
                isEligible(c.cgpa, c.codingScore)) {
                count++;
            }
        }

        P5[] shortlisted = new P5[count];

        int j = 0;

        for (P5 c : candidates) {
            if (isEligible(c.cgpa) ||
                isEligible(c.cgpa, c.codingScore)) {

                shortlisted[j] = c;
                j++;
            }
        }

        Arrays.sort(shortlisted);

        String result = "";

        for (int i = 0; i < shortlisted.length; i++) {

            double score = shortlisted[i].cgpa * 10
                         + shortlisted[i].codingScore * 0.5;

            result += (i + 1) + ". "
                   + shortlisted[i].name
                   + " (" + score + ")";

            if (i < shortlisted.length - 1) {
                result += " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        P5[] candidates = {
            new P5("Aisha", 8.2, 40),
            new P5("Rohit", 6.8, 65),
            new P5("Meena", 6.0, 90),
            new P5("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
    }
}

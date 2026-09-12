import java.util.Arrays;

public class Problem5 implements Comparable<Problem5> {

    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Problem5(String name, int matchesPlayed,
                    double battingAverage, boolean injured) {

        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    // Rule 1: Experience only
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    // Rule 2: Experience + fitness
    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    // Sort by batting average, descending
    @Override
    public int compareTo(Problem5 other) {
        return Double.compare(other.battingAverage, this.battingAverage);
    }

    static String draftAndRank(Problem5[] players) {

        int count = 0;

        // Count draftable players
        for (Problem5 p : players) {
            if (isDraftable(p.matchesPlayed) ||
                isDraftable(p.matchesPlayed, p.injured)) {
                count++;
            }
        }

        Problem5[] draftable = new Problem5[count];

        int j = 0;

        // Store draftable players
        for (Problem5 p : players) {
            if (isDraftable(p.matchesPlayed) ||
                isDraftable(p.matchesPlayed, p.injured)) {

                draftable[j] = p;
                j++;
            }
        }

        // Sort using compareTo()
        Arrays.sort(draftable);

        String result = "";

        for (int i = 0; i < draftable.length; i++) {

            result += (i + 1) + ". " + draftable[i].name;

            if (i < draftable.length - 1)
                result += " | ";
        }

        return result;
    }

    public static void main(String[] args) {

        Problem5[] players = {
            new Problem5("Virat", 15, 48.0, false),
            new Problem5("Rahul", 7, 55.0, false),
            new Problem5("Sameer", 3, 60.0, false),
            new Problem5("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}

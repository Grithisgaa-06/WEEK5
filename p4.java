

public class p4 {

    private static double rowAverage(int[] row) {

        int sum = 0;

        for (int x : row) {
            sum += x;
        }

        return (double) sum / row.length;
    }

    static String classifyRows(int[][] seatingScores, int threshold) {

        String result = "";

        for (int i = 0; i < seatingScores.length; i++) {

            double avg = rowAverage(seatingScores[i]);

            if (avg < threshold) {
                result += "Row " + i + ": Quiet Zone";
            }
            else {
                result += "Row " + i + ": Buzzing Zone";
            }

            if (i < seatingScores.length - 1) {
                result += " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] scores = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };

        System.out.println(classifyRows(scores, 60));
    }
}

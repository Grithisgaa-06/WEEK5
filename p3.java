import java.util.Arrays;

public class p3{

    static int[] findTopThreeScores(int[] scores) {

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int x : scores) {

            if (x >= first) {
                third = second;
                second = first;
                first = x;
            }
            else if (x >= second) {
                third = second;
                second = x;
            }
            else if (x >= third) {
                third = x;
            }
        }

        return new int[]{first, second, third};
    }

    public static void main(String[] args) {

        int[] scores = {45, 82, 79, 90, 33, 90, 61};

        int[] result = findTopThreeScores(scores);

        System.out.println(Arrays.toString(result));
    }
}

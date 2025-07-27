package BKJ_1546;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer tokenize(String input) {
        return new StringTokenizer(input);
    }

    public static void main(String[] args) throws IOException {
        int subjectNum = Integer.parseInt(br.readLine());
        double newAverage = getNewAverage(subjectNum);

        System.out.println(newAverage);
    }

    public static double getNewAverage(int subjectNum) throws IOException {
        StringTokenizer token = tokenize(br.readLine());
        double score, maxScore = -1, totalScore = 0;

        while (token.hasMoreTokens()) {
            score = Integer.parseInt(token.nextToken());
            totalScore += score;
            if (score > maxScore) maxScore = score;
        }

        return (totalScore * 100) / (maxScore * subjectNum);
    }

}

public class Average {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/BKJ_1546/input.txt"));
        Main.main(args);
    }
}

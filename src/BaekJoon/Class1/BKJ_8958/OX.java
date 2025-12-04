package BaekJoon.Class1.BKJ_8958;

import java.io.*;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++){
            char[] score = br.readLine().toCharArray();
            int totalScore = 0, tempScore = 0;
            for (char ox : score) {
                if (ox == 'O') {
                    totalScore += ++tempScore;
                } else {
                    tempScore = 0;
                }
            }
            sb.append(totalScore).append("\n");
        }

        System.out.print(sb);
    }
}

public class OX {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/BaekJoon.Class1.BKJ_8958/input.txt"));
        Main.main(args);
    }
}

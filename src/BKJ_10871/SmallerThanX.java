package BKJ_10871;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int X = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < N; i++) {
            int number = Integer.parseInt(token.nextToken());
            if (number < X) sb.append(number).append(" ");
        }

        System.out.print(sb);
    }
}

public class SmallerThanX {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/BKJ_10871/input.txt"));
        Main.main(args);
    }
}

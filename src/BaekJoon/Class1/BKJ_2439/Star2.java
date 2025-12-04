package BaekJoon.Class1.BKJ_2439;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N ;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        printStars();
    }

    static void printStars() {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N - i; j++) sb.append(" ");
            for (int j = 1; j <= i; j++) sb.append("*");
            sb.append("\n");
        }

        System.out.print(sb);
    }
}

public class Star2 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BaekJoon.Class1.BKJ_2439/input.txt"));
        Main.main(args);
    }
}

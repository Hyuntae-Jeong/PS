package BKJ_10250;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(token.nextToken());
            int W = Integer.parseInt(token.nextToken());
            int N = Integer.parseInt(token.nextToken());

            // 층
            if (N % H == 0) sb.append(H);
            else sb.append(N % H);
            // 호수
            if (((N - 1) / H) + 1 < 10) sb.append(0).append(((N - 1) / H) + 1);
            else sb.append(((N - 1) / H) + 1);

            sb.append("\n");
        }

        System.out.print(sb);
    }
}

public class ACMHotel {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BKJ_10250/input.txt"));
        Main.main(args);
    }
}

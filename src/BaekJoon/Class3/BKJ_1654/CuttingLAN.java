package BaekJoon.Class3.BKJ_1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int K, N;

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        K = Integer.parseInt(token.nextToken());
        N = Integer.parseInt(token.nextToken());

        long sum = getInputAndSum();
//        System.out.println("sum = " + sum);

        int startLength = findStartPoint(sum);
//        System.out.println("startLength = " + startLength);

        int answer = findMaxLAN(startLength);

        System.out.print(answer);
    }

    static int[] lanCables;
    static long getInputAndSum() throws IOException {
        lanCables = new int[K];
        long sum = 0;

        for (int i = 0; i < K; i++) {
            lanCables[i] = Integer.parseInt(br.readLine());
            sum += lanCables[i];
        }

        return sum;
    }

    static int findStartPoint(long sum) {
        return (int) (sum / N);
    }

    static int findMaxLAN(int length) {
        while (length > 0) {
            if (getAvailableLANcount(length) >= N) {
                return length;
            }
            length--;
        }

        return length;
    }

    static int getAvailableLANcount(int length) {
        int count = 0;
        for (int i = 0; i < K; i++) {
            count += lanCables[i] / length;
        }
        return count;
    }
}

public class CuttingLAN {
    public static void main(String[] args) throws IOException {
        System.setIn(Files.newInputStream(Paths.get("src/BaekJoon/Class3/BKJ_1654/input.txt")));
        Main.main(args);
    }
}

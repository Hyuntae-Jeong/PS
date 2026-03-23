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

        System.out.print(findMaxLAN(getInputAndMax()));
    }

    static long[] lanCables;
    static long getInputAndMax() throws IOException {
        lanCables = new long[K];
        long max = 0;

        for (int i = 0; i < K; i++) {
            lanCables[i] = Long.parseLong(br.readLine());
            max = Math.max(max, lanCables[i]);
        }

        return max;
    }

    static long findMaxLAN(long startMaxLength) {
        long L = 1, R = startMaxLength;

        while (L < R) {
            // 주의: R이 2^31 -1 이라면, L + R은 int 범위를 넘어가게 된다..
            long lanCount = getAvailableLANcount((L + R) / 2);
            if (lanCount < N) {
                R = (L + R) / 2 - 1;
            } else {
                L = (L + R) / 2;
                if (L + 1 == R) {
                    if (getAvailableLANcount(R) >= N) return R;
                    else return L;
                }
            }
        }

        return L;
    }

    static long getAvailableLANcount(long length) {
        long count = 0;
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

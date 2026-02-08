package BaekJoon.Class5.BKJ_1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static long target;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        target = Long.parseLong(token.nextToken());
        numbers = new int[N];

        getInput();
        searchWithTwoPointer();
    }

    static void getInput() throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(token.nextToken());
        }
    }

    static void searchWithTwoPointer() {
        int s = 0, e = 0;
        double sum = numbers[0];
        int minLength = Integer.MAX_VALUE;

        // phase 1: end pointer not reached end
        while (e < N - 1) {
            if (sum < target) {
                sum += numbers[++e];
            } else {
                minLength = Math.min(minLength, e - s + 1);
                // 한개의 숫자가 target보다 크거나 같아서 s가 e보다 커지는 경우 예방
                sum = s == e ? sum + numbers[++e] : sum - numbers[s++];
            }
        }

        // phase 2: end pointer reached end
        while (s < N && sum >= target) {
            minLength = Math.min(minLength, e - s + 1);
            sum -= numbers[s++];
        }

        minLength = minLength == Integer.MAX_VALUE ? 0 : minLength;
        System.out.print(minLength);
    }
}

public class PartialSum {
    public static void main(String[] args) throws IOException {
        System.setIn(Files.newInputStream(Paths.get("src/BaekJoon/Class5/BKJ_1806/input.txt")));
        Main.main(args);
    }
}

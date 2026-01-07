package BaekJoon.Class2.BKJ_2108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        int totalSum = 0;                       // 1. 산술평균
        int[] occurrence = new int[8001];       // 3. 최빈값
        int min = Integer.MAX_VALUE, max = -Integer.MAX_VALUE;   // 4. 범위 (최댓값 최솟값 차이)
        int[] allValue = new int[N];

        for (int i = 0; i < N; i++){
            int value = Integer.parseInt(br.readLine());

            totalSum += value;
            occurrence[value + 4000]++;
            min = Math.min(min, value);
            max = Math.max(max, value);
            allValue[i] = value;
        }

        // 2. 중앙값
        Arrays.sort(allValue);

        StringBuilder sb = new StringBuilder();
        int avg = Math.round(totalSum / (float) N);
        // 1. 산술평균
        sb.append(avg).append("\n");
        // 2. 중앙값
        sb.append(allValue[(N / 2)]).append("\n");
        // 3. 최빈값
        int maxCnt = 0;
        int freqValue = 0, secondFreqValue = Integer.MAX_VALUE;
        for (int i = 0; i <= 8000; i++) {
            if (maxCnt < occurrence[i]) {
                maxCnt = occurrence[i];
                freqValue =  i - 4000;
                secondFreqValue = Integer.MAX_VALUE;
            } else if (maxCnt == occurrence[i] && secondFreqValue == Integer.MAX_VALUE) {
                secondFreqValue = i - 4000;
            }
        }
        if (secondFreqValue == Integer.MAX_VALUE) sb.append(freqValue).append("\n");
        else sb.append(secondFreqValue).append("\n");
        // 4. 범위
        sb.append(max - min);

        System.out.print(sb);
    }
}

public class Statistics {
    public static void main(String[] args) throws IOException {
        System.setIn(Files.newInputStream(Paths.get("src/BaekJoon/Class2/BKJ_2108/input.txt")));
        Main.main(args);
    }
}

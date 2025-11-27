package BKJ_11053;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Info {
    int value;
    int count;

    Info(int value, int count) {
        this.value = value;
        this.count = count;
    }
}

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Info[] lengthInfos;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        lengthInfos = new Info[N];

        int num, totalMaxCount = 0;
        StringTokenizer token = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(token.nextToken());
            int maxCount = 0;
            for (int j = i - 1; j >= 0; j--) {
                // 앞에 있는 값들 중 자기보다 작은 값들의 count 중 최대값을 찾는다
                if (lengthInfos[j].value < num) {
                    maxCount = Math.max(maxCount, lengthInfos[j].count);
                }
            }
            // 앞에 있는 값들 중 maxCount를 가진 조합에 자신의 값을 이어 붙인다
            lengthInfos[i] = new Info(num, maxCount + 1);
            totalMaxCount = Math.max(totalMaxCount, maxCount + 1);
        }

        System.out.println(totalMaxCount);
    }
}

public class LongestIncreasingSubsequence {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BKJ_11053/input.txt"));
        Main.main(args);
    }
}

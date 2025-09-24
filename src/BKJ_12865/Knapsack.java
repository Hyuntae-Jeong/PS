package BKJ_12865;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, limit;
    static int weight[];
    static int value[];
    static int bestChoice[][];

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        limit = Integer.parseInt(token.nextToken());

        getInput();
//        int maxValue = putOrNot(N, limit);
        int maxValue = stepByStep();
        System.out.println(maxValue);
    }

    static int stepByStep() {
        // Bottom-up (작은 부분 문제 부터 차례대로 채워가는 방식)
        bestChoice = new int[N + 1][limit + 1];

        // 각 항목별로 넣었을 때와 안 넣었을 때 비교하면서 채워나감
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < weight[i] && j <= limit; j++) {
                bestChoice[i][j] = bestChoice[i - 1][j];
            }
            for (int j = weight[i]; j <= limit; j++) {
                bestChoice[i][j] = Math.max(bestChoice[i - 1][j - weight[i]] + value[i], bestChoice[i - 1][j]);
            }
        }

        return bestChoice[N][limit];
    }

    static int putOrNot(int index, int leftWeight) {
        // Top-down (큰 문제를 작은 문제로 쪼개서 재귀적으로 탐색)
        if (index == 0) return 0;

        if (leftWeight - weight[index] < 0) return putOrNot(index - 1, leftWeight);
        return Math.max(putOrNot(index - 1, leftWeight), putOrNot(index - 1, leftWeight - weight[index]) + value[index]);
    }

    static void getInput() throws IOException {
        value = new int[N + 1];
        weight = new int[N + 1];

        StringTokenizer token;
        for (int i = 1; i <= N; i++) {
            token = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(token.nextToken());
            value[i] = Integer.parseInt(token.nextToken());
        }
    }
}

public class Knapsack {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BKJ_12865/input.txt"));
        Main.main(args);
    }
}

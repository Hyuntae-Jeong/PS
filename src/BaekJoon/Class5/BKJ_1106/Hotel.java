package BaekJoon.Class5.BKJ_1106;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int C, N;
    static int[] costs, customers;

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        C = Integer.parseInt(token.nextToken());
        N = Integer.parseInt(token.nextToken());

        getInputs();
        findCheapestCostForOverC();
    }

    static void getInputs() throws IOException {
        costs = new int[N];
        customers = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            costs[i] = Integer.parseInt(token.nextToken());
            customers[i] = Integer.parseInt(token.nextToken());
        }
    }

    static void findCheapestCostForOverC() {
        int[] dp = new int[C + 100];
        int minCost = Integer.MAX_VALUE;

        for (int i = 1; i < C + 100; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < N; j++) {
                // dp[x]가 Integer.MAX_VALUE인 경우는 만들 수 없는 인원수 조합인 경우
                if (i - customers[j] < 0 || dp[i - customers[j]] == Integer.MAX_VALUE) continue;
                dp[i] = Math.min(dp[i], dp[i - customers[j]] + costs[j]);
            }
            if (i >= C) minCost = Math.min(minCost, dp[i]);
        }

        System.out.print(minCost);
    }
}

public class Hotel {
    public static void main(String[] args) throws IOException {
        System.setIn(Files.newInputStream(Paths.get("src/BaekJoon/Class5/BKJ_1106/input.txt")));
        Main.main(args);
    }
}

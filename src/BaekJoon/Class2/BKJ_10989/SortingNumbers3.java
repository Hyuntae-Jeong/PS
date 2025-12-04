package BaekJoon.Class2.BKJ_10989;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(10_001);;
    static int[] pqCount = new int[10_001];

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        getInput();
        sortNumbers();
    }

    private static void getInput() throws IOException {
        int x;
        for (int i = 0; i < N; i++) {
            x = Integer.parseInt(br.readLine());
            if (pqCount[x] == 0) {
                pq.add(x);
                pqCount[x]++;
            } else {
                pqCount[x]++;
            }
        }
    }

    private static void sortNumbers() {
        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            int x = pq.poll();
            for (int i = 0; i < pqCount[x]; i++) {
                sb.append(x).append("\n");
            }
        }

        System.out.print(sb);
    }
}

public class SortingNumbers3 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BaekJoon.Class2.BKJ_10989/input.txt"));
        Main.main(args);
    }
}

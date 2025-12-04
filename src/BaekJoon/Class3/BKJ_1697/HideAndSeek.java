package BaekJoon.Class3.BKJ_1697;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Main {
    static int N, K, pos;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] visited = new int[100_001];
    static ArrayDeque<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        try {
            goFindSister();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void goFindSister() throws RuntimeException {
        if (N >= K) {
            throw new RuntimeException(String.valueOf(N - K));
        }

        queue.add(N);
        visited[N] = 1;

        while (!queue.isEmpty()) {
            pos = queue.poll();

            move(pos, pos - 1);

            if (pos >= K) continue; // 수빈이가 이미 동생을 지나쳤다면 더 멀리 갈 필요는 없다

            move(pos, pos + 1);
            move(pos, pos * 2);
        }
    }

    static void move(int pos, int nextPos) {
        if (nextPos < 0 || nextPos > 100_000) return;

        if (visited[nextPos] == 0){
            if(nextPos == K) {
                throw new RuntimeException(String.valueOf(visited[pos]));
            }
            visited[nextPos] = visited[pos] + 1;
            queue.add(nextPos);
        }
    }
}


public class HideAndSeek {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BaekJoon.Class3.BKJ_1697/input.txt"));
        Main.main(args);
    }
}

package BaekJoon.Class3.BKJ_14940;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;
    int step;

    Point(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }
}

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[][] map, answerMap;
    static Deque<Point> deque = new ArrayDeque<>();
    static int[] moveX = {-1, 0, 1, 0};
    static int[] moveY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        answerMap = new int[N][M];

        getInput();
//        printInput();

        startFindingShortestPath();
        checkUnreachable();
        printAnswer();
    }

    private static void printInput() throws IOException {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.printf("%d ", map[i][j]);
            }
            System.out.println();
        }
    }

    private static void printAnswer() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(answerMap[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void getInput() throws IOException {
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    deque.push(new Point(i, j, 0));
                }
            }
        }
    }

    static void startFindingShortestPath() {
        while (!deque.isEmpty()) {
            Point point = deque.pop();
            addAnswer(point);
        }
    }

    static void addAnswer(Point p) {
        for (int i = 0; i < 4; i++) {
            int newX = p.x + moveX[i];
            int newY = p.y + moveY[i];

            if (newX < 0 || newX >= N) continue;
            if (newY < 0 || newY >= M) continue;

            if (map[newX][newY] == 1) {
                deque.add(new Point(newX, newY, p.step + 1));
                map[newX][newY] = 0;
                answerMap[newX][newY] = p.step + 1;
            }
        }
    }

    static void checkUnreachable() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    answerMap[i][j] = -1;
                }
            }
        }
    }
}

public class EasyShortestPath {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BaekJoon.Class3.BKJ_14940/input.txt"));
        Main.main(args);
    }
}

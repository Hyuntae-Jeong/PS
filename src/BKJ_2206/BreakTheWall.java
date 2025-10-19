package BKJ_2206;


import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


class Point {
    int x, y, step;
    Point (int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }
}

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[][] arr;
    static Deque<Point> queue;
    static Deque<Point> wallQueue;
    static boolean debug = true;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};


    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arr = new int[N + 1][M + 1];

        getInput();
        boolean withoutBreaking = findPathWithoutBreaking();

        if(debug) printThings();
        if (withoutBreaking) {
            // 벽 하나씩 뿌셔보기
//            breakWallsOneByOne();
        } else {
            // 막힌 지점에서 벽 뚫기 시도하기
                // 일단 해당 지점에서 빠져나갈 구멍이 있는지 검사하기
                    // 빠져나갈 구멍 없으면 -1 리턴
                    // 빠져나갈 구멍 있으면 도착지점에서부터 역으로 최단거리 구해서 올라오고, 벽 뚫으면 그 값들과 만나는지 확인하기
        }
        
    }

    static void breakWallsOneByOne() {
        while (!wallQueue.isEmpty()) {
            Point p = wallQueue.poll();

            int minStep = N * M, maxStep = 0, step;
            for (int i = 0; i < 4; i++) {
                step = getStep(p.x + dx[i], p.y + dy[i]);
                if (step == -1) continue;

                minStep = Math.min(minStep, step);
                maxStep = Math.min(maxStep, step);
            }

            // min
        }

    }

    static int getStep(int x, int y) {
        if (x <= 0 || x > N) return -1;
        if (y <= 0 || y > M) return -1;

        return arr[x][y];
    }


    static void printThings() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                System.out.printf("%d\t", arr[i][j]);
            }
            System.out.println();
       }

    }

    static void getInput() throws IOException {
        StringTokenizer token;
        wallQueue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                if (Integer.parseInt(token.nextToken()) == 1) {
                    arr[i][j] = -1;
                    wallQueue.add(new Point(i, j, 0));
                }
            }
        }
    }

    static boolean findPathWithoutBreaking() {
        queue = new ArrayDeque<>();
        queue.add(new Point(1, 1, 1));
        arr[1][1] = 1;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            nextStep(p);
        }
        
        // 마지막 위치가 (N, M)이 아니면 벽에 막힌 것
        return arr[N][M] != 0;
    }

    static void nextStep (Point p) {
        for (int i = 0; i < 4; i++) {
            if (inRangeAndCanGo(p.x + dx[i], p.y + dy[i])) {
                queue.add(new Point(p.x + dx[i], p.y + dy[i], p.step + 1));
                arr[p.x + dx[i]][p.y + dy[i]] = p.step + 1;
            }
        }
    }

    static boolean inRangeAndCanGo(int x, int y) {
        if (x <= 0 || x > N) return false;
        if (y <= 0 || y > M) return false;
        if (arr[x][y] != 0) return false;

        return true;
    }
}

public class BreakTheWall {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/BKJ_2206/input.txt"));
        Main.main(args);
    }
}

package BaekJoon.Class4.BKJ_2206;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Point {
    int x, y, step, minPrevStep;

    Point (int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }
}

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[][] arr, revArr;
    static Deque<Point> queue, wallQueue;
    static boolean debug = false;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arr = new int[N + 1][M + 1];        // path
        revArr = new int[N + 1][M + 1];     // reverse path

        getInput();
        findPath(arr, 1, 1, N, M);
        findPath(revArr, N, M, 1, 1);

        if(debug) {
            printThings(arr);
            printThings(revArr);
        }

        if (arr[N][M] != 0) {
            /**
             * @case: 벽 부수기 없이 최단거리 찾은 경우
             * @target: 최단거리 더 짧아지는 경우 (벽 1개만 부수기)
             */
            System.out.print(goThroughWall(arr[N][M]));
        } else {
            /**
             * @case: 벽에 막혀서 도착지점 도달하지 못한 경우
             * @target: 도착지점에 최단거리로 도착할 수 있는 벽 찾기
             * @condition: 뚫리는 벽의 조건은 4면 중 arr 양수값과 revArr 양수값 모두 존재 (시작점과 끝점에서의 최단거리가 만나는 점)
             */
            int shortestPathAfterBlocked  = goThroughWall(N * M);

            if (shortestPathAfterBlocked == N * M) shortestPathAfterBlocked = -1;   // 벽 안 뚫리는 경우
            System.out.print(shortestPathAfterBlocked);
        }
    }

    static void getInput() throws IOException {
        wallQueue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            String inputLine = br.readLine();
            for (int j = 1; j <= M; j++) {
                if (inputLine.charAt(j - 1) == '1') {
                    arr[i][j] = -1;
                    revArr[i][j] = -1;
                    wallQueue.add(new Point(i, j, 0));
                }
            }
        }
    }

    static void findPath(int[][] targetArr, int startX, int startY, int endX, int endY) {
        queue = new ArrayDeque<>();
        queue.add(new Point(startX, startY, 1));
        targetArr[startX][startY] = 1;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p.x == endX && p.y == endY) break;
            moveNextStep(p, targetArr);
        }
    }

    static void moveNextStep(Point p, int[][] targetArr) {
        for (int i = 0; i < 4; i++) {
            if (getStep(p.x + dx[i], p.y + dy[i], targetArr) == 0) {
                queue.add(new Point(p.x + dx[i], p.y + dy[i], p.step + 1));
                targetArr[p.x + dx[i]][p.y + dy[i]] = p.step + 1;
            }
        }
    }

    static int goThroughWall(int shortestPath) {
        while (!wallQueue.isEmpty()) {
            Point p = wallQueue.poll();
            int minStep = N * M, minRevStep = N * M, step, revStep;

            for (int i = 0; i < 4; i++) {
                step = getStep(p.x + dx[i], p.y + dy[i], arr);
                revStep = getStep(p.x + dx[i], p.y + dy[i], revArr);

                if (step > 0) minStep = Math.min(minStep, step);
                if (revStep > 0) minRevStep = Math.min(minRevStep, revStep);
            }

            if (minStep != (N * M) && minRevStep != (N * M)) {
                if (debug) System.out.printf("going through wall (%d, %d) = min: %d, minRev: %d, step through wall: %d\n", p.x, p.y, minStep, minRevStep, minStep + 1 + minRevStep);
                shortestPath = Math.min(shortestPath, minStep + 1 + minRevStep);
            }
        }

        return shortestPath;
    }

    static int getStep(int x, int y, int[][] targetArr) {
        if (x <= 0 || x > N) return -1;
        if (y <= 0 || y > M) return -1;

        return targetArr[x][y];
    }

    static void printThings(int[][] targetArr) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                System.out.printf("%d\t", targetArr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}

public class BreakTheWall {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/BaekJoon.Class4.BKJ_2206/input.txt"));
        Main.main(args);
    }
}

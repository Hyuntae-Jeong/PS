package BKJ_1865;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Path {
    int s, e, t;

    Path(int s, int e, int t) {
        this.s = s;
        this.e = e;
        this.t = t;
    }
}

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int TESTCASE;
    static int nodes, roads, wormholes;
    static ArrayList<Path> paths;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        TESTCASE = Integer.parseInt(br.readLine());
        for (int t = 0; t < TESTCASE; t++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            nodes = Integer.parseInt(token.nextToken());
            roads = Integer.parseInt(token.nextToken());
            wormholes = Integer.parseInt(token.nextToken());

            paths = new ArrayList<>();
            
            /**
             * dist를 0으로 초기화하는 이유
             * 슈퍼 소스를 시작점으로 두면 첫번째 벨만포드 탐색 시 모든 정점의 dist가 0이 되기 때문
             *
             * 슈퍼 소스란?
             * 모든 정점에 거리 0으로 연결된 새로운 정점
             *
             * 슈퍼 소스를 사용하는 이유?
             * 클러스터가 분리된 경우에도 음의 사이클 탐지를 위해
             */
            dist = new int[nodes + 1];
            getInput();

            if(bellmanFord()) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.print(sb);
    }

    static void getInput() throws IOException {
        int cnt = 0;
        for (int i = 0; i < roads; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int S, E, T;
            S = Integer.parseInt(token.nextToken());
            E = Integer.parseInt(token.nextToken());
            T = Integer.parseInt(token.nextToken());

            paths.add(new Path(S, E, T));
            paths.add(new Path(E, S, T));
        }

        for (int i = 0; i < wormholes; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int S, E, T;
            S = Integer.parseInt(token.nextToken());
            E = Integer.parseInt(token.nextToken());
            T = Integer.parseInt(token.nextToken());

            paths.add(new Path(S, E, T * -1));
        }
    }

    static boolean checkDist(boolean flag) {
        for (Path path : paths) {
            if (dist[path.e] > dist[path.s] + path.t) {
                if (flag) return true;
                dist[path.e] = dist[path.s] + path.t;
            }
        }
        return false;
    }

    static boolean bellmanFord() {
        /**
         * step을 nodes가 아닌 nodes - 1 까지 반복하는 이유?
         * 슈퍼 소스가 추가된 경우 첫번째 반복에서는 dist가 모두 0으로 바뀜
         * 이 과정을 dist배열을 0으로 초기화 하는것으로 대체함
         */
        for (int step = 0; step < nodes; step++) {
            checkDist(false);
        }
        return checkDist(true);
    }
}

public class Wormhole {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/BKJ_1865/input.txt"));
        Main.main(args);
    }
}
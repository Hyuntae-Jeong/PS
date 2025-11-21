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
    static boolean debug = false;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        TESTCASE = Integer.parseInt(br.readLine());
        for (int t = 0; t < TESTCASE; t++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            nodes = Integer.parseInt(token.nextToken());
            roads = Integer.parseInt(token.nextToken());
            wormholes = Integer.parseInt(token.nextToken());

            paths = new ArrayList<>();
            dist = new int[nodes + 1];
            getInput();
            if (debug) printInput();

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

    static void printInput() {
        for (Path path : paths) {
            System.out.printf("S:%d E:%d T:%d\n", path.s, path.e, path.t);
        }
    }

    static boolean bellmanFord() {
        for (int step = 0; step <= nodes; step++) {
            if (debug) System.out.printf("step : %d\n", step);
            for (Path path : paths) {
                if (debug) System.out.printf("%d --(%d)--> %d : %d vs %d\n", path.s, path.t, path.e, dist[path.e], dist[path.s] + path.t);
                if (dist[path.e] > dist[path.s] + path.t) {
                    if (debug) System.out.printf("step: %d | dist[%d] %d -> ", step, path.e, dist[path.e]);
                    dist[path.e] = dist[path.s] + path.t;
                    if (debug) System.out.printf("%d\n", dist[path.e]);
                }
            }
        }
        for (Path path : paths) {
            if (dist[path.e] > dist[path.s] + path.t) {
                return true;
            }
        }
        return false;
    }
}

public class Wormhole {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/BKJ_1865/input.txt"));
        Main.main(args);
    }
}
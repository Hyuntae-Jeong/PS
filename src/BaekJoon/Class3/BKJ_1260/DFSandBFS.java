package BaekJoon.Class3.BKJ_1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    PriorityQueue<Integer> forDFS;
    PriorityQueue<Integer> forBFS;

    Node() {
        this.forDFS = new PriorityQueue<>();
        this.forBFS = new PriorityQueue<>();
    }
}

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, start;
    static Node[] nodes;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        start = Integer.parseInt(token.nextToken());

        getNodes();
        startDFS(start);
        sb.append("\n");
        startBFS(start);
        System.out.print(sb);
    }

    static void getNodes() throws IOException {
        visited = new boolean[N + 1];
        nodes = new Node[N + 1];
        for (int i = 1; i <= N; i++) nodes[i] = new Node();

        for (int i = 1; i <= M; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            nodes[a].forDFS.add(b);
            nodes[a].forBFS.add(b);

            nodes[b].forDFS.add(a);
            nodes[b].forBFS.add(a);
        }
    }

    static void startDFS(int nodeNum) {
        visited[nodeNum] = true;
        sb.append(nodeNum).append(" ");

        while (!nodes[nodeNum].forDFS.isEmpty()) {
            int child = nodes[nodeNum].forDFS.poll();
            if (!visited[child]) {
                startDFS(child);
            }
        }
    }

    static void startBFS(int startNode) {
        visited = new boolean[N + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(startNode);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (visited[cur]) continue;
            visited[cur] = true;
            sb.append(cur).append(" ");

            while (!nodes[cur].forBFS.isEmpty()) {
                queue.add(nodes[cur].forBFS.poll());
            }
        }
    }
}

public class DFSandBFS {
    public static void main(String[] args) throws IOException {
        System.setIn(Files.newInputStream(Paths.get("src/BaekJoon/Class3/BKJ_1260/input.txt")));
        Main.main(args);
    }
}

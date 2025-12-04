package BaekJoon.Class4.BKJ_1753;

import java.io.*;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class NodeVisited implements Comparable<NodeVisited> {
    int nodeNum;
    int pathValue;

    NodeVisited(int nodeNum, int pathValue) {
        this.nodeNum = nodeNum;
        this.pathValue = pathValue;
    }

    @Override
    public int compareTo(NodeVisited o) {
        return this.pathValue - o.pathValue;
    }
}

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, headNode;
    /**
     * 자료구조: HashMap 배열
     * Index: 시작점 Node
     * HashMap Key: 도착점 Node
     * HashMap Value: 비용
     */
    static HashMap<Integer, Integer>[] nodeConnection;
    static boolean debug = false;
    static int[] shortestPathFromHead;

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        headNode = Integer.parseInt(br.readLine());
        nodeConnection = new HashMap[N + 1];
        shortestPathFromHead = new int[N + 1];

        getInput();
        if (debug) printInput();

        findPath(headNode);

        if (debug) printShortestPathFromHead();
        printResult();
    }

    static void getInput() throws IOException {
        int u, v, w;
        for (int i = 0; i < M; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            u = Integer.parseInt(token.nextToken());
            v = Integer.parseInt(token.nextToken());
            w = Integer.parseInt(token.nextToken());

            if (nodeConnection[u] == null) nodeConnection[u] = new HashMap<>();
            if (!nodeConnection[u].containsKey(v)) {
                nodeConnection[u].put(v, w);
            } else {
                // 노드 간선이 중복될 경우 가장 짧은 간선을 저장함
                nodeConnection[u].replace(v, Math.min(nodeConnection[u].get(v), w));
            }
        }
    }

    static void printInput() {
        for (int i = 1; i <= N; i++) {
            System.out.printf("start node : %d\n", i);
            if (nodeConnection[i] == null) continue;

            nodeConnection[i].forEach((key, value) -> {
                System.out.printf("key: %d, value: %d\n", key, value);
            });
        }
        System.out.println();
    }

    // 다익스트라 알고리즘
    static void findPath(int startNode) {
        Queue<NodeVisited> visitableNodes = new PriorityQueue<>();
        visitableNodes.add(new NodeVisited(startNode, 0));

        while (!visitableNodes.isEmpty()) {
            NodeVisited currNode = visitableNodes.poll();
            if (shortestPathFromHead[currNode.nodeNum] > 0 && shortestPathFromHead[currNode.nodeNum] < currNode.pathValue) continue;

            if (debug) System.out.printf("Polling Node: %d, Path sum: %d)\n", currNode.nodeNum, currNode.pathValue);

            try {
                nodeConnection[currNode.nodeNum].forEach((targetNode, value) -> {
                    if (targetNode == startNode) return;

                    if (shortestPathFromHead[targetNode] == 0 || shortestPathFromHead[currNode.nodeNum] + value < shortestPathFromHead[targetNode]) {
                        shortestPathFromHead[targetNode] = shortestPathFromHead[currNode.nodeNum] + value;
                        visitableNodes.add(new NodeVisited(targetNode, shortestPathFromHead[targetNode]));
                    }
                });
            } catch (NullPointerException npe) {
                // Path가 없는 node는 건너뛰기
            }
        }
    }

    static void printShortestPathFromHead() {
        System.out.println("Shortest Path From Head Infos...");
        for (int i = 1; i <= N; i++) {
            System.out.printf("node %d: %d\n", i, shortestPathFromHead[i]);
        }
    }

    static void printResult() {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            if (shortestPathFromHead[i] == 0 && i != headNode) {
                sb.append("INF").append("\n");
            } else {
                sb.append(shortestPathFromHead[i]).append("\n");
            }
        }

        System.out.print(sb);
    }
}

public class ShortestPathToAllNodes {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/BaekJoon.Class4.BKJ_1753/input.txt"));
        Main.main(args);
    }
}

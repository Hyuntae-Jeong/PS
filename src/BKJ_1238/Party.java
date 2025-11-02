package BKJ_1238;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
    static int N, M, partyNode;
    static int[] shortestPathFromPartyNode, shortestPathToPartyNode;

    static HashMap<Integer, Integer>[] path;

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        partyNode = Integer.parseInt(token.nextToken());
        path = new HashMap[N + 1];
        shortestPathFromPartyNode = new int[N + 1];
        shortestPathToPartyNode = new int[N + 1];

        getInput();
        findShortestPathFromPartyNode();

        for (int i = 1; i <= N; i++) {
            if (i == partyNode) continue;
            shortestPathToPartyNode[i] = findShortestPathFromOtherNodes(i);
        }

        findLongestStudent();
    }

    static void getInput() throws IOException {
        int from, to, time;
        for (int i = 0; i < M; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            from = Integer.parseInt(token.nextToken());
            to = Integer.parseInt(token.nextToken());
            time = Integer.parseInt(token.nextToken());

            if (path[from] == null) path[from] = new HashMap<>();
            path[from].putIfAbsent(to, time);
        }
    }

    static void findShortestPathFromPartyNode() {
        Queue<NodeVisited> visitableNodes = new PriorityQueue<>();
        visitableNodes.add(new NodeVisited(partyNode, 0));

        while (!visitableNodes.isEmpty()) {
            NodeVisited currNode = visitableNodes.poll();
            if (shortestPathFromPartyNode[currNode.nodeNum] > 0 && shortestPathFromPartyNode[currNode.nodeNum] < currNode.pathValue) continue;

            try {
                path[currNode.nodeNum].forEach((targetNode, value) -> {
                    if (targetNode == partyNode) return;

                    if (shortestPathFromPartyNode[targetNode] == 0 || shortestPathFromPartyNode[currNode.nodeNum] + value < shortestPathFromPartyNode[targetNode]) {
                        shortestPathFromPartyNode[targetNode] = shortestPathFromPartyNode[currNode.nodeNum] + value;
                        visitableNodes.add(new NodeVisited(targetNode, shortestPathFromPartyNode[targetNode]));
                    }
                });
            } catch (NullPointerException npe) {
                // Path가 없는 node는 건너뛰기
            }
        }
    }

    static int findShortestPathFromOtherNodes(int startNode) {
        Queue<NodeVisited> visitableNodes = new PriorityQueue<>();
        visitableNodes.add(new NodeVisited(startNode, 0));
        int[] path = new int[N + 1];

        while (!visitableNodes.isEmpty()) {
            NodeVisited currNode = visitableNodes.poll();

            if (currNode.nodeNum == partyNode) return currNode.pathValue;
            if (path[currNode.nodeNum] > 0 && path[currNode.nodeNum] < currNode.pathValue) continue;

            try {
                Main.path[currNode.nodeNum].forEach((targetNode, value) -> {
                    if (targetNode == startNode) return;

                    if (path[targetNode] == 0 || path[currNode.nodeNum] + value < path[targetNode]) {
                        path[targetNode] = path[currNode.nodeNum] + value;
                        visitableNodes.add(new NodeVisited(targetNode, path[targetNode]));
                    }
                });
            } catch (NullPointerException npe) {
                // Path가 없는 node는 건너뛰기
            }
        }

        return 100_001;
    }

    static void findLongestStudent() {
        int max = 0;

        for (int i = 1; i <= N; i++) {
            if (i == partyNode) continue;
            max = Math.max(max, shortestPathToPartyNode[i] + shortestPathFromPartyNode[i]);
        }

        System.out.print(max);
    }
}

public class Party {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/BKJ_1238/input.txt"));
        Main.main(args);
    }
}


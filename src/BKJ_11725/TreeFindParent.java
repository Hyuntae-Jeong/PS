package BKJ_11725;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

class Node {
    int value;
    ArrayList<Node> connected;

    Node (int value){
        this.value = value;
        connected = new ArrayList<>();
    }
}

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static Node[] nodes;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        nodes = new Node[N + 1];

        getInput();
        startProcess();
    }

    static void getInput() throws IOException {
        StringTokenizer token;
        int a, b;

        for (int i = 1 ; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            a = Integer.parseInt(token.nextToken());
            b = Integer.parseInt(token.nextToken());

            if (nodes[a] == null) nodes[a] = new Node(a);
            if (nodes[b] == null) nodes[b] = new Node(b);

            nodes[a].connected.add(nodes[b]);
            nodes[b].connected.add(nodes[a]);
        }
    }

    static int[] parents;
    static void startProcess() {
        parents = new int[N + 1];

        Deque<Node> queue = new ArrayDeque<>();
        queue.add(nodes[1]);
        parents[1] = -1;

        while (!queue.isEmpty()) {
            Node currNode = queue.pop();
            for (Node next : currNode.connected) {
                if (parents[next.value] != 0) continue;

                parents[next.value] = currNode.value;
                queue.push(next);
            }
        }

        // print result
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parents[i]).append("\n");
        }

        System.out.print(sb);
    }
}

public class TreeFindParent {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BKJ_11725/input.txt"));
        Main.main(args);
    }
}

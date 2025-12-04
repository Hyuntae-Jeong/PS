package BaekJoon.Class2.BKJ_11866;

import java.io.*;
import java.util.StringTokenizer;

class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K;
    static Node currentNode, headNode;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        initializeNode();
//        printNode();

        if (K == 1) startOneStepJosephus();     // step이 1인 경우 별 다른 알고리즘 필요 x
        else startJosephus();
    }

    private static void startOneStepJosephus() {
        sb.append("<");

        for (int i = 1; i <= N; i++) {
            addToResult(i);
        }

        System.out.println(sb.append(">"));
    }

    private static void startJosephus() {
        sb.append("<");

        Node node = headNode;
        int count = 0;

        while (node.next != node) {
            count++;

            if (count == K - 1) {
                // step 1. print victim node's value
                addToResult(node.next.value);

                // step 2. disconnect victim node
                node.next = node.next.next;

                // step 3. reset count
                count = 0;
            }

            node = node.next;
        }

        addToResult(node.value);
        System.out.println(sb.append(">"));
    }

    private static void addToResult(int value) {
        if (sb.length() > 1) sb.append(", ");
        sb.append(value);
    }

    private static void printNode() {
        Node start = headNode;
        int repeatCount = 0;

        while (true) {
            repeatCount++;
            System.out.print(start.value + " -> ");
            start = start.next;

            if (repeatCount == N * 3) break;
        }
    }

    private static void initializeNode() {
        currentNode = new Node(1);
        headNode = currentNode;

        for (int i = 2; i <= N; i++) {
            currentNode.next = new Node(i);
            currentNode = currentNode.next;
        }

        currentNode.next = headNode;
    }
}


public class Josephus0 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BaekJoon.Class2.BKJ_11866/input.txt"));
        Main.main(args);
    }

}

package BaekJoon.Class2.BKJ_11650;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
    static int N, SIZE = 200001, HALFSIZE = 100000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Node xHeads[] = new Node[SIZE];    // original value + 100000 = index

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        startProcess();
        printNodes();
    }

    public static void startProcess() throws IOException {
        StringTokenizer token;
        int x, y;

        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            x = Integer.parseInt(token.nextToken());
            y = Integer.parseInt(token.nextToken());

            insertNode(x + HALFSIZE, y);
        }
    }

    public static void insertNode(int x, int y) {
        if (xHeads[x] == null) {
            xHeads[x] = new Node(y);
            return;
        }

        Node currNode = xHeads[x];
        Node newNode = new Node(y);

        // case 1: head보다 작은 경우
        if (y < xHeads[x].value){
            newNode.next = xHeads[x];
            xHeads[x] = newNode;
            return;
        }

        // case 2: head보단 큰 경우
        while(currNode.next != null) {
            if (y < currNode.next.value) break;
            currNode = currNode.next;
        }
        newNode.next = currNode.next;
        currNode.next = newNode;
    }

    public static void printNodes() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < SIZE; i++) {
            Node currNode = xHeads[i];
            if (currNode == null) continue;

            while(currNode != null) {
                sb.append(i - HALFSIZE).append(" ").append(currNode.value).append("\n");
                currNode = currNode.next;
            }
        }

        System.out.println(sb);
    }
}


public class CoordinateSorting {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BaekJoon.Class2.BKJ_11650/input.txt"));
        Main.main(args);
    }
}

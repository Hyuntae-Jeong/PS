package BKJ_2164;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
        this.next = null;
    }
}
class Main {
    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Node curr, head;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        initialize();
        startProgress();
    }

    public static void initialize() {
        head = curr = new Node(1);
        for (int i = 2; i <= N; i++) {
            curr.next = new Node(i);
            curr = curr.next;
        }
        curr.next = head;   // tail -> head 연결 (circular linked list)
    }

    public static void startProgress() {
        // tail에서 부터 노드를 하나씩 건너뜀
        while (curr != curr.next) {
            curr.next = curr.next.next;
            curr = curr.next;
        }
        
        // curr.next 가 자신을 가르키면 카드가 하나 남았다는 것
        System.out.println(curr.value);
    }
}



public class Card2 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BKJ_2164/input.txt"));
        Main.main(args);
    }
}

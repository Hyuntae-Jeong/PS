package BaekJoon.Class2.BKJ_10845;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer token;
    static int N;
    static Deque<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());

        startProcess();
    }

    static String command;
    static Integer value;
    static StringBuilder sb = new StringBuilder();

    public static void startProcess() throws IOException {
        while (N > 0) {
            token = new StringTokenizer(br.readLine());
            command = token.nextToken();
            switch (command) {
                case "push":
                    value = (Integer) Integer.parseInt(token.nextToken());
                    queue.offer(value);
                    break;
                case "pop":
                    value = queue.poll();
                    sb.append(value == null ? -1 : value).append("\n");
                    break;
                case "front":
                    value = queue.peekFirst();
                    sb.append(value == null ? -1 : value).append("\n");
                    break;
                case "back":
                    value = queue.peekLast();
                    sb.append(value == null ? -1 : value).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append("\n");
            }
            N--;
        }
        System.out.println(sb);
    }
}

/**
 * push X: 정수 X를 큐에 넣는 연산이다.
 * pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 큐에 들어있는 정수의 개수를 출력한다.
 * empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
 * front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */

public class Queue {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/BaekJoon.Class2.BKJ_10845/input.txt"));
        Main.main(args);
    }
}
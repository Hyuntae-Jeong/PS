package BaekJoon.Class2.BKJ_10828;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer token;
    static int N;

    public static void main(String[] args) throws IOException {
        token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());

        startProcess();
    }

    static Stack<Integer> stack = new Stack<>();
    static String command;

    public static void startProcess() throws IOException {
        StringBuilder sb = new StringBuilder();

        while (N > 0){
            token = new StringTokenizer(br.readLine());
            command = token.nextToken();

            switch (command) {
                case "push":
                    stack.push(Integer.valueOf(Integer.parseInt(token.nextToken())));
                    break;
                case "pop":
                    sb.append(stack.empty() ? -1 : stack.pop()).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    sb.append(stack.empty() ? 1 : 0).append("\n");
                    break;
                case "top":
                    sb.append(stack.empty() ? -1 : stack.peek()).append("\n");
                    break;
            }

            N--;
        }
        System.out.println(sb);
    }
}

/**
 * push X: 정수 X를 스택에 넣는 연산이다.
 * pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 스택에 들어있는 정수의 개수를 출력한다.
 * empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
 * top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */

public class JavaStack {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/BaekJoon.Class2.BKJ_10828/input.txt"));
        Main.main(args);
    }
}

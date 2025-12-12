package BaekJoon.Class2.BKJ_1874;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static Stack<Integer> stack = new Stack<>();
    static int[] target;

    public static void main(String[] args) throws IOException {
        getInput();
        startProcess();
    }

    static void getInput() throws IOException {
        N = Integer.parseInt(br.readLine());
        target = new int[N];

        for (int i = 0; i < N; i++) {
            target[i] = Integer.parseInt(br.readLine());
        }
    }

    static void startProcess() {
        int x = 0, counter = 1;
        StringBuilder sb = new StringBuilder();

        while (x < N) {
            if (!stack.isEmpty()) {
                if (stack.peek() > target[x]) {
                    System.out.println("NO");
                    return;
                } else if (stack.peek() == target[x]) {
                    stack.pop();
                    sb.append("-\n");
                    x++;
                    continue;
                }
            }
            stack.push(counter++);
            sb.append("+\n");
        }

        System.out.print(sb);
    }
}

public class StackSequence {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BaekJoon/Class2/BKJ_1874/input.txt"));
        Main.main(args);
    }
}

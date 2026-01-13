package BaekJoon.Class2.BKJ_4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Stack;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String sentence = br.readLine();
        StringBuilder sb = new StringBuilder();

        getout:
        while (!sentence.equals(".")){
            char[] letters = sentence.toCharArray();
            Stack<Character> stack = new Stack<>();

            for (char letter : letters) {
                switch(letter) {
                    case '[':
                    case '(':
                        stack.push(letter);
                        break;
                    case ')':
                        if (stack.isEmpty() || stack.pop() != '(') {
                            sb.append("no\n");
                            sentence = br.readLine();
                            continue getout;
                        }
                        break;
                    case ']':
                        if (stack.isEmpty() || stack.pop() != '[') {
                            sb.append("no\n");
                            sentence = br.readLine();
                            continue getout;
                        }
                        break;
                }
            }

            if (stack.isEmpty()) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
            sentence = br.readLine();
        }

        System.out.print(sb);
    }
}

public class BalancedWorld {
    public static void main(String[] args) throws IOException {
        System.setIn(Files.newInputStream(Paths.get("src/BaekJoon/Class2/BKJ_4949/input.txt")));
        Main.main(args);
    }
}

package BaekJoon.Class4.BKJ_1991;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Child {
    String left;
    String right;

    Child(String left, String right) {
        if (left.equals(".")) this.left = null;
        else this.left = left;

        if (right.equals(".")) this.right = null;
        else this.right = right;
    }
}

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static StringBuilder preorder = new StringBuilder();
    static StringBuilder inorder = new StringBuilder();
    static StringBuilder postorder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        getInput();
        getOutput("A");

        System.out.println(preorder);
        System.out.println(inorder);
        System.out.println(postorder);
    }

    static HashMap<String, Child> map;

    static void getInput() throws IOException {
        map = new HashMap<>(N);
        String key, left, right;

        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            key = token.nextToken();
            left = token.nextToken();
            right = token.nextToken();

            map.put(key, new Child(left, right));
        }
    }

    static void getOutput(String key) {
        preorder.append(key);
        if (map.get(key).left != null) getOutput(map.get(key).left);
        inorder.append(key);
        if (map.get(key).right != null) getOutput(map.get(key).right);
        postorder.append(key);
    }
}

public class TreeTraversal {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BaekJoon.Class4.BKJ_1991/input.txt"));
        Main.main(args);
    }
}

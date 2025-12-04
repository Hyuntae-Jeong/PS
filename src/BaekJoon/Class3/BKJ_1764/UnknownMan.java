package BaekJoon.Class3.BKJ_1764;

import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static Set<String> nameList;

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        neverHeard();
        neverSeen();
    }

    static void neverHeard() throws IOException {
        nameList = new HashSet<>(N);
        for (int i = 0; i < N; i++){
            nameList.add(br.readLine());
        }
    }

    static void neverSeen() throws IOException {
        StringBuilder sb = new StringBuilder();
        String name;
        int count = 0;

        Set<String> unknownList = new TreeSet<>();

        for (int i = 0; i < M; i++) {
            name = br.readLine();
            if (nameList.contains(name)) {
                unknownList.add(name);
            }
        }

        sb.append(unknownList.size()).append("\n");
        for (String names : unknownList) sb.append(names).append("\n");

        System.out.println(sb);
    }
}


public class UnknownMan {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/BaekJoon.Class3.BKJ_1764/input.txt"));
        Main.main(args);
    }
}

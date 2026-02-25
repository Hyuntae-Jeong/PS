package BaekJoon.Class3.BKJ_1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

class User {
    int num;
    Set<Integer> friends;
    int[] steps;

    User(int num, int N) {
        this.num = num;
        this.friends = new HashSet<>();
        this.steps = new int[N + 1];
    }
}

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static User[] users;

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        getInput();

        int realKevinBaconValue = Integer.MAX_VALUE;
        int realKevinBacon = 0;
        for (int i = 1; i <= N; i++) {
            int kevinBacon = getKevinBacon(i);
            if (kevinBacon < realKevinBaconValue) {
                realKevinBacon = i;
                realKevinBaconValue = kevinBacon;
            }
        }

        System.out.println(realKevinBacon);
    }

    static void getInput() throws IOException {
        users = new User[N + 1];
        for (int i = 1; i <= N; i++) {
            users[i] = new User(i, N);
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            users[a].friends.add(b);
            users[b].friends.add(a);
        }
    }

    static int getKevinBacon(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        int total = 0;
        queue.add(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : users[curr].friends) {
                if (users[start].steps[next] == 0 && next != start) {
                    users[start].steps[next] = users[start].steps[curr] + 1;
                    total += users[start].steps[next];
                    queue.add(next);
                }
            }
        }

        return total;
    }
}

public class KevinBacon {
    public static void main(String[] args) throws IOException {
        System.setIn(Files.newInputStream(Paths.get("src/BaekJoon/Class3/BKJ_1389/input.txt")));
        Main.main(args);
    }
}

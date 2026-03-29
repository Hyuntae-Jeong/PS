package BaekJoon.Class5.BKJ_1202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Jewel {
    int value;
    int weight;

    Jewel (int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static ArrayList<Jewel> jewels;

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        getJewels();
    }

    static void getJewels() throws IOException {
        jewels = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(token.nextToken());
            int value = Integer.parseInt(token.nextToken());

            jewels.add(new Jewel(value, weight));
        }

        jewels.sort((j1, j2) -> {
            if (j1.value != j2.value) return j2.value - j1.value;
            else return j2.weight - j1.weight;
            // todo: value가 같은 경우에는 무거운거 먼저? 가벼운거 먼저? 아니면 상관없음??
        });
    }
}

public class JewelThief {
    public static void main(String[] args) throws IOException {
        System.setIn(Files.newInputStream(Paths.get("src/BaekJoon/Class5/BKJ_1202/input.txt")));
        Main.main(args);
    }
}

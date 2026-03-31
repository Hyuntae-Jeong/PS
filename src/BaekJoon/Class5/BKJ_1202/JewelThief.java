package BaekJoon.Class5.BKJ_1202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

class Jewel {
    int value;
    int weight;

    Jewel (int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

class Bag {
    int capacity;
    boolean isFull;
    Bag nextBag;

    Bag (int capacity) {
        this.capacity = capacity;
    }

    Bag (int capacity, Bag preBag) {
        this.capacity = capacity;
        preBag.nextBag = this;
    }
}

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static ArrayList<Jewel> jewels;
    static Bag[] bags;
    static long totalValue = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        getJewels();
        getBags();
        findPerfectBag();

        System.out.print(totalValue);
    }

    static void getJewels() throws IOException {
        jewels = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(token.nextToken());
            int value = Integer.parseInt(token.nextToken());

            jewels.add(new Jewel(value, weight));
        }

        // 보석을 값어치 기준으로 내림차순 정렬한다
        jewels.sort((j1, j2) -> {
            if (j1.value != j2.value) return j2.value - j1.value;
            else return j2.weight - j1.weight;
        });
    }

    static void getBags() throws IOException {
        ArrayList<Integer> bagInput = new ArrayList<>(M);
        for (int i = 0; i < M; i++) {
            int bag = Integer.parseInt(br.readLine());
            bagInput.add(bag);
        }
        // 가방의 용량을 오름차순 정렬한다
        bagInput.sort(Comparator.naturalOrder());

        bags = new Bag[M];
        bags[0] = new Bag(bagInput.get(0));
        for (int i = 1; i < bagInput.size(); i++) {
            bags[i] = new Bag(bagInput.get(i), bags[i-1]);
        }
    }

    static void findPerfectBag() {
        // 가장 값비싼 보석부터 가방에 담는다
        for (Jewel jewel : jewels) {
            Bag searchedBag = binarySearchBag(jewel.weight);
            addJewelToEmptyBag(searchedBag, jewel.value);
        }

    }

    static Bag binarySearchBag(int weight) {
        int L = 0, R = M - 1, C;

        while (L < R) {
            C = (L + R) / 2;
            if (bags[C].capacity < weight) {
                L = C + 1;
            } else if (bags[C].capacity > weight) {
                R = C;
            } else {
                return bags[C];
            }
        }

        if (bags[L].capacity < weight) return null;
        return bags[L];
    }

    static void addJewelToEmptyBag(Bag bag, int jewelValue) {
        Bag initialBag = bag;
        while (bag != null && bag.isFull) {
            bag = bag.nextBag;
        }

        if (bag == null) {
            return;
        }

        // 1. 가방을 full 상태로 전환
        bag.isFull = true;

        // 2. 현재 넣는 가방의 nextBag을 초기에 발견한 가방의 nextBag으로 설정한다
        initialBag.nextBag = bag.nextBag;

        totalValue += jewelValue;
    }
}

public class JewelThief {
    public static void main(String[] args) throws IOException {
        System.setIn(Files.newInputStream(Paths.get("src/BaekJoon/Class5/BKJ_1202/input.txt")));
        Main.main(args);
    }
}

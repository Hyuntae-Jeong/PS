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
    Bag preBag;
    Bag postBag;

    Bag (int capacity) {
        this.capacity = capacity;
    }

    Bag (int capacity, Bag preBag) {
        this.capacity = capacity;
        this.preBag = preBag;
        preBag.postBag = this;
    }
}

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static ArrayList<Jewel> jewels;
    static Bag[] bags;

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        getJewels();
        getBags();
        findPerfectBag();
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
            // -> 일단은 상관 없을 것 같아서, 무게 내림차순으로 정렬함
        });
    }

    static void getBags() throws IOException {
        ArrayList<Integer> bagInput = new ArrayList<>(M);
        for (int i = 0; i < M; i++) {
            int bag = Integer.parseInt(br.readLine());
            bagInput.add(bag);
        }
        bagInput.sort(Comparator.naturalOrder());

        bags = new Bag[M];
        bags[0] = new Bag(bagInput.get(0));
        for (int i = 1; i < bagInput.size(); i++) {
            bags[i] = new Bag(bagInput.get(i), bags[i-1]);
        }

//        Bag deleteTest = bags[2];
//        deleteTest.isFull = true;
//        deleteTest.preBag.postBag = deleteTest.postBag;
//        deleteTest.postBag.preBag = deleteTest.preBag;

    }

    static void findPerfectBag() {
        // 가장 값비싼 
        for (Jewel jewel : jewels) {
            System.out.println("value : " + jewel.value + ", weight: " + jewel.weight);
        }

    }
}

public class JewelThief {
    public static void main(String[] args) throws IOException {
        System.setIn(Files.newInputStream(Paths.get("src/BaekJoon/Class5/BKJ_1202/input.txt")));
        Main.main(args);
    }
}

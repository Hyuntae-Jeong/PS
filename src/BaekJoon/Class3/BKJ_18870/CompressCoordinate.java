package BaekJoon.Class3.BKJ_18870;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    // PriorityQueue(정렬) + HashMap(Key로 Value 찾기 & 중복 체크)
    static PriorityQueue<Integer> queue = new PriorityQueue<>();
    static HashMap<Integer, Integer> hashMap = new HashMap<>();
    static int[] arr;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());
        arr = new int[N];

        makeUpCollections(token);
        printAnswer();
    }

    private static void makeUpCollections(StringTokenizer token) {
        // insert to queue in natural order
        for (int i = 0; i < N; i++){
            int num = Integer.parseInt(token.nextToken());
            arr[i] = num;

            // search hashmap to avoid duplication
            if (hashMap.containsKey(num)) continue;

            hashMap.put(num, 0);
            queue.add(num);
        }

        int count = 0;
        // 주의: 단순 iterator는 정렬된 상태를 보장하지 않음.. 왜냐?? priorityQueue는 루트 원소만 최소/최대 값을 보장하기 때문이다..
        // 그래서 poll을 하면서 꺼내야지 정렬된 상태로 꺼낼 수 있음
        while(!queue.isEmpty()) {
            Integer q = queue.poll();
            // replace q's ordered index to hash map for fast lookup
            hashMap.replace(q, count++);
        }
    }

    private static void printAnswer() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(hashMap.get(arr[i])).append(" ");
        }

        sb.deleteCharAt(sb.lastIndexOf(" "));
        System.out.print(sb);
    }
}

public class CompressCoordinate {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/BaekJoon.Class3.BKJ_18870/input.txt"));
        Main.main(args);
    }
}

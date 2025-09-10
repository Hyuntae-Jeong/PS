package BKJ_2805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int numTree, needTree;
    static int[] trees;
    static int min = 0, max = 0, maxHeight = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());

        numTree = Integer.parseInt(token.nextToken());
        needTree = Integer.parseInt(token.nextToken());
        trees = new int[numTree];

        token = new StringTokenizer(br.readLine());

        for (int i = 0; i < numTree; i++) {
            trees[i] = Integer.parseInt(token.nextToken());
            if (trees[i] > max) max = trees[i];
        }

        System.out.println(binarySearch());
    }

    static int binarySearch () {

        while (true) {
            double sumTree = 0;             // 더하다 보면 정수 범위를 넘어서는 경우 존재하므로 double로 선언
            int height = (min + max) / 2;

            for (int i = 0; i < numTree; i++) {
                if (trees[i] > height) {
                    sumTree += (trees[i] - height);
                }

                if (sumTree > needTree) {
                    // 높이를 더 올려도 되는 경우
                    if (maxHeight < height) maxHeight = height;
                    min = height + 1;
                    break;
                }
            }

            if (sumTree < needTree) {
                // 높이를 내려야 하는 경우
                max = height - 1;
            } else if (sumTree == needTree) {
                return height;
            }

            if (max < min) return maxHeight;
        }
    }
}

public class CuttingTree {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BKJ_2805/input.txt"));
        Main.main(args);
    }
}

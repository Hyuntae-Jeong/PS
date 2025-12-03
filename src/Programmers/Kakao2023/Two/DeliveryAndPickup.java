package Programmers.Kakao2023.Two;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int lastD = n - 1, lastP = n - 1;   // two pointer
        int leftD, leftP, maxD, maxP;
        long answer = 0;

        while (lastD >= 0 || lastP >= 0) {
            // 배달 최대 거리 구하기
            leftD = cap;
            maxD = -1;
            while (leftD > 0 && lastD >= 0) {
                if (deliveries[lastD] == 0) {
                    lastD--;
                    continue;
                }

                maxD = Math.max(maxD, lastD);

                if (deliveries[lastD] <= leftD) {
                    leftD -= deliveries[lastD];
                    deliveries[lastD] = 0;
                    lastD--;
                } else {
                    deliveries[lastD] -= leftD;
                    leftD = 0;
                }
            }

            // 픽업 최대 거리 구하기
            leftP = cap;
            maxP = -1;
            while (leftP > 0 && lastP >= 0) {
                if (pickups[lastP] == 0) {
                    lastP--;
                    continue;
                }

                maxP = Math.max(maxP, lastP);

                if (pickups[lastP] <= leftP) {
                    leftP -= pickups[lastP];
                    pickups[lastP] = 0;
                    lastP--;
                } else {
                    pickups[lastP] -= leftP;
                    leftP = 0;
                }
            }

//            System.out.printf("maxD: %d , lastD: %d\nmaxP: %d , lastP: %d\n\n", maxD, lastD, maxP, lastP);

            // 배달 최대거리와 픽업 최대거리 중 큰 값 결과에 더해주기
            answer += 2 * (Math.max(maxD, maxP) + 1);
        }

        return answer;
    }
}

public class DeliveryAndPickup {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Programmers/Kakao2023/Two/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cap = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        StringTokenizer token = new StringTokenizer(br.readLine());
        int[] deliveries = new int[n];
        for (int i = 0; i < n; i++) {
            deliveries[i] = Integer.parseInt(token.nextToken());
        }

        token = new StringTokenizer(br.readLine());
        int[] pickups = new int[n];
        for (int i = 0; i < n; i++) {
            pickups[i] = Integer.parseInt(token.nextToken());
        }

        System.out.println(Solution.solution(cap, n, deliveries, pickups));
    }
}

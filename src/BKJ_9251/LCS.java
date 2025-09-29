package BKJ_9251;

import java.io.*;

class Info {
    int lastIndex;
    int count;
    String word;

    Info (int lastIndex, int count) {
        this.lastIndex = lastIndex;
        this.count = count;
        this.word = "";
    }
}

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[] first, second;
    static boolean debug = false;

    public static void main(String[] args) throws IOException {
        String firstWord = br.readLine();
        String secondWord = br.readLine();

//        firstWord.toCharArray() 대신 내부 구현된 내용을 변형하여 시작 index를 1부터 시작하도록 커스터마이징함
        first = new char[firstWord.length() + 1];
        System.arraycopy(firstWord.toCharArray(), 0, first, 1, firstWord.length());

        second = new char[secondWord.length() + 1];
        System.arraycopy(secondWord.toCharArray(), 0, second, 1, secondWord.length());

//        startProcess(firstWord.length(), secondWord.length());
        startProcess(firstWord.length(), secondWord.length());
        
    }

    static int[][] lcsGraph;
    static void startProcess(int firstWordLength, int secondWordLength) {
        lcsGraph = new int[firstWordLength + 1][secondWordLength + 1];
        for (int i = 1; i <= firstWordLength; i++) {
            for (int j = 1; j <= secondWordLength; j++) {
                if (first[i] == second[j]) {
                    lcsGraph[i][j] = lcsGraph[i - 1][j - 1] + 1;
                } else {
                    lcsGraph[i][j] = Math.max(lcsGraph[i-1][j], lcsGraph[i][j-1]);
                }
                if (debug) System.out.printf("%d\t", lcsGraph[i][j]);
            }
            if (debug) System.out.println();
        }
        System.out.println(lcsGraph[firstWordLength][secondWordLength]);
    }

    static void startProcess_old(int firstWordLength, int secondWordLength) {
        /** 
         * 이 풀이 방법은 문자열을 하나씩 늘리면서 첫번째 문자열과 두번째 문자열의 한 글자가 LCS에 포함되는 경우를 구했다.
         * 하지만, 이 풀이 방법의 문제는 같은 글자가 나오면 무조건 선택해버린다는 것이다.
         * (같은 문자여도 선택을 하지 않고 뒤에서 선택하는 경우 LCS가 더 길어지는 경우도 있다)
         * 그래서 1차원 배열으로는 풀이가 어렵다고 판단되어 knapsack 문제 bottom-up 풀이와 같이 2차원 배열을 이용해서 선택해 나가는 풀이로 전환했다
         *
         * VREGDFELK
         * VLSKD
         * (반례)
         * 출력: 2 VD
         * 정답: 3 VLK
         */
        Info firstInfo = new Info(-1, 0);
        Info secondInfo = new Info(-1, 0);
        int currentIndex = 0;

        while (currentIndex < Math.max(firstWordLength, secondWordLength)) {
            if (currentIndex < firstWordLength) {
                for (int i = firstInfo.lastIndex + 1; i <= Math.min(currentIndex, secondWordLength - 1); i++) {
                    if (first[currentIndex] == second[i]) {
                        firstInfo.lastIndex = i;
                        firstInfo.count++;
                        firstInfo.word = firstInfo.word.concat(String.valueOf(first[currentIndex]));
                        
                        break;
                    }
                }
            }

            if (currentIndex < secondWordLength) {
                for (int i = secondInfo.lastIndex + 1; i <=Math.min(currentIndex, firstWordLength - 1); i++) {
                    if (i < firstWordLength && second[currentIndex] == first[i]) {
                        secondInfo.lastIndex = i;
                        secondInfo.count++;
                        secondInfo.word = secondInfo.word.concat(String.valueOf(second[currentIndex]));

                        break;
                    }
                }
            }

            if (debug) {
                System.out.printf("AFTER %d step\n first) lastIndex: %d, count: %d, LCS: %s\n second) lastIndex: %d, count: %d, LCS: %s\n",
                        currentIndex, firstInfo.lastIndex, firstInfo.count, firstInfo.word, secondInfo.lastIndex, secondInfo.count, secondInfo.word);

            }
            currentIndex++;
        }

        System.out.println(Math.max(firstInfo.count, secondInfo.count));
    }
}

public class LCS {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BKJ_9251/input.txt"));
        Main.main(args);
    }
}

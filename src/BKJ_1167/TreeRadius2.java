package BKJ_1167;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class ChildInfo {
    int childIndex;
    int length;
    int max;

    ChildInfo (int childIndex, int length) {
        this.childIndex = childIndex;
        this.length = length;
    }
}

class Node {
    int value;
    ArrayList<ChildInfo> childInfos;
    int maxChildLength;
    int secondMaxChildLength;

    Node (int value, int child, int length) {
        this.value = value;
        this.childInfos = new ArrayList<>();
        this.childInfos.add(new ChildInfo(child, length));
    }

    void addChildInfo(int child, int length) {
        this.childInfos.add(new ChildInfo(child, length));
    }
}

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static Node[] nodes;
    static int startNode;
    static int totalMax;
    static boolean debug = false;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        nodes = new Node[N + 1];

        getInput();
        if(debug) printInput();
        gotoChild(startNode, 0);
        System.out.print(totalMax);
    }

    static void getInput() throws IOException {
        int parentNode, childNode, length;

        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            parentNode = Integer.parseInt(token.nextToken());
            if (i == 0) startNode = parentNode;

            while (token.hasMoreTokens()) {
                childNode = Integer.parseInt(token.nextToken());
                if (childNode == -1) break;
                length = Integer.parseInt(token.nextToken());

                if (nodes[parentNode] == null) {
                    nodes[parentNode] = new Node(parentNode, childNode, length);
                } else {
                    // 자식이 여러개 일 수 있으므로 arrayList에 자식 정보 저장한다
                    nodes[parentNode].addChildInfo(childNode, length);
                }
            }
        }
    }

    static void printInput() {
        for (int i = 1; i <= N; i++) {
            System.out.printf("Node %d's child infos\n", i);
            for (ChildInfo childInfo : nodes[i].childInfos) {
                System.out.printf("child: %d , length: %d\n", childInfo.childIndex, childInfo.length);
            }
        }
    }

    static int gotoChild (int parent, int caller) {
        boolean hasChild = false;
        int returnLength = 0;

        for (ChildInfo child : nodes[parent].childInfos) {
            if (child.childIndex == caller) {
                returnLength = child.length;
                continue;
            }
            hasChild = true;

            child.max = gotoChild(child.childIndex, parent);
            if (child.max > nodes[parent].maxChildLength) {
                nodes[parent].secondMaxChildLength = nodes[parent].maxChildLength;
                nodes[parent].maxChildLength = child.max;
            }
            else if (child.max > nodes[parent].secondMaxChildLength) nodes[parent].secondMaxChildLength = child.max;

            if (debug) System.out.printf("parent: %d, child: %d, lengthSum: %d\n", parent, child.childIndex, child.max);
        }

        // leaf 노드일 경우 자신의 length를 리턴한다
        if (!hasChild) return returnLength;
        
        // parent 노드가 꺾이는 지점이라고 했을때 그 값이 최대값인지 확인
        totalMax = Math.max(totalMax, nodes[parent].maxChildLength + nodes[parent].secondMaxChildLength);
        return nodes[parent].maxChildLength + returnLength;
    }
}

public class TreeRadius2 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/BKJ_1167/input.txt"));
        Main.main(args);
    }
}

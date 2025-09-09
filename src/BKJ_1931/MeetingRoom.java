package BKJ_1931;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Meeting implements Comparable<Meeting> {
    int start;
    int end;

    public Meeting(int s, int e) {
        this.start = s;
        this.end = e;
    }

    @Override
    public int compareTo(Meeting o) {
        if (this.end < o.end) return -1;
        else if (this.end > o.end) return 1;
        else return Integer.compare(this.start, o.start);
    }

}

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
//    static ArrayList<Meeting> meetings;
    static PriorityQueue<Meeting> meetings;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
//        meetings = new ArrayList<Meeting>();
        meetings = new PriorityQueue<>();

        getMeetingInfos();
//        printMeetingInfos();
        planMeetings();
    }

    private static void planMeetings() {
        int meetingCount = 0;
        int lastEndMeetingTime = 0;

//        for (Meeting meeting : meetings) {
        while (!meetings.isEmpty()) {
            Meeting meeting = meetings.poll();

            if (meeting.start >= lastEndMeetingTime) {
                lastEndMeetingTime = meeting.end;
                meetingCount++;
            }
        }

        System.out.println(meetingCount);
    }

    private static void printMeetingInfos() {
        /*for (Meeting meeting : meetings) {
            System.out.println(meeting.start + " , " + meeting.end);
        }*/

        while (!meetings.isEmpty()){
            Meeting meeting = meetings.poll();
            System.out.println(meeting.start + " , " + meeting.end);
        }
    }

    private static void getMeetingInfos() throws IOException {
        StringTokenizer token;

        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            meetings.add(new Meeting(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken())));
        }

//        Collections.sort(meetings);
    }
}


public class MeetingRoom {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BKJ_1931/input.txt"));
        Main.main(args);
    }
}

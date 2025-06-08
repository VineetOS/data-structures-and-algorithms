package com.dsa.greedy;

class Meeting {
    int start;
    int end;
    int meetingId;

    Meeting(int start, int end, int meetingId) {
        this.start = start;
        this.end = end;
        this.meetingId = meetingId;
    }
}

class MeetingComparator implements java.util.Comparator<Meeting> {
    @Override
    public int compare(Meeting m1, Meeting m2) {
        if (m1.end != m2.end) {
            return Integer.compare(m1.end, m2.end);
        } else {
            return Integer.compare(m1.meetingId, m2.meetingId);
        }
    }
}

public class NMeetings {

    /*
        Problem Statement:
        * Given N meetings in one room, find the maximum number of meetings that can be accommodated in the room.
        * Each meeting has a start and end time.
        * The meetings can only be attended if they do not overlap.
     */

    private static int[] maxMeetings(int[] start, int[] end) {
        int n = start.length;
        Meeting[] meetings = new Meeting[n];

        for (int i = 0; i < n; i++) {
            meetings[i] = new Meeting(start[i], end[i], i + 1);
        }

        java.util.Arrays.sort(meetings, new MeetingComparator());

        int[] result = new int[n];
        int count = 0;
        int lastEndTime = -1;

        for (Meeting meeting : meetings) {
            if (meeting.start > lastEndTime) {
                result[count++] = meeting.meetingId;
                lastEndTime = meeting.end;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        int[] result = maxMeetings(start, end);
        System.out.print("Maximum number of meetings: ");
        for (int i = 0; i < result.length && result[i] != 0; i++) {
            System.out.print(result[i] + " ");
        }
    }
}

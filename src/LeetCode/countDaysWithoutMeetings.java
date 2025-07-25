package LeetCode;

import java.util.Arrays;

public class countDaysWithoutMeetings {


    public static void main(String arga[]){
        int[][] meetings = new int[][]{{3,49},{23,44},{21,56},{26,55},{23,52},{2,9},{1,48},{3,31}};
        System.out.println(countDays(57,meetings));

    }



    public static int countDays(int days, int[][] meetings) {

        Arrays.sort(meetings , (a, b)-> Integer.compare(a[0],b[0]));
        // Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        // int ans = 0 ;
        int startOfFirstMeeting = meetings[0][0];
        int ans = startOfFirstMeeting-1;
        int lastDayOfMeeting = 0;
        for(int i = 0 ; i < meetings.length-1 ; i++){
            if(meetings[i][1]>lastDayOfMeeting){
                lastDayOfMeeting =meetings[i][1];
            }
            if(meetings[i][1]<meetings[i+1][0]){
                ans= ans+meetings[i+1][0]-meetings[i][1]-1;
            }

        }
        if(meetings[meetings.length-1][1]>lastDayOfMeeting){
            lastDayOfMeeting = meetings[meetings.length-1][1];
        }
        if(days!=lastDayOfMeeting){
            ans = ans+days-lastDayOfMeeting;
        }
        return ans;

    }
}

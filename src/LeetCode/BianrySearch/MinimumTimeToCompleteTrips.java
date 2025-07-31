package LeetCode.BianrySearch;

public class MinimumTimeToCompleteTrips {

//    https://leetcode.com/problems/minimum-time-to-complete-trips/description/


    class Solution {
        public static long minimumTime(int[] timeTaken, int totalTrips) {
            int minTimeIndependently = Integer.MAX_VALUE;
            for (int l : timeTaken) {
                minTimeIndependently = Math.min(minTimeIndependently, l);
            }

            long low = 1;
            long high = (long) minTimeIndependently * totalTrips;
            long ans = high;

            while (low <= high) {
                long mid = low + (high - low) / 2;
                long trips = calculateTotalTripsInTimeT(mid, timeTaken);

                if (trips >= totalTrips) {
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            return ans;
        }

        public static long calculateTotalTripsInTimeT(long time, int[] timeTaken) {
            long totalTrips = 0;
            for (int t : timeTaken) {
                totalTrips += time / t;
            }
            return totalTrips;
        }
    }

}

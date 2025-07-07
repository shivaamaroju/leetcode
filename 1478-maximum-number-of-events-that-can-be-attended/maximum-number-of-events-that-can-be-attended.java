import java.util.*;

class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[1] - b[1]); // endDay ఆధారంగా sort

        TreeSet<Integer> availableDays = new TreeSet<>();
        int maxDay = 0;
        for (int[] event : events) {
            maxDay = Math.max(maxDay, event[1]);
        }

        // అందుబాటులో ఉన్న అన్ని రోజులు add చేయండి
        for (int i = 1; i <= maxDay; i++) {
            availableDays.add(i);
        }

        int count = 0;
        for (int[] event : events) {
            int start = event[0];
            int end = event[1];

            Integer d = availableDays.ceiling(start); // start నుండి మొదలుపెట్టి ఖాళీ రోజు
            if (d != null && d <= end) {
                count++;
                availableDays.remove(d);
            }
        }

        return count;
    }
}

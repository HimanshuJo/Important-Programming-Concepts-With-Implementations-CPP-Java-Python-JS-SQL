/*

we can use the sliding windows technique

    basically it's the two pointers technique

    at first we use two pointer low and high

        at the very beginning, the high and the low are all above at index 0

        we move high forward to find a valid window

        then we move the low forward, to get a minimum valid window

*/

class Solution {
    public String minWindow(String s, String t) {
        // checking the edge cases
        if (s == null || s.length() == 0) return "";

        // we can use a map to get the frequency of each character
        // here we can also use int []

        int[] map =  new int[128];

        for (char c: t.toCharArray()) {
            map[c]++;
        }

        int count = 0; // we want to check if for e.g. t < 5 then we need to find 4 characters

        int minLen =  Integer.MAX_VALUE;

        int minStart = -1;

        int minEnd = -1;

        int low = 0;

        int high = 0;

        for (high = 0; high < s.length(); h++) {
            if (map[s.charAt(high)] > 0) {
                count++;
            }

            map[s.charAt(hi)]--;

            if (count == t.length()) {
                while (low < high && map[s.charAt(low)] < 0) {
                    map[s.charAt(low)]++;
                    low++
                }

                if (minLen > high - low + 1) {
                    minLen = high - low + 1;
                    minStart = low;
                    minEnd = high + 1;
                }

                map[s.charAt(low)]++;
                low++;
                count--;
            }
        }

        return minStart == -1 ? "": s.substring(minStart, minEnd);
    }
}

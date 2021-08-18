
import java.util.*;

public class Main {

    public int lengthOfLongestSubString(String n) {
        int len_input = n.length();
        if (len_input == 0) {
            return 0;
        }
        int max_len = 0;
        int curr_len = 0;
        int curr_start = 0;

        Map<Character, Integer> string_map = new HashMap<>();
        for (int i = 0; i < len_input; i++) {
            Integer offset = string_map.get(n.charAt(i));
            if (offset == null) {
                curr_len++;
            } else if (offset >= curr_start) {
                curr_len = i - offset;
                curr_start = offset + 1;
            } else {
                curr_len++;
            }
            string_map.put(n.charAt(i), i);
            if (curr_len > max_len) {
                max_len = curr_len;
            }
        }
        return max_len;
    }

    public static void main(String[] args) {
        Main my_obj = new Main();
        System.out.println(my_obj.lengthOfLongestSubString("abcabcbb"));
    }

}

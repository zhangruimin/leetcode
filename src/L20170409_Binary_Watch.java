import java.util.*;

/**
 * https://leetcode.com/problems/binary-watch/
 */
public class L20170409_Binary_Watch {
    public List<String> readBinaryWatch(int num) {
        boolean[] leds = new boolean[10];
        ArrayList<String> result = new ArrayList<>();
        recursiveFind(leds, 0, num, result);
        return result;
    }

    private void recursiveFind(boolean[] leds, int currentLed, int num, ArrayList<String> result) {
        if (leds.length - currentLed < num) {
            return;
        }
        if (num == 0) {
            addResult(leds, result);
            return;
        }

        leds[currentLed] = true;
        recursiveFind(leds, currentLed + 1, num - 1, result);
        leds[currentLed] = false;
        recursiveFind(leds, currentLed + 1, num, result);
    }

    private void addResult(boolean[] leds, ArrayList<String> result) {
        int hour =0;
        for (int i = 0; i < 4; i++) {
            if (leds[i]) {
                hour += Math.pow(2, i);
            }
        }

        if (hour > 11) {
            return;
        }

        int min = 0;
        for (int i = 4; i < 10; i++) {
            if (leds[i]) {
                min += Math.pow(2, i - 4);
            }
        }
        if (min > 59) {
            return;
        }

        String minString = "" + min;
        if (min < 10) {
            minString="0"+minString;
        }
        result.add("" + hour + ":" + minString);
    }
}


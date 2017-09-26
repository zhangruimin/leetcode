package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 */
public class L2017092601_93_Restore_IP_Addresses {
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> current = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        if (s.length() > 12) {
            return result;
        }

        recursive(s.trim(), current, result);
        return result;
    }

    private void recursive(String s, ArrayList<String> current, ArrayList<String> result) {
        if (s.length() == 0) {
            return;
        }
        if (current.size() == 3) {
            current.add(s);
            addToResultIfValid(current, result);
            current.remove(3);
            return;
        }
        int size = current.size();
        if (s.length() > 0) {
            current.add(s.substring(0, 1));
            recursive(s.substring(1),current,result);
            current.remove(size);
        }
        if (s.length() > 1) {
            current.add(s.substring(0, 2));
            recursive(s.substring(2),current,result);
            current.remove(size);
        }
        if (s.length() > 2) {
            current.add(s.substring(0, 3));
            recursive(s.substring(3),current,result);
            current.remove(size);
        }
    }

    private void addToResultIfValid(ArrayList<String> current, ArrayList<String> result) {
        for (String s : current) {
            if (s.length() > 1 && s.charAt(0) == '0') {
                return;
            }
            int i = Integer.parseInt(s);
            if (i > 255) {
                return;
            }
        }
        result.add(current.stream().collect(Collectors.joining(".")));
    }
}


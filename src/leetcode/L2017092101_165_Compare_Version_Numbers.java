package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 */
public class L2017092101_165_Compare_Version_Numbers {
    public static void main(String[] args) {
        System.out.println(new L2017092101_165_Compare_Version_Numbers().compareVersion("01","1"));
    }
    public int compareVersion(String version1, String version2) {
        String v1 = version1.trim();
        String v2 = version2.trim();

        if (v1.equals(v2)) {
            return 0;
        }

        String[] v1Split = v1.split("\\.");
        String[] v2Split = v2.split("\\.");
        List<Integer> v1Nums = Arrays.stream(v1Split).map(s -> Integer.valueOf(s)).collect(Collectors.toList());
        List<Integer> v2Nums = Arrays.stream(v2Split).map(s -> Integer.valueOf(s)).collect(Collectors.toList());
        int minSize = Math.min(v1Nums.size(), v2Nums.size());
        for (int i = 0; i < minSize; i++) {
            if (v1Nums.get(i) < v2Nums.get(i)) {
                return -1;
            } else if (v1Nums.get(i) > v2Nums.get(i)) {
                return 1;
            }
        }

        if(v1Nums.size() == v2Nums.size()){
            return 0;
        }

        List<Integer> longVersion = v1Nums.size() > v2Nums.size() ? v1Nums : v2Nums;
        boolean isAllZero=true;
        for (int i = minSize; i <longVersion.size() ; i++) {
            if (longVersion.get(i) != 0) {
                isAllZero = false;
                break;
            }
        }
        if (isAllZero) {
            return 0;
        }
        return v1Nums.size() > v2Nums.size() ? 1 : -1;
    }
}


package leetcode;

/**
 */
public class L2017050103_476_Number_Complement {
    public int findComplement(int num) {
        return ~num & ((Integer.highestOneBit(num) << 1) - 1);
    }
}






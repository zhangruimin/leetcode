/**
 */
public class L2017042502_461_Hamming_Distance {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

        public int hammingDistance_mine(int x, int y) {

        int xor = x ^ y;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((xor & 1) == 1) {
                count++;
            }
            xor=xor>>>1;
        }
        return count;
    }
}



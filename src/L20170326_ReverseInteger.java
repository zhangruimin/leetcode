/**
 * Created by zrruimin on 3/26/17.
 */
public class L20170326_ReverseInteger {
    public static void main(String[] args) {
        L20170326_ReverseInteger nextPermutation = new L20170326_ReverseInteger();
        int reverse = nextPermutation.reverse(321);
        System.out.println(reverse);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    public int reverse(int x) {
        int result = 0;
        while(x != 0){
            int tail = x % 10;
            x = x / 10;
            int next  = result * 10 + tail;
            if((next - tail) / 10 != result){
                return 0;
            }
            result = next;
        }
        return result;
    }
}

package leetcode;

/**
 */
public class L20171124_393_UTF_8_Validation {
    public static void main(String[] args) {
        System.out.println(new L20171124_393_UTF_8_Validation().validUtf8(new int[]{197, 130, 1}));

    }
    public boolean validUtf8(int[] data) {
        int index = 0;
        while (index < data.length) {
            int bytes = getNextMatchedBytes(data, index);
            if (bytes == 0) {
                return false;
            }
            index += bytes;
        }
        return true;
    }

    private int getNextMatchedBytes(int[] data, int index) {
        int firstByte = data[index];
        int bytes = 0;
        if ((firstByte & 0b10000000) == 0) {
            bytes=1;
        } else if ((firstByte & 0b11100000) == 0b11000000) {
            bytes=2;
        } else if ((firstByte & 0b11110000) == 0b11100000) {
            bytes=3;
        } else if ((firstByte & 0b11111000) == 0b11110000) {
            bytes=4;
        }else{
            return 0;
        }


        for (int i = 1; i < bytes; i++) {
            if (index+i>=data.length || (data[index + i] & 0b11000000) != 0b10000000) {
                return 0;
            }
        }
        return bytes;
    }
}


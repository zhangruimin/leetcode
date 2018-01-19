package nonLeetcode;

import java.util.Date;
import java.util.LinkedHashMap;

public class TestMemoryTime {
    public static void main(String[] args) throws InterruptedException {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        int i=0;
        while (i <= 300000){
            map.put(i, "OutOfMemoryError soon");
            i++;
        }

        long time = new Date().getTime();
        LinkedHashMap<Integer, String> map2 = new LinkedHashMap<>(map);
        long time2 = new Date().getTime();
        System.out.println(time2-time);

    }
}

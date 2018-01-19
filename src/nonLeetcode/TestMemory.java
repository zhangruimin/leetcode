package nonLeetcode;

import java.util.ArrayList;
import java.util.List;

public class TestMemory {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<String>();
        int i=0;
        while (i <= 1197000000){
            list.add("OutOfMemoryError soon");
            i++;
            if (i % 1000000 == 0) {
                System.out.println(i);
            }
        }

        System.out.println("Sleeping");
        Thread.sleep(1000*60*30);
        System.out.println("Waking up");
    }
}

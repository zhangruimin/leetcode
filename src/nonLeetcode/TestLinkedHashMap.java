package nonLeetcode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class TestLinkedHashMap {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(1, "aaa");
        map.put(2, "bbb");
        map.put(3, "ccc");

        print(map);
        map.remove(1);
        map.put(1, "ddd");
        print(map);
    }

    private static void print(LinkedHashMap<Integer, String> map) {
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey() + entry.getValue());
        }
    }
}

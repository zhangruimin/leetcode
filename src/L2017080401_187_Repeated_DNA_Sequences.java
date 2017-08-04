import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 */
public class L2017080401_187_Repeated_DNA_Sequences {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> all = new HashSet<>();
        HashSet<String> repeated = new HashSet<>();

        for (int i = 0; i + 10 <= s.length(); i++) {
            String current = s.substring(i, i + 10);
            if (!all.add(current)) {
                repeated.add(current);
            }
        }

        return new ArrayList<>(repeated);
    }
}


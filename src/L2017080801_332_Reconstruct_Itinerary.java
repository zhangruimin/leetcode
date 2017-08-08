import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 */
public class L2017080801_332_Reconstruct_Itinerary {
    public List<String> findItinerary(String[][] tickets) {
        LinkedList<String> result = new LinkedList<>();
        HashMap<String, PriorityQueue<String>> ticketsMap = new HashMap<>();

        for (String[] ticket : tickets) {
            PriorityQueue<String> queue = ticketsMap.computeIfAbsent(ticket[0], k -> new PriorityQueue());
            queue.add(ticket[1]);
        }
        visit("JFK", ticketsMap, result);
        return result;

    }

    private void visit(String airport, HashMap<String, PriorityQueue<String>> ticketsMap, LinkedList<String> result) {
        PriorityQueue<String> queue = ticketsMap.get(airport);
        while (queue != null && !queue.isEmpty()) {
            String next = queue.poll();
            visit(next, ticketsMap, result);
        }
        result.add(0, airport);
    }

}


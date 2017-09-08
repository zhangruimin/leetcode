package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 */
public class L2017090801_399_Evaluate_Division {
    public static void main(String[] args) {
        String[][] s = {{"a", "b"}, {"b", "c"}};
        double[] d = {2.0, 3.0};
        String[][] s2 = {{"a", "c"}};
        System.out.println(new L2017090801_399_Evaluate_Division().calcEquation(s, d, s2));
    }
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Set<Edge>> graph = getGraph(equations, values);
        double[] result = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            List<Edge> path = getPath(graph, query);
            result[i] = calculate(graph,query, path);
        }
        return result;
    }

    private double calculate(Map<String, Set<Edge>> graph, String[] query, List<Edge> path) {
        String start = query[0];
        String end = query[1];

        if (!graph.containsKey(start) || !graph.containsKey(end)) {
            return -1.0;
        }

        if (start.equals(end)) {
            return 1;
        }

        if (path.size() == 0) {
            return -1;
        }
        String current = start;
        double result = 1;
        for (Edge edge : path) {
            if (edge.start.equals(current)) {
                result *= edge.value;
                current = edge.end;
            } else {
                result /= edge.value;
                current = edge.start;
            }
        }
        return result;
    }

    private List<Edge> getPath(Map<String, Set<Edge>> graph, String[] query) {
        ArrayList<Edge> result = new ArrayList<>();
        HashSet<String> visited = new HashSet<>();
        recursive(query[0], query[1], graph, result, visited);
        return result;
    }

    private boolean recursive(String start, String end, Map<String, Set<Edge>> graph, ArrayList<Edge> result, HashSet<String> visited) {

        if (start.equals(end)) {
            return true;
        }

        if (visited.contains(start)) {
            return false;
        }

        Set<Edge> edges = graph.get(start);
        if (edges == null) {
            return false;
        }

        visited.add(start);
        for (Edge edge : edges) {
            result.add(edge);
            if (edge.start.equals(start)) {
                if (recursive(edge.end, end, graph, result, visited)) {
                    return true;
                }
            } else {
                if (recursive(edge.start, end, graph, result, visited)) {
                    return true;
                }
            }
            result.remove(edge);
        }
        visited.remove(start);
        return false;
    }

    private Map<String, Set<Edge>> getGraph(String[][] equations, double[] values) {
        HashMap<String, Set<Edge>> result = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            Edge edge = new Edge(equations[i][0], equations[i][1], values[i]);
            Set<Edge> edgesForStart = result.getOrDefault(edge.start, new HashSet<>());
            edgesForStart.add(edge);
            result.put(edge.start, edgesForStart);

            Set<Edge> edgesForEnd = result.getOrDefault(edge.end, new HashSet<>());
            edgesForEnd.add(edge);
            result.put(edge.end, edgesForEnd);
        }
        return result;
    }

    private class Edge {
        private String start;
        private String end;
        private double value;

        public Edge(String s, String e, double value) {
            start = s;
            end = e;
            this.value = value;
        }
    }
}


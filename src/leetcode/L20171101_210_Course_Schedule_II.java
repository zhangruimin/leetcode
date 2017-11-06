package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 */
public class L20171101_210_Course_Schedule_II {
    public static void main(String[] args) {
        System.out.println(new L20171101_210_Course_Schedule_II().findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}}));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Set<Integer>> dependentsMap = new HashMap<>();
        HashMap<Integer, Set<Integer>> index = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            Set<Integer> dependents = dependentsMap.getOrDefault(prerequisite[0], new HashSet<>());
            dependents.add(prerequisite[1]);
            dependentsMap.put(prerequisite[0], dependents);

            Set<Integer> set = index.getOrDefault(prerequisite[1], new HashSet<>());
            set.add(prerequisite[0]);
            index.put(prerequisite[1], set);
        }

        LinkedList<Integer> zeroDependents = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            Set<Integer> dependents = dependentsMap.get(i);
            if (dependents == null || dependents.isEmpty()) {
                zeroDependents.push(i);
                dependentsMap.remove(i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!zeroDependents.isEmpty()) {
            Integer current = zeroDependents.poll();
            result.add(current);
            Set<Integer> toRemove = index.getOrDefault(current, new HashSet<>());

            for (Integer r : toRemove) {
                Set<Integer> dependents = dependentsMap.get(r);
                dependents.remove(current);
                if (dependents.isEmpty()) {
                    dependentsMap.remove(r);
                    zeroDependents.add(r);
                }
            }
        }
        if (result.size() < numCourses) {
            return new int[0];
        }

        return result.stream().mapToInt(x -> x).toArray();

    }
}


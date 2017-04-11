import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/course-schedule/#/description
 */
public class L20170411_Course_Schedule {
    public static void main(String[] args) {
        new L20170411_Course_Schedule().canFinish(2, new int[][]{{0,1}});
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] indegree = new int[numCourses];
        int[][] matrix = new int[numCourses][numCourses];

        for (int[] prerequisite : prerequisites) {
            indegree[prerequisite[0]]++;
            matrix[prerequisite[0]][prerequisite[1]] = 1;
        }

        int count = 0;
        Queue<Integer> readyToTake = getReadyToTake(indegree);
        while (!readyToTake.isEmpty()) {
            count++;
            int course = readyToTake.poll();
            for (int i = 0; i < numCourses; i++) {
                if (matrix[i][course] == 1) {
                    if (--indegree[i] == 0) {
                        readyToTake.offer(i);
                    }
                }
            }
        }

        return numCourses == count;
    }

    private Queue<Integer> getReadyToTake(int[] dependencies) {
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = 0; i < dependencies.length; i++) {
            if (dependencies[i] == 0) {
                result.offer(i);
            }
        }
        return result;
    }
}


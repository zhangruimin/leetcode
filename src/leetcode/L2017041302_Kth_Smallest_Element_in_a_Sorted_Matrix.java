package leetcode;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/#/description
 */
public class L2017041302_Kth_Smallest_Element_in_a_Sorted_Matrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        int height = matrix.length;
        int width = matrix[0].length;

        for (int j = 0; j < width; j++) {
            pq.add(new Tuple(0, j, matrix[0][j]));
        }
        Tuple current = null;
        for (int i = 0; i < k; i++) {
            current = pq.poll();
            if (current.i < height - 1) {
                pq.offer(new Tuple(current.i + 1, current.j, matrix[current.i + 1][current.j]));
            }
        }
        return current.value;
    }

}

class Tuple implements Comparable<Tuple> {
    public int i;
    public int j;
    public int value;

    public Tuple(int i, int j, int value) {
        this.i = i;
        this.j = j;
        this.value = value;
    }

    @Override
    public int compareTo(Tuple o) {
        return value - o.value;
    }
}


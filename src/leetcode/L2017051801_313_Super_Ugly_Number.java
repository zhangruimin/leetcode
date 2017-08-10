package leetcode;

import java.util.PriorityQueue;

/**
 */
public class L2017051801_313_Super_Ugly_Number {

    public static void main(String[] args) {
        new L2017051801_313_Super_Ugly_Number().nthSuperUglyNumber(3, new int[]{2, 3, 5});
    }

    public int nthSuperUglyNumber(int n, int[] primes) {

        if (n == 1) {
            return 1;
        }

        PriorityQueue<Num> heap = new PriorityQueue<>();

        for (int prime : primes) {
            heap.add(new Num(prime, 0, prime));
        }

        int[] uglies = new int[n];
        uglies[0] = 1;

        for (int i = 1; i < n; i++) {

            int min = heap.peek().val;
            uglies[i] = min;
            while (heap.peek().val == min) {
                Num current = heap.poll();
                heap.add(new Num(uglies[current.index + 1] * current.prime, current.index + 1, current.prime));
            }
        }
        return uglies[n - 1];
    }

    class Num implements Comparable<Num> {
        int val;
        int index;
        int prime;

        public Num(int val, int index, int prime) {
            this.val = val;
            this.index = index;
            this.prime = prime;
        }

        @Override
        public int compareTo(Num o) {
            return this.val-o.val;
        }
    }

    public int nthSuperUglyNumber_mine(int n, int[] primes) {
        if (n == 1) {
            return 1;
        }

        int[] uglyNumbers = new int[n];

        int[] indices = new int[primes.length];

        uglyNumbers[0] = 1;

        for (int i = 1; i < n; i++) {
            int min = findMin(indices, uglyNumbers, primes);
            uglyNumbers[i] = min;
            for (int j = 0; j < indices.length; j++) {
                if (uglyNumbers[indices[j]] * primes[j] == min) {
                    indices[j]++;
                }
            }
        }
        return uglyNumbers[n - 1];
    }

    private int findMin(int[] indices, int[] uglyNumbers, int[] primes) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < indices.length; i++) {
            min = Math.min(uglyNumbers[indices[i]] * primes[i], min);
        }
        return min;
    }
}
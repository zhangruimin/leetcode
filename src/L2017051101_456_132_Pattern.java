import java.util.Stack;

/**
 * come back
 */
public class L2017051101_456_132_Pattern {
    class Pair {
        int min;
        int max;

        Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    public boolean find132pattern(int[] nums) {
        Stack<Pair> stack = new Stack<>();

        for (int n : nums) {
            if (stack.isEmpty() || n < stack.peek().min) {
                stack.push(new Pair(n, n));
            } else if (n > stack.peek().min) {
                if (n < stack.peek().max) {
                    return true;
                }
                Pair last = stack.pop();
                last.max=n;
                while (!stack.isEmpty() && last.min <= stack.peek().min && last.max >= stack.peek().max) {
                    stack.pop();
                }
                if (!stack.isEmpty() && n > stack.peek().min) {
                    return true;
                }
                stack.push(last);
            }
        }
        return false;
    }
    public boolean find132pattern_mine(int[] nums) {
        Stack<Pair> stack = new Stack<>();

        for (int num : nums) {
            if (stack.isEmpty()) {
                stack.push(new Pair(num, num));
                continue;
            }

            if (num <= stack.peek().min) {
                stack.add(new Pair(num, num));
                continue;
            }

            if (num < stack.peek().max && num > stack.peek().min) {
                return true;
            }

            Pair pop = stack.pop();
            pop.max = num;

            while (!stack.isEmpty() && stack.peek().min >= pop.min && stack.peek().max <= pop.max) {
                stack.pop();
            }


            if (!stack.isEmpty() && num > stack.peek().min && num < stack.peek().max) {
                return true;
            }

            stack.push(pop);

        }
        return false;
    }
}






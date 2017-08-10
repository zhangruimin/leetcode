package leetcode;

import java.util.Stack;

/**
 */
public class L2017051301_385_Mini_Parser {
    public NestedInteger deserialize(String s) {
        Stack<Object> stack = new Stack<>();
        StringParser stringParser = new StringParser(s);
        while (stringParser.hasNext()) {
            String current = stringParser.next();
            if (current.equals(",")) {
                continue;
            }
            if (current.equals("[")) {
                stack.push(current);
                continue;
            }

            if (current.equals("]")) {
                NestedInteger nestedInteger = new NestedInteger();
                Stack<NestedInteger> nestedIntegers = new Stack<>();
                while (!stack.peek().equals("[")) {
                    NestedInteger pop = (NestedInteger)stack.pop();
                    nestedIntegers.push(pop);
                }
                stack.pop();
                while (!nestedIntegers.isEmpty()) {
                    nestedInteger.add(nestedIntegers.pop());
                }
                stack.push(nestedInteger);
                continue;
            }

            stack.push(new NestedInteger(Integer.parseInt(current)));
        }
        return (NestedInteger)stack.peek();
    }

    private class StringParser {
        private String s;
        private int index;

        public StringParser(String s) {
            this.s = s;
            index = 0;
        }


        public boolean hasNext() {
            return index < s.length();
        }


        public String next() {
            String special = "[],";
            if (special.contains("" + s.charAt(index))) {
                return String.valueOf(this.s.charAt(index++));
            }

            StringBuffer sb = new StringBuffer();
            while (index < s.length() && !special.contains("" + s.charAt(index))) {
                sb.append(s.charAt(index++));
            }
            return sb.toString();
        }
    }
}






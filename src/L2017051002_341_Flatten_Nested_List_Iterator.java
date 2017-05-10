import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 */
public class L2017051002_341_Flatten_Nested_List_Iterator implements Iterator<Integer> {

    private final Stack<NestedInteger> stack = new Stack<>();

    public L2017051002_341_Flatten_Nested_List_Iterator(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            NestedInteger pop = stack.pop();
            List<NestedInteger> list = pop.getList();
            for (int i = list.size() - 1; i >= 0; i--) {
                stack.push(list.get(i));
            }
        }

        return !stack.isEmpty();
    }
}






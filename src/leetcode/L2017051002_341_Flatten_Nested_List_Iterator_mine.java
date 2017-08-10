package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 */
public class L2017051002_341_Flatten_Nested_List_Iterator_mine implements Iterator<Integer> {

    private final Iterator<Integer> iterator;

    public L2017051002_341_Flatten_Nested_List_Iterator_mine(List<NestedInteger> nestedList) {
        List<Integer> list = flatten(nestedList);
        iterator = list.iterator();
    }

    private List<Integer> flatten(List<NestedInteger> nestedList) {
        ArrayList<Integer> result = new ArrayList<>();
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                result.add(nestedInteger.getInteger());
            } else {
                result.addAll(flatten(nestedInteger.getList()));
            }
        }
        return result;
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }
}






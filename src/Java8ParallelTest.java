import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by zrruimin on 3/29/17.
 */
public class Java8ParallelTest {
    private static final int iterationNum = 10000;
    private static final int arrayLength = 10000;
    public static void main(String[] args) {

        Java8ParallelTest java8ParallelTest = new Java8ParallelTest();
        java8ParallelTest.test();

    }

    private void test() {
        Integer[] array = new Integer[arrayLength];
        Arrays.fill(array, 0);
        List<Integer> list = Arrays.asList(array);
        Date start = new Date();

        ArrayList<Integer> result = new ArrayList<>();
        for (Integer integer : list) {
            result.add(run(integer));
        }
        Date start1 = new Date();
        System.out.println(start1.getTime()-start.getTime());
        List<Integer> collect = list.stream().map(Java8ParallelTest::run).collect(Collectors.toList());
        Date date2 = new Date();
        System.out.println(date2.getTime()-start1.getTime());

        List<Integer> collect2 = list.parallelStream().map(Java8ParallelTest::run).collect(Collectors.toList());
        Date date3 = new Date();
        System.out.println(date3.getTime()-date2.getTime());

//        System.out.println(result);
    }

    private static int run(int i) {
        int c = 0;
        for (int j = 0; j < iterationNum; j++) {
            double d = new Random().nextDouble();
            double v = d / new Random().nextDouble();
        }
        return c;
    }
}

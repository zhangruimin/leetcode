/**
 */
public class L2017041502_134_Gas_Station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = gas.length - 1;
        int end = 0;
        int currentGas = gas[start] - cost[start];
        while (start > end) {
            if (currentGas >= 0) {
                currentGas += gas[end] - cost[end];
                end++;
            } else {
                start--;
                currentGas += gas[start] - cost[start];
            }
        }

        if (currentGas < 0) {
            return -1;
        }
        return start;
    }

    public int canCompleteCircuit_mine(int[] gas, int[] cost) {
        int node = 0;

        int start = 0;
        int end = 0;
        int allGas = 0;
        int allCost = 0;


        while (node <= cost.length) {
            if (allGas >= allCost) {
                allCost += cost[end];
                allGas += gas[end];
                node++;

                if (end == gas.length - 1) {
                    end = 0;
                } else {
                    end++;
                }

            } else {
                node--;
                allCost -= cost[start];
                allGas -= gas[start];

                start++;
                if (start == cost.length) {
                    return -1;
                }
            }
        }

        if (allCost > allGas) {
            return -1;
        }
        return start;
    }

}


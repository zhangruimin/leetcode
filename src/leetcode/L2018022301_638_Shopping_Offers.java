package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 */
public class L2018022301_638_Shopping_Offers {
    public static void main(String[] args) {
        List<Integer> prices = Arrays.asList(2, 5);
        List<Integer> offer1 = Arrays.asList(3, 0, 5);
        List<Integer> offer2 = Arrays.asList(1, 2, 10);
        List<List<Integer>> offers = new ArrayList<>(Arrays.asList(offer1, offer2));
        List<Integer> needs = Arrays.asList(3, 2);
        System.out.println(new L2018022301_638_Shopping_Offers().shoppingOffers(prices, offers, needs));
    }

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        for (int i = 0; i < price.size(); i++) {
            ArrayList<Integer> specialWithOneItem = new ArrayList<>();
            for (int j = 0; j < price.size(); j++) {
                if (j == i) {
                    specialWithOneItem.add(1);
                } else {
                    specialWithOneItem.add(0);
                }
            }
            specialWithOneItem.add(price.get(i));
            special.add(specialWithOneItem);
        }
        return getMin(special, needs);
    }

    private Integer getMin(List<List<Integer>> special, List<Integer> needs) {
        if (noNeeds(needs)) {
            return 0;
        }
        if (special.size() == 0) {
            return null;
        }
        List<Integer> offer = special.get(0);

        List<Integer> newNeeds = getNewNeeds(needs, offer);

        Integer min = Integer.MAX_VALUE;
        if (newNeeds != null) {
            Integer min1 = getMin(special, newNeeds);
            if (min1 != null) {
                int b = offer.get(offer.size() - 1) + min1;
                min = Math.min(min, b);
            }
        }
        ArrayList<List<Integer>> newSpecial = new ArrayList<>(special);
        newSpecial.remove(0);
        Integer min1 = getMin(newSpecial, needs);
        if (min1 != null) {
            min = Math.min(min, min1);
        }
        if (min == Integer.MAX_VALUE) {
            min = null;
        }
        return min;

    }

    private List<Integer> getNewNeeds(List<Integer> needs, List<Integer> offer) {
        ArrayList<Integer> newNeeds = new ArrayList<>();
        for (int i = 0; i < needs.size(); i++) {
            if (needs.get(i) < offer.get(i)) {
                return null;
            }
            newNeeds.add(needs.get(i) - offer.get(i));
        }
        return newNeeds;
    }

    private boolean noNeeds(List<Integer> needs) {
        for (Integer need : needs) {
            if (need > 0) {
                return false;
            }
        }
        return true;
    }
}

package leetcode;

import java.util.List;

/**
 */
public class L2017081001_355_Design_Twitter {
    public static void main(String[] args) {
       Twitter obj = new Twitter();
       obj.postTweet(1,5);
       List<Integer> param_2 = obj.getNewsFeed(1);
       obj.follow(1,2);
        obj.postTweet(2,6);
        List<Integer> param_3 = obj.getNewsFeed(1);
    }
}


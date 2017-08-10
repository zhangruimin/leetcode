import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Twitter {

    private final HashMap<Integer, Set<Integer>> followeeMap;
    private final HashMap<Integer, List<Post>> postsMap;
    private int currentPostId = 0;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        followeeMap = new HashMap<>();
        postsMap = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        List<Post> posts = this.postsMap.computeIfAbsent(userId, k -> new ArrayList<>());
        posts.add(new Post(tweetId, currentPostId++));
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Post> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.sequence));

        addToQueue(priorityQueue, userId);
        Set<Integer> followers = followeeMap.getOrDefault(userId, new HashSet<>());
        for (Integer follower : followers) {
            addToQueue(priorityQueue, follower);
        }
        ArrayList<Integer> result = new ArrayList<>();

        while (!priorityQueue.isEmpty()) {
            result.add(priorityQueue.poll().tweetId);
        }

        Collections.reverse(result);
        return result;
    }

    private void addToQueue(PriorityQueue<Post> priorityQueue, Integer follower) {
        List<Post> posts = postsMap.getOrDefault(follower, new ArrayList<>());
        List<Post> top10Posts = posts.subList(Math.max(0, posts.size() - 10), posts.size());
        for (Post post : top10Posts) {
            priorityQueue.add(post);
            if (priorityQueue.size() == 11) {
                priorityQueue.poll();
            }
        }
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        Set<Integer> followees = followeeMap.computeIfAbsent(followerId, k -> new HashSet<>());
        followees.add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees = followeeMap.computeIfAbsent(followerId, k -> new HashSet<>());
        followees.remove(followeeId);
    }

    private class Post {
        private int tweetId;
        private int sequence;

        private Post(int tweetId, int sequence) {
            this.tweetId = tweetId;
            this.sequence = sequence;
        }
    }
}

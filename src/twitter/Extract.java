package twitter;

import java.util.List;

import java.time.Instant;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

//buggy implementation 
//public static Set<String> getMentionedUsers(List<Tweet> tweets) {
//    Set<String> mentionedUsers = new HashSet<>();
//    
//    for (Tweet tweet : tweets) {
//        String[] words = tweet.getText().split("\\s+");
//        for (String word : words) {
//            if (word.startsWith("@")) {
//                // Bug: Not checking for invalid characters before or after the username.
//                String mention = word.substring(1).toLowerCase();
//                mentionedUsers.add(mention);
//            }
//        }
//    }
//
//    return mentionedUsers;
//}
//public static Timespan getTimespan(List<Tweet> tweets) {
//    if (tweets.isEmpty()) {
//        return null;
//    }
//
//    Instant start = tweets.get(0).getTimestamp();
//    Instant end = start;  // Incorrect logic: end should be updated independently of start.
//
//    for (Tweet tweet : tweets) {
//        Instant tweetTime = tweet.getTimestamp();
//        if (tweetTime.isBefore(start)) {
//            start = tweetTime;
//        }
//        end = start;  // Bug: This overwrites the correct end value.
//    }
//
//    return new Timespan(start, end);
//}

//implementation 1
//public static Timespan getTimespan(List<Tweet> tweets) {
//    if (tweets.isEmpty()) {
//        return null;
//    }
//
//    Instant start = tweets.get(0).getTimestamp();
//    Instant end = start;
//
//    for (Tweet tweet : tweets) {
//        Instant tweetTime = tweet.getTimestamp();
//        if (tweetTime.isBefore(start)) {
//            start = tweetTime; 
//        } else if (tweetTime.isAfter(end)) {
//            end = tweetTime;
//        }
//    }
//
//    return new Timespan(start, end);
//}
//
//public static Set<String> getMentionedUsers(List<Tweet> tweets) {
//    Set<String> mentionedUsers = new HashSet<>();
//    
//    for (Tweet tweet : tweets) {
//        String[] words = tweet.getText().split("\\s+");
//        for (String word : words) {
//            if (word.startsWith("@") && word.length() > 1) {
//                String mention = word.substring(1).toLowerCase(); // remove '@' and normalize to lowercase
//                mentionedUsers.add(mention);
//            }
//        }
//    }
//
//    return mentionedUsers;
//}

//implementation 2
//public class Extract {
//
//	public static Timespan getTimespan(List<Tweet> tweets) {
//        if (tweets.isEmpty()) {
//            return null;
//        }
//
//        Instant start = tweets.get(0).getTimestamp();
//        Instant end = start;
//
//        for (Tweet tweet : tweets) {
//            Instant tweetTime = tweet.getTimestamp();
//            if (tweetTime.isBefore(start)) {
//                start = tweetTime;
//            }
//            if (tweetTime.isAfter(end)) {
//                end = tweetTime;
//            }
//        }
//
//        return new Timespan(start, end);
//    }
//
//    public static Set<String> getMentionedUsers(List<Tweet> tweets) {
//        Set<String> mentionedUsers = new HashSet<>();
//
//        tweets.forEach(tweet -> {
//            String[] words = tweet.getText().split("\\s+");
//            for (String word : words) {
//                if (word.startsWith("@") && word.length() > 1) {
//                    String mention = word.substring(1).toLowerCase();
//                    mentionedUsers.add(mention);
//                }
//            }
//        });
//
//        return mentionedUsers;
//    }}

//implementation 3
public class Extract {

	public static Timespan getTimespan(List<Tweet> tweets) {
        if (tweets.isEmpty()) {
            return null;
        }

        Instant start = tweets.get(0).getTimestamp();
        Instant end = start;

        for (Tweet tweet : tweets) {
            Instant tweetTime = tweet.getTimestamp();
            if (tweetTime.isBefore(start)) {
                start = tweetTime;
            }
            if (tweetTime.isAfter(end)) {
                end = tweetTime;
            }
        }

        return new Timespan(start, end);
    }

    public static Set<String> getMentionedUsers(List<Tweet> tweets) {
        Set<String> mentionedUsers = new HashSet<>();

        tweets.forEach(tweet -> {
            String[] words = tweet.getText().split("\\s+");
            for (String word : words) {
                if (word.startsWith("@") && word.length() > 1) {
                    String mention = word.substring(1).toLowerCase();
                    mentionedUsers.add(mention);
                }
            }
        });

        return mentionedUsers;
    }}

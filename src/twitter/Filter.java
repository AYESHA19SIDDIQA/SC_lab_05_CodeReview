package twitter;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

//buggy code:
//
//public static List<Tweet> writtenBy(List<Tweet> tweets, String author) {
//    List<Tweet> result = new ArrayList<>();
//    for (Tweet tweet : tweets) {
//        if (tweet.getAuthor().equalsIgnoreCase(author)) { // Bug: This should be case-sensitive
//            result.add(tweet);
//        }
//    }
//    return result;
//}
//
//// Bug: Incorrectly checks for timespan
//public static List<Tweet> inTimespan(List<Tweet> tweets, Timespan timespan) {
//    List<Tweet> result = new ArrayList<>();
//    for (Tweet tweet : tweets) {
//        if (tweet.getTimestamp().isBefore(timespan.getStart()) || tweet.getTimestamp().isAfter(timespan.getEnd())) { // Bug: Should use inclusive bounds
//            continue;
//        }
//        result.add(tweet);
//    }
//    return result;
//}
//public static List<Tweet> containing(List<Tweet> tweets, List<String> keywords) {
//    List<Tweet> result = new ArrayList<>();
//    for (Tweet tweet : tweets) {
//        for (String keyword : keywords) {
//            if (tweet.getText().contains(keyword)) { // Use the correct method name
//                result.add(tweet);
//                break; // Avoid adding the same tweet multiple times
//            }
//        }
//    }
//    return;
//}
// var 1
//public class Filter {
//
//    public static List<Tweet> writtenBy(List<Tweet> tweets, String username) {
//        if (tweets.isEmpty()) return new ArrayList<>();
//        List<Tweet> result = new ArrayList<>();
//        for (Tweet tweet : tweets) {
//            if (tweet.getAuthor().equals(username)) {
//                result.add(tweet);
//            }
//        }
//        return result;
//    }
//
//    public static List<Tweet> inTimespan(List<Tweet> tweets, Timespan timespan) {
//        if (tweets.isEmpty()) return new ArrayList<>();
//        List<Tweet> result = new ArrayList<>();
//        for (Tweet tweet : tweets) {
//            if (timespan.contains(tweet.getTimestamp())) {
//                result.add(tweet);
//            }
//        }
//        return result;
//    }
//
//    public static List<Tweet> containing(List<Tweet> tweets, List<String> words) {
//        if (tweets.isEmpty() || words.isEmpty()) return new ArrayList<>();
//        List<Tweet> result = new ArrayList<>();
//        for (Tweet tweet : tweets) {
//            String tweetText = tweet.getText().toLowerCase();
//            for (String word : words) {
//                if (tweetText.contains(word.toLowerCase())) {
//                    result.add(tweet);
//                    break;
//                }
//            }
//        }
//        return result;
//    }
//}
//ver 2
//public class Filter {
//
//    public static List<Tweet> writtenBy(List<Tweet> tweets, String username) {
//        if (tweets.isEmpty()) return new ArrayList<>();
//        List<Tweet> result = new ArrayList<>();
//        for (Tweet tweet : tweets) {
//            if (tweet.getAuthor().equals(username)) {
//                result.add(tweet);
//            }
//        }
//        return result;
//    }
//
//    public static List<Tweet> inTimespan(List<Tweet> tweets, Timespan timespan) {
//        if (tweets.isEmpty()) return new ArrayList<>();
//        List<Tweet> result = new ArrayList<>();
//        for (Tweet tweet : tweets) {
//            if (timespan.contains(tweet.getTimestamp())) {
//                result.add(tweet);
//            }
//        }
//        return result;
//    }
//
//    public static List<Tweet> containing(List<Tweet> tweets, List<String> words) {
//        if (tweets.isEmpty() || words.isEmpty()) return new ArrayList<>();
//        List<Tweet> result = new ArrayList<>();
//        for (Tweet tweet : tweets) {
//            String tweetText = tweet.getText().toLowerCase();
//            for (String word : words) {
//                if (tweetText.contains(word.toLowerCase())) {
//                    result.add(tweet);
//                    break;
//                }
//            }
//        }
//        return result;
//    }
//}
//ver 3
import java.util.regex.Pattern;

public class Filter {

    public static List<Tweet> writtenBy(List<Tweet> tweets, String username) {
        List<Tweet> result = new ArrayList<>();
        for (Tweet tweet : tweets) {
            if (tweet.getAuthor().equals(username)) {
                result.add(tweet);
            }
        }
        return result;
    }

    public static List<Tweet> inTimespan(List<Tweet> tweets, Timespan timespan) {
        List<Tweet> result = new ArrayList<>();
        for (Tweet tweet : tweets) {
            if (timespan.contains(tweet.getTimestamp())) {
                result.add(tweet);
            }
        }
        return result;
    }

    public static List<Tweet> containing(List<Tweet> tweets, List<String> words) {
        List<Tweet> result = new ArrayList<>();
        for (Tweet tweet : tweets) {
            String tweetText = tweet.getText().toLowerCase();
            for (String word : words) {
                String regex = "\\b" + Pattern.quote(word.toLowerCase()) + "\\b";
                if (Pattern.compile(regex).matcher(tweetText).find()) {
                    result.add(tweet);
                    break;
                }
            }
        }
        return result;
    }
}



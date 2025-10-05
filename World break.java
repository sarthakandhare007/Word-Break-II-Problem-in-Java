import java.util.*;

public class WordBreakII {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Map<String, List<String>> memo = new HashMap<>();
        return helper(s, wordSet, memo);
    }

    private List<String> helper(String s, Set<String> wordSet, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) return memo.get(s);
        List<String> result = new ArrayList<>();

        // Base case
        if (s.length() == 0) {
            result.add("");
            return result;
        }

        for (String word : wordSet) {
            if (s.startsWith(word)) {
                String remaining = s.substring(word.length());
                List<String> subList = helper(remaining, wordSet, memo);

                for (String sub : subList) {
                    if (sub.isEmpty()) result.add(word);
                    else result.add(word + " " + sub);
                }
            }
        }

        memo.put(s, result);
        return result;
    }

    // Main method for testing
    public static void main(String[] args) {
        WordBreakII obj = new WordBreakII();
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        System.out.println(obj.wordBreak(s, wordDict));
    }
}

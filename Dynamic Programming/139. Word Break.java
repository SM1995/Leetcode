public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakRecur(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }

    private boolean wordBreakRecur(String s, Set<String> wordDict, int start, Boolean[] out) {
        if (start == s.length()) {
            return true;
        }
        if(out[start]!=null) return out[start];
        
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreakRecur(s, wordDict, end, out)) {
                return out[start] = true;
            }
        }
        return out[start] = false;
    }
}

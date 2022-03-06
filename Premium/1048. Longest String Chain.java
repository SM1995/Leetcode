class Solution {
    
    HashMap<String, Integer> hmap = new HashMap<>();
    HashSet<String> wordList = new HashSet<>();
    
    public int longestStrChain(String[] words) {
        for(String word:words){
            wordList.add(word);
        }
        
        System.out.println(wordList);
        
        int maxC = 0;
        for(String word: words){
            maxC = Math.max(count(word), maxC);
            //System.out.println(curr + " " + word);
        }
        
        return maxC;
    }
    
    public int count(String words){
        
        if(hmap.containsKey(words)) return hmap.get(words);
        
        int out = 1;
        StringBuilder sb = new StringBuilder(words);
        
        for(int i=0;i<words.length();i++){
            String check = sb.deleteCharAt(i).toString();
            
            if(wordList.contains(check)){
                int value = 1+ count(check);
                out = Math.max(value, out);
            }            
            sb.insert(i,words.charAt(i));
            
        }
        hmap.put(words, out);
        
        return out;
        
    }
}

/*

Solution
Overview
A word chain is a sequence of words (word1 -> word2 -> word3 -> word4 -> word5......) such that word1 is a predecessor of word2 and so on. A key point in the problem statement is that word1 can be a predecessor of word2 if and only if we can add exactly one letter anywhere in word1 to make it equal to word2. In other words, word2 should have one letter more than word1 and the position of this new letter can be anywhere. Note that the order of the words in the list does not need to be maintained while creating the word sequence.

Suppose that word1 is ab then word2 can be ab*, a*b, *ab where * is any lowercase English letter.

Therefore, it is possible for a particular word to have more than one predecessor in the given list, and thus belong to more than one word sequence. Our objective is to determine the length of the longest possible word sequence.

Let us consider the following example : ['abcd','abc','bcd','abd','ab','ad','b'] In this list, the immediate predecessors of abcd are ['abc','bcd','abd'] as all these words are missing exactly one letter from the word abcd. Similarly, the immediate predecessors of abd are ['ab','ad'] and the predecessor of ab is ['b'].


Approach 1: Top-Down Dynamic Programming (Recursion + Memoization)
Intuition

If you're not familiar with DFS (Depth First Search), check out our Explore Card.

Here we work backwards to find the longest chain, this means that we will start from a word and delete one character at a time. We continue this chain until we come across a word that is not present in the list or is one letter long.

In the above example some of the possible word sequences are: abcd -> abd -> ab -> b , abcd -> abc -> ab -> b , abcd -> bcd and so on. The possible word sequences are illustrated in Figure 1.

fig

Figure 1. Figure demonstrating DFS to find the longest word sequence.

In this graph, we can observe that the length of the longest possible word sequence is 4. There are two word sequences that have the longest length : abcd -> abd -> ab -> b and abcd -> abc -> ab -> b. (The longest path is shown in the diagram with red arrows).

Notice that a particular sequence can be a part of more than one word sequence. For example the sequence ab -> b is part of both the following sequences : abcd -> abd -> ab -> b and abcd -> abc -> ab -> b. This leads to repeated calculations because every time we encounter ab we need to explore the subpath ab -> a. For a small list, this is not a problem but as the size of the list increases, the size of the graph grows exponentially.

What we can do is whenever we encounter a new word, we will find all possible sequences with this word as the last word in the sequence. Then, we will store the length of the longest possible sequence that ends with this word.

We will use a map for this where each key will be an ending word and the value will be the length of the longest possible word sequence ending with this word. In the above example when we first encounter the word ab we will store the value 2 (word sequence ab -> b) for key ab. The next time we encounter ab, we will simply return the value stored against it in the map instead of going through the entire subtree again. This process is known as memoization and it prevents recalculation. For every word present in the list, we only need to determine the length of the longest path that ends with this word once.

Algorithm

Initialize a set (wordsPresent) and add all the words in the list to the set. This set will be used to check if a word is present in the list.

Initialize a map (memo) having key type as String and value type as Integer. This map will store the length of the longest possible word sequence where the key is the last word in the sequence.

Iterate over the list. For each word in the list perform a depth-first search.

In the DFS, consider the current word (currentWord) as the last word in the word sequence.

If currentWord was encountered previously we just return its corresponding value in the map memo.

Initialize maxLength to 1.

Iterate over the entire length of the currentWord.

Create all possible words (newWord) by taking out one character at a time.
If newWord is present in the set perform a DFS with this word and store the intermediate result in a variable currentLength.
Update the maxLength so that it contains the length of the longest sequence possible where the currentWord is the end word.
Set the maxLength as the value for currentWord (key) in the map.

Return maxLength.

Implementation


class Solution {

    private int dfs(Set<String> words, Map<String, Integer> memo, String currentWord) {
        // If the word is encountered previously we just return its value present in the map (memoization).
        if (memo.containsKey(currentWord)) {
            return memo.get(currentWord);
        }
        // This stores the maximum length of word sequence possible with the 'currentWord' as the
        int maxLength = 1;
        StringBuilder sb = new StringBuilder(currentWord);

        // creating all possible strings taking out one character at a time from the `currentWord`
        for (int i = 0; i < currentWord.length(); i++) {
            sb.deleteCharAt(i);
            String newWord = sb.toString();
            // If the new word formed is present in the list, we do a dfs search with this newWord.
            if (words.contains(newWord)) {
                int currentLength = 1 + dfs(words, memo, newWord);
                maxLength = Math.max(maxLength, currentLength);
            }
            sb.insert(i, currentWord.charAt(i));
        }
        memo.put(currentWord, maxLength);

        return maxLength;
    }

    public int longestStrChain(String[] words) {
        Map<String, Integer> memo = new HashMap<>();
        Set<String> wordsPresent = new HashSet<>();
        Collections.addAll(wordsPresent, words);
        int ans = 0;
        for (String word : words) {
            ans = Math.max(ans, dfs(wordsPresent, memo, word));
        }
        return ans;
    }
}

Complexity Analysis

Let NN be the number of words in the list and LL be the maximum possible length of a word.

Time complexity: O(L ^ 2 \cdot N)O(L 
2
 ⋅N).

Initially, we iterate over the list to store all the given words in a set (adds NN to the complexity).

Next, we perform a DFS for each word (O(N)O(N)). For each word, we iterate over its length(O(L)O(L)). At each index (i) we create a new word by deleting the character at position i from the original word (O(L)O(L)). Therefore, the overall time complexity is O(N + (L ^ 2 \cdot N))O(N+(L 
2
 ⋅N)) = O(L ^ 2 \cdot N))O(L 
2
 ⋅N)), because the NN term is insignificant relative to the L ^ 2 \cdot NL 
2
 ⋅N term. Note that because of memoization we can be sure that each word in the list is traversed only once.

Space complexity: O(N)O(N).

The extra space is used by the recursion call stack. In worst case all the words are a part of the longest word sequence which requires a recursion stack size of NN.

Also, we use a set to store all distinct words (size NN) and a map to store intermediate results (size NN). Since the maximum number of distinct words will be NN (when there is no repetition) the overall space complexity is O(2 \cdot N)O(2⋅N) which in Big O notation equals O(N)O(N).


Approach 2: Bottom-Up Dynamic Programming
Intuition

In this solution, we will create the word sequence by adding one letter at a time to the last word in the sequence. Thus the resulting word sequence will be a series of words where each word has one more letter than its predecessor.

If we know the length (previousLength) of the longest word sequence that ends with a word we can use this value to find the length of the longest word sequence for its successor(newLength = previousLength + 1).

Let us again consider the above example ['abcd','abc','bcd','abd','ab','ad','b']. The longest word sequence with the word b is 1. Thus the length of the longest word sequence with the word ab will be 1 + 1 = 2 (ab -> b). This result can in turn be used to find the length of the longest word sequence for the word abc (2 + 1 = 3 for sequence abc -> ab -> b).

The length of the words in a sequence increases as we move from left to right. Also, we know that the order of the words in the list doesn't matter. So we can sort the words in ascending order based on their length. Next, we can iterate over the sorted list and calculate the length of the longest sequence possible where the word at index ii is the end word. We store this result in a map where key is the word and value is the sequence length. By doing this we ensure that, for each word that we encounter, we already know the result of all of its possible predecessors. This process is demonstrated in the following animation.

Current
1 / 9

Algorithm

Initialize a map where key is the word and value is the length of the longest word sequence possible with the key as the end word.

Sort the word list in increasing order of the word length.

Initialize longestWordSequenceLength to 1. This variable holds the length of the longest word sequence possible.

Iterate over the sorted list.

For each word initialize presentLength to 1.

Iterate over the entire length of each word.

Delete the character at i^{th}i 
th
  position from the current word and assign the new word to the variable predecessor.
Check if predecessor is present in the list or not.
If the predecessor is present, then assign its mapped value to previousLength. Update the presentLength if previousLength + 1 is greater than the presentLength.
After terminating the inner for loop, assign presentLength to the current word in the map dp.

Update the longestWordSequenceLength if the longest word sequence formed with the current word as the end word is longer than the previously considered word sequence.

After terminating the outer for loop, return longestWordSequenceLength.

Implementation


class Solution {
    public int longestStrChain(String[] words) {
        Map<String, Integer> dp = new HashMap<>();

        // Sorting the list in terms of the word length.
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int longestWordSequenceLength = 1;

        for (String word : words) {
            int presentLength = 1;
            // Find all possible predecessors for the current word by removing one letter at a time.
            for (int i = 0; i < word.length(); i++) {
                StringBuilder temp = new StringBuilder(word);
                temp.deleteCharAt(i);
                String predecessor = temp.toString();
                int previousLength = dp.getOrDefault(predecessor, 0);
                presentLength = Math.max(presentLength, previousLength + 1);
            }
            dp.put(word, presentLength);
            longestWordSequenceLength = Math.max(longestWordSequenceLength, presentLength);
        }
        return longestWordSequenceLength;
    }
}

Complexity Analysis

Let NN be the number of words in the list and LL be the maximum possible length of a word.

Time complexity: O(N \cdot (\log N + L ^ 2))O(N⋅(logN+L 
2
 )).

Sorting a list of size NN takes O(N \log N)O(NlogN) time. Next, we use two for loops in which the outer loop runs for O(N)O(N) iterations and the inner loop runs for O(L ^ 2)O(L 
2
 ) iterations in the worst case scenario. The first LL is for the inner loop and the second LL is for creating each predecessor. Thus the overall time complexity is O(N \log N + (N \cdot L ^ 2))O(NlogN+(N⋅L 
2
 )) which equals O(N \cdot (\log N + L ^ 2))O(N⋅(logN+L 
2
 )).

Space complexity: O(N)O(N).

We use a map to store the length of the longest sequence formed with each of the NN words as the end word.

*/

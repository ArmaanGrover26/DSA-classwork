import java.util.*;
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>(wordList);

        // If endWord is not present, transformation is impossible
        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            // Process one level at a time
            for (int i = 0; i < size; i++) {

                String word = queue.poll();

                char[] arr = word.toCharArray();

                // Try changing every character
                for (int j = 0; j < arr.length; j++) {

                    char original = arr[j];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        if (ch == original) {
                            continue;
                        }

                        arr[j] = ch;

                        String newWord = new String(arr);

                        // We found the target
                        if (newWord.equals(endWord)) {
                            return level + 1;
                        }

                        // If this word exists and hasn't been visited
                        if (set.contains(newWord)) {
                            queue.offer(newWord);
                            set.remove(newWord);
                        }
                    }

                    // Restore original character
                    arr[j] = original;
                }
            }

            level++;
        }

        return 0;
    }
}

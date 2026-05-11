class Solution {

    public boolean checkIfPangram(String sentence) {

        boolean[] seen = new boolean[26];

        for (char c : sentence.toCharArray()) {
            seen[c - 'a'] = true;
        }

        for (boolean exists : seen) {
            if (!exists) {
                return false;
            }
        }

        return true;
    }
}

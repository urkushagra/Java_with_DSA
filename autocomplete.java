class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;
}

public class Autocomplete {
    private TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) node.children[c - 'a'] = new TrieNode();
            node = node.children[c - 'a'];
        }
        node.isEndOfWord = true;
    }

    private void dfs(TrieNode node, String prefix, List<String> res) {
        if (node.isEndOfWord) res.add(prefix);
        for (char c = 'a'; c <= 'z'; c++) {
            if (node.children[c - 'a'] != null) dfs(node.children[c - 'a'], prefix + c, res);
        }
    }

    public List<String> autocomplete(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.children[c - 'a'] == null) return new ArrayList<>();
            node = node.children[c - 'a'];
        }
        List<String> res = new ArrayList<>();
        dfs(node, prefix, res);
        return res;
    }

    public static void main(String[] args) {
        Autocomplete ac = new Autocomplete();
        ac.insert("apple"); ac.insert("app"); ac.insert("ape"); ac.insert("bat");
        System.out.println(ac.autocomplete("ap"));
    }
}

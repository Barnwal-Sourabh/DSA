package TriesAndHuffman;

public class TrieUse {
    
    public static void main(String[] args) {
        Trie t = new Trie();
        t.add("bat");
        t.add("this");
        t.add("news");

        System.out.println(t.search("bat"));
        t.remove("bat");
        System.out.println(t.search("bat"));
    }
}

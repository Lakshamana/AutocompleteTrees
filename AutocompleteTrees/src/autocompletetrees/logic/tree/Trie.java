package autocompletetrees.logic.tree;

public class Trie implements ITree{
    private TrieNode root;

    public TrieNode getRoot() {
        return root;
    }
    
    public Trie(){
        root = new TrieNode(' '); 
    }

    @Override
    public void inserir(String word){   
        TrieNode current = root; 
        for (char ch : word.toCharArray()){
            TrieNode child = current.subNode(ch);
            if (child != null)
                current = child;
            else {
                 current.getChildren().add(new TrieNode(ch));
                 current = current.subNode(ch);
            }
            current.setCount(1 + current.getCount());
        }
        current.setCountRepeat(1 + current.getCountRepeat());
        current.setIsEnd(true);
    }
    
    /* Função de busca de uma palavra */
    @Override
    public int existe(String word){
        TrieNode current = root;  
        for (char ch : word.toCharArray()){
            if (current.subNode(ch) == null)
                return 0;
            else
                current = current.subNode(ch);
        }      
        if (current.isEnd == true) 
            return current.countRepeat;
        return 0;
    }

    @Override
    public void remover(String word){
        if (existe(word) == 0){
            System.out.println(word + " não existe!!!\n");
            return;
        }             
        TrieNode current = root;
        for (char ch : word.toCharArray()) { 
            TrieNode child = current.subNode(ch);
            if (child.count == 1) {
                current.childList.remove(child);
                return;
            } 
            else {
                child.count--;
                current = child;
            }
        }
        current.isEnd = false;
    }

    @Override
    public String getPalavra(String w) {
        return (existe(w) != 0) ? w : null;
    }
}
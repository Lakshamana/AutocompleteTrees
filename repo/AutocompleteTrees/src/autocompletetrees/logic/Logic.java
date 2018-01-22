package autocompletetrees.logic;

import autocompletetrees.logic.tree.Trie;
import autocompletetrees.logic.tree.TrieNode;
import java.util.LinkedList;
import java.util.Scanner;

public class Logic {

    LinkedList<String> list = new LinkedList<>();

    public void getTodasAsPalavras(TrieNode no, String name) {
        if (no.getIsEnd()) 
            list.add(name);
        for (TrieNode filho : no.getChildren()) {
            String filhoName = Character.toString(filho.getContent());
            getTodasAsPalavras(filho, name + filhoName);
        }
    }

    public LinkedList<String> getList() {
        return list;
    }

    public void list(LinkedList<String> ls) {
        for (String s : ls) {
            System.out.println(s);
        }
        System.out.println("");
    }

    public LinkedList<String> matchPalavras(String s, LinkedList<String> l) {
        LinkedList<String> matchList = new LinkedList<>();
        if (s.length() >= 3) {
            s += ".*";
            for (String str : l) 
                if (str.matches(" " + s)) 
                    matchList.add(str);
        }
        return matchList;
    }
    
    public void addPalavra(Trie t){
        Scanner sc = new Scanner(System.in);
        String P = sc.next();
        
        t.inserir(P);
        this.list.add(P);
    }
    
    public void rmvPalavra(Trie t){
        Scanner sc = new Scanner(System.in);
        String P = sc.next();
        
        if(t.existe(P)==0){
            System.err.println("A palavra "+P+" não está listada!");
        }else {
            t.remover(P);
            this.list.remove(P);
        }
    }
    
    public void printPalavra(TrieNode t){
        this.list(this.getList());
    }
    
    public void searchPalavra(){
        Scanner sc = new Scanner(System.in);
        String P = sc.next();
        
        this.list(this.matchPalavras(P, this.getList()));
    }
}

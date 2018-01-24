package autocompletetrees.logic;

import autocompletetrees.gui.Menu;
import autocompletetrees.logic.tree.Trie;
import autocompletetrees.logic.tree.TrieNode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Logic {

    Menu m = new Menu();
    Map<String, Integer> list = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    
    public void getTree(TrieNode no, String name) {
        for (TrieNode filho : no.getChildren()) {
            System.out.println(name + filho.getContent());
            getTree(filho, name + filho.getContent());
        }
    }

    public Map<String, Integer> getList() {
        return list;
    }

    public void list(Map<String, Integer> ls) {
        Set<String> chaves = ls.keySet();
        for(Iterator<String> iterator = chaves.iterator();iterator.hasNext();){
            String chave = iterator.next();
            if(chave!=null){
                System.out.println("+"+chave);
            }
        }   
    }
    
    public void listCount() {
        Set<String> chaves = list.keySet();
        for(Iterator<String> iterator = chaves.iterator();iterator.hasNext();){
            String chave = iterator.next();
            if(chave!=null){
                System.out.println("+"+chave+"("+list.get(chave)+")");
            }
        } 
    }

    public Map<String, Integer> matchPalavras(String s, Map<String, Integer> l) {
        Map<String, Integer> matchList = new HashMap<>();
        if (s.length() >= 3) {
            s += ".*";
            for (String str : l.keySet()) 
                if (str.matches(s)) 
                    matchList.put(str,null);
        }
        return matchList;
    }

    public void addPalavra(Trie t) {
        m.inserirPalavraMenu();
        String P = sc.next();
        if(this.getList().containsKey(P)==true){
            this.getList().put(P, this.getList().get(P)+1);
        }else{    
        t.inserir(P);
        this.getList().put(P,1);
        }
    }

    public void rmvPalavra(Trie t) {
        m.removerPalavraMenu();
        String P = sc.next();
        if (t.existe(P) == 0) {
            System.err.println("\nA palavra " + P + " não está listada!");
        } else if (list.isEmpty()) {
            System.err.println("\nNão existem palavras no dicionário!");
        } else {
            if(this.getList().get(P)==1){
                t.remover(P);
                this.getList().remove(P);
            }else if(this.getList().get(P)>1){
                this.getList().put(P, this.getList().get(P)-1);
            }
            
        }
    }

    public void printPalavras() {
        if (!list.isEmpty()) {
            System.out.println("\nMostrando todas as palavras:");
            this.list(this.list);
        } else 
            System.err.println("\nNão existem palavras no dicionário!");
    }

    public void searchPalavra() {
        m.buscarPalavraMenu();
        String P = sc.next();
        if (matchPalavras(P, this.getList()).isEmpty()) 
            System.err.printf("\nNão foram encontradas palavras com o radical \"%s\"\n!", P);
        else if (list.isEmpty()) 
            System.err.println("\nNão existem palavras no dicionário!");
        else {
            this.list(this.matchPalavras(P, this.getList()));
            }
    }
    
    public void showRadicais(TrieNode no){
        System.out.println("\nMostrando todos os caminhos:");
        getTree(no, Character.toString(no.getContent()));
    }
}

package autocompletetrees.logic;

import autocompletetrees.gui.Menu;
import autocompletetrees.logic.tree.Trie;
import autocompletetrees.logic.tree.TrieNode;
import java.util.LinkedList;
import java.util.Scanner;

public class Logic {

    Menu m = new Menu();
    LinkedList<String> list = new LinkedList<>();
    Scanner sc = new Scanner(System.in);
    
    public void getTree(TrieNode no, String name) {
        for (TrieNode filho : no.getChildren()) {
            System.out.println(name + filho.getContent());
            getTree(filho, name + filho.getContent());
        }
    }

    public LinkedList<String> getList() {
        return list;
    }

    public void list(LinkedList<String> ls) {
        for (String s : ls) {
            System.out.println("-" + s);
        }
        System.out.println("");
    }

    public LinkedList<String> matchPalavras(String s, LinkedList<String> l) {
        LinkedList<String> matchList = new LinkedList<>();
        if (s.length() >= 3) {
            s += ".*";
            for (String str : l) 
                if (str.matches(s)) 
                    matchList.add(str);
        }
        return matchList;
    }

    public void addPalavra(Trie t) {
        m.inserirPalavraMenu();
        String P = sc.next();
        t.inserir(P);
        list.add(P);
    }

    public void rmvPalavra(Trie t) {
        m.removerPalavraMenu();
        String P = sc.next();
        if (t.existe(P) == 0) {
            System.err.println("\nA palavra " + P + " não está listada!");
        } else if (list.isEmpty()) {
            System.err.println("\nNão existem palavras no dicionário!");
        } else {
            t.remover(P);
            this.list.remove(P);
        }
    }

    public void printPalavras(TrieNode t) {
        if (!list.isEmpty()) {
            System.out.println("\nMostrando todas as palavras:");
            this.list(this.getList());
        } else 
            System.err.println("\nNão existem palavras no dicionário!");
    }

    public void searchPalavra(Trie t) {
        m.buscarPalavraMenu();
        String P = sc.next();
        if (matchPalavras(P, list).isEmpty()) 
            System.err.printf("\nNão foram encontradas palavras com o radical \"%s\"\n!", P);
        else if (list.isEmpty()) 
            System.err.println("\nNão existem palavras no dicionário!");
         else 
            this.list(this.matchPalavras(P, list));
    }
    
    public void showRadicais(TrieNode no){
        System.out.println("\nMostrando todos os caminhos:");
        getTree(no, Character.toString(no.getContent()));
    }
}
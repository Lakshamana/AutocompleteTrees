package autocompletetrees;

import autocompletetrees.gui.Menu;
import autocompletetrees.logic.Logic;
import autocompletetrees.logic.tree.Trie;
import autocompletetrees.logic.tree.TrieNode;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu m = new Menu();
        Logic l = new Logic();
        Trie t = new Trie();
        Scanner sc = new Scanner(System.in);
        int op;
        System.out.println("Autocomplete Trees =)");
        //Do case 1 pra baixo, chamar da classe Logic
        do {
            op = m.menuEntrada(sc);
            switch(op) {
                case 0:
                    m.exit();
                    break;
                case 1:
                    m.inserirPalavraMenu();
                    l.addPalavra(t);
                    break;
                case 2:
                    m.removerPalavraMenu();
                    l.rmvPalavra(t);
                    break;
                case 3:
                    m.buscarPalavraMenu();
                    l.searchPalavra();
                    break;
                case 4:
                    TrieNode root = t.getRoot();
                    l.printPalavra(root);
                    break;
                default:
                    break;
            }
        } while(op != 0);
//        System.out.println("Mostrando caminhos:");
//        t.inserir("bola");
//        t.inserir("bolinha");
//        t.inserir("bolo");
//        t.inserir("bolor");
//        t.inserir("bolorado");
//        t.inserir("barulho");
//        t.inserir("belem");
//        t.inserir("casa");
//        t.inserir("deserto");
//        TrieNode root = t.getRoot();
//        String s = Character.toString(root.getContent());
//        l.getTodasAsPalavras(root, s);
//        l.list(l.getList());
//        l.list(l.matchPalavras("b", l.getList()));
    }
}

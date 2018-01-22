package autocompletetrees;

import autocompletetrees.gui.Menu;
import autocompletetrees.logic.Logic;
import autocompletetrees.logic.tree.Trie;
import autocompletetrees.logic.tree.TrieNode;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu m = new Menu();
        Trie t = new Trie();
        Logic l = new Logic();
        TrieNode root = t.getRoot();
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
                    l.addPalavra(t);
                    break;
                case 2:
                    l.rmvPalavra(t);
                    break;
                case 3:
                    l.searchPalavra(t);
                    break;
                case 4:
                    l.printPalavras(root);
                    break;
                case 5:
                    l.showRadicais(root);
                    break;
                default:
                    m.dispararErro();
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
//        String s = Character.toString(root.getContent());
//        l.getTree(root, s);
//        l.list(l.getList());
//        l.list(l.matchPalavras("b", l.getList()));
    }
}

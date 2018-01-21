package autocompletetrees.logic;

import autocompletetrees.logic.tree.TrieNode;
import java.util.LinkedList;

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
}

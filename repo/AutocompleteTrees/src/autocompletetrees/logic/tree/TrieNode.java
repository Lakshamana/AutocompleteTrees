package autocompletetrees.logic.tree;

import java.util.*;
/**
 *
 * @author 201604940041
 */

public class TrieNode implements INode<TrieNode> {
    char content; 
    boolean isEnd; 
    int count, countRepeat;  

    LinkedList<TrieNode> childList; 
    /* Constructor */
    public TrieNode(char c){
        childList = new LinkedList<>(); // LinkedList<TrieNode>
        isEnd = false;
        content = c;
        count = 0;
        countRepeat = 0;
    }  

    @Override
    public TrieNode subNode(char c){
        if (childList != null)
            for (TrieNode eachChild : childList)
                if (eachChild.content == c)
                    return eachChild;
        return null;
    }

    
    public char getContent() {
        return content;
    }

    public void setContent(char content) {
        this.content = content;
    }

    public boolean getIsEnd() {
        return isEnd;
    }

    public void setIsEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCountRepeat() {
        return countRepeat;
    }

    public void setCountRepeat(int countRepeat) {
        this.countRepeat = countRepeat;
    }

    @Override
    public LinkedList<TrieNode> getChildren() {
        return childList;
    }

    @Override
    public TrieNode subNode(String s) {
        throw new UnsupportedOperationException("Implementar somente subNode(Char)"); 
    }

    @Override
    public boolean isLeaf() {
        return getChildren().isEmpty();
    }
}
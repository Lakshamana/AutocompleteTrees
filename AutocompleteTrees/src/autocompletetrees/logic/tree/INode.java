package autocompletetrees.logic.tree;

import java.util.LinkedList;

public interface INode<T> {
    T subNode(char c);
    
    T subNode(String s);
    
    LinkedList<T> getChildren();
    
    boolean isLeaf();
}

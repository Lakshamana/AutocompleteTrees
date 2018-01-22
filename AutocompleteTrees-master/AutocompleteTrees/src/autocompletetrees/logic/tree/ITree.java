/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autocompletetrees.logic.tree;

public interface ITree {
    void inserir(String w);
    
    void remover(String w);
    
    int existe(String w);
    
    String getPalavra(String w);
}

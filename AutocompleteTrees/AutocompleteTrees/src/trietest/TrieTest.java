package trietest;

import autocompletetrees.logic.tree.Trie;
import java.util.Scanner;

/**
 *
 * @author 201604940041
 */
public class TrieTest{
    
    public static void main(String[] args){            
        Scanner scan = new Scanner(System.in);

        Trie t = new Trie(); 
        System.out.println("Trie Test\n");          
        char ch;

        do{
            System.out.println("\nTrie Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. delete");
            System.out.println("3. search");
 
            int choice = scan.nextInt();            
            switch (choice){
            case 1 : 
                System.out.println("Informe o elemento a ser Inserido:");
                t.inserir( scan.next() );                     
                break;                          
            case 2 : 
                System.out.println("Informe o elemento a ser Deletado:");
                try
                {
                    t.remover( scan.next() ); 
                }                    
                catch (Exception e)
                {
                    System.out.println(e.getMessage()+" not found ");
                }
                break;                         
            case 3 : 
                System.out.println("Enter string element to search");
                System.out.println("Search result : "+ t.existe(scan.next()));
                break;                                          
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
 
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');               
    }
}

package autocompletetrees.gui;

import java.util.Scanner;

public class Menu {
    public int menuEntrada(Scanner s){
        System.out.println("\nSelecione uma opção abaixo:");
        System.out.println("I. Inserir uma palavra\n"
                + "II. Deletar uma palavra\n"
                + "III. Buscar uma palavra\n"
                + "IV. Mostrar palavras no dicionário\n"
                + "0. Parar execução");
        return s.nextInt();
    }
    
    public void inserirPalavraMenu(){
        System.out.println("\nInsira uma palavra:");
    }
    
    public void removerPalavraMenu(){
        System.out.println("\nEscolha uma palavra para remover:");
    }
    
    public void buscarPalavraMenu(){
        System.out.println("\nEscolha uma palavra para buscar:");
    }
    
    public void exit(){
        System.out.println("\nSaindo...");
        System.exit(0);
    }
    
    public void dispararErro(){
        System.err.println("\nComando Inválido!\n"
                + "Por favor, tente outro.");
    }
}

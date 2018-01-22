package autocompletetrees.gui;

import java.util.Scanner;

public class Menu {
    public int menuEntrada(Scanner s){
        System.out.println("\nSelecione uma opção abaixo:");
        System.out.println("1. Inserir uma palavra\n"
                + "2. Deletar uma palavra\n"
                + "3. Buscar uma palavra\n"
                + "4. Mostrar palavras no dicionário\n"
                + "0. Parar execução");
        System.err.print("-Escolha a Opção:");    
        return s.nextInt();
    }
    
    public void inserirPalavraMenu(){
        System.err.print("\nInsira uma palavra:");
    }
    
    public void removerPalavraMenu(){
        System.err.print("\nEscolha uma palavra para remover:");
    }
    
    public void buscarPalavraMenu(){
        System.err.print("\nEscolha uma palavra para buscar:");
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

package autocompletetrees;

import autocompletetrees.gui.Menu;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu m = new Menu();
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
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    break;
            }
        } while(op != 0);
    }
}

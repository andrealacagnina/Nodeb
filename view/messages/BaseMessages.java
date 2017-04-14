package view.messages;

import java.util.Scanner;

/**
 * Created by utente on 13/04/2017.
 */
public class BaseMessages {

    Scanner consoleScanner = new Scanner(System.in);

    public BaseMessages() {

    }

    public void showWelcome(){

        System.out.println("Welcome! ");
        System.out.println("2 to play, 3 to learn, 4 to learnC, 5 to show, 6 to save, 7 to load, 1 to quit. ");
    }

    public void isNotInMap(){
        System.out.println("This node is not in map. ");
    }

    public String readMessage(){

        return consoleScanner.nextLine().replaceAll("\\s+$", "");
    }

    public String addNodeInputLearnEvent(){
        System.out.println("please insert node input string (or 1 to menu): ");
        return consoleScanner.nextLine().replaceAll("\\s+$", "");
    }

    public String addNodeOutputLearnEvent(){
        System.out.println("please insert node output string (or 1 to menu): ");
        return consoleScanner.nextLine().replaceAll("\\s+$", "");
    }

    public String showPreference(){
        System.out.println("please insert show preference: 2 to single node, 3 to all nodes (or 1 to menu): ");
        return consoleScanner.nextLine().replaceAll("\\s+$", "");
    }

    public String getNodeToShowEvent(){
        System.out.println("please insert node to show (or 1 to menu): ");
        return consoleScanner.nextLine().replaceAll("\\s+$", "");
    }

    public String learnCEvent(){
        System.out.println("(1 to menu) or >: ");
        return consoleScanner.nextLine().replaceAll("\\s+$", "");
    }

    public void notYetImplented(){
        System.out.println("not yet implented! ");
    }
}

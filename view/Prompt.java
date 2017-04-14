package view;

import view.messages.BaseMessages;

/**
 * Created by utente on 13/04/2017.
 */
public class Prompt {

    private static Prompt istance = null;
    BaseMessages baseMessage = new BaseMessages();

    public Prompt(){

    }

    public static synchronized Prompt getIstance() {

        if (istance == null) {
            istance = new Prompt();
        }

        return istance;
    }

    public void showMessage(String event){

        switch (event) {
            case "welcomeEvent":
                baseMessage.showWelcome();
                break;

            case "notYetImplented":
                baseMessage.notYetImplented();
                break;

            case "isNotInMap":
                baseMessage.isNotInMap();
                break;

            default:
                baseMessage.notYetImplented();
                break;
        }
    }

    public String showAndReadMessage(String event){

        String returnMessage = "";

        switch (event) {
            case "welcomeEvent":
                returnMessage = baseMessage.readMessage();
                break;

            case "addNodeInputLearnEvent":
                returnMessage = baseMessage.addNodeInputLearnEvent();
                break;

            case "addNodeOutputLearnEvent":
                returnMessage = baseMessage.addNodeOutputLearnEvent();
                break;

            case "showPreference":
                returnMessage = baseMessage.showPreference();
                break;

            case "getNodeToShowEvent":
                returnMessage = baseMessage.getNodeToShowEvent();
                break;

            case "learnCEvent":
                returnMessage = baseMessage.learnCEvent();
                break;

            default:
                baseMessage.notYetImplented();
                break;
        }

        return returnMessage;
    }
}

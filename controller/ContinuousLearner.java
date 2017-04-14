package controller;

import model.Map;
import model.Node;
import resources.EnumStatus;
import view.Prompt;

/**
 * Created by utente on 14/04/2017.
 */
public class ContinuousLearner {

    private static ContinuousLearner istance = null;

    EnumStatus statusValue;
    Map map;
    Prompt prompt;

    public ContinuousLearner() {
        map = Map.INSTANCE;
        prompt = Prompt.getIstance();
    }

    public static synchronized ContinuousLearner getIstance() {

        if (istance == null) {
            istance = new ContinuousLearner();
        }
        return istance;
    }

    public EnumStatus continuousLearn() {

        String returnedMessage = prompt.showAndReadMessage("learnCEvent");
        if(returnedMessage.equals("1")){
            return EnumStatus.WELCOME;
        }

        Node node;

        int returnedValue = map.isInMap(returnedMessage);

        if(returnedValue == -1){

            node = new Node();
            node.setValue(returnedMessage);
            map.addNode(node);
        }
        else{

            node = map.getNodeInList(returnedValue);
        }

        statusValue = learnC(node);

        return statusValue;
    }

    public EnumStatus learnC(Node previousNode){

        String returnedMessage = prompt.showAndReadMessage("learnCEvent");
        if(returnedMessage.equals("1")){
            return EnumStatus.WELCOME;
        }

        Node node;

        int returnedValue = map.isInMap(returnedMessage);

        if(returnedValue == -1){

            node = new Node();
            node.setValue(returnedMessage);
            map.addNode(node);
        }
        else{

            node = map.getNodeInList(returnedValue);
        }

        previousNode.addNeighbor(node);

        learnC(node);

        return EnumStatus.WELCOME;
    }


}

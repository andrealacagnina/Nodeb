package controller;

import model.Map;
import model.Node;
import resources.EnumStatus;
import view.Prompt;

/**
 * Created by utente on 14/04/2017.
 */
public class Learner {

    private static Learner istance = null;

    Map map;
    Prompt prompt;

    public Learner() {
        map = Map.INSTANCE;
        prompt = Prompt.getIstance();
    }

    public static synchronized Learner getIstance() {

        if (istance == null) {
            istance = new Learner();
        }
        return istance;
    }

    public EnumStatus learn() {

        String returnedFirstMessage = prompt.showAndReadMessage("addNodeInputLearnEvent");
        if(returnedFirstMessage.equals("1")){
            return EnumStatus.WELCOME;
        }
        int returnedFirstValue = map.isInMap(returnedFirstMessage);

        String returnedSecondMessage = prompt.showAndReadMessage("addNodeOutputLearnEvent");
        if(returnedSecondMessage.equals("1")){
            return EnumStatus.WELCOME;
        }
        int returnedSecondValue = map.isInMap(returnedSecondMessage);

        if(returnedFirstMessage.equals(returnedSecondMessage)){
            equivalence(returnedFirstMessage, returnedFirstValue);
            return EnumStatus.LEARN;
        }

        Node nInput = new Node(), nOutput = new Node();
        if(returnedFirstValue == -1){
            if(returnedSecondValue == -1){

                nInput.setValue(returnedFirstMessage);
                nOutput.setValue(returnedSecondMessage);

                nInput.addNeighbor(nOutput);

                map.addNode(nInput);
                map.addNode(nOutput);

                System.out.println("nodeInput and nodeOutput added in knowledge !");
            }
            else{

                nInput.setValue(returnedFirstMessage);
                nOutput = map.getNodeInList(returnedSecondValue);

                nInput.addNeighbor(nOutput);
                map.addNode(nInput);

                System.out.println("nodeInput added in knowledge, nodeOutput was in knowledge !");
            }
        }
        else{
            if(returnedSecondValue == -1){

                nInput = map.getNodeInList(returnedFirstValue);
                nOutput.setValue(returnedSecondMessage);

                nInput.addNeighbor(nOutput);
                map.addNode(nOutput);

                System.out.println("nodeOutput added in knowledge, nodeInput was in knowledge !");
            }
            else{

                nInput = map.getNodeInList(returnedFirstValue);
                nOutput = map.getNodeInList(returnedSecondValue);

                nInput.addNeighbor(nOutput);

                System.out.println("nodeOutput and nodeInput was in knowledge, bind done !");
            }
        }

        return EnumStatus.LEARN;
    }

    public void equivalence(String value, int index){

        Node n = new Node();

        if(index == -1){
            n.setValue(value);
            n.addNeighbor(n);
            map.addNode(n);
        }
        else{
            n = map.getNodeInList(index);
            n.addNeighbor(n);
        }

    }
}

package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by utente on 13/04/2017.
 */
public class Node implements java.io.Serializable {

    String value;
    private List<Node> list = new ArrayList<Node>();

    public Node(){}

    public void setValue(String value){

        this.value = value;
    }

    public void addNeighbor(Node n){

        if(isInList(n.value) == false) {
            list.add(n);
        }
    }

    public boolean isInList(String value){
        for(int i = 0; i < list.size(); i++){
            if(value.equals(list.get(i).value)) {
                return true;
            }
        }
        return false;
    }

    public void stampNode() {

        String returned = "node: " + this.value + " < " ;

        for(int i = 0; i < this.list.size(); i++) {
            returned += " " + this.list.get(i).value + ",";
        }
        returned += " >";

        System.out.println(returned);
    }

}

package model;

import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by utente on 13/04/2017.
 */
public enum Map {

    INSTANCE;

    public List<Node> mapList = new ArrayList<Node>();

    Map (){}

    private Object readResolve() throws ObjectStreamException{
        return INSTANCE;
    }

    public void addNode(Node n){

        mapList.add(n);
    }

    public Node getNodeInList(int index){

        return  mapList.get(index);
    }

    public void stampAllNode(){

        for(int i = 0; i < mapList.size(); i++) {
            mapList.get(i).stampNode();
        }
    }

    public int isInMap(String value){

        for(int i = 0; i < mapList.size(); i++){
            if(value.equals(mapList.get(i).value)) {
                return i;
            }
        }

        return -1;
    }
}

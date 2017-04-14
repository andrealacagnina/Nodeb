package model.SerializableClasses;

import model.Map;
import model.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andla on 14/04/2017.
 */
public class SerializableMap implements java.io.Serializable {

    private List<Node> serializedMapList = new ArrayList<Node>();
    public static String src = "map.proto";

    public SerializableMap(){}

    public void convertToSerializable(Map map){

        for(int i = 0; i < map.mapList.size(); i++){

            Node n = map.mapList.get(i);
            serializedMapList.add(n);
        }
    }

    public Map convertFromSerializable(Map map){

        for(int i = 0; i < serializedMapList.size(); i++){

            Node n = serializedMapList.get(i);
            map.addNode(n);
        }

        return map;
    }
}

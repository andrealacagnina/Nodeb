package model;

import model.SerializableClasses.SerializableMap;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by utente on 14/04/2017.
 */
public class Serializer {

    Map map;
    SerializableMap serializableMap;

    public Serializer(){
        map = Map.INSTANCE;
        serializableMap = new SerializableMap();
    }

    public void serialize(){

        serializableMap.convertToSerializable(map);

        try {
            FileOutputStream fileOut = new FileOutputStream(serializableMap.src);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(serializableMap);
            out.close();
            fileOut.close();
        }catch(IOException i) {
            i.printStackTrace();
        }
    }
}

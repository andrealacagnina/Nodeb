package model;

import model.SerializableClasses.SerializableMap;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by utente on 14/04/2017.
 */
public class Deserializer {

    Map map;
    SerializableMap serializableMap;

    public Deserializer(){
        map = Map.INSTANCE;
        serializableMap = new SerializableMap();
    }

    public void deserialize(){

        try {
            FileInputStream fileIn = new FileInputStream(serializableMap.src);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            serializableMap = (SerializableMap) in.readObject();
            in.close();
            fileIn.close();
            map = serializableMap.convertFromSerializable(map);
        }catch(IOException i) {
            i.printStackTrace();
        }catch(ClassNotFoundException c) {
            System.out.println("Map class not found");
            c.printStackTrace();
        }

    }
}

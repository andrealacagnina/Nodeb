package controller;

import model.Map;
import resources.EnumStatus;
import view.Prompt;

/**
 * Created by utente on 14/04/2017.
 */
public class Drawer {

    private static Drawer istance = null;

    Map map;
    Prompt prompt;

    public Drawer() {

        map = Map.INSTANCE;
        prompt = Prompt.getIstance();
    }

    public static synchronized Drawer getIstance() {

        if (istance == null) {
            istance = new Drawer();
        }
        return istance;
    }

    public EnumStatus show(){

        String preference = prompt.showAndReadMessage("showPreference");

        if(preference.equals("2")) {
            String returnedIdex = prompt.showAndReadMessage("getNodeToShowEvent");

            int index = map.isInMap(returnedIdex);

            if(index == - 1){
                prompt.showMessage("isNotInMap");
                return EnumStatus.SHOW;
            }
            else{
                map.getNodeInList(index).stampNode();
            }
        }
        else if(preference.equals("3")) {
            map.stampAllNode();
        }
        else {
            return EnumStatus.WELCOME;
        }

        return EnumStatus.SHOW;
    }
}

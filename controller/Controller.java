package controller;

import model.Deserializer;
import model.Map;
import model.Serializer;
import resources.EnumStatus;
import view.Prompt;

/**
 * Created by utente on 13/04/2017.
 */
public class Controller {

    private static Controller istance = null;

    EnumStatus statusValue;
    Map map;
    Prompt prompt;
    Drawer drawer;
    Learner learner;
    ContinuousLearner continuousLearner;
    Serializer serializer;
    Deserializer deserializer;

    public Controller() {
        statusValue = EnumStatus.WELCOME;
        map = Map.INSTANCE;
        prompt = Prompt.getIstance();
        drawer = Drawer.getIstance();
        learner = Learner.getIstance();
        continuousLearner = ContinuousLearner.getIstance();
        serializer = new Serializer();
        deserializer = new Deserializer();
    }

    public static synchronized Controller getIstance() {

        if (istance == null) {
            istance = new Controller();
        }
        return istance;
    }

    public void run() {

        while(statusValue != EnumStatus.EXIT ) {

            switch (statusValue) {

                case WELCOME:
                    String returnedMessage;

                    prompt.showMessage("welcomeEvent");
                    returnedMessage = this.prompt.showAndReadMessage("welcomeEvent");

                    switch (returnedMessage) {

                        case "1":
                            statusValue = EnumStatus.EXIT;
                            break;
                        case "2":
                            statusValue = EnumStatus.PLAY;
                            break;
                        case "3":
                            statusValue = EnumStatus.LEARN;
                            break;
                        case "4":
                            statusValue = EnumStatus.CONTINUOUSLEARNING;
                            break;
                        case "5":
                            statusValue = EnumStatus.SHOW;
                            break;
                        case "6":
                            statusValue = EnumStatus.SAVE;
                            break;
                        case "7":
                            statusValue = EnumStatus.LOAD;
                            break;
                        default:
                            statusValue = EnumStatus.NOTIMPLEMENTED;
                            break;
                    }

                case PLAY:
                    break;

                case SHOW:
                    statusValue = drawer.show();
                    break;

                case LEARN:
                    statusValue = learner.learn();
                    break;

                case SAVE:
                    serializer.serialize();
                    statusValue = EnumStatus.WELCOME;
                    break;

                case LOAD:
                    deserializer.deserialize();
                    statusValue = EnumStatus.WELCOME;
                    break;

                case CONTINUOUSLEARNING:
                    statusValue = continuousLearner.continuousLearn();
                    break;

                case NOTIMPLEMENTED:
                    prompt.showMessage("notYetImplented");
                    statusValue = EnumStatus.WELCOME;
                    break;

                default:
                    prompt.showMessage("notYetImplented");
                    statusValue = EnumStatus.WELCOME;
                    break;
            }
        }
    }
}

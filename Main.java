import controller.Controller;
import resources.EnumStatus;

/**
 * Created by utente on 13/04/2017.
 */
public class Main {

    public static void main(String[] args) {

        Controller controller = Controller.getIstance();
        controller.run();

        System.out.println("See you, byeee! ");
    }
}

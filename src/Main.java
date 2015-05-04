
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args)  {
        Utils utils = new Utils();
        utils.createList(Paths.get("junit"));
        new Database().writeToDB(utils.getListPaths());







    }
}

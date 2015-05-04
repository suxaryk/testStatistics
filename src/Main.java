
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args)  {
        Utils utils = new Utils();
        utils.createList(Paths.get("junit"));
        new Database().writeToDB(utils.getListPaths());




//        utils.createList(Paths.get("junit"));
//        utils.sh//owList();
//        try {
//            utils.DOMparser(Paths.get("junit/TEST-codec.binary.Base32InputStreamTest.xml"));
//        } catch (ParserConfigurationException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (SAXException e) {
//            e.printStackTrace();
//        }


    }
}

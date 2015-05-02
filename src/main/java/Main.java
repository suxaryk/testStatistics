import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        TestsStat testStat = new TestsStat(Paths.get(args[0]));
        testStat.showList();




//        Database database = new Database();
//        database.connectToDB();
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));






    }
}

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Date;
import java.nio.file.Path;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.List;

public class Database {
    private Test test;
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static final String INSERT_NEW ="INSERT INTO testsStatistics VALUES(?, ?, ?, ?, ?, ?)";




    public  void writeToDB(List<Path> list)  {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            preparedStatement = connection.prepareStatement(INSERT_NEW);


//            for (int i = 0; i < list.size(); i++) {
                  DOMparser(list.get(0));


//            preparedStatement.setString(1, String.valueOf(0));
//            preparedStatement.setString(2, test.getName());
//            preparedStatement.setString(3, test.getDateTime());
//            preparedStatement.setString(4, String.valueOf(test.isResult()));
//            preparedStatement.setString(5, String.valueOf(test.getOutTime()));
//            preparedStatement.setString(6, test.getDscription());
//            preparedStatement.addBatch();

            System.out.println(String.valueOf(0));
            System.out.println(test.getName());
            System.out.println(test.getDateTime());
            System.out.println(String.valueOf(test.isResult()));
            System.out.println(String.valueOf(test.getOutTime()));
            System.out.println(test.getDscription());


//            preparedStatement.setString(1, "4");
//            preparedStatement.setString(2, "someTest.java");
//            preparedStatement.setString(3, "2015-05-02 00:09:43");
//            preparedStatement.setString(4, "1");
//            preparedStatement.setString(5, "0.0");
//            preparedStatement.setString(6, "error ");
//            preparedStatement.addBatch();
//            }




            preparedStatement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void DOMparser(Path path){

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();



        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(path.toString());
            document.getDocumentElement();
            Element element;
            test = new Test();
            test.setName(element.getAttribute("name"));

            test.setDateTime(element.getAttribute("timestamp").replace("T", " "));
            test.setResult(Integer.parseInt(element.getAttribute("failures")));
            test.setOutTime(Double.parseDouble(element.getAttribute("time")));
            test.setDscription(document.getElementsByTagName("error").item(0).getTextContent());

//            test =  new Test( element.getAttribute("name"),  element.getAttribute("timestamp").replace("T", " "),  Integer.parseInt(element.getAttribute("failures")), Double.parseDouble (element.getAttribute("time")),   document.getElementsByTagName("error").item(0).getTextContent());
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}

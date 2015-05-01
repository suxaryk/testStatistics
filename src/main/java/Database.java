import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";



    public  void connectToDB(){
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try(
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement statement = connection.createStatement()
        ){
            //statement.execute("");

            System.out.println(connection.isClosed());


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }





}

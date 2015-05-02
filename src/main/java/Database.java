import com.mysql.fabric.jdbc.FabricMySQLDriver;
import java.util.Date;
import java.nio.file.Path;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.List;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static final String INSERT_NEW ="INSERT INTO testsStatistics VALUES(?, ?, ?, ?, ?, ?)";




    public  void connectToDB(List<Path> list) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            preparedStatement = connection.prepareStatement(INSERT_NEW);


//            for (int i = 0; i < list.size(); i++) {
//
//            }
            preparedStatement.setString(2, "name");
            preparedStatement.setString(3, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            preparedStatement.setString(4, "result");
            preparedStatement.setString(5, "out_time");
            preparedStatement.setString(6, "error message");
            preparedStatement.addBatch();




            preparedStatement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }


        }


    }





}

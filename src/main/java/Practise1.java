import java.sql.*;

public class Practise1 {
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "arkadiy";
    private static final String URL = "jdbc:mysql://localhost:3306/practise_1";
    public static Statement statement;
    public static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException exc) {
            exc.getStackTrace();
        }
    }

    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException exc) {
            exc.getStackTrace();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        //statement.executeUpdate("Create table Address (AddressId int, PersonId int, City varchar(255), State varchar(255))");
        //statement.executeUpdate("Create table Person (PersonId int, FirstName varchar(255), LastName varchar(255))");
        statement.executeUpdate("Truncate table Person");
        statement.executeUpdate("insert into Person (PersonId, LastName, FirstName) values ('1', 'Wang', 'Allen')");
        statement.executeUpdate("Truncate table Address");
        statement.executeUpdate("insert into Address (AddressId, PersonId, City, State) values ('1', '2', 'New York City', 'New York')");
        ResultSet resultSet = statement.executeQuery("select firstName, lastName, city, state from person left join address on person.personid = address.personid;");

        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) +
                    " " + resultSet.getString(2) +
                    " " + resultSet.getString(3) +
                    " " + resultSet.getString(4));
        }
    }
}
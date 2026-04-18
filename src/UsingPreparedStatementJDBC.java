import java.sql.*;

public class UsingPreparedStatementJDBC {
    private static final String URL="jdbc:mysql://localhost:3306/student";
    private static final String USERNAME="root";
    private static final String PASSWORD="SxOp10%AL";
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
        String query="Insert into student_temp (id,name,age) values (?,?,?)";
        PreparedStatement prepareStatement=connection.prepareStatement(query);
        int id=3;
        String name="Ananya";
        int age=25;
        prepareStatement.setInt(1,id);
        prepareStatement.setString(2,name);
        prepareStatement.setInt(3,age);

        int insertIntoDb=prepareStatement.executeUpdate();
        if(insertIntoDb>0){
            System.out.println("Data Inserted");
        }
        else {
            System.out.println("Failed to insert data");
        }
    }
}

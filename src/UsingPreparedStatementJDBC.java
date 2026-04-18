import java.sql.*;

public class UsingPreparedStatementJDBC {
    private static final String URL="jdbc:mysql://localhost:3306/student";
    private static final String USERNAME="root";
    private static final String PASSWORD="SxOp10%AL";
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
//        String query="Insert into student_temp (id,name,age) values (?,?,?)";
        String query1="Update student_temp set name=? where id=?";
        PreparedStatement prepareStatement=connection.prepareStatement(query1);
//        int id=3;
        String name="Ajay";
        int id=3;
//        prepareStatement.setInt(1,id);
//        prepareStatement.setString(2,name);
//        prepareStatement.setInt(3,age);

        prepareStatement.setString(1,name);
        prepareStatement.setInt(2,3);
        /**
         * executeUpdate() (Returns int)
         * When to use: Use for DML queries (INSERT, UPDATE, DELETE) or DDL statements (CREATE, ALTER, DROP).
         */
//        int insertIntoDb=prepareStatement.executeUpdate();
        int updateDb=prepareStatement.executeUpdate();
        if(updateDb>0){
            System.out.println("Data Updated");
        }
        else {
            System.out.println("Failed to update data");
        }
    }
}

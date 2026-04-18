import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final String URL="jdbc:mysql://localhost:3306/student";
    private static final String USERNAME="root";
    private static final String PASSWORD="SxOp10%AL";
    public static void main(String[] args) throws ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        try {
            Connection connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
            Statement statement=connection.createStatement();
            String query="Select * from student_temp";
            ResultSet resultSet=statement.executeQuery(query);
            while(resultSet.next()){
                int id=resultSet
                        .getInt("ID");
                String name=resultSet.getString("NAME");
                String age=resultSet.getString("AGE");

                System.out.println("ID: "+id);
                System.out.println("NAME: "+name);
                System.out.println("AGE: "+age);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
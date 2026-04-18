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
//            String query="Select * from student_temp";
            /**
             *
            You only use String.format() when you have variables that you want to plug into a template.
            Example with variables:
            Java
            int studentId = 4;
            String studentName = "Rahul";
            int studentAge = 22;
             Here, String.format is useful to inject the variables into the string
            String query = String.format("INSERT INTO student_temp (id, name, age) VALUES (%d, '%s', %d)",
                    studentId, studentName, studentAge);
             */

//            String query=String.format("INSERT INTO student_temp (id,name,age) values (3,'Ankush',34)");

//            String query="Update student_temp set age=19,name='Ankur' where id=3";
            String query="delete from student_temp where id=3";
//            ResultSet resultSet=statement.executeQuery(query);
            int update=statement.executeUpdate(query);
            if(update>0){
                System.out.println("Data deleted");
            }
            else {
                System.out.println("Not Deleted");
            }
//            while(resultSet.next()){
//                int id=resultSet
//                        .getInt("ID");
//                String name=resultSet.getString("NAME");
//                int age=resultSet.getInt("AGE");
//
//                System.out.println("ID: "+id);
//                System.out.println("NAME: "+name);
//                System.out.println("AGE: "+age);
//            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}